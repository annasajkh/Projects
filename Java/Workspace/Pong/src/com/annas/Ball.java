package com.annas;

import org.newdawn.slick.Color;
import org.newdawn.slick.geom.Vector2f;

import java.util.Random;

public class Ball extends Square
{
    float speed = 15f;
    Random random = new Random();
    int[] choices = {135 + random.nextInt(90), -45 + random.nextInt(90)};
    Vector2f velocity = new Vector2f(choices[random.nextInt(1)]).scale(speed);

    public Ball(float x, float y, float width, float height, Color color)
    {
        super(x, y, width, height, color);
    }

    public void collide(Square otherSquare)
    {
        if (intersects(otherSquare))
        {
            if (otherSquare.getX() + otherSquare.getWidth() < getX())
            {
                velocity.setTheta(-velocity.getTheta());
            }
            else
            {

                velocity.setTheta(velocity.getTheta() - (velocity.getTheta() - 90) * 2);
            }
        }
    }

    @Override
    public void update()
    {
        if (getY() <= 0)
        {
            velocity.setTheta(-velocity.getTheta());
        }
        else if (getY() >= 600 - getHeight())
        {
            velocity.setTheta(-velocity.getTheta());
        }

        setLocation(getLocation().add(velocity));
    }
}
