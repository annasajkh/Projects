package com.github.annasajkh;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.github.annasajkh.libraries.RectangleRenderers;
import com.github.annasajkh.libraries.Size;

import java.util.ArrayList;

public class Game extends ApplicationAdapter
{

    static Node[][] nodes;
    static int resolution = 20;
    static RectangleRenderers rectangleRenderers;
    static ArrayList<Node> openSet;
    static ArrayList<Node> closeSet;
    static ArrayList<Node> path;
    static Node start;
    static Node end;
    static boolean done;
    static int rows;
    static int columns;

    @Override
    public void create()
    {
        openSet = new ArrayList<>();
        closeSet = new ArrayList<>();
        columns = Gdx.graphics.getWidth() / resolution;
        rows = Gdx.graphics.getHeight() / resolution;
        path = new ArrayList<>();
        nodes = new Node[rows][columns];
        done = false;

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                nodes[i][j] = new Node(new Vector2(j * resolution + resolution / 2f, i * resolution + resolution / 2f),
                        new Size(resolution, resolution), Color.WHITE, i, j);
                nodes[i][j].centered = true;
            }

        }

        start = nodes[1][1];
        end = nodes[rows - 2][columns - 2];
        start.start = true;
        end.end = true;
        openSet.add(start);

        for (int i = 0; i < rows; i++)
        {
            for (int j = 0; j < columns; j++)
            {
                nodes[i][j].addNeighbors();
                nodes[i][j].setWall();
            }

        }
        rectangleRenderers = new RectangleRenderers(true);
    }

    @Override
    public void render()
    {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (openSet.size() > 0)
        {
            int winner = 0;
            for (int i = 0; i < openSet.size(); i++)
            {
                if (openSet.get(i).getF() < openSet.get(winner).getF())
                {
                    winner = i;
                }
            }

            Node current = openSet.get(winner);

            if (current.equals(end))
            {
                for (Node[] rows : nodes)
                {
                    for (Node node : rows)
                    {
                        if (node.modulate.equals(Color.BLUE))
                        {
                            node.modulate = Color.WHITE;
                        }
                    }
                }

                path.clear();
                Node temp = end;
                path.add(temp);
                while (temp.previous != null)
                {
                    path.add(temp.previous);
                    temp = temp.previous;
                }
                for (Node pth : path)
                {
                    pth.modulate = Color.BLUE;
                }

                start.modulate = Color.DARK_GRAY;
                end.modulate = Color.GOLD;
                done = true;
            }

            openSet.remove(current);
            closeSet.add(current);

            for (Node neighbor : current.neighbors)
            {

                if (!closeSet.contains(neighbor) && !neighbor.wall)
                {
                    float tempG = current.getG() + 1;

                    boolean newPath = false;

                    if (openSet.contains(neighbor))
                    {
                        if (tempG < neighbor.getG())
                        {
                            neighbor.g = tempG;
                            newPath = true;
                        }
                    }
                    else
                    {
                        neighbor.g = tempG;
                        newPath = true;
                        openSet.add(neighbor);
                    }

                    if (newPath)
                    {
                        neighbor.h = heuristic(neighbor, end);
                        neighbor.f = neighbor.getG() + neighbor.getH();
                        neighbor.previous = current;
                    }
                }
            }

            path = new ArrayList<>();
            Node temp = current;
            path.add(temp);
            while (temp.previous != null)
            {
                path.add(temp.previous);
                temp = temp.previous;
            }

        }
        else
        {
            done = true;
        }

        if (!done)
        {

            for (Node oSet : openSet)
            {
                oSet.modulate = Color.GREEN;
            }
            for (Node cSet : closeSet)
            {
                cSet.modulate = Color.RED;
            }
            for (Node pth : path)
            {
                pth.modulate = Color.BLUE;
            }
            for (Node[] rows : nodes)
            {
                for (Node node : rows)
                {
                    if (node.wall)
                    {
                        node.modulate = Color.BLACK;
                    }
                }
            }
            start.modulate = Color.DARK_GRAY;
            end.modulate = Color.GOLD;
        }

        rectangleRenderers.renderAll(nodes);
    }

    private float heuristic(Node a, Node b)
    {
        return Vector2.dst(a.j, a.i, b.j, b.i);
    }

    @Override
    public void dispose()
    {
        rectangleRenderers.dispose();
    }
}
