package com.annas;

import org.newdawn.slick.Color;

public class Player extends Square
{

    boolean alreadyAttack = false;
    boolean aiMode = true;

    public Player(float x, float y, float width, float height, Color color)
    {
        super(x, y, width, height, color);
    }

    @Override
    public void update()
    {
        if (aiMode)
        {
            if (Main.ball.getX() < 300 && !alreadyAttack)
            {
                setY(Main.ball.getY() - getWidth() / 2);
                alreadyAttack = true;
            }
            else
            {
                alreadyAttack = false;
            }
        }
        else
        {
            setLocation(50, Main.mousePos.getY() - getHeight() / 2);
        }
    }


}
