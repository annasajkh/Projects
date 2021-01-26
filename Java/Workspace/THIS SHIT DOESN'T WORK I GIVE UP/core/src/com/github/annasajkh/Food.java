package com.github.annasajkh;

import com.badlogic.gdx.math.Vector2;

public class Food
{
    public Vector2 position;
    Snake snake;
    Line[] borders = new Line[4];

    public Food(Snake snake)
    {
        this.snake = snake;
        position = new Vector2(Game.random.nextInt(Game.collums) * Game.scale, Game.random.nextInt(Game.rows) *
                                                                               Game.scale);
        borders[0] = new Line(new Vector2(position.x, position.y), new Vector2(position.x, position.y + Game.scale));
        borders[1] = new Line(new Vector2(position.x, position.y), new Vector2(position.x + Game.scale, position.y));
        borders[2] = new Line(new Vector2(position.x, position.y + Game.scale), new Vector2(position.x + Game.scale,
                                                                                            position.y +
                                                                                            Game.scale));
        borders[3] = new Line(new Vector2(position.x + Game.scale, position.y), new Vector2(position.x + Game.scale,
                                                                                            position.y +
                                                                                            Game.scale));

        for (Tail tail : snake.tails)
        {
            while (position.equals(tail.position))
            {
                position = new Vector2(Game.random.nextInt(Game.collums) * Game.scale, Game.random.nextInt(Game.rows) *
                                                                                       Game.scale);
                borders[0] = new Line(new Vector2(position.x, position.y), new Vector2(position.x, position.y +
                                                                                                   Game.scale));
                borders[1] = new Line(new Vector2(position.x, position.y), new Vector2(position.x +
                                                                                       Game.scale, position.y));
                borders[2] = new Line(new Vector2(position.x, position.y + Game.scale), new Vector2(position.x +
                                                                                                    Game.scale, position.y +
                                                                                                                Game.scale));
                borders[3] = new Line(new Vector2(position.x + Game.scale, position.y), new Vector2(position.x +
                                                                                                    Game.scale, position.y +
                                                                                                                Game.scale));
            }
        }
    }

    public void update()
    {

        if (snake.position.equals(getPosition()))
        {
            snake.attempt = 0;
            snake.score++;
            snake.tails.add(new Tail(new Vector2(0, -1000), snake.colorHue, snake.forward));
            position = new Vector2(Game.random.nextInt(Game.collums) * Game.scale, Game.random.nextInt(Game.rows) *
                                                                                   Game.scale);
            borders[0] = new Line(new Vector2(position.x, position.y), new Vector2(position.x, position.y +
                                                                                               Game.scale));
            borders[1] = new Line(new Vector2(position.x, position.y), new Vector2(position.x +
                                                                                   Game.scale, position.y));
            borders[2] = new Line(new Vector2(position.x, position.y + Game.scale), new Vector2(position.x + Game.scale,
                                                                                                position.y +
                                                                                                Game.scale));
            borders[3] = new Line(new Vector2(position.x + Game.scale, position.y), new Vector2(position.x + Game.scale,
                                                                                                position.y +
                                                                                                Game.scale));
            for (Tail tail : snake.tails)
            {
                while (position.equals(tail.position))
                {
                    position = new Vector2(Game.random.nextInt(Game.collums) *
                                           Game.scale, Game.random.nextInt(Game.rows) * Game.scale);
                    borders[0] = new Line(new Vector2(position.x, position.y), new Vector2(position.x, position.y +
                                                                                                       Game.scale));
                    borders[1] = new Line(new Vector2(position.x, position.y), new Vector2(position.x +
                                                                                           Game.scale, position.y));
                    borders[2] = new Line(new Vector2(position.x, position.y + Game.scale), new Vector2(position.x +
                                                                                                        Game.scale,
                                                                                                        position.y +
                                                                                                        Game.scale));
                    borders[3] = new Line(new Vector2(position.x + Game.scale, position.y), new Vector2(position.x +
                                                                                                        Game.scale,
                                                                                                        position.y +
                                                                                                        Game.scale));
                }
            }
        }
    }

    public Vector2 getPosition()
    {
        return new Vector2(position);
    }

    public float getX()
    {
        return position.x;
    }

    public float getY()
    {
        return position.y;
    }
}
