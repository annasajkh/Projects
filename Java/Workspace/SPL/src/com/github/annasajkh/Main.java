package com.github.annasajkh;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

public class Main
{
	static HashMap<String,Double> memory = new HashMap<>();
	
	public static String parseOperator(String variable,String otherVariable,char operator)
	{
		return variable + '=' + variable + operator + otherVariable;
	}

	public static void main(String[] args)
	{
		try
		{
			if(args.length == 0)
			{
				System.exit(0);
			}
			
			BufferedReader reader  = new BufferedReader(new FileReader(args[0]));
			
			String line;
			StringBuilder builder = new StringBuilder();
			
			while((line = reader.readLine()) != null)
			{
				builder.append(line + '\n');
			}
			
			String sourceCode = builder.toString();

			
			String[] sourceArray = sourceCode.split("\n");
			Executer.execute(sourceArray);
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		
	}

}
