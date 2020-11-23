package com.github.annasajkh.libraries;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SpriteRenderers
{
    Sprite[] sprites;
    SpriteBatch spriteBatch;
    TextureRegion textureRegion;

    public SpriteRenderers(Sprite[] sprites)
    {
        this.sprites = sprites;
        spriteBatch = new SpriteBatch();
        textureRegion = new TextureRegion();
    }

    public void renderAll()
    {
        spriteBatch.begin();
        for (Sprite sprite : sprites)
        {
            textureRegion.setRegion(sprite.texture);
            spriteBatch.setColor(sprite.modulate);
            if (sprite.centered)
            {
                spriteBatch.draw(textureRegion, sprite.position.x - sprite.size.width / 2,
                        sprite.position.y - sprite.size.height / 2, sprite.size.width / 2, sprite.size.height / 2,
                        sprite.size.width, sprite.size.height, 1, 1, sprite.rotation);
            }
            else
            {
                spriteBatch.draw(textureRegion, sprite.position.x, sprite.position.y, sprite.size.width / 2,
                        sprite.size.height / 2, sprite.size.width, sprite.size.height, 1, 1, sprite.rotation);
            }
        }
        spriteBatch.end();
    }

    public void disposeAll()
    {
        for (Sprite sprite : sprites)
        {
            sprite.texture.dispose();
        }
        spriteBatch.dispose();
    }
}
