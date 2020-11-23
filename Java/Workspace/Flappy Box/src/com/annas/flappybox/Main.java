package com.annas.flappybox;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Main extends BasicGame {
	static final short WIDTH = 1024;
	static final short HEIGHT = 600;
	static Pipe[] pipes;
	static int score;
	static boolean scoreIsTrigger;

	Player player;

	public static void main(String[] args) {
		try {
			AppGameContainer app = new AppGameContainer(new Main());
			app.setShowFPS(false);
			app.setDisplayMode(WIDTH, HEIGHT, false);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}

	public Main() {
		super("Flappy Box");
	}

	@Override
	public void init(GameContainer gameContainer) throws SlickException {
		score = 0;
		scoreIsTrigger = false;
		player = new Player(50, 300, 50, 50);
		pipes = new Pipe[4];
		for (byte i = 0; i < 4; i++) {
			pipes[i] = new Pipe(1024 + i * 300, (int) (160 + (Math.random() * 280)));
		}
	}

	@Override
	public void update(GameContainer gameContainer, int delta) throws SlickException {
		player.update(gameContainer, delta);
		for (byte i = 0; i < 4; i++) {
			pipes[i].update(delta);
			if (player.getX() + 50 > pipes[i].pipeUp.getX() && player.getX() < pipes[i].pipeUp.getX() + 50
					&& player.getY() < pipes[i].pipeUp.getY()
					&& player.getY() + 50 + pipes[i].pipeUp.getHeight() < pipes[i].pipeUp.getY()) {
				player.dead = true;
			} else if (player.intersects(pipes[i].pipeDown)) {
				player.dead = true;
			} else if (player.getY() > 550) {
				init(gameContainer);
			} else if (player.getY() < 0) {
				player.dead = true;
			}
			if (player.intersects(pipes[i].scoreTrigger) && !scoreIsTrigger) {
				score++;
				scoreIsTrigger = true;
			}

			if (pipes[i].x < -150) {
				scoreIsTrigger = false;
				pipes[i] = new Pipe(1024, (int) (180 + (Math.random() * 280)));
			}
		}
	}

	@Override
	public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
		graphics.clear();
		for (Pipe pipe : pipes) {
			pipe.drawAll(graphics);
		}
		if (player.dead) {
			player.draw(graphics, Color.red);
		} else {
			player.draw(graphics, Color.blue);
		}
		graphics.setColor(Color.green);
		graphics.drawString(Integer.toString(score), 25, 25);
	}

}