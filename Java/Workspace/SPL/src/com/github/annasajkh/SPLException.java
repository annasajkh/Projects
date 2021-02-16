package com.github.annasajkh;

public class SPLException
{
	
	public static Exception create(String text,int lineIndex)
	{
		return new Exception("Error: " + text + "\nat line: " + (lineIndex + 1));
	}
	
}
