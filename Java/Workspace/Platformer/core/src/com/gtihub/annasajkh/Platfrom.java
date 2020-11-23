package com.gtihub.annasajkh;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Platfrom extends Rectangle
{
    public Platfrom(Vector2 position, float width, float height, Color color)
    {
        super(position, width, height, color);
    }

    public void update()
    {
        rightSide = position.x + width / 2;
        leftSide = position.x - width / 2;
        topSide = position.y + height / 2;
        bottomSide = position.y - height / 2;
    }
}
