package com.annas;

import org.newdawn.slick.*;

public class Main extends BasicGame
{

    static Cell[][] cells;
    Ant ant;
    static boolean draw;
    static int timeStep;
    static int cellSize;

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
        super("Ant");
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException
    {
        draw = false;
        timeStep = 100;
        cellSize = 10;

        cells = new Cell[1000 / cellSize][600 / cellSize];

        for (int x = 0; x < cells.length; x++)
        {
            for (int y = 0; y < cells[x].length; y++)
            {
                cells[x][y] = new Cell(x * cellSize, y * cellSize, cellSize, cellSize, Color.white);
            }
        }

        ant = new Ant(500, 300, cellSize, cellSize, Color.red, cellSize);

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException
    {
    }

    @Override
    public void render(GameContainer container, Graphics graphics) throws SlickException
    {
        for (int i = 0; i < timeStep; i++)
        {
            for (Cell[] cellRows : cells)
            {
                for (Cell cell : cellRows)
                {
                    if (!draw)
                    {
                        cell.draw(graphics);
                    }
                    ant.update(cell);
                }
            }

            draw = true;
            ant.move();
        }
        ant.draw(graphics);
        draw = false;
    }
}