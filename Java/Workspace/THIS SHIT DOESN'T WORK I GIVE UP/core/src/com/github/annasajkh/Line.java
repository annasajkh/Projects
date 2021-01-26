package com.github.annasajkh;

import com.badlogic.gdx.math.Vector2;

public class Line
{
    Vector2 pointA;
    Vector2 pointB;

    public Line(Vector2 pointA, Vector2 pointB)
    {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public float length()
    {
        return pointA.dst(pointB);
    }

    private Vector2 lineIntersection(float x1, float y1, float x2, float y2, float x3, float y3, float x4, float y4)
    {

        float uA = ((x4 - x3) * (y1 - y3) - (y4 - y3) * (x1 - x3)) / ((y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1));
        float uB = ((x2 - x1) * (y1 - y3) - (y2 - y1) * (x1 - x3)) / ((y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1));

        if (uA >= 0 && uA <= 1 && uB >= 0 && uB <= 1)
        {
            return new Vector2(x1 + (uA * (x2 - x1)), y1 + (uA * (y2 - y1)));
        }
        return null;
    }

    public Vector2 collide(Line other)
    {
        return lineIntersection(pointA.x, pointA.y, pointB.x, pointB.y, other.pointA.x, other.pointA.y, other.pointB.x, other.pointB.y);
    }


}
