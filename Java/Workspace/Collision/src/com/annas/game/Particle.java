package com.annas.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Vector2f;

public class Particle extends Circle {

	private static final long serialVersionUID = 1L;
	private Vector2f position;
	Vector2f velocity = new Vector2f((float) (-0.01 + Math.random() * 0.02), (float) (-0.01 + Math.random() * 0.02));
	org.newdawn.slick.Color color = new Color((float) Math.random(), (float) Math.random(), (float) Math.random());

	public Particle(float radius) {
		super((float) ((radius * 2) + Math.random() * 1024 - (radius * 4)),
				(float) ((radius * 2) + Math.random() * 600 - (radius * 4)), radius);
		position = new Vector2f(getLocation());
	}

	public void update(Particle otherParticle) {
		setLocation(position);

		if (intersects(otherParticle)) {
			velocity.sub(otherParticle.getLocation().sub(getLocation()).normalise().scale(0.001f));

		}

		if (getX() > 1024 - (radius * 2) || getX() < 0) {
			velocity.x = -velocity.x;
		}

		if (getY() > 600 - (radius * 2) || getY() < 0) {
			velocity.y = -velocity.y;
		}

		position.add(velocity);
	}

	public void draw(Graphics graphics) {
		graphics.setColor(color);
		graphics.fill(this);
	}

}
