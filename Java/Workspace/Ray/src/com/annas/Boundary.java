package com.annas;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Line;

public class Boundary extends Line
{


    public Boundary(float x1, float y1, float x2, float y2)
    {
        super(x1, y1, x2, y2);
    }

    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.gray);
        graphics.drawLine(getX1(), getY1(), getX2(), getY2());
    }
}
