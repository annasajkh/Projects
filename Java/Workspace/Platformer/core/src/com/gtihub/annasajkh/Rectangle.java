package com.gtihub.annasajkh;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Rectangle
{
    Vector2 position;
    float width;
    float height;
    Color color;
    float leftSide;
    float rightSide;
    float topSide;
    float bottomSide;


    public Rectangle(Vector2 position, float width, float height, Color color)
    {

        this.position = position;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void render(ShapeRenderer shapeRenderer)
    {
        shapeRenderer.setColor(color);
        shapeRenderer.rect(position.x - width / 2, position.y - height / 2, width, height);
    }
}
