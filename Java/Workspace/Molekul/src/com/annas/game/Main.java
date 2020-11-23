package com.annas.game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Main extends BasicGame {

	Particle[] particles = new Particle[400];

	public static void main(String[] arguments) {
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
		super("Nama Game");
	}

	@Override
	public void init(GameContainer gameContainer) throws SlickException {

		for (int i = 0; i < particles.length; i++) {
			particles[i] = new Particle((float) (Math.random() * 1024), (float) (Math.random() * 600), 5);
		}

	}

	@Override
	public void update(GameContainer gameContainer, int delta) throws SlickException {
		for (Particle particle : particles) {
			for (Particle otherParticle : particles) {
				particle.update(otherParticle);
			}
		}
	}

	@Override
	public void render(GameContainer container, Graphics graphics) throws SlickException {
		for (Particle particle : particles) {
			particle.draw(graphics);
		}
	}
}