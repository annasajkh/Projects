package com.github.annasajkh;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;

import java.util.ArrayList;
import java.util.List;

public class Game extends ApplicationAdapter
{
    static ShapeRenderer shapeRenderer;
    static List<Pillar> pillars;
    static int index = 0;
    static int pillarCount = 600;
    static float different;

    public static Pillar getSmallest(List<Pillar> pillars, int index)
    {
        Pillar smallest = pillars.get(index);
        for (int i = index; i < pillarCount; i++)
        {
            if (pillars.get(i).value < smallest.value)
            {
                smallest = pillars.get(i);
            }
        }
        return smallest;
    }

    public static void shuffling(Pillar a, Pillar b)
    {
        Pillar tempB = b.copy();
        pillars.set(pillars.indexOf(b), a);
        pillars.set(pillars.indexOf(a), tempB);
    }

    @Override
    public void create()
    {
        shapeRenderer = new ShapeRenderer();
        pillars = new ArrayList<>();
        different = Gdx.graphics.getWidth() / (float) pillarCount;
        for (int i = 0; i < pillarCount; i++)
        {
            pillars.add(new Pillar(i + 1, different * i, different));
        }
        for (int i = 0; i < 5000; i++)
        {
            shuffling(pillars.get(MathUtils.random(pillarCount - 1)), pillars.get(MathUtils.random(pillarCount - 1)));
        }
    }

    @Override
    public void render()
    {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (index < pillarCount)
        {
            Pillar smallest = getSmallest(pillars, index);
            pillars.remove(smallest);
            pillars.add(0, smallest);
            index++;
        }
        for (int i = 0; i < pillarCount; i++)
        {
            pillars.get(i).positionX = i * different;
        }
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        for (Pillar pillar : pillars)
        {
            pillar.render(shapeRenderer, Color.WHITE);
        }
        shapeRenderer.end();
    }

    @Override
    public void dispose()
    {
        shapeRenderer.dispose();
    }
}
