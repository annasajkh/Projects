package com.github.annasajkh;

public class AnnasLinkedList<E>
{
    private class Node
    {
        E value;
        Node next;

        public Node(E value)
        {
            this.value = value;
        }

    }


    Node start = null;

    public void add(E element)
    {
        if (start == null)
        {
            start = new Node(element);
        }
        else
        {
            Node node = start;
            while (node.next != null)
            {
                node = node.next;
            }
            node.next = new Node(element);
        }
    }

    public Node removeFirst()
    {
        if (start == null)
        {
            return null;
        }
        Node n = start;
        start = start.next;
        return n;
    }

    public Node remove(int index)
    {
        if (index == 0)
        {
            removeFirst();
        }
        else if (index == size() - 1)
        {
            removeLast();
        }


        Node node = start;
        while (node.next != null)
        {
            if (index == 1)
            {
                Node n = node.next;
                node.next = node.next.next;
                return n;
            }
            index -= 1;
            node = node.next;
        }

        return null;
    }

    public Node removeLast()
    {
        if (start == null)
        {
            return null;
        }
        Node node = start;
        while (node.next != null)
        {
            if (node.next.next == null)
            {
                Node n = node.next;
                node.next = null;
                return n;
            }
            node = node.next;
        }
        Node n = start;
        start = null;
        return n;
    }


    public E get(int index)
    {
        if (isEmpty())
        {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index == 0)
        {
            return start.value;
        }
        Node node = start;
        while (node.next != null)
        {
            node = node.next;
            index -= 1;
            if (index == 0)
            {
                return node.value;
            }
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int size()
    {
        if (start == null)
        {
            return 0;
        }
        if (start.next == null)
        {
            return 1;
        }

        int size = 1;
        Node node = start;
        while (node.next != null)
        {
            node = node.next;
            size++;
        }
        return size;
    }

    public boolean isEmpty()
    {
        return start == null;
    }

    @Override
    public String toString()
    {
        if (isEmpty())
        {
            return "[]";
        }
        StringBuilder string = new StringBuilder("[");
        Node node = start;
        if (node.next == null)
        {
            return "[" + start.value + "]";
        }
        string.append(node.value + ", ");
        while (node.next != null)
        {
            node = node.next;
            if (node.next == null)
            {
                string.append(node.value);
            }
            else
            {
                string.append(node.value + ", ");
            }
        }
        string.append("]");
        return string.toString();
    }
}
