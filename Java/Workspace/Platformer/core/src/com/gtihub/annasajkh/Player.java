package com.gtihub.annasajkh;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Player extends Rectangle
{
    Vector2 velocity = new Vector2();
    int speed = 5;
    float gravity = 0.5f;

    public Player(Vector2 position, float width, float height, Color color)
    {
        super(position, width, height, color);
    }

    public void update()
    {
        if (Gdx.input.isKeyPressed(Input.Keys.D))
        {
            velocity.x = speed;
        }
        else if (Gdx.input.isKeyPressed(Input.Keys.A))
        {
            velocity.x = -speed;
        }

        if (velocity.y == 0 && Gdx.input.isKeyJustPressed(Input.Keys.SPACE))
        {
            velocity.y = 15;
        }

        velocity.y -= gravity;

        position.add(velocity);

        rightSide = position.x + width / 2;
        leftSide = position.x - width / 2;
        topSide = position.y + height / 2;
        bottomSide = position.y - height / 2;


    }

    public void resolveCollision(Rectangle otherRect)
    {
        if (rightSide > otherRect.leftSide && leftSide < otherRect.rightSide && bottomSide < otherRect.topSide &&
                topSide > otherRect.bottomSide)
        {
            float collisionDeepX;
            float collisionDeepY;


            if (position.x > otherRect.position.x)
            {
                collisionDeepX = Math.abs(position.x - otherRect.position.x - width / 2 - otherRect.width / 2);
            }
            else
            {
                collisionDeepX = Math.abs(otherRect.position.x - position.x - width / 2 - otherRect.width / 2);
            }

            if (position.y > otherRect.position.y)
            {
                velocity.x *= 0.8f;
                collisionDeepY = Math.abs(position.y - otherRect.position.y - height / 2 - otherRect.height / 2);
            }
            else
            {
                velocity.x *= 0.8f;
                collisionDeepY = Math.abs(otherRect.position.y - position.y - height / 2 - otherRect.height / 2);
            }

            if (position.x < otherRect.position.x && collisionDeepX < collisionDeepY)
            {
                velocity.x = 0;
                position.x -= collisionDeepX;
            }
            else if (position.x > otherRect.position.x && collisionDeepX < collisionDeepY)
            {
                velocity.x = 0;
                position.x += collisionDeepX;
            }
            else if (position.y > otherRect.position.y && collisionDeepX > collisionDeepY)
            {
                velocity.y = 0;
                position.y += collisionDeepY;
            }
            else if (position.y < otherRect.position.y && collisionDeepX > collisionDeepY)
            {
                velocity.y = 0;
                position.y -= collisionDeepY;
            }
        }
    }
}

