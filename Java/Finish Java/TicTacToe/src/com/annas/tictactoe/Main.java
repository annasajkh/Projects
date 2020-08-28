package com.annas.tictactoe;

import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Display.construct();
        while (true) {
            if (Display.isEnd) {
                System.out.print("Mau main lagi (iya / tidak) : ");
                String input2 = scanner.nextLine();
                if (input2.equals("iya")) {
                    Display.isEnd = false;
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    Display.construct();
                } else if (input2.equals("tidak")) {
                    break;
                } else {
                    System.out.println("masukan pilihan iya / tidak");
                    continue;
                }
            }
            Display.draw();
            System.out.print("Masukan angka 1 - 9 : ");
            String input = scanner.nextLine();
            if (input.equals("keluar"))
                break;
            if (!input.matches(".*[123456789].*")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                System.out.println("harus angka 1 - 9");
                continue;
            }
            byte playerChooice;
            playerChooice = Byte.parseByte(input);

            if (playerChooice > 9) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                System.out.println("harus angka 1 - 9");
                continue;
            }
            byte choice = playerChooice;
            while (choice > 3)
                choice -= 3;
            Point position = new Point((byte) (playerChooice / 3.1), choice - 1);
            if (Display.display[position.x][position.y].equals(' ')) {
                Display.display[position.x][position.y] = 'O';
            } else {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                System.out.println("Itu sudah terisi");
                continue;
            }
            Computer.isAlreadyMove = false;
            Computer.move();
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            Display.checkIfGameEnding();
        }
        System.out.print("Terimakasih sudah bermain :)");
        System.in.read();
        scanner.close();
    }

}
