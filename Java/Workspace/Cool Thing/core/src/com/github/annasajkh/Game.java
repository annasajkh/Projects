package com.github.annasajkh;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;

public class Game extends ApplicationAdapter
{
    Texture img;
    Pixel[][] pixels;
    ShapeRenderer shapeRenderer;
    Pixmap pixmap;
    OrthographicCamera orthographicCamera;


    @Override
    public void create()
    {
        img = new Texture("niko.png");
        img.getTextureData().prepare();
        pixmap = img.getTextureData().consumePixmap();
        shapeRenderer = new ShapeRenderer();
        pixels = new Pixel[pixmap.getHeight()][pixmap.getWidth()];
        orthographicCamera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        orthographicCamera.position.x = Gdx.graphics.getWidth() / 2f;
        orthographicCamera.position.y = Gdx.graphics.getHeight() / 2f;

        for (int i = 0; i < pixmap.getHeight(); i++)
        {
            for (int j = 0; j < pixmap.getWidth(); j++)
            {
                pixels[i][j] = new Pixel(new Vector2(j, i), new Color(pixmap.getPixel(j, i)));
            }
        }
    }

    @Override
    public void render()
    {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        orthographicCamera.update();
        Vector3 mousePos = orthographicCamera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
        int size = 100;
        Rectangle mouse = new Rectangle(mousePos.x - size / 2f, mousePos.y - size / 2f, size, size);


        for (int i = 0; i < pixels.length; i++)
        {
            for (int j = 0; j < pixels[i].length; j++)
            {
                Rectangle pixel = new Rectangle(pixels[i][j].position.x + 500 - pixels[0].length / 2f,
                        -pixels[i][j].position.y + pixels.length + 300 - pixels.length / 2f, 1, 1);
                if (mouse.overlaps(pixel))
                {
                    pixels[i][j].position
                            .sub(new Vector2(mouse.getX(), mouse.getY()).sub(pixels[i][j].getPosition()).nor()
                                    .scl(MathUtils.random(-8f, 8f)));
                }
                shapeRenderer.setColor(pixels[i][j].color);
                shapeRenderer.rect(pixel.x, pixel.y, pixel.width, pixel.height);
            }
        }
        shapeRenderer.setColor(Color.PURPLE);
        shapeRenderer.rect(mouse.x, mouse.y, mouse.width, mouse.height);
        shapeRenderer.end();
    }

    @Override
    public void dispose()
    {
        pixmap.dispose();
        shapeRenderer.dispose();
        img.dispose();
    }
}
