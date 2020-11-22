package com.annas;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Vector2f;

public class Ant extends Cell
{
    Vector2f[] directions;
    int directionIndex = 0;

    public Ant(float x, float y, float width, float height, Color color, int step)
    {
        super(x, y, width, height, color);
        directions = new Vector2f[]{new Vector2f(0, -step), new Vector2f(step, 0), new Vector2f(0, step),
                new Vector2f(-step, 0)};
    }

    public void move()
    {
        if (directionIndex > directions.length - 1)
        {
            directionIndex = 0;
        }
        else if (directionIndex < 0)
        {
            directionIndex = directions.length - 1;
        }
        setLocation(getLocation().add(directions[directionIndex]));
    }

    public void update(Cell cell)
    {
        if (cell.getLocation().equals(getLocation()))
        {
            if (cell.color == Color.white)
            {
                directionIndex += 1;
                cell.color = Color.black;
            }
            else
            {
                directionIndex -= 1;
                cell.color = Color.white;
            }
        }
    }
}
