package com.github.annasajkh;

public class HandlePrint
{
	
	public static void handle(String source,int lineIndex) throws Exception
	{
		
		source = source.replace("print","").strip();
		
		if(source.equals("memory"))
		{
			System.out.println(Main.memory);
			return;
		}
		
		source = VariableParser.parse(source,lineIndex);
		
		System.out.println(source);

	}

}
