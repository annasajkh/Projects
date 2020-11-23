package com.annas.game;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Vector2f;

public class Particle extends org.newdawn.slick.geom.Circle {

	private static final long serialVersionUID = 1L;
	Vector2f position;
	Vector2f velocity = new Vector2f(0, 0);
	Color color = new Color((float) Math.random(), (float) Math.random(), (float) Math.random());
	float attraction = (float) Math.random();
	float repulsion = (float) Math.random();
	float forceRadius = (float) (5 + Math.random() * 10);

	public Particle(float x, float y, float radius) {
		super(x, y, radius);
		position = new Vector2f(getCenter());
	}

	public void update(Particle otherParticle) {

		if (getLocation().distance(otherParticle.getLocation()) < forceRadius) {
			velocity.add(otherParticle.getLocation().sub(getLocation()).normalise().scale(0.0001f * attraction));
			velocity.sub(otherParticle.getLocation().sub(getLocation()).normalise().scale(0.0001f * repulsion));
			if (this.intersects(otherParticle)) {
				velocity = (otherParticle.velocity.normalise().scale(0.005f));
			}
		}

		if (position.x > 1029) {
			position.x = -5;
		}
		if (position.x < -5) {
			position.x = 1029;
		}
		if (position.y > 605) {
			position.y = -5;
		}
		if (position.y < -5) {
			position.y = 605;
		}

		setLocation(position.x - getWidth() / 2, position.y - getHeight() / 2);
		position.add(velocity);
	}

	public void draw(Graphics graphics) {
		graphics.setColor(color);
		graphics.fill(this);
	}

}
