package com.github.annasajkh;

public class Tree
{
	Node root;

	public Tree(int value)
	{
		root = new Node(value);
	}

	public void addValue(int value)
	{
		root.addNode(new Node(value));
	}

	public Node search(int value)
	{
		return root.search(value);
	}

	public void traverse()
	{
		root.visit();
	}

}