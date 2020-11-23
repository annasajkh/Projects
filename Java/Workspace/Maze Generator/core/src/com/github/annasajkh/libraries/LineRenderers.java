package com.github.annasajkh.libraries;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.LinkedList;

public class LineRenderers extends ShapeRenderers
{

    public void renderAll(LinkedList<Line> lines)
    {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        for (Line line : lines)
        {
            if (!line.dontRender)
            {
                shapeRenderer.setColor(line.color);
                shapeRenderer.line(line.pA.x, line.pA.y, line.pB.x, line.pB.y);
            }
        }
        shapeRenderer.end();
    }

    public void renderAll(Line[] lines)
    {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        for (Line line : lines)
        {
            if (!line.dontRender)
            {
                shapeRenderer.setColor(line.color);
                shapeRenderer.line(line.pA.x, line.pA.y, line.pB.x, line.pB.y);
            }
        }
        shapeRenderer.end();
    }

}
