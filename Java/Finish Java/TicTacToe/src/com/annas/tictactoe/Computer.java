package com.annas.tictactoe;

import java.awt.*;
import java.util.Random;

public class Computer {

    static boolean isAlreadyMove;

    private static boolean contain(Point[] points, Character character) {
        for (Point point : points)
            if (Display.display[point.x][point.y] == character)
                return true;
        return false;
    }

    static void winning(Point[] points) {
        if (!Computer.isAlreadyMove) {
            byte count = 0;
            for (Point point : points)
                if (Display.display[point.x][point.y] == 'X')
                    count++;
            if (count == 2)
                for (Point point : points)
                    if (Display.display[point.x][point.y] == ' ') {
                        Display.display[point.x][point.y] = 'X';
                        Computer.isAlreadyMove = true;
                    }
        }
    }

    static void stopPlayerFromWinning(Point[] points) {
        if (!Computer.isAlreadyMove) {
            byte count = 0;
            for (Point point : points)
                if (Display.display[point.x][point.y] == 'O')
                    count++;
            if (count == 2)
                for (Point point : points)
                    if (Display.display[point.x][point.y] == ' ' && !contain(points, 'X')) {
                        Display.display[point.x][point.y] = 'X';
                        Computer.isAlreadyMove = true;
                    }
        }
    }

    static void computerMove(Point[] points) {
        if (!Computer.isAlreadyMove)
            if (!contain(points, 'O')) {
                Random random = new Random();
                int computerChoice = random.nextInt(3);
                while (Display.display[points[computerChoice].x][points[computerChoice].y] != ' ' && contain(points, ' '))
                    computerChoice = random.nextInt(3);
                if (contain(points, ' ')) {
                    Display.display[points[computerChoice].x][points[computerChoice].y] = 'X';
                    isAlreadyMove = true;
                }
            } else {
                Random random = new Random();
                int computerChoice = random.nextInt(3);
                while (Display.display[points[computerChoice].x][points[computerChoice].y] != ' ' && contain(points, ' '))
                    computerChoice = random.nextInt(3);
                if (contain(points, ' ')) {
                    Display.display[points[computerChoice].x][points[computerChoice].y] = 'X';
                    isAlreadyMove = true;
                }
            }
    }

    static void move() {
        winning(Display.horizontal1Loc);
        winning(Display.horizontal2Loc);
        winning(Display.horizontal3Loc);
        winning(Display.vertical1Loc);
        winning(Display.vertical2Loc);
        winning(Display.vertical3Loc);
        winning(Display.diagonal1Loc);
        winning(Display.diagonal2Loc);
        winning(Display.horizontal1Loc);
        winning(Display.horizontal2Loc);
        winning(Display.horizontal3Loc);
        winning(Display.vertical1Loc);
        winning(Display.vertical2Loc);
        winning(Display.vertical3Loc);
        winning(Display.diagonal1Loc);
        winning(Display.diagonal2Loc);

        stopPlayerFromWinning(Display.horizontal1Loc);
        stopPlayerFromWinning(Display.horizontal2Loc);
        stopPlayerFromWinning(Display.horizontal3Loc);
        stopPlayerFromWinning(Display.vertical1Loc);
        stopPlayerFromWinning(Display.vertical2Loc);
        stopPlayerFromWinning(Display.vertical3Loc);
        stopPlayerFromWinning(Display.diagonal1Loc);
        stopPlayerFromWinning(Display.diagonal2Loc);
        stopPlayerFromWinning(Display.horizontal1Loc);
        stopPlayerFromWinning(Display.horizontal2Loc);
        stopPlayerFromWinning(Display.horizontal3Loc);
        stopPlayerFromWinning(Display.vertical1Loc);
        stopPlayerFromWinning(Display.vertical2Loc);
        stopPlayerFromWinning(Display.vertical3Loc);
        stopPlayerFromWinning(Display.diagonal1Loc);
        stopPlayerFromWinning(Display.diagonal2Loc);

        computerMove(Display.horizontal1Loc);
        computerMove(Display.horizontal2Loc);
        computerMove(Display.horizontal3Loc);
        computerMove(Display.vertical1Loc);
        computerMove(Display.vertical2Loc);
        computerMove(Display.vertical3Loc);
        computerMove(Display.diagonal1Loc);
        computerMove(Display.diagonal2Loc);
    }
}
