package com.github.annasajkh.libraries;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public abstract class GameObject
{

    public Vector2 position;
    public Color modulate;
    public Size size;
    public float rotation = 0;
    public boolean centered = false;

    public GameObject(Vector2 position, Size size, Color modulate)
    {
        this.position = position;
        this.modulate = modulate;
        this.size = size;
    }
}
