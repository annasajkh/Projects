package com.annas;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Vector2f;

public class Main extends BasicGame
{

    Player player;
    Enemy enemy;
    static Ball ball;

    static Vector2f mousePos;

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
        super("Pong");
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException
    {
        player = new Player(50, 300, 50, 200, Color.blue);
        enemy = new Enemy(926, 300, 50, 200, Color.red);
        ball = new Ball(512, 300, 50, 50, Color.white);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException
    {
        mousePos = new Vector2f(gameContainer.getInput().getMouseX(), gameContainer.getInput().getMouseY());
        player.update();
        enemy.update();
        ball.collide(player);
        ball.collide(enemy);
        ball.update();
    }

    @Override
    public void render(GameContainer container, Graphics graphics) throws SlickException
    {
        player.draw(graphics);
        enemy.draw(graphics);
        ball.draw(graphics);
    }
}