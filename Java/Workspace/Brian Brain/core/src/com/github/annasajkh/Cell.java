package com.github.annasajkh;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class Cell
{
    ArrayList<Cell> neighbors = new ArrayList<>();
    Vector2 position;
    // 0 = die
    // 1 = dying
    // 2 = alive
    byte state;
    byte neighborOn;

    public Cell(Vector2 position)
    {
        this.position = position;
        this.state = 0;

    }

    public void update()
    {
        if (state == 0 && neighborOn == 2)
        {
            state = 2;
        }
        else if (state != 0)
        {
            state--;
        }


    }

    public void render(ShapeRenderer shapeRenderer)
    {
        neighborOn = 0;
        for (Cell neighbor : neighbors)
        {
            if (neighbor.state == 2)
            {
                neighborOn++;
            }
        }
        switch (state)
        {
            case 0:
                shapeRenderer.setColor(Color.BLACK);
                break;
            case 1:
                shapeRenderer.setColor(Color.BLUE);
                break;
            case 2:
                shapeRenderer.setColor(Color.CYAN);
        }
        shapeRenderer.rect(position.x, position.y, Game.scale, Game.scale);
    }
}
