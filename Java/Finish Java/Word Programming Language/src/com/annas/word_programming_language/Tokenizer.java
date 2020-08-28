package com.annas.word_programming_language;

import java.util.StringTokenizer;

public class Tokenizer {
    private static StringTokenizer tokenizer;
    public static void makeToken(String word) {
        tokenizer = new StringTokenizer(word, " \n");
        while (tokenizer.hasMoreTokens()) {
            Reader.reader.add(tokenizer.nextToken().trim());
        }
        int pointer = 0;
        while (pointer < Reader.reader.size()) {
            switch (Reader.reader.get(pointer)) {
                case "tandai":
                    Memory.tag.put(Reader.reader.get(pointer+1), pointer+1);
            }
            pointer++;
        }
        tokenizer = null;
    }
}
