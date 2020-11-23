package com.github.annasajkh;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Food
{
    public Vector2 position;

    public Food()
    {
        position = new Vector2(Game.random.nextInt(40) * Game.scale, Game.random.nextInt(24) * Game.scale);
    }

    public void update()
    {
        if (Game.snake.getPosition().equals(getPosition()))
        {
            //snake eat da food
            for (int i = 0; i < 50; i++)
            {
                Game.snake.tail.add(new Tail(new Vector2(0, -1000)));
            }
            position = new Vector2(Game.random.nextInt(Game.collums) * Game.scale,
                    Game.random.nextInt(Game.rows) * Game.scale);
        }
    }

    public void render(ShapeRenderer shapeRenderer)
    {
        for (Tail tail : Game.snake.tail)
        {
            while (position.equals(tail.getPosition()))
            {
                position = new Vector2(Game.random.nextInt(40) * Game.scale, Game.random.nextInt(24) * Game.scale);
            }
        }
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.rect(position.x, position.y, Game.scale, Game.scale);
    }

    public Vector2 getPosition()
    {
        return position;
    }
}
