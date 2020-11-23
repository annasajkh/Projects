package com.github.annasajkh;

import com.badlogic.gdx.graphics.Color;
import com.github.annasajkh.libraries.Line;
import com.github.annasajkh.libraries.MiniVector;

public class Cell
{
    Line[] lines;
    public boolean visited;
    public MiniVector position;
    int i;
    int j;
    boolean[] walls;

    public Cell(MiniVector position)
    {
        lines = new Line[4];
        visited = false;
        //top,bottom,rigt,left
        walls = new boolean[]{true, true, true, true};
        this.position = position;
        i = (int) ((int) position.y / Game.size);
        j = (int) ((int) position.x / Game.size);
        //top
        lines[0] = new Line(new MiniVector(position.getX(), position.getY() + Game.size),
                new MiniVector(position.getX() + Game.size, position.getY() + Game.size), Color.WHITE);
        //bottom
        lines[1] = new Line(new MiniVector(position.getX(), position.getY()),
                new MiniVector(position.getX() + Game.size, position.getY()), Color.WHITE);
        //right
        lines[2] = new Line(new MiniVector(position.getX() + Game.size, position.getY()),
                new MiniVector(position.getX() + Game.size, position.getY() + Game.size), Color.WHITE);
        //left
        lines[3] = new Line(new MiniVector(position.getX(), position.getY()),
                new MiniVector(position.getX(), position.getY() + Game.size), Color.WHITE);
    }

    public boolean check(int i, int j)
    {
        if (i < 0 || i > Game.rows - 1 || j < 0 || j > Game.colums - 1)
        {
            return false;
        }
        return !Game.cells[i][j].visited;
    }

    public void checkNeigbors()
    {
        // check if neigbors top is not visited the push the not visited arraylist
        if (check(i + 1, j))
        {
            Game.notVisitedCell.add(Game.cells[i + 1][j]);
        }
        // check if neigbors bottom is not visited the push the not visited arraylist
        if (check(i - 1, j))
        {
            Game.notVisitedCell.add(Game.cells[i - 1][j]);
        }

        // check if neigbors right is not visited the push the not visited arraylist
        if (check(i, j + 1))
        {
            Game.notVisitedCell.add(Game.cells[i][j + 1]);
        }
        // check if neigbors down left not visited the push the not visited arraylist
        if (check(i, j - 1))
        {
            Game.notVisitedCell.add(Game.cells[i][j - 1]);
        }
    }

    public void update()
    {

        if (walls[0])
        {
            lines[0].dontRender = false;
        }
        else
        {
            lines[0].dontRender = true;
        }

        if (walls[1])
        {
            lines[1].dontRender = false;
        }
        else
        {
            lines[1].dontRender = true;
        }
        if (walls[2])
        {
            lines[2].dontRender = false;
        }
        else
        {
            lines[2].dontRender = true;
        }

        if (walls[3])
        {
            lines[3].dontRender = false;
        }
        else
        {
            lines[3].dontRender = true;
        }
    }
}
