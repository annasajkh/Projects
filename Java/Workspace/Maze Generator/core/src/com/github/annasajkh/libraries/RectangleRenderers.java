package com.github.annasajkh.libraries;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.LinkedList;

public class RectangleRenderers extends ShapeRenderers
{
    boolean filled;


    public RectangleRenderers(boolean filled)
    {
        this.filled = filled;
    }

    public void renderAll(LinkedList<Rectangle> rectangles)
    {
        if (filled)
        {
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        }
        else
        {
            shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        }
        for (Rectangle rectangle : rectangles)
        {
            shapeRenderer.setColor(rectangle.modulate);
            if (rectangle.centered)
            {
                if (!rectangle.dontRender)
                {
                    shapeRenderer.rect(rectangle.position.x - rectangle.size.width / 2,
                            rectangle.position.y - rectangle.size.height / 2, rectangle.size.width / 2,
                            rectangle.size.height / 2, rectangle.size.width, rectangle.size.height, 1, 1,
                            rectangle.rotation);
                }

            }
            else
            {
                if (!rectangle.dontRender)
                {
                    shapeRenderer.rect(rectangle.position.x, rectangle.position.y, rectangle.size.width / 2,
                            rectangle.size.height / 2, rectangle.size.width, rectangle.size.height, 1, 1,
                            rectangle.rotation);
                }

            }
        }
        shapeRenderer.end();
    }


    public void renderAll(Rectangle[] rectangles)
    {
        if (filled)
        {
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        }
        else
        {
            shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        }
        for (Rectangle rectangle : rectangles)
        {
            shapeRenderer.setColor(rectangle.modulate);
            if (rectangle.centered)
            {
                if (!rectangle.dontRender)
                {
                    shapeRenderer.rect(rectangle.position.x - rectangle.size.width / 2,
                            rectangle.position.y - rectangle.size.height / 2, rectangle.size.width / 2,
                            rectangle.size.height / 2, rectangle.size.width, rectangle.size.height, 1, 1,
                            rectangle.rotation);
                }

            }
            else
            {
                if (!rectangle.dontRender)
                {
                    shapeRenderer.rect(rectangle.position.x, rectangle.position.y, rectangle.size.width / 2,
                            rectangle.size.height / 2, rectangle.size.width, rectangle.size.height, 1, 1,
                            rectangle.rotation);
                }
            }
        }
        shapeRenderer.end();
    }
}
