package com.annas.apl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        boolean exit = false;

        while (!exit) {
            try {
                String fileName = "";
                String path;
                Scanner readFile = new Scanner(System.in);
                path = new File("").getAbsolutePath();
                System.out.print(path + ">");
                fileName = readFile.nextLine();
                if (fileName.equals("keluar")) {
                    System.exit(0);
                }
                if (!fileName.substring(fileName.lastIndexOf('.'), fileName.length()).equals(".apl")) {
                    System.out.println("harus ada .apl");
                    continue;
                }
                String data = new String(Files.readAllBytes(Paths.get(path + "/" + fileName)));
                Tokenizer.makeToken(data);
                Reader.read();
            } catch (Exception exception) {
                System.out.println("Mampus error wkwkwkwk");
                System.out.println(exception);
            }
        }
    }
}
