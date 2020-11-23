package com.github.annasajkh.libraries;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.LinkedList;

public class EllipseRenderers extends ShapeRenderers
{
    boolean filled;


    public EllipseRenderers(boolean filled)
    {
        this.filled = filled;
    }

    public void renderAll(LinkedList<Ellipse> ellipses)
    {
        if (filled)
        {
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        }
        else
        {
            shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        }
        for (Ellipse ellipse : ellipses)
        {
            shapeRenderer.setColor(ellipse.modulate);
            if (ellipse.centered)
            {
                if (!ellipse.dontRender)
                {
                    shapeRenderer.ellipse(ellipse.position.x - ellipse.size.width / 2,
                            ellipse.position.y - ellipse.size.height / 2, ellipse.size.width, ellipse.size.height,
                            ellipse.rotation);
                }

            }
            else
            {
                if (!ellipse.dontRender)
                {
                    shapeRenderer
                            .ellipse(ellipse.position.x, ellipse.position.y, ellipse.size.width, ellipse.size.height,
                                    ellipse.rotation);
                }
            }
        }


        shapeRenderer.end();
    }

    public void renderAll(Ellipse[] ellipses)
    {
        if (filled)
        {
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        }
        else
        {
            shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        }
        for (Ellipse ellipse : ellipses)
        {
            shapeRenderer.setColor(ellipse.modulate);
            if (ellipse.centered)
            {
                if (!ellipse.dontRender)
                {
                    shapeRenderer.ellipse(ellipse.position.x - ellipse.size.width / 2,
                            ellipse.position.y - ellipse.size.height / 2, ellipse.size.width, ellipse.size.height,
                            ellipse.rotation);
                }

            }
            else
            {
                if (!ellipse.dontRender)
                {
                    shapeRenderer
                            .ellipse(ellipse.position.x, ellipse.position.y, ellipse.size.width, ellipse.size.height,
                                    ellipse.rotation);
                }
            }
        }


        shapeRenderer.end();
    }
}
