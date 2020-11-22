package com.annas;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public class Cell extends Rectangle
{
    Color color;

    public Cell(float x, float y, float width, float height, Color color)
    {
        super(x, y, width, height);
        this.color = color;
    }

    public void draw(Graphics graphics)
    {
        graphics.setColor(color);
        graphics.fillRect(x, y, width, height);
    }
}
