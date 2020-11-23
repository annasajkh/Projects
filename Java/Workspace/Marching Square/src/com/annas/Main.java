package com.annas;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Vector2f;

public class Main extends BasicGame
{

    static int resolution = 10;
    static int columns = 1 + 1000 / resolution;
    static int rows = 1 + 600 / resolution;
    static double[][] field = new double[columns][rows];
    static int length = resolution;
    OpenSimplexNoise openSimplexNoise;
    static float increment = 0.1f;
    static float zOffset = 0;

    public double getState(double a, double b, double c, double d)
    {
        return a * 8 + b * 4 + c * 2 + d * 1;
    }

    public void drawLine(Vector2f v1, Vector2f v2, Graphics graphics)
    {
        graphics.setColor(Color.white);
        graphics.drawLine(v1.x, v1.y, v2.x, v2.y);
    }


    public static void main(String[] arguments)
    {

        try
        {
            AppGameContainer app = new AppGameContainer(new Main());
            app.setDisplayMode(1000, 600, false);
            app.setShowFPS(false);
            app.start();
        } catch (SlickException slickException)
        {
            slickException.printStackTrace();
        }
    }

    public Main()
    {
        super("Marching Squares");
    }

    @Override
    public void init(GameContainer gameContainer)
    {
        openSimplexNoise = new OpenSimplexNoise();

    }

    @Override
    public void update(GameContainer gameContainer, int delta)
    {


    }

    @Override
    public void render(GameContainer container, Graphics graphics)
    {
        graphics.setBackground(Color.darkGray);
        float xOffset = 0;
        for (int i = 0; i < columns; i++)
        {
            xOffset += increment;
            float yOffset = 0;
            for (int j = 0; j < rows; j++)
            {
                field[i][j] = openSimplexNoise.eval(xOffset, yOffset, zOffset);
                yOffset += increment;

            }
        }

        zOffset += 0.01f;

        for (int i = 0; i < columns; i++)
        {
            for (int j = 0; j < rows; j++)
            {
                graphics.setColor(new Color(255, 255, 255, (int) (30 + (field[i][j] * 225))));
                graphics.fillRect(i * resolution - length / 2f, j * resolution - length / 2f, length, length);
            }

        }

        for (int i = 0; i < columns - 1; i++)
        {
            for (int j = 0; j < rows - 1; j++)
            {
                float x = i * resolution;
                float y = j * resolution;

                int state = (int) getState(Math.ceil(field[i][j]), Math.ceil(field[i + 1][j]),
                        Math.ceil(field[i + 1][j + 1]), Math.ceil(field[i][j + 1]));

                Vector2f a = new Vector2f(x + resolution / 2f, y);
                Vector2f b = new Vector2f(x + resolution, y + resolution / 2f);
                Vector2f c = new Vector2f(x + resolution / 2f, y + resolution);
                Vector2f d = new Vector2f(x, y + resolution / 2f);

                switch (state)
                {
                    case 1:
                    case 14:
                        drawLine(c, d, graphics);
                        break;
                    case 2:
                    case 13:
                        drawLine(b, c, graphics);
                        break;
                    case 3:
                    case 12:
                        drawLine(b, d, graphics);
                        break;
                    case 4:
                    case 11:
                        drawLine(a, b, graphics);
                        break;
                    case 5:
                        drawLine(a, d, graphics);
                        drawLine(b, c, graphics);
                        break;
                    case 6:
                    case 9:
                        drawLine(a, c, graphics);
                        break;
                    case 7:
                    case 8:
                        drawLine(a, d, graphics);
                        break;
                    case 10:
                        drawLine(a, b, graphics);
                        drawLine(c, d, graphics);
                        break;
                }
            }

        }
    }
}