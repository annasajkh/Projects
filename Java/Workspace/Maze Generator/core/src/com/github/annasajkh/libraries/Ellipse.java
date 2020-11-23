package com.github.annasajkh.libraries;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Ellipse extends GameObject
{
    public boolean dontRender = false;

    public Ellipse(Vector2 position, Size size, Color modulate)
    {
        super(position, size, modulate);
        centered = true;
    }
}