package com.annas.game;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

public class Cell extends Rectangle {

	private static final long serialVersionUID = 1L;
	public Color color;
	public byte alive = (byte) Math.round(Math.random());
	public ArrayList<Cell> neighbors = new ArrayList<Cell>();
	byte neighborAlive;
	Vector2f position;
	Vector2f otherPosition;
	float distance;

	public Cell(float x, float y, float width, float height) {
		super(x, y, width, height);
	}

	public void getNeighbor(Cell otherCell) {
		if (intersects(otherCell) && !otherCell.equals(this)) {
			neighbors.add(otherCell);
		}
	}

	public void update() {

		if (alive == 1 && (neighborAlive == 2 || neighborAlive == 3)) {
			alive = 1;
		} else if (alive == 0 && neighborAlive == 3) {
			alive = 1;
		} else {
			alive = 0;
		}
	}

	public void draw(Graphics graphics) {
		byte sum = 0;
		for (Cell c : neighbors) {
			sum += c.alive;
		}
		neighborAlive = sum;
		if (alive == 1) {
			color = Color.green;
		} else {
			color = Color.white;
		}
		graphics.setColor(color);
		graphics.fill(this);
	}

}
