package com.github.annasajkh.libraries;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class ShapeRenderers
{

    protected ShapeRenderer shapeRenderer;

    public ShapeRenderers()
    {
        shapeRenderer = new ShapeRenderer();
    }


    public void dispose()
    {
        shapeRenderer.dispose();
    }
}
