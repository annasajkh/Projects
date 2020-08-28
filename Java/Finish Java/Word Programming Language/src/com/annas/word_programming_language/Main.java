package com.annas.word_programming_language;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        String fileName = "";
        String path;

        Scanner readFile = new Scanner(System.in);
        try {
            path = new File("").getAbsolutePath();
            System.out.print(path + ">");
            fileName = readFile.nextLine();
            String data = new String(Files.readAllBytes(Paths.get(path + "/" + fileName)));
            Tokenizer.makeToken(data);
            Reader.read();
            System.out.print("Press enter to exit.......");
            System.in.read();
        } catch (Exception exception) {
            System.out.println("Mampus error wkwkwkwk");
            System.out.println(exception);
            System.out.print("Press enter to exit......");
            System.in.read();
        }
    }
}
