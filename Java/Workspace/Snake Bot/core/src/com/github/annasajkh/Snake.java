package com.github.annasajkh;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import java.util.LinkedList;

public class Snake
{
    Vector2 position;
    LinkedList<Tail> tail;
    Color color;

    public Snake(Vector2 position)
    {
        tail = new LinkedList<>();
        tail.add(new Tail(position));
        this.position = position;
        color = Game.hsvToRgba(Game.colorHue, 1, 1, 1);
        Game.colorHue += 0.01f;
    }

    public void update()
    {
        for (int i = tail.size() - 1; i > 0; i--)
        {
            tail.get(i).position.x = tail.get(i - 1).getPosition().x;
            tail.get(i).position.y = tail.get(i - 1).getPosition().y;
        }
        tail.getFirst().position = getPosition();
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
