package com.annas.apl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Tokenizer {

    static StringTokenizer tokenizer;
    public static ArrayList<String> tokens;

    static void makeToken(String s) {
        tokens = new ArrayList<>();
        Memory.variable = new HashMap<>();
        String string = s.replaceAll("[\n\t\r]", " ");
        tokenizer = new StringTokenizer(string, " =+-*/%", true);

        while (tokenizer.hasMoreTokens()) {
            tokens.add(tokenizer.nextToken());
        }
        while (tokens.contains(" ")) {
            tokens.remove(" ");
        }
    }

}
