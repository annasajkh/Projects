package com.annas;

public class Main {

    public static void calculate() {
        double x = (int) (-1000 + Math.random() * 2000);
        double y = (int) (-1000 + Math.random() * 2000);

        while (!(Math.pow(8, x) * Math.pow(2, y) == 32 && Math.pow(9, x) * Math.pow(1 / 3, y) == 243)) {
            x = (int) (Math.random() * 1000);
            y = (int) (Math.random() * 1000);
        }
        System.out.println(x);
        System.out.println(y);
    }

    public static void main(String[] args) {
        calculate();
    }
}
