package com.annas;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Vector2f;

public class Main extends BasicGame
{

    static Vector2f mousePos;
    static Ray[] rays;
    static Boundary boundary;

    public static void main(String[] arguments)
    {

        try
        {
            AppGameContainer app = new AppGameContainer(new Main());
            app.setDisplayMode(1024, 600, false);
            app.setShowFPS(false);
            app.start();
        } catch (SlickException slickException)
        {
            slickException.printStackTrace();
        }
    }

    public Main()
    {
        super("Ray");
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException
    {
        mousePos = new Vector2f(gameContainer.getInput().getMouseX(), gameContainer.getInput().getMouseY());
        rays = new Ray[1080];
        boundary = new Boundary(512, 100, 512, 300);
        for (int i = 0; i < rays.length; i++)
        {
            rays[i] = new Ray(mousePos.getX(), mousePos.getY(), mousePos.getX(), mousePos.getY(), new Vector2f(i * 0.333333333333));
        }
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException
    {
        mousePos = new Vector2f(gameContainer.getInput().getMouseX(), gameContainer.getInput().getMouseY());
        for (Ray ray : rays)
        {
            ray.update(boundary);
        }
    }

    @Override
    public void render(GameContainer container, Graphics graphics) throws SlickException
    {
        for (Ray ray : rays)
        {
            ray.draw(graphics);
        }
        boundary.draw(graphics);
    }
}