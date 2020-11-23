package com.annas.flappybox;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;

public class Rect extends Rectangle {

	private static final long serialVersionUID = 1L;

	public Rect(float x, float y, float width, float height) {
		super(x, y, width, height);
	}

	public void draw(Graphics graphics, Color color) {
		graphics.setColor(color);
		graphics.draw(this);
	}

}
