package com.github.annasajkh;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Game extends ApplicationAdapter
{
    ShapeRenderer shapeRenderer;
    static float scale = 2;
    Cell[][] cells;
    int rows;
    int colums;

    @Override
    public void create()
    {
        shapeRenderer = new ShapeRenderer();
        rows = (int) (Gdx.graphics.getHeight() / Game.scale);
        colums = (int) (Gdx.graphics.getWidth() / Game.scale);
        cells = new Cell[rows][colums];
        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < colums; j++)
            {

                cells[i][j] = new Cell(new Vector2(j * scale, i * scale));

            }
        }
        for (int i = 0; i < cells.length; i++)
        {
            for (int j = 0; j < cells[i].length; j++)
            {
                if (j != 0)
                {
                    cells[i][j].neighbors.add(cells[i][j - 1]);
                }
                if (j < cells[i].length - 1)
                {
                    cells[i][j].neighbors.add(cells[i][j + 1]);
                }
                if (i != 0)
                {
                    cells[i][j].neighbors.add(cells[i - 1][j]);
                }
                if (i < cells.length - 1)
                {
                    cells[i][j].neighbors.add(cells[i + 1][j]);
                }

                if (i != 0 && j != 0)
                {
                    cells[i][j].neighbors.add(cells[i - 1][j - 1]);
                }
                if (i < cells.length - 1 && j != 0)
                {
                    cells[i][j].neighbors.add(cells[i + 1][j - 1]);
                }

                if (i < cells.length - 1 && j < cells[i].length - 1)
                {
                    cells[i][j].neighbors.add(cells[i + 1][j + 1]);
                }
                if (i != 0 && j < cells[i].length - 1)
                {
                    cells[i][j].neighbors.add(cells[i - 1][j + 1]);
                }
            }
        }


    }

    @Override
    public void render()
    {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        for (int i = 0; i < cells.length; i++)
        {
            for (int j = 0; j < cells[i].length; j++)
            {
                cells[i][j].render(shapeRenderer);
            }
        }
        shapeRenderer.end();
        for (int i = 0; i < cells.length; i++)
        {
            for (int j = 0; j < cells[i].length; j++)
            {
                cells[i][j].update();
            }
        }

    }

    @Override
    public void dispose()
    {
        shapeRenderer.dispose();
    }
}
