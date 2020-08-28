package com.annas.word_programming_language;

import java.util.ArrayList;

public class Reader {
    public static ArrayList<String> reader = new ArrayList<>();

    public static void read() {
        int pointer = 0;

        while (pointer < reader.size()) {
            switch (reader.get(pointer)) {
                case "equal":
                    if(Memory.numberMemory.containsKey(reader.get(pointer+1)) && Memory.numberMemory.containsKey(reader.get(pointer+2))) {
                        if(Memory.numberMemory.get(reader.get(pointer + 1)).equals(Memory.numberMemory.get(reader.get(pointer + 2)))){
                            pointer = Memory.tag.get(reader.get(pointer+3))-1;
                        }
                    }
                    if(Memory.stringMemory.containsKey(reader.get(pointer+1)) && Memory.stringMemory.containsKey(reader.get(pointer+2))) {
                        if(Memory.stringMemory.get(reader.get(pointer + 1)).equals(Memory.stringMemory.get(reader.get(pointer + 2)))){
                            pointer = Memory.tag.get(reader.get(pointer+3))-1;
                        }
                    }
                    if(Memory.booleanMemory.containsKey(reader.get(pointer+1)) && Memory.booleanMemory.containsKey(reader.get(pointer+2))) {
                        if(Memory.booleanMemory.get(reader.get(pointer + 1)).equals(Memory.booleanMemory.get(reader.get(pointer + 2)))){
                            pointer = Memory.tag.get(reader.get(pointer+3))-1;
                        }
                    }
                    break;
                case "unequal":
                    if(Memory.numberMemory.containsKey(reader.get(pointer+1)) && Memory.numberMemory.containsKey(reader.get(pointer+2))) {
                        if(!(Memory.numberMemory.get(reader.get(pointer + 1)).equals(Memory.numberMemory.get(reader.get(pointer + 2))))){
                            pointer = Memory.tag.get(reader.get(pointer+3))-1;
                        }
                    }
                    if(Memory.stringMemory.containsKey(reader.get(pointer+1)) && Memory.stringMemory.containsKey(reader.get(pointer+2))) {
                        if(!(Memory.stringMemory.get(reader.get(pointer + 1)).equals(Memory.stringMemory.get(reader.get(pointer + 2))))){
                            pointer = Memory.tag.get(reader.get(pointer+3))-1;
                        }
                    }
                    if(Memory.booleanMemory.containsKey(reader.get(pointer+1)) && Memory.booleanMemory.containsKey(reader.get(pointer+2))) {
                        if(!(Memory.booleanMemory.get(reader.get(pointer + 1)).equals(Memory.booleanMemory.get(reader.get(pointer + 2))))){
                            pointer = Memory.tag.get(reader.get(pointer+3))-1;
                        }
                    }
                    break;
                case "jump":
                    pointer = Memory.tag.get(reader.get(pointer+1));
                    break;
                case "set":
                    String key = reader.get(pointer+1);
                    String value = reader.get(pointer+2);
                    if(value.charAt(0) != '\"' && value.charAt(value.length()-1) != '\"' && !(value.equals("true") || value.equals("false"))){
                        Memory.numberMemory.put(key, Double.parseDouble(value));
                    }else if(value.equals("true") || value.equals("false")){
                        Memory.booleanMemory.put(key, Boolean.parseBoolean(value));
                    }else if(value.charAt(0) == '\"' && value.charAt(value.length()-1) == '\"'){
                        Memory.stringMemory.put(key,value.replace("\"", "").replace("_", " "));
                    }
                    break;
                case "printl":
                    if(Memory.numberMemory.containsKey(reader.get(pointer+1))){
                        System.out.println(Memory.numberMemory.get(reader.get(pointer+1)));
                    }else if(Memory.stringMemory.containsKey(reader.get(pointer+1))){
                        System.out.println(Memory.stringMemory.get(reader.get(pointer+1)));
                    }else if(Memory.stringMemory.containsKey(reader.get(pointer+1))){
                        System.out.println(Memory.booleanMemory.get(reader.get(pointer+1)));
                    }
                    break;
                case "print":
                    if(Memory.numberMemory.containsKey(reader.get(pointer+1))){
                        System.out.print(Memory.numberMemory.get(reader.get(pointer+1)));
                    }else if(Memory.stringMemory.containsKey(reader.get(pointer+1))){
                        System.out.print(Memory.stringMemory.get(reader.get(pointer+1)));
                    }else if(Memory.stringMemory.containsKey(reader.get(pointer+1))){
                        System.out.print(Memory.booleanMemory.get(reader.get(pointer+1)));
                    }
                    break;
                case "add":
                    if(Memory.numberMemory.containsKey(reader.get(pointer+1)) && Memory.numberMemory.containsKey(reader.get(pointer+2))) {
                        Memory.numberMemory.put(reader.get(pointer + 1), Memory.numberMemory.get(reader.get(pointer + 1)) + Memory.numberMemory.get(reader.get(pointer + 2)));

                    }else if(Memory.stringMemory.containsKey(reader.get(pointer+1)) && Memory.stringMemory.containsKey(reader.get(pointer+2))){
                        Memory.stringMemory.put(reader.get(pointer+1), Memory.stringMemory.get(reader.get(pointer+1))+Memory.stringMemory.get(reader.get(pointer+2)));
                    }
                    break;
                case "sub":
                    if(Memory.numberMemory.containsKey(reader.get(pointer+1)) && Memory.numberMemory.containsKey(reader.get(pointer+2))){
                        Memory.numberMemory.put(reader.get(pointer+1), Memory.numberMemory.get(reader.get(pointer+1))-Memory.numberMemory.get(reader.get(pointer+2)));
                    }
                    break;
                case "div":
                    if(Memory.numberMemory.containsKey(reader.get(pointer+1)) && Memory.numberMemory.containsKey(reader.get(pointer+2))){
                        Memory.numberMemory.put(reader.get(pointer+1), Memory.numberMemory.get(reader.get(pointer+1))/Memory.numberMemory.get(reader.get(pointer+2)));
                    }
                    break;
                case "mult":
                    if(Memory.numberMemory.containsKey(reader.get(pointer+1)) && Memory.numberMemory.containsKey(reader.get(pointer+2))){
                        Memory.numberMemory.put(reader.get(pointer+1), Memory.numberMemory.get(reader.get(pointer+1))*Memory.numberMemory.get(reader.get(pointer+2)));
                    }
                    break;
                case "mod":
                    if(Memory.numberMemory.containsKey(reader.get(pointer+1)) && Memory.numberMemory.containsKey(reader.get(pointer+2))) {
                        Memory.numberMemory.put(reader.get(pointer + 1), Memory.numberMemory.get(reader.get(pointer + 1)) % Memory.numberMemory.get(reader.get(pointer + 2)));
                    }
                    break;

            }
            pointer++;
        }
    }

}
