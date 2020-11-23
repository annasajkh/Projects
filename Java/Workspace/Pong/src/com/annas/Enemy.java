package com.annas;

import org.newdawn.slick.Color;

public class Enemy extends Square
{

    boolean alreadyAttack = false;

    public Enemy(float x, float y, float width, float height, Color color)
    {
        super(x, y, width, height, color);
    }

    @Override
    public void update()
    {
        if (Main.ball.getX() > 750 && !alreadyAttack)
        {
            setY(Main.ball.getY()- getWidth()/2);
            alreadyAttack = true;
        }
        else
        {
            alreadyAttack = false;
        }
    }
}
