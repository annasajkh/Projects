package com.github.annasajkh;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;

public class Circle
{

    Vector2 position = new Vector2((float) (-1 + Math.random() * 2), (float) (-1 + Math.random() * 2));
    float label;
    Color color;

    public Circle(float x, float y)
    {
        position.x = x;
        position.y = y;
    }

    public Circle()
    {

        if (position.y > Main.f(position.x))
        {
            label = 1;
            color = new Color(1, 0, 0, 1);
        }
        else
        {
            label = 0;
            color = new Color(0, 0, 1, 1);
        }
    }

    public float getPixelX()
    {
        return MathUtils.map(-1, 1, 0, Gdx.graphics.getWidth(), getPosition().x);

    }

    public float getPixelY()
    {
        return MathUtils.map(-1, 1, 0, Gdx.graphics.getHeight(), getPosition().y);
    }

    public Vector2 getPosition()
    {
        return position;
    }

    public void render(ShapeRenderer shapeRenderer)
    {

        shapeRenderer.setColor(color);
        shapeRenderer.circle(getPixelX(), getPixelY(), 20);
    }
}
