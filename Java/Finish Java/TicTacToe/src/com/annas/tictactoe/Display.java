package com.annas.tictactoe;


import java.awt.*;

public class Display {
    static boolean isEnd = false;

    static Character[][] display = new Character[3][3];

    static Point[] displayAll;

    static Point[] horizontal1Loc;
    static Point[] horizontal2Loc;
    static Point[] horizontal3Loc;

    static Point[] vertical1Loc;
    static Point[] vertical2Loc;
    static Point[] vertical3Loc;

    static Point[] diagonal1Loc;
    static Point[] diagonal2Loc;

    static void construct() {
        for (int i = 0; i < display.length; i++)
            for (int j = 0; j < display[i].length; j++)
                display[i][j] = ' ';

        displayAll = new Point[]{new Point(0, 0), new Point(0, 1), new Point(0, 2),
                new Point(1, 0), new Point(1, 1), new Point(1, 2), new Point(2, 0)
                , new Point(2, 1), new Point(2, 2)
        };

        horizontal1Loc = new Point[]{new Point(0, 0), new Point(0, 1), new Point(0, 2)};
        horizontal2Loc = new Point[]{new Point(1, 0), new Point(1, 1), new Point(1, 2)};
        horizontal3Loc = new Point[]{new Point(2, 0), new Point(2, 1), new Point(2, 2)};

        vertical1Loc = new Point[]{new Point(0, 0), new Point(1, 0), new Point(2, 0)};
        vertical2Loc = new Point[]{new Point(0, 1), new Point(1, 1), new Point(2, 1)};
        vertical3Loc = new Point[]{new Point(0, 2), new Point(1, 2), new Point(2, 2)};

        diagonal1Loc = new Point[]{new Point(0, 0), new Point(1, 1), new Point(2, 2)};
        diagonal2Loc = new Point[]{new Point(0, 2), new Point(1, 1), new Point(2, 0)};

    }

    static boolean isFull(Point[] points, Character character) {
        byte count = 0;
        for (Point point : points)
            if (Display.display[point.x][point.y] == character)
                count++;
        return count == 3;
    }

    static void checkIfGameEnding() {

        if (isFull(horizontal1Loc, 'O') || isFull(horizontal2Loc, 'O') || isFull(horizontal3Loc, 'O')
                || isFull(vertical1Loc, 'O') ||
                isFull(vertical2Loc, 'O') || isFull(vertical3Loc, 'O') ||
                isFull(diagonal1Loc, 'O') || isFull(diagonal2Loc, 'O')) {
            draw();
            System.out.println("Kamu menang");
            isEnd = true;

        } else if (isFull(horizontal1Loc, 'X') || isFull(horizontal2Loc, 'X') || isFull(horizontal3Loc, 'X')
                || isFull(vertical1Loc, 'X') ||
                isFull(vertical2Loc, 'X') || isFull(vertical3Loc, 'X') ||
                isFull(diagonal1Loc, 'X') || isFull(diagonal2Loc, 'X')) {
            draw();
            System.out.println("Kamu kalah");
            isEnd = true;
        }
        byte count = 0;
        for (Point points : displayAll)
            if (display[points.x][points.y] == ' ')
                count++;
        if (count == 0) {
            draw();
            System.out.println("Seri");
            isEnd = true;
        }
    }

    static void draw() {
        for (Character[] characters : display) {
            for (Character character : characters) {
                System.out.print('[');
                System.out.print(character);
                System.out.print(']');
            }
            System.out.print('\n');
        }
    }
    
}
