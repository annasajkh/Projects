package com.github.annasajkh;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.github.annasajkh.libraries.Rectangle;
import com.github.annasajkh.libraries.Size;

import java.util.ArrayList;

public class Node extends Rectangle

{

    float f = 0;
    float g = 0;
    float h = 0;
    int i;
    int j;
    boolean wall;
    ArrayList<Node> neighbors = new ArrayList<>();
    public Node previous;
    boolean end = false;
    boolean start = false;

    public Node(Vector2 position, Size size, Color modulate, int i, int j)
    {
        super(position, size, modulate);
        this.i = i;
        this.j = j;
    }

    public void setWall()
    {
        if (Math.random() < 0.3 && !end && !start)
        {
            wall = true;
        }
        else
        {
            wall = false;
        }
    }

    public void addNeighbors()
    {
        if (i < Game.rows - 1)
        {
            neighbors.add(Game.nodes[i + 1][j]);
        }
        if (i > 0)
        {
            neighbors.add(Game.nodes[i - 1][j]);
        }

        if (j < Game.columns - 1)
        {
            neighbors.add(Game.nodes[i][j + 1]);
        }
        if (j > 0)
        {
            neighbors.add(Game.nodes[i][j - 1]);
        }
    }

    public float getF()
    {
        return f;
    }

    public float getG()
    {
        return g;
    }

    public float getH()
    {
        return h;
    }

    public int getI()
    {
        return i;
    }

    public int getJ()
    {
        return j;
    }
}
