package com.github.annasajkh;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Main
{
    static HashMap<String, Double> memory;
    static String acceptedSpecialCharacters = "+-*/%()^";
    static String[] specialKeywords = {"print"};

    public static ArrayList<String> splitByLine(String path) throws IOException
    {
        ArrayList<String> souceCode = new ArrayList<>();
        BufferedReader fileReader = new BufferedReader(new FileReader(path));

        String line;
        while ((line = fileReader.readLine()) != null)
        {
            souceCode.add(line.strip());
        }

        fileReader.close();
        line = null;
        return souceCode;

    }

    public static String convertAllVariableNameToValue(String string)
    {

        //replace all variable in a field with their value a = b + c + d -> a = 5 + 6 + 5
        //if variable not found it will return error
        ArrayList<String> variables = new ArrayList<>();
        Set<String> keys = memory.keySet();

        for (String key : keys)
        {
            if (string.contains(key))
            {
                variables.add(key);
            }
        }
        for (String variable : variables)
        {
            string = string.replace(variable, String.valueOf(memory.get(variable)));
        }
        return string;
    }

    public static boolean handleVariabelAssignment(String line, int index)
    {
        String[] splitLine = line.split("=");
        int lineIndex = index + 1;
        String variableName = splitLine[0].strip();
        String variableValue = splitLine[1].replaceAll("\\s+", "");

        for (String specialKeyword : specialKeywords)
        {
            if (variableName.equals(specialKeyword) || variableValue.contains(specialKeyword))
            {
                System.out.println("Error : Variable name or value cannot contain specialKeyword at line : " +
                                   lineIndex);
                return false;
            }
        }

        if (variableName.isEmpty() || variableValue.isEmpty())
        {
            System.out.println("Error : Variable name or value cannot be empty at line : " + lineIndex);
            return false;
        }

        if (Character.isDigit(variableName.charAt(0)))
        {
            System.out.println("Error : Variable name cannot have number infront\nat line : " + lineIndex);
            return false;
        }

        for (int i = 0; i < variableName.length(); i++)
        {
            if (!Character.isLetterOrDigit(variableName.charAt(i)))
            {
                System.out.println("Error : Variable name cannot have special character\nat line : " + lineIndex);
                return false;
            }
        }

        boolean valueContainVariableName = false;
        for (int i = 0; i < variableValue.length(); i++)
        {
            char c = variableValue.charAt(i);
            if (Character.isLetter(c))
            {
                valueContainVariableName = true;
            }
            //error if variable value contains a non letter or digit character that not +-*/%()^
            if (!Character.isLetterOrDigit(c))
            {
                if (acceptedSpecialCharacters.indexOf(c) == -1)
                {
                    System.out.println("Error : Variable value cannot have special character\nat line : " + lineIndex);
                    return false;
                }
            }
        }
        if (valueContainVariableName)
        {
            variableValue = convertAllVariableNameToValue(variableValue);
        }
        if (variableValue.length() > 1)
        {
            memory.put(variableName, ArithmeticExecutor.eval(variableValue));
        }
        else
        {
            memory.put(variableName, Double.parseDouble(variableValue));
        }
        return true;
    }

    public static boolean handlePrintStatment(String line, int lineIndex)
    {
        String[] split;
        try
        {
            split = line.split("<<");
        }
        catch (Exception exception)
        {
            System.out.println("Error : cannot find a value '<<' : " + lineIndex);
            return false;
        }

        String field = split[1].strip();
        if (field.charAt(0) == '~')
        {
            field = field.replace("~", "");
            field = convertAllVariableNameToValue(field);
            System.out.println(field);
        }
        else
        {
            field = field.replaceAll("\\s+", "");
            boolean valueContainVariableName = false;
            for (int i = 0; i < field.length(); i++)
            {
                char c = field.charAt(i);
                if (Character.isLetter(c))
                {
                    valueContainVariableName = true;
                }

                if (!Character.isLetterOrDigit(c))
                {
                    if (acceptedSpecialCharacters.indexOf(c) == -1)
                    {
                        System.out.println("Error : value cannot have special character\nat line : " + lineIndex);
                        return false;
                    }
                }
            }
            if (valueContainVariableName)
            {
                field = convertAllVariableNameToValue(field);
            }

            System.out.println(ArithmeticExecutor.eval(field));

        }
        return true;
    }

    public static void execute(ArrayList<String> sourceCode)
    {
        for (int i = 0; i < sourceCode.size(); i++)
        {
            String line = sourceCode.get(i);

            if (line.contains("=") && !line.contains("~"))
            {
                if (!handleVariabelAssignment(line, i))
                {
                    break;
                }
            }
            else if (line.contains("print") && line.contains("<<"))
            {
                if (!handlePrintStatment(line, i))
                {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException
    {

        Scanner readFile = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        String path = System.getProperty("user.dir");

        while (true)
        {
            try
            {
                memory = new HashMap<>();
                System.out.print(path + ">");
                String fileName = readFile.nextLine();
                if (fileName.equalsIgnoreCase("quit"))
                {
                    break;
                }

                if (fileName.equalsIgnoreCase("cls"))
                {
                    (new ProcessBuilder(new String[]{"cmd", "/c", "cls"})).inheritIO()
                                                                          .start()
                                                                          .waitFor();
                }
                else if (!fileName.isBlank() && !fileName.isEmpty())
                {
                    if (fileName.contains(".apl"))
                    {
                        execute(splitByLine(path + "/" + fileName));
                    }
                    else
                    {
                        System.out.println("Error : " + fileName + " doesn't contains .apl");
                    }
                }
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }

        System.out.println(" ");
        System.out.print("Press enter to exit....");
        System.in.read();
        readFile.close();
        input.close();
    }
}
