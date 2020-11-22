package com.github.annasajkh.libraries;

public class MiniVector
{
    public float x;
    public float y;

    public MiniVector(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public float getX()
    {
        return x;
    }

    public float getY()
    {
        return y;
    }

    public boolean equal(MiniVector otherMiniVector)
    {
        return x == otherMiniVector.x && y == otherMiniVector.y;
    }
}
