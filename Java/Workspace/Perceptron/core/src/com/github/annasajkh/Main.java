package com.github.annasajkh;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Matrix3;

import java.math.MathContext;

public class Main extends ApplicationAdapter
{
    Perceptron perceptron;
    ShapeRenderer shapeRenderer;
    Circle[] circles;
    int trainningIndex = 0;

    @Override
    public void create()
    {
        shapeRenderer = new ShapeRenderer();
        circles = new Circle[1000];
        for (int i = 0; i < circles.length; i++)
        {
            circles[i] = new Circle();
        }
        perceptron = new Perceptron(2, 0.005f, Perceptron.ActivationFunctions.STEP);
    }

    @Override
    public void render()
    {
        Color color = Color.LIGHT_GRAY;
        Gdx.gl.glClearColor(color.r, color.g, color.b, color.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        for (Circle circle : circles)
        {
            circle.render(shapeRenderer);

            float[] inputs = {circle.position.x, circle.position.y};
            float guess = perceptron.guess(inputs);
            if (guess == 0)
            {

                shapeRenderer.setColor(new Color(0, 0.5f, 1f, 1));
                shapeRenderer.circle(circle.getPixelX(), circle.getPixelY(), 10);
            }
            else if (guess == 1)
            {
                shapeRenderer.setColor(new Color(1f, 0.5f, 0.5f, 1));
                shapeRenderer.circle(circle.getPixelX(), circle.getPixelY(), 10);
            }
        }

        float x1 = -1;
        float y1 = f(x1);
        float x2 = 1;
        float y2 = f(x2);

        Circle p1 = new Circle(-1, f(-1));
        Circle p2 = new Circle(1, f(1));
        shapeRenderer.setColor(Color.BLACK);

        shapeRenderer.rectLine(p1.getPixelX(), p1.getPixelY(), p2.getPixelX(), p2.getPixelY(), 2);
        Circle gp1 = new Circle(-1, perceptron.guessY(-1));
        Circle gp2 = new Circle(1, perceptron.guessY(1));
        shapeRenderer.setColor(Color.WHITE);
        shapeRenderer.rectLine(gp1.getPixelX(), gp1.getPixelY(), gp2.getPixelX(), gp2.getPixelY(), 2);

        shapeRenderer.end();

        float[] inputs = {circles[trainningIndex].position.x, circles[trainningIndex].position.y};
        perceptron.train(inputs, circles[trainningIndex].label);
        trainningIndex++;
        if (trainningIndex == circles.length)
        {
            trainningIndex = 0;
        }
    }

    @Override
    public void dispose()
    {
        shapeRenderer.dispose();
    }


    public static float f(float x)
    {
        return 0.3f * x + 0.2f;
    }
}
