package com.annas.game;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Main extends BasicGame {

	static int cellSize = 6;
	static final short WIDTH = 1200;
	static final short HEIGHT = WIDTH / 2;

	public static boolean pointRect(float px, float py, float rx, float ry, float rw, float rh) {
		return (px >= rx && px <= rx + rw && py >= ry && py <= ry + rh);
	}

	public static Cell[][] cells;
	public static byte pause = 1;

	public static void main(String[] arguments) {
		cells = new Cell[WIDTH / cellSize][(WIDTH / 2) / cellSize];

		for (int rows = 0; rows < cells.length; rows++) {
			for (int cell = 0; cell < cells[rows].length; cell++) {
				cells[rows][cell] = new Cell(rows * cellSize, cell * cellSize, cellSize, cellSize);
			}
		}

		for (Cell[] rows : cells) {
			for (Cell cell : rows) {
				neighborsIsEnough: for (int otherRows = 0; otherRows < cells.length; otherRows++) {
					for (int otherCell = 0; otherCell < cells[otherRows].length; otherCell++) {
						cell.getNeighbor(cells[otherRows][otherCell]);
						if (cell.neighbors.size() == 8) {
							break neighborsIsEnough;
						}
					}
				}
			}
		}

		try {
			AppGameContainer app = new AppGameContainer(new Main());
			app.setDisplayMode(WIDTH, HEIGHT, false);
			app.setShowFPS(false);
			app.start();
		} catch (SlickException slickException) {
			slickException.printStackTrace();
		}
	}

	public Main() {
		super("Game of Life");
	}

	@Override
	public void init(GameContainer gameContainer) throws SlickException {
	}

	@Override
	public void update(GameContainer gameContainer, int delta) throws SlickException {
		if (gameContainer.getInput().isKeyPressed(Input.KEY_C)) {
			for (Cell[] rows : cells) {
				for (Cell cell : rows) {
					cell.alive = 0;
				}
			}
			if (pause == -1) {
				for (Cell[] rows : cells) {
					for (Cell cell : rows) {
						cell.update();
					}
				}
			}
		} else if (gameContainer.getInput().isKeyPressed(Input.KEY_R)) {
			for (Cell[] rows : cells) {
				for (Cell cell : rows) {
					cell.alive = (byte) Math.round(Math.random());
				}
			}
			if (pause == -1) {
				for (Cell[] rows : cells) {
					for (Cell cell : rows) {
						cell.update();
					}
				}
			}
		} else if (gameContainer.getInput().isKeyPressed(Input.KEY_S)) {
			pause = (byte) -pause;
		}

	}

	@Override
	public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
		if (gameContainer.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
			out: for (Cell[] rows : cells) {
				for (Cell cell : rows) {
					if (pointRect(gameContainer.getInput().getMouseX(), gameContainer.getInput().getMouseY(),
							cell.getX(), cell.getY(), cell.getWidth(), cell.getHeight())) {
						cell.alive++;
						if (cell.alive > 1) {
							cell.alive = 0;
						}
						cell.color = Color.green;
						cell.draw(graphics);
						break out;
					}
				}
			}
		}
		for (Cell[] rows : cells) {
			for (Cell cell : rows) {
				cell.draw(graphics);
			}
		}
		if (pause == 1) {
			for (Cell[] rows : cells) {
				for (Cell cell : rows) {
					cell.update();
				}
			}
		}
	}
}