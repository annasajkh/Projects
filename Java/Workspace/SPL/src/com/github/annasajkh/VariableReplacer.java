package com.github.annasajkh;

import java.util.Set;

public class VariableReplacer
{
	
	public static String replace(String string,int lineIndex) throws Exception
	{
		Set<String> variableNames = Main.memory.keySet();
		
		for(String variableName : variableNames)
		{
			if(string.contains(variableName))
			{
				string = string.replace(variableName,String.valueOf(Main.memory.get(variableName)));
			}
		}
		
		if(StringChecker.isContainsVariable(string))
		{
			throw SPLException.create("error cannot found variable name",lineIndex);
		}
		
		
		return string;
	}

}
