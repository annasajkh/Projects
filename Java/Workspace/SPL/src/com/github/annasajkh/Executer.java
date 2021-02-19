package com.github.annasajkh;

public class Executer
{
	
	private static int backward = 1;
	private static String funcBody = "";
	private static boolean writeFuncBody = false;
	private static String funcName = "";
	
	public static String parseOperator(String variable,String otherVariable,char operator)
	{
		return variable + '=' + variable + operator + otherVariable;
	}
	
	public static void execute(String[] sourceArray) throws Exception
	{
		
		for(int i = 0; i < sourceArray.length; i++)
		{
			if(sourceArray[i].startsWith(":"))
			{
				Main.labels.put(sourceArray[i],i);
			}
		}
		for(int i = 0; i < sourceArray.length;i += 1 * backward)
		{
			
			if(i < 0)
			{
				break;
			}
			
			if(sourceArray[i].contains("func"))
			{
				funcName = sourceArray[i].replace("func","").strip();
				writeFuncBody = true;
				continue;
			}
			else if(sourceArray[i].strip().equals("end") && !funcBody.isEmpty())
			{
				writeFuncBody = false;
				Main.functions.put(funcName,funcBody);
				funcBody = "";
			}
			
			if(writeFuncBody)
			{
				funcBody += sourceArray[i] + '\n';
			}
			
			if(!writeFuncBody)
			{
				if(sourceArray[i].contains("++"))
				{
					String value = sourceArray[i].replace("++","");
					sourceArray[i] = parseOperator(value,"1",'+');
				}
				else if(sourceArray[i].contains("--"))
				{
					String value = sourceArray[i].replace("--","");
					sourceArray[i] = parseOperator(value,"1",'-');
				}
				else if(sourceArray[i].contains("+="))
				{
					String[] valueArray = sourceArray[i].split("\\+=");
					sourceArray[i] = parseOperator(valueArray[0],valueArray[1],'+');
				}
				else if(sourceArray[i].contains("-="))
				{
					String[] valueArray = sourceArray[i].split("-=");
					sourceArray[i] = parseOperator(valueArray[0],valueArray[1],'-');
				}
				else if(sourceArray[i].contains("*="))
				{
					String[] valueArray = sourceArray[i].split("\\*=");
					sourceArray[i] = parseOperator(valueArray[0],valueArray[1],'*');
				}
				else if(sourceArray[i].contains("/="))
				{
					String[] valueArray = sourceArray[i].split("/=");
					sourceArray[i] = parseOperator(valueArray[0],valueArray[1],'/');
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
					String value = sourceArray[i].replace("goto","").strip();
					if(value.startsWith(":"))
					{
						i = Main.labels.get(value);
						continue;
					}
					int goIndex = (int) Double.parseDouble(VariableParser.parse(value, i));
					
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
					i += jumpIndex - 1;
				}
				else if(sourceArray[i].contains("mirror"))
				{
					int mirrorValue = (int) Double.parseDouble(VariableParser.parse(sourceArray[i].replace("mirror","").strip(), i));
					
					if(mirrorValue == 0)
					{
						continue;
					}
					backward = -backward;
				}
				else if(sourceArray[i].contains("call"))
				{
					String value = sourceArray[i].replace("call","").strip();
					execute(Main.functions.get(value).split("\n"));
				}
			}
		}
	}

}
