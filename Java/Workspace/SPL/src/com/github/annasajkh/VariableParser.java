package com.github.annasajkh;

public class VariableParser
{
	
	public static String parse(String string,int lineIndex) throws Exception
	{
		if(StringChecker.isContainsVariable(string))
		{
			string = VariableReplacer.replace(string,lineIndex);
		}
		
		if(StringChecker.isContainsMath(string))
		{
			string = "" + ArithmeticExecutor.eval(string);
		}
		return string;
	}

}
