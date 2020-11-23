package com.github.annasajkh.libraries;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class Sprite extends GameObject
{
    Texture texture;

    public Sprite(String img, Vector2 position, boolean centered)
    {
        super(position, new Size(new Texture(img).getWidth(), new Texture(img).getHeight()), Color.WHITE);
        this.texture = new Texture(img);
        this.centered = centered;
    }

    public Sprite(String img, Vector2 position, boolean centered, Color modulate)
    {
        super(position, new Size(new Texture(img).getWidth(), new Texture(img).getHeight()), modulate);
        this.texture = new Texture(img);
        this.centered = centered;
    }

    public Sprite(String img, Vector2 position, boolean centered, Color modulate, Size size)
    {
        super(position, size, modulate);
        this.texture = new Texture(img);
        this.size = size;
        this.centered = centered;
    }
}
