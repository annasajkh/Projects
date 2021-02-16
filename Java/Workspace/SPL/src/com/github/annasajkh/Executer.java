package com.github.annasajkh;

public class Executer
{
	
	public static void execute(String[] sourceArray) throws Exception
	{
		for(int i = 0; i < sourceArray.length; i++)
		{
			if(sourceArray[i].contains("++"))
			{
				String value = sourceArray[i].replace("++","");
				sourceArray[i] = Main.parseOperator(value,"1",'+');
			}
			else if(sourceArray[i].contains("--"))
			{
				String value = sourceArray[i].replace("--","");
				sourceArray[i] = Main.parseOperator(value,"1",'-');
			}
			else if(sourceArray[i].contains("+="))
			{
				String[] valueArray = sourceArray[i].split("\\+=");
				sourceArray[i] = Main.parseOperator(valueArray[0],valueArray[1],'+');
			}
			else if(sourceArray[i].contains("-="))
			{
				String[] valueArray = sourceArray[i].split("-=");
				sourceArray[i] = Main.parseOperator(valueArray[0],valueArray[1],'-');
			}
			else if(sourceArray[i].contains("*="))
			{
				String[] valueArray = sourceArray[i].split("\\*=");
				sourceArray[i] = Main.parseOperator(valueArray[0],valueArray[1],'*');
			}
			else if(sourceArray[i].contains("/="))
			{
				String[] valueArray = sourceArray[i].split("/=");
				sourceArray[i] = Main.parseOperator(valueArray[0],valueArray[1],'/');
			}
			
			if(sourceArray[i].contains("print"))
			{
				HandlePrint.handle(sourceArray[i], i);
			}
			else if(sourceArray[i].contains("="))
			{
				HandleVariableAssignment.handle(sourceArray[i], i);
			}
			else if(sourceArray[i].contains("goto"))
			{
				int goIndex = (int) Double.parseDouble(VariableParser.parse(sourceArray[i].replace("goto","").strip(), i));
				
				if(goIndex - 1 == i)
				{
					continue;
				}
				i = goIndex - 2;
			}
			else if(sourceArray[i].contains("jump"))
			{
				int jumpIndex = (int) Double.parseDouble(VariableParser.parse(sourceArray[i].replace("jump","").strip(), i));
				
				if(jumpIndex == 0)
				{
					continue;
				}
				i += jumpIndex-1;
			}
		}
	}

}
