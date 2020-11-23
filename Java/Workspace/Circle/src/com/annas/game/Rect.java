package com.annas.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

public class Rect extends Rectangle {

	private static final long serialVersionUID = 1L;
	public Vector2f position;
	public Vector2f velocity = new Vector2f(0, 0);

	public Rect(float x, float y, float width, float height) {
		super(x, y, width, height);
		position = new Vector2f(x, y);

	}

	public void update() {
		setLocation(position.x - (getWidth() / 2), position.y - getWidth() / 2);
		if (velocity.length() > 1) {
			velocity = new Vector2f((velocity.x / (float) Math.sqrt(velocity.length())) * 1,
					(velocity.y / (float) Math.sqrt(velocity.length())) * 1);

		}
		position.add(velocity);
	}

	public void draw(Graphics graphics, Color color) {
		graphics.setColor(color);
		graphics.fill(this);
	}

}
