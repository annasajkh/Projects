package com.github.annasajkh;

public class AnnasStack<E>
{
    private AnnasList<E> list;

    public AnnasStack()
    {
        list = new AnnasList<>();
    }

    public void push(E e)
    {
        list.add(e);
    }

    public E pop()
    {
        E element = list.clone()
                        .get(list.size() - 1);
        list.removeByIndex(list.size() - 1);
        return element;
    }

    public E peek()
    {
        return list.clone()
                   .get(list.size() - 1);
    }

    public String toString()
    {
        return list.toString();
    }

}
