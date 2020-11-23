package com.annas.game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;

public class Main extends BasicGame {

	Rect[] rects = new Rect[2000];
	Vector2f mousepos = new Vector2f(0, 0);

	public static void main(String[] argument) {
		try {

			AppGameContainer app = new AppGameContainer(new Main());
			app.setDisplayMode(1024, 600, false);
			app.setShowFPS(false);
			app.start();
		} catch (SlickException slickException) {
			slickException.printStackTrace();
		}
	}

	public Main() {
		super("Circle");
	}

	@Override
	public void init(GameContainer gameContainer) throws SlickException {
		for (int i = 0; i < rects.length; i++) {
			rects[i] = new Rect((float) (Math.random() * 1024), (float) (Math.random() * 600), 5, 5);
		}
	}

	@Override
	public void update(GameContainer gameContainer, int delta) throws SlickException {
		for (Rect rect : rects) {
			rect.velocity.add(new Vector2f(512, 300).sub(rect.position).normalise().scale(0.002f));
			rect.update();
		}
	}

	@Override
	public void render(GameContainer container, Graphics graphics) throws SlickException {

		for (Rect rect : rects) {
			rect.draw(graphics, Color.white);
		}
	}
}