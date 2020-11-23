package com.annas.flappybox;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

public class Player extends Rect {

	private static final long serialVersionUID = 1L;
	public float velocity = 0;
	public float y = 200;
	public boolean dead = false;
	public Color color;

	public Player(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public void update(GameContainer gameContainer, int delta) {
		if (gameContainer.getInput().isKeyPressed(Input.KEY_SPACE) && !dead) {
			velocity = -0.65f;
		}

		velocity += 0.003 * delta;
		this.setY(y);
		y += velocity;
	}

}
