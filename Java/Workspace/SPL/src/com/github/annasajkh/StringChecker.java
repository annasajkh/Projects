package com.github.annasajkh;

public class StringChecker
{

	private static char[] mathExpressions = {'+','-','/','*','%'};
	
	public static boolean isContainsVariable(String string)
	{
		boolean isContainsVariable = false;
		
		for (int i = 0; i < string.length(); i++)
		{
			if(Character.isLetter(string.charAt(i)))
			{
				isContainsVariable = true;
				break;
			}
		}
		
		return isContainsVariable;
	}
	
	public static boolean isContainsMath(String string)
	{
		boolean isContainsMath = false;
		
		for(int i = 0; i < string.length(); i++)
		{
			for (int j = 0; j < mathExpressions.length; j++)
			{
				if(mathExpressions[j] == string.charAt(i))
				{
					isContainsMath = true;
					break;
				}
			}
		}
		
		return isContainsMath;
	}
	
}
