package com.github.annasajkh;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Tail
{

    Vector2 position;
    Color color;

    public Tail(Vector2 position)
    {
        this.position = position;
        color = Game.hsvToRgba(Game.colorHue, 1, 1, 1);
        if (Game.colorHue > 0.8 || Game.colorHue < 0.2)
        {
            Game.forward = !Game.forward;
        }
        if (Game.forward)
        {
            Game.colorHue += 0.01f;
        }
        else
        {
            Game.colorHue -= 0.01f;
        }

    }


    public void render(ShapeRenderer shapeRenderer)
    {
        shapeRenderer.setColor(color);
        shapeRenderer.rect(getPosition().x, getPosition().y, Game.scale, Game.scale);

    }

    public Vector2 getPosition()
    {
        return position;
    }
}
