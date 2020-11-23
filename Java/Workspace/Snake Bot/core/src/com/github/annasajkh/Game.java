package com.github.annasajkh;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.Random;

public class Game extends ApplicationAdapter
{

    static ShapeRenderer shapeRenderer;
    static float scale = 25;
    static Snake snake;
    static Food food;
    static Random random = new Random();
    static float colorHue = 0.2f;
    static boolean forward = true;
    static ArrayList<int[]> hamiltonianCycle;
    static int rows;
    static int collums;
    static int index = 0;
    static boolean end = false;

    @Override
    public void create()
    {
        shapeRenderer = new ShapeRenderer();
        snake = new Snake(new Vector2(0, 0));
        food = new Food();
        rows = (int) (Gdx.graphics.getHeight() / scale);
        collums = (int) (Gdx.graphics.getWidth() / scale);
        hamiltonianCycle = new ArrayList<>();
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < collums; j++)
            {
                if (j > 0)
                {
                    hamiltonianCycle.add(new int[]{j, i});
                }
            }
            i++;
            for (int j = collums - 1; j >= 0; j--)
            {
                if (j > 0)
                {
                    hamiltonianCycle.add(new int[]{j, i});
                }
            }
        }
        for (int i = rows - 1; i >= 0; i--)
        {
            hamiltonianCycle.add(new int[]{0, i});
        }
    }

    @Override
    public void render()
    {
        if (!end)
        {
            snake.position =
                    new Vector2(hamiltonianCycle.get(index)[0] * scale, hamiltonianCycle.get(index)[1] * scale);
            index++;
            if (index > hamiltonianCycle.size() - 1)
            {
                index = 0;
            }

            food.update();
            snake.update();
        }

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        for (int i = 0; i < snake.tail.size(); i++)
        {
            if (i > 1)
            {
                if (snake.tail.get(i).getPosition().equals(snake.getPosition()))
                {
                    end = true;
                }
            }
        }

        food.render(shapeRenderer);
        for (Tail tail : snake.tail)

        {
            tail.render(shapeRenderer);
        }
        snake.render(shapeRenderer);
        shapeRenderer.end();

    }

    @Override
    public void dispose()
    {
        shapeRenderer.dispose();
    }


    public static Color hsvToRgba(float hue, float saturation, float value, float alpha)
    {

        int h = (int) (hue * 6);
        float f = hue * 6 - h;
        float p = value * (1 - saturation);
        float q = value * (1 - f * saturation);
        float t = value * (1 - (1 - f) * saturation);

        switch (h)
        {
            case 0:
                return new Color(value, t, p, alpha);
            case 1:
                return new Color(q, value, p, alpha);
            case 2:
                return new Color(p, value, t, alpha);
            case 3:
                return new Color(p, q, value, alpha);
            case 4:
                return new Color(t, p, value, alpha);
            case 5:
                return new Color(value, p, q, alpha);
            default:
                throw new RuntimeException(
                        "Something went wrong when converting from HSV to RGB. Input was " + hue + ", " + saturation +
                                ", " + value);
        }
    }
}
