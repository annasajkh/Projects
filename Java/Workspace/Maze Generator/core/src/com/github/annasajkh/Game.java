package com.github.annasajkh;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.github.annasajkh.libraries.Line;
import com.github.annasajkh.libraries.LineRenderers;
import com.github.annasajkh.libraries.MiniVector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class Game extends ApplicationAdapter
{
    static Cell[][] cells;
    static LinkedList<Line> lines;
    static int colums;
    static int rows;
    static float size = 10;
    static LineRenderers lineRenderers;
    static Cell current;
    static Random random;
    static LinkedList<Cell> notVisitedCell;
    static ArrayList<Cell> stack;
    static boolean done = false;
    static float r;
    static float g;
    static float b;

    public void choose()
    {
        current.checkNeigbors();
        if (notVisitedCell.size() > 0)
        {
            Cell next = notVisitedCell.get(random.nextInt(notVisitedCell.size()));
            int y = next.i - current.i;
            int x = next.j - current.j;

            if (x == -1)
            {
                current.walls[3] = false;
                next.walls[2] = false;
            }
            else if (x == 1)
            {
                current.walls[2] = false;
                next.walls[3] = false;
            }
            if (y == 1)
            {
                current.walls[0] = false;
                next.walls[1] = false;
            }
            else if (y == -1)
            {
                current.walls[1] = false;
                next.walls[0] = false;
            }
            current = next;
            current.visited = true;
            stack.add(current);
            notVisitedCell.clear();
        }
        else
        {
            stack.remove(stack.size() - 1);
            if (stack.size() != 0)
            {
                current = stack.get(stack.size() - 1);
            }
            else
            {
                done = true;
            }
        }
    }

    @Override
    public void create()
    {
        lines = new LinkedList<>();
        notVisitedCell = new LinkedList<>();
        stack = new ArrayList<>();
        random = new Random();
        r = random.nextFloat() / 1.1f;
        g = random.nextFloat() / 1.1f;
        b = random.nextFloat() / 1.1f;
        rows = (int) Math.floor(Gdx.graphics.getHeight() / size);
        colums = (int) Math.floor(Gdx.graphics.getWidth() / size);
        cells = new Cell[rows][colums];

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < colums; j++)
            {
                cells[i][j] = new Cell(new MiniVector(j * size, i * size));
            }
        }
        for (Cell[] row : cells)
        {
            for (Cell cell : row)
            {
                lines.addAll(Arrays.asList(cell.lines));
            }
        }
        lineRenderers = new LineRenderers();
        current = cells[0][0];
        stack.add(current);
    }

    @Override
    public void render()
    {
        if (Gdx.input.isKeyPressed(Input.Keys.SPACE))
        {
            create();
            done = false;
        }
        Gdx.gl.glClearColor(r, g, b, 0.5f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        for (Cell[] row : cells)
        {
            for (Cell cell : row)
            {

                cell.update();
            }
            if (!done)
            {
                choose();
            }
        }
        lineRenderers.renderAll(lines);

    }

    @Override
    public void dispose()
    {
        lineRenderers.dispose();
    }
}
