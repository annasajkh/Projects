package com.annas;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Line;
import org.newdawn.slick.geom.Vector2f;

public class Ray extends Line
{

    Vector2f extended = new Vector2f(0, 0);
    Vector2f direction;
    float amount = 10f;

    public Ray(float x1, float y1, float x2, float y2, Vector2f direction)
    {
        super(x1, y1, x2, y2);
        this.direction = direction;
    }

    private Vector2f lineIntersection(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4)
    {

        float uA = ((x4 - x3) * (y1 - y3) - (y4 - y3) * (x1 - x3)) / ((y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1));
        float uB = ((x2 - x1) * (y1 - y3) - (y2 - y1) * (x1 - x3)) / ((y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1));

        if (uA >= 0 && uA <= 1 && uB >= 0 && uB <= 1)
        {
            return new Vector2f(x1 + (uA * (x2 - x1)), y1 + (uA * (y2 - y1)));
        }
        return null;
    }

    public void update(Boundary boundary)
    {


        if (getX2() < 1024 && getX2() > 0 && getY1() < 600 && getY2() > 0)
        {
            extended.add(direction.normalise().scale(amount));
        }

        set(Main.mousePos.getX(), Main.mousePos.getY(), Main.mousePos.getX() + extended.getX(), Main.mousePos.getY() + extended.getY());
        Vector2f intersectPoint = lineIntersection(getX1(), getY1(), getX2(), getY2(), boundary.getX1(), boundary.getY1(), boundary.getX2(), boundary.getY2());

        if (intersectPoint != null)
        {

            set(Main.mousePos.getX(), Main.mousePos.getY(), intersectPoint.getX(), intersectPoint.getY());
        }
    }

    public void draw(Graphics graphics)
    {
        graphics.setColor(Color.white);
        graphics.drawLine(getX1(), getY1(), getX2(), getY2());
    }
}
