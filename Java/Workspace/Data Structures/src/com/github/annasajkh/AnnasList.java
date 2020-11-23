package com.github.annasajkh;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class AnnasList<E>
{
    private E[] array;
    private int size;

    public AnnasList()
    {
        array = (E[]) new Object[10];
        size = 0;
    }

    protected AnnasList(E[] array, int size)
    {
        this.array = array;
        this.size = size;
    }

    public void add(E e)
    {
        if (size == array.length)
        {
            array = Arrays.copyOf(array, size + size / 2);
            array[size++] = e;
        }
        else
        {
            array[size++] = e;
        }
    }

    public void add(E e, int index)
    {
        outOfBoundsCheck(index);

        E[] fistArray = (E[]) new Object[index];
        E[] lastArray;
        int idx = 0;

        fistArray = Arrays.copyOfRange(array, 0, fistArray.length);
        lastArray = Arrays.copyOfRange(array, index, size);
        array = (E[]) new Object[array.length + 1];

        for (int i = 0; i < fistArray.length; i++)
        {
            array[i] = fistArray[i];
        }

        for (int i = index + 1; i < size + 1; i++)
        {
            array[i] = lastArray[idx];
            idx++;
        }
        array[fistArray.length] = e;

        size = index + idx + 1;
        fistArray = null;
        lastArray = null;
    }

    public void set(int index, E e)
    {
        if (index > size - 1)
        {
            throw new IndexOutOfBoundsException();
        }
        array[index] = e;
    }

    public void remove(E e)
    {
        int index = indexOf(e);

        if (index == -1)
        {
            throw new NoSuchElementException();
        }

        array[index] = null;
        E[] fistArray = (E[]) new Object[index];
        E[] lastArray;
        int idx = 0;

        fistArray = Arrays.copyOfRange(array, 0, fistArray.length);
        lastArray = Arrays.copyOfRange(array, index + 1, size);

        for (int i = 0; i < size; i++)
        {
            array[i] = null;
        }

        for (int i = 0; i < fistArray.length; i++)
        {
            array[i] = fistArray[i];
        }

        for (int i = index; i < size - 1; i++)
        {
            array[i] = lastArray[idx];
            idx++;
        }

        size = index + idx;
        fistArray = null;
        lastArray = null;
    }

    public void removeByIndex(int index)
    {
        outOfBoundsCheck(index);

        array[index] = null;
        E[] fistArray = (E[]) new Object[index];
        E[] lastArray;
        int idx = 0;

        fistArray = Arrays.copyOfRange(array, 0, fistArray.length);
        lastArray = Arrays.copyOfRange(array, index + 1, size);

        for (int i = 0; i < size; i++)
        {
            array[i] = null;
        }

        for (int i = 0; i < fistArray.length; i++)
        {
            array[i] = fistArray[i];
        }

        for (int i = index; i < size - 1; i++)
        {
            array[i] = lastArray[idx];
            idx++;
        }

        size = index + idx;
        fistArray = null;
        lastArray = null;
    }

    private void outOfBoundsCheck(int index)
    {
        if (index < 0 || index > size - 1)
        {
            throw new ArrayIndexOutOfBoundsException();
        }

    }

    public void clear()
    {
        if (!isEmpty())
        {
            array = (E[]) new Object[10];
            size = 0;
        }
    }

    public int indexOf(E e)
    {
        for (int i = 0; i < size; i++)
        {
            if (array[i].equals(e))
            {
                return i;
            }
        }
        return -1;
    }

    public AnnasList<E> clone()
    {
        return new AnnasList<E>(Arrays.copyOf(array, array.length), size);
    }

    public int size()
    {
        return size;
    }

    public boolean isFist(E e)
    {
        return indexOf(e) == 0;
    }

    public boolean isLast(E e)
    {
        return indexOf(e) == size - 1;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public E get(int index)
    {
        return array[index];
    }

    public boolean contain(E e)
    {
        return indexOf(e) != -1;
    }

    public Object[] toArray()
    {
        return Arrays.copyOf(array, size);
    }

    public String toString()
    {
        return Arrays.toString(toArray());
    }

}
