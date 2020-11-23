package com.github.annasajkh.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.github.annasajkh.Game;

public class DesktopLauncher
{
    public static void main(String[] arg)
    {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.title = "Maze Generator";
        config.width = 960 * 2;
        config.height = 600 * 2;
        config.forceExit = false;
        new LwjglApplication(new Game(), config);
    }
}
