package com.github.annasajkh;

import java.util.NoSuchElementException;

public class AnnasMap<K, V>
{
    private class Item<K, V>
    {
        public K key;
        public V value;

        public Item(K key, V value)
        {
            this.key = key;
            this.value = value;
        }
    }

    private AnnasList<Item<K, V>> map = new AnnasList<>();

    public AnnasMap(AnnasList<Item<K, V>> map)
    {
        this.map = map;
    }

    public AnnasMap()
    {
    }

    public void remove(K key)
    {
        boolean contain = false;
        for (Object itemO : map.toArray())
        {
            Item item = (Item) itemO;
            if (item.key.equals(key))
            {
                contain = true;
                map.remove(item);
            }
        }
        if (!contain)
        {
            throw new NoSuchElementException();
        }
    }

    public boolean containKey(K key)
    {
        for (Object itemO : map.toArray())
        {
            Item item = (Item) itemO;
            if (item.key.equals(key))
            {
                return true;
            }
        }
        return false;
    }

    public boolean containValue(V value)
    {
        for (Object itemO : map.toArray())
        {
            Item item = (Item) itemO;
            if (item.value.equals(value))
            {
                return true;
            }
        }
        return false;
    }

    public V get(K key)
    {
        for (Object itemO : map.toArray())
        {
            Item item = (Item) itemO;
            if (item.key.equals(key))
            {
                return (V) item.value;
            }
        }
        throw new NoSuchElementException();
    }

    public String toString()
    {
        String string = "{";
        for (Object itemO : map.toArray())
        {
            Item item = (Item) itemO;
            string += item.key + "=";
            string += item.value;
            if (!map.isLast(item))
            {
                string += ", ";
            }
        }
        string += "}";
        return string;
    }

    public void put(K key, V value)
    {
        map.add(new Item<>(key, value));
    }

    public AnnasList<Item<K, V>> getList()
    {
        return map;
    }

    public AnnasList<K> keySet()
    {
        AnnasList<K> keys = new AnnasList<>();
        for (int i = 0; i < map.size(); i++)
        {
            keys.add(map.get(i).key);
        }
        return keys;
    }

    public AnnasList<V> values()
    {
        AnnasList<V> values = new AnnasList<>();
        for (int i = 0; i < map.size(); i++)
        {
            values.add(map.get(i).value);
        }
        return values;
    }

    public AnnasMap<K, V> clone()
    {
        return new AnnasMap<K, V>(map.clone());
    }

    public void clear()
    {
        map.clear();
    }

    public boolean isEmpty()
    {
        return map.isEmpty();
    }


}
