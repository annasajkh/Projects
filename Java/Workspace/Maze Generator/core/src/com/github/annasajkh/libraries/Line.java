package com.github.annasajkh.libraries;

import com.badlogic.gdx.graphics.Color;

public class Line
{
    public MiniVector pA;
    public MiniVector pB;
    public Color color;
    public boolean dontRender = false;

    public Line(MiniVector pA, MiniVector pB, Color color)
    {
        this.pA = pA;
        this.pB = pB;
        this.color = color;
    }

}
