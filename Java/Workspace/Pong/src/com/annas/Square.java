package com.annas;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public abstract class Square extends Rectangle
{

    Color color;

    public Square(float x, float y, float width, float height, Color color)
    {
        super(x, y, width, height);
        this.color = color;
    }

    public abstract void update();

    public void draw(Graphics graphics)
    {
        graphics.setColor(color);
        graphics.fill(this);
    }
}
