package com.github.annasajkh.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.github.annasajkh.Game;

public class DesktopLauncher
{
    public static void main(String[] arg)
    {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 1200;
        config.height = 800;
        config.title = "Brian's Brain Simulation Thing Yeaaah";
        new LwjglApplication(new Game(), config);
    }
}
