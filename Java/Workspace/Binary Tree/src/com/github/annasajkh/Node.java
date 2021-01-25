package com.github.annasajkh;

public class Node
{
	int value;
	Node right;
	Node left;

	public Node(int value)
	{
		this(value, null, null);
	}

	public Node(int value, Node right, Node left)
	{
		this.value = value;
		this.right = right;
		this.left = left;
	}

	public void addNode(Node node)
	{
		if (node.value < value)
		{
			if (left == null)
			{
				left = node;
			}
			else
			{
				left.addNode(node);
			}
		}
		else if (node.value > value)
		{
			if (right == null)
			{
				right = node;
			}
			else
			{
				right.addNode(node);
			}
		}
	}

	public Node search(int value)
	{
		if (this.value == value)
		{
			return this;
		}
		else if (value < this.value && left != null)
		{
			return left.search(value);
		}
		else if (value > this.value && right != null)
		{
			return right.search(value);
		}
		return null;
	}

	public void visit()
	{
		if (left != null)
		{
			left.visit();
		}
		System.out.println(value);
		if (right != null)
		{
			right.visit();
		}
	}

}
