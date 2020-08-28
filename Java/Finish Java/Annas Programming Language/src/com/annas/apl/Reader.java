package com.annas.apl;

public class Reader {

    private static void remove(int i, double result) {
        Tokenizer.tokens.set(i, Double.toString(result));
        Tokenizer.tokens.remove(i + 1);
        Tokenizer.tokens.remove(i - 1);
    }

    static void read() {


        for (int i = 0; i < Tokenizer.tokens.size(); i++) {

            if (Tokenizer.tokens.get(i).equals("*") && !Memory.variable.containsKey(Tokenizer.tokens.get(i - 1)) && !Memory.variable.containsKey(Tokenizer.tokens.get(i + 1))) {
                remove(i, Double.parseDouble(Tokenizer.tokens.get(i - 1)) * Double.parseDouble(Tokenizer.tokens.get(i + 1)));
            }

            if (Tokenizer.tokens.get(i).equals("/") && !Memory.variable.containsKey(Tokenizer.tokens.get(i - 1)) && !Memory.variable.containsKey(Tokenizer.tokens.get(i + 1))) {
                remove(i, Double.parseDouble(Tokenizer.tokens.get(i - 1)) / Double.parseDouble(Tokenizer.tokens.get(i + 1)));
            }

            if (Tokenizer.tokens.get(i).equals("%") && !Memory.variable.containsKey(Tokenizer.tokens.get(i - 1)) && !Memory.variable.containsKey(Tokenizer.tokens.get(i + 1))) {
                remove(i, Double.parseDouble(Tokenizer.tokens.get(i - 1)) % Double.parseDouble(Tokenizer.tokens.get(i + 1)));
            }

            if (Tokenizer.tokens.get(i).equals("+") && !Memory.variable.containsKey(Tokenizer.tokens.get(i - 1)) && !Memory.variable.containsKey(Tokenizer.tokens.get(i + 1))) {
                remove(i, Double.parseDouble(Tokenizer.tokens.get(i - 1)) + Double.parseDouble(Tokenizer.tokens.get(i + 1)));
            }

            if (Tokenizer.tokens.get(i).equals("-") && !Memory.variable.containsKey(Tokenizer.tokens.get(i - 1)) && !Memory.variable.containsKey(Tokenizer.tokens.get(i + 1))) {
                remove(i, Double.parseDouble(Tokenizer.tokens.get(i - 1)) - Double.parseDouble(Tokenizer.tokens.get(i + 1)));
            }

            if (Tokenizer.tokens.get(i).equals("=") && !"+-*/%".contains(Tokenizer.tokens.get(i + 2)) && !Memory.variable.containsKey(Tokenizer.tokens.get(i + 1))) {
                Memory.variable.put(Tokenizer.tokens.get(i - 1), Double.parseDouble(Tokenizer.tokens.get(i + 1)));
            } else if (Tokenizer.tokens.get(i).equals("=") && !"+-*/%".contains(Tokenizer.tokens.get(i + 2)) && Memory.variable.containsKey(Tokenizer.tokens.get(i + 1))) {
                Memory.variable.put(Tokenizer.tokens.get(i - 1), Memory.variable.get(Tokenizer.tokens.get(i + 1)));
            }

            if (Tokenizer.tokens.get(i).equals("=") && "+-*/%".contains(Tokenizer.tokens.get(i + 2)) && !Memory.variable.containsKey(Tokenizer.tokens.get(i + 1))) {
                Memory.variable.put(Tokenizer.tokens.get(i - 1), Double.parseDouble(Tokenizer.tokens.get(i + 1)));
            } else if (Tokenizer.tokens.get(i).equals("=") && "+-*/%".contains(Tokenizer.tokens.get(i + 2)) && Memory.variable.containsKey(Tokenizer.tokens.get(i + 1))) {
                Memory.variable.put(Tokenizer.tokens.get(i - 1), Memory.variable.get(Tokenizer.tokens.get(i + 1)));
            }

        }


        while (Tokenizer.tokens.contains("*")) {
            int i = Tokenizer.tokens.indexOf("*");
            if (Memory.variable.containsKey(Tokenizer.tokens.get(i - 1)) && Memory.variable.containsKey(Tokenizer.tokens.get(i + 1))) {
                remove(i, Memory.variable.get(Tokenizer.tokens.get(i - 1)) * Memory.variable.get(Tokenizer.tokens.get(i + 1)));
            } else if (Memory.variable.containsKey(Tokenizer.tokens.get(i - 1)) && !Memory.variable.containsKey(Tokenizer.tokens.get(i + 1))) {
                remove(i, Memory.variable.get(Tokenizer.tokens.get(i - 1)) * Double.parseDouble(Tokenizer.tokens.get(i + 1)));
            } else if (!Memory.variable.containsKey(Tokenizer.tokens.get(i - 1)) && Memory.variable.containsKey(Tokenizer.tokens.get(i + 1))) {
                remove(i, Double.parseDouble(Tokenizer.tokens.get(i - 1)) * Memory.variable.get((Tokenizer.tokens.get(i + 1))));
            }
        }

        while (Tokenizer.tokens.contains("/")) {
            int i = Tokenizer.tokens.indexOf("/");
            if (Memory.variable.containsKey(Tokenizer.tokens.get(i - 1)) && Memory.variable.containsKey(Tokenizer.tokens.get(i + 1))) {
                remove(i, Memory.variable.get(Tokenizer.tokens.get(i - 1)) / Memory.variable.get(Tokenizer.tokens.get(i + 1)));
            } else if (Memory.variable.containsKey(Tokenizer.tokens.get(i - 1)) && !Memory.variable.containsKey(Tokenizer.tokens.get(i + 1))) {
                remove(i, Memory.variable.get(Tokenizer.tokens.get(i - 1)) / Double.parseDouble(Tokenizer.tokens.get(i + 1)));
            } else if (!Memory.variable.containsKey(Tokenizer.tokens.get(i - 1)) && Memory.variable.containsKey(Tokenizer.tokens.get(i + 1))) {
                remove(i, Double.parseDouble(Tokenizer.tokens.get(i - 1)) / Memory.variable.get((Tokenizer.tokens.get(i + 1))));
            }
        }

        while (Tokenizer.tokens.contains("%")) {
            int i = Tokenizer.tokens.indexOf("%");
            if (Memory.variable.containsKey(Tokenizer.tokens.get(i - 1)) && Memory.variable.containsKey(Tokenizer.tokens.get(i + 1))) {
                remove(i, Memory.variable.get(Tokenizer.tokens.get(i - 1)) % Memory.variable.get(Tokenizer.tokens.get(i + 1)));
            } else if (Memory.variable.containsKey(Tokenizer.tokens.get(i - 1)) && !Memory.variable.containsKey(Tokenizer.tokens.get(i + 1))) {
                remove(i, Memory.variable.get(Tokenizer.tokens.get(i - 1)) % Double.parseDouble(Tokenizer.tokens.get(i + 1)));
            } else if (!Memory.variable.containsKey(Tokenizer.tokens.get(i - 1)) && Memory.variable.containsKey(Tokenizer.tokens.get(i + 1))) {
                remove(i, Double.parseDouble(Tokenizer.tokens.get(i - 1)) % Memory.variable.get((Tokenizer.tokens.get(i + 1))));
            }
        }

        while (Tokenizer.tokens.contains("+")) {
            int i = Tokenizer.tokens.indexOf("+");
            if (Memory.variable.containsKey(Tokenizer.tokens.get(i - 1)) && Memory.variable.containsKey(Tokenizer.tokens.get(i + 1))) {
                remove(i, Memory.variable.get(Tokenizer.tokens.get(i - 1)) + Memory.variable.get(Tokenizer.tokens.get(i + 1)));
            } else if (Memory.variable.containsKey(Tokenizer.tokens.get(i - 1)) && !Memory.variable.containsKey(Tokenizer.tokens.get(i + 1))) {
                remove(i, Memory.variable.get(Tokenizer.tokens.get(i - 1)) + Double.parseDouble(Tokenizer.tokens.get(i + 1)));
            } else if (!Memory.variable.containsKey(Tokenizer.tokens.get(i - 1)) && Memory.variable.containsKey(Tokenizer.tokens.get(i + 1))) {
                remove(i, Double.parseDouble(Tokenizer.tokens.get(i - 1)) + Memory.variable.get((Tokenizer.tokens.get(i + 1))));
            }
        }

        while (Tokenizer.tokens.contains("-")) {
            int i = Tokenizer.tokens.indexOf("-");
            if (Memory.variable.containsKey(Tokenizer.tokens.get(i - 1)) && Memory.variable.containsKey(Tokenizer.tokens.get(i + 1))) {
                remove(i, Memory.variable.get(Tokenizer.tokens.get(i - 1)) - Memory.variable.get(Tokenizer.tokens.get(i + 1)));
            } else if (Memory.variable.containsKey(Tokenizer.tokens.get(i - 1)) && !Memory.variable.containsKey(Tokenizer.tokens.get(i + 1))) {
                remove(i, Memory.variable.get(Tokenizer.tokens.get(i - 1)) - Double.parseDouble(Tokenizer.tokens.get(i + 1)));
            } else if (!Memory.variable.containsKey(Tokenizer.tokens.get(i - 1)) && Memory.variable.containsKey(Tokenizer.tokens.get(i + 1))) {
                remove(i, Double.parseDouble(Tokenizer.tokens.get(i - 1)) - Memory.variable.get((Tokenizer.tokens.get(i + 1))));
            }

        }


        for (int i = 0; i < Tokenizer.tokens.size(); i++) {
            if (Tokenizer.tokens.get(i).equals("=") && !Memory.variable.containsKey(Tokenizer.tokens.get(i + 1))) {
                Memory.variable.put(Tokenizer.tokens.get(i - 1), Double.parseDouble(Tokenizer.tokens.get(i + 1)));
            } else if (Tokenizer.tokens.get(i).equals("=") && Memory.variable.containsKey(Tokenizer.tokens.get(i + 1))) {
                Memory.variable.put(Tokenizer.tokens.get(i - 1), Memory.variable.get(Tokenizer.tokens.get(i + 1)));
            }

            if (Tokenizer.tokens.get(i).equals("cetak")) {
                if (!Memory.variable.containsKey(Tokenizer.tokens.get(i + 1))) {
                    System.out.println(Double.parseDouble((Tokenizer.tokens.get(i + 1))));
                } else if (Memory.variable.containsKey(Tokenizer.tokens.get(i + 1))) {
                    System.out.println(Memory.variable.get((Tokenizer.tokens.get(i + 1))));
                }
            }
        }
    }
}