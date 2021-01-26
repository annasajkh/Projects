package com.github.annasajkh;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game extends ApplicationAdapter
{

    static ShapeRenderer shapeRenderer;
    static float scale = 50;
    static List<Snake> snakes;
    static List<Snake> snakeDies;
    static Random random = new Random();
    static int inputSize = 24;
    static int rows;
    static int collums;
    static int populationSize = 2000;
    static int index;
    static int generation = 0;
    static BitmapFont font;
    static SpriteBatch spriteBatch;
    static Snake bestSnake;
    static boolean isRendering = false;
    static Line[] borders = new Line[4];

    public static void removeSnake(int index)
    {
        Snake die = snakes.get(index);
        snakeDies.add(snakes.remove(index));
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
                throw new RuntimeException("Something went wrong when converting from HSV to RGB. Input was " +
                                           hue +
                                           ", " +
                                           saturation +
                                           ", " +
                                           value);
        }
    }

    @Override
    public void create()
    {
        font = new BitmapFont();
        spriteBatch = new SpriteBatch();

        rows = (int) (Gdx.graphics.getHeight() / scale);
        collums = (int) (Gdx.graphics.getWidth() / scale);


        borders[0] = new Line(new Vector2(0, 0), new Vector2(0, Gdx.graphics.getHeight()));
        borders[1] = new Line(new Vector2(0, 0), new Vector2(Gdx.graphics.getWidth(), 0));
        borders[2] = new Line(new Vector2(0, Gdx.graphics.getHeight()), new Vector2(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));
        borders[3] = new Line(new Vector2(Gdx.graphics.getWidth(), 0), new Vector2(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));


        snakeDies = new ArrayList<>(populationSize);
        snakes = new ArrayList<>(populationSize);
        index = 0;
        shapeRenderer = new ShapeRenderer();
        for (int i = 0; i < populationSize; i++)
        {
            snakes.add(new Snake());
        }
    }

    @Override
    public void render()
    {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (snakes.isEmpty())
        {
            if (!isRendering)
            {
                bestSnake = snakeDies.get(0);
                for (Snake snake : snakeDies)
                {
                    if (snake.score > bestSnake.score)
                    {
                        bestSnake = snake;
                    }
                }
                bestSnake = new Snake(bestSnake.brain.clone());
            }

            if (!bestSnake.die && generation % 100 == 0 && generation != 0)
            {
                isRendering = true;
                bestSnake.update();
                shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
                bestSnake.render(shapeRenderer);
                shapeRenderer.end();
                spriteBatch.begin();
                font.draw(spriteBatch, "generation : " + generation, 10, 20);
                spriteBatch.end();

                try
                {
                    Thread.sleep(100);
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }
            }
            else
            {
                Snake[] bestSnakes = new Snake[populationSize / 2];
                for (int i = 0; i < bestSnakes.length; i++)
                {
                    bestSnake = snakeDies.get(0);
                    for (Snake snake : snakeDies)
                    {
                        if (snake.score > bestSnake.score)
                        {
                            bestSnake = snake;
                        }
                    }
                    bestSnakes[i] = new Snake(bestSnake.brain.clone());
                    snakeDies.remove(bestSnake);
                }
                snakes = new ArrayList<>(populationSize);
                generation++;

                for (int i = 0; i < populationSize / 2; i++)
                {
                    if (bestSnakes[i].score > 0)
                    {
                        snakes.add(new Snake(bestSnakes[i].brain.clone()
                                                                .mutate(0.5)));
                    }
                    else
                    {
                        snakes.add(new Snake());
                    }
                }

                for (int i = 0; i < populationSize / 2; i++)
                {
                    if (bestSnakes[i].score > 0)
                    {
                        snakes.add(bestSnakes[i]);
                    }
                    else
                    {
                        snakes.add(new Snake());
                    }
                }
                isRendering = false;
                snakeDies.clear();
            }
        }
        else
        {
            for (int i = snakes.size() - 1; i >= 0; i--)
            {
                snakes.get(i)
                      .update();
                if (snakes.get(i).die)
                {
                    removeSnake(i);
                }
            }
        }
    }


    @Override
    public void dispose()
    {
        shapeRenderer.dispose();
    }
}
