package com.github.annasajkh;

import java.util.Random;

public class Main
{

	public static void main(String[] args)
	{
		Tree tree = new Tree(5);
		Random random = new Random();
		for (int i = 0; i < 10; i++)
		{
			tree.addValue(random.nextInt(11));
		}
		tree.traverse();
	}

}
