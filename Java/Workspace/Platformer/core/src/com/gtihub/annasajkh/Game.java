package com.gtihub.annasajkh;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Game extends ApplicationAdapter
{

    ShapeRenderer shapeRenderer;
    Player player;
    Platfrom[] platfroms;

    @Override
    public void create()
    {
        shapeRenderer = new ShapeRenderer();
        platfroms = new Platfrom[6];
        player = new Player(new Vector2(500, 500), 50, 100, Color.GREEN);
        platfroms[0] = new Platfrom(new Vector2(25, 300), 50, 600, Color.GRAY);
        platfroms[1] = new Platfrom(new Vector2(500, 25), 1000, 50, Color.GRAY);
        platfroms[2] = new Platfrom(new Vector2(975, 300), 50, 600, Color.GRAY);
        platfroms[3] = new Platfrom(new Vector2(500, 200), 500, 50, Color.GRAY);
        platfroms[4] = new Platfrom(new Vector2(250, 400), 250, 50, Color.GRAY);
        platfroms[5] = new Platfrom(new Vector2(750, 400), 250, 50, Color.GRAY);
    }

    @Override
    public void render()
    {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        player.update();
        for (Platfrom platfrom : platfroms)
        {
            platfrom.update();
            player.resolveCollision(platfrom);
        }
        for (Platfrom platfrom : platfroms)
        {
            platfrom.render(shapeRenderer);
        }
        player.render(shapeRenderer);
        shapeRenderer.end();
    }

    @Override
    public void dispose()
    {
        shapeRenderer.dispose();
    }
}
