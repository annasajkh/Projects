package com.annas.flappybox;

import org.newdawn.slick.Graphics;

public class Pipe extends Draw {

	float moveSpeed = 0.15f;
	float x;
	Rect pipeUp;
	Rect pipeDown;
	Rect scoreTrigger;

	public Pipe(float x, float y) {
		this.x = x;
		pipeUp = new Rect(x, y, 50, -y);
		pipeDown = new Rect(x, pipeUp.getY() + 160, 50, 800 - pipeUp.getY() + 70);
		scoreTrigger = new Rect(x, y, 50, 800 - pipeUp.getY() + 70);

	}

	public void update(int delta) {
		pipeUp.setX(x);
		pipeDown.setX(x);
		scoreTrigger.setX(x);
		x -= moveSpeed * delta;
	}

	public void drawAll(Graphics graphics) {
		draw(pipeUp, graphics);
		draw(pipeDown, graphics);
	}

}
