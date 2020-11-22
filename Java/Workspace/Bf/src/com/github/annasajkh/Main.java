package com.github.annasajkh;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.Stack;

public class Main
{

    public static void main(String[] args) throws IOException
    {
        String fileName = "";
        Scanner readFile = new Scanner(System.in);
        Scanner input = new Scanner(System.in);
        boolean jump = false;

        String path = System.getProperty("user.dir");
        while (true)
        {
            try
            {
                short[] memory = new short[3000];
                int pointer = 0;
                int reader = 0;
                Stack<Integer> loopStack = new Stack<Integer>();
                System.out.print(path + '>');
                fileName = readFile.nextLine();
                if (fileName.equalsIgnoreCase("quit"))
                {
                    break;
                }
                else if (fileName.equalsIgnoreCase("cls"))
                {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    continue;
                }
                else if (fileName.isBlank())
                {
                    continue;
                }
                else if (!fileName.contains(".txt"))
                {
                    System.out.println("Error : " + fileName + " is not a command");
                    continue;
                }
                String data = new String(Files.readAllBytes(Paths.get(path + '/' + fileName)));

                while (reader < data.length())
                {
                    if (!jump)
                    {
                        switch (data.charAt(reader))
                        {
                            case '+':
                                memory[pointer] += 1;
                                if (memory[pointer] > 255)
                                {
                                    memory[pointer] = 0;
                                }
                                break;
                            case '-':
                                memory[pointer] -= 1;
                                if (memory[pointer] < 0)
                                {
                                    memory[pointer] = 255;
                                }
                                break;
                            case '>':
                                pointer += 1;
                                if (pointer == memory.length)
                                {
                                    pointer = 0;
                                }
                                break;
                            case '<':
                                pointer -= 1;
                                if (pointer < 0)
                                {
                                    pointer = memory.length - 1;
                                }
                                break;
                            case '[':
                                if (memory[pointer] == 0)
                                {
                                    jump = true;
                                }
                                else
                                {
                                    loopStack.add(reader);
                                }
                                break;
                            case ',':
                                System.out.print("bf>");
                                memory[pointer] = (short) input.next().charAt(0);
                                break;
                            case '.':
                                System.out.print((char) memory[pointer]);
                                break;
                            case '$':
                                System.out.println(memory[pointer]);

                        }
                    }
                    if (data.charAt(reader) == ']')
                    {
                        if (jump)
                        {
                            jump = false;
                        }
                        else
                        {
                            if (memory[pointer] != 0)
                            {
                                reader = loopStack.peek() - 1;
                            }
                            loopStack.pop();
                        }
                    }
                    reader++;
                }
                System.out.print('\n');
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