package com.github.annasajkh;

public class HandleVariableAssignment
{
	
	public static void handle(String source,int lineIndex) throws Exception
	{
		String[] sourceArray = source.split("=");
		sourceArray[0] = sourceArray[0].strip();
		sourceArray[1] = sourceArray[1].strip();
		
		if(sourceArray.length  != 2)
		{
			throw SPLException.create("variable assigment is not valid",lineIndex);
		}
		
		sourceArray[1] = VariableParser.parse(sourceArray[1],lineIndex);
		Main.memory.put(sourceArray[0],Double.parseDouble(sourceArray[1]));
	}

}
