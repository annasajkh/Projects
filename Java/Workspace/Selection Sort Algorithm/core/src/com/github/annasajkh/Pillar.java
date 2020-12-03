package com.github.annasajkh;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Pillar
{
    int value;
    float positionX;
    float width;

    public Pillar(int value, float positionX, float width)
    {
        this.value = value;
        this.width = width;
        this.positionX = positionX;
    }

    public void render(ShapeRenderer shapeRenderer, Color color)
    {
        shapeRenderer.setColor(color);
        shapeRenderer.rect(positionX, 0, width, value);
    }

    public Pillar copy()
    {
        return new Pillar(value, positionX, width);
    }
}
