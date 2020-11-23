package com.github.annasajkh;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Pixel
{
    Color color;
    Vector2 position;

    public Pixel(Vector2 position, Color color)
    {
        this.color = color;
        this.position = position;
    }

    public Vector2 getPosition()
    {
        return position;
    }
}
