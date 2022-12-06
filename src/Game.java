public class Game {
    private String answer;

    private String lvl;
    private String guesses;
    private int lives;

    public Game() {
        lives = 6;
        guesses = "";
        int r = (int) (Math.random() * 10);
        if (r == 9) {
            answer = "crab";
        } else if (r == 8) {
            answer = "banana";
        } else if (r == 7) {
            answer = "tarantula";
        } else if (r == 6) {
            answer = "quintillion";
        } else if (r == 5) {
            answer = "parallelization";
        } else if (r == 4) {
            answer = "myrrh";
        } else if (r == 3) {
            answer = "squirreled";
        } else if (r == 2) {
            answer = "traumatize";
        } else if (r == 1) {
            answer = "expedite";
        } else if (r == 0) {
            answer = "eel";
        }
    }

    public Game(String lvl) {
        lives = 6;
        guesses = "";
        int r = (int) (Math.random() * 10);
        if (lvl.equals("hard")) {
            if (r == 9) {
                answer = "arbitrary";
            } else if (r == 8) {
                answer = "bilingual";
            } else if (r == 7) {
                answer = "tarantula";
            } else if (r == 6) {
                answer = "quintillion";
            } else if (r == 5) {
                answer = "parallelization";
            } else if (r == 4) {
                answer = "myrrh";
            } else if (r == 3) {
                answer = "squirreled";
            } else if (r == 2) {
                answer = "traumatize";
            } else if (r == 1) {
                answer = "expedite";
            } else if (r == 0) {
                answer = "cornucopia";
            }
        } else if (lvl.equals("normal")) {
            if (r == 9) {
                answer = "banana";
            } else if (r == 8) {
                answer = "computer";
            } else if (r == 7) {
                answer = "science";
            } else if (r == 6) {
                answer = "bald";
            } else if (r == 5) {
                answer = "camel";
            } else if (r == 4) {
                answer = "mammoth";
            } else if (r == 3) {
                answer = "robin";
            } else if (r == 2) {
                answer = "cancer";
            } else if (r == 1) {
                answer = "calculus";
            } else if (r == 0) {
                answer = "apple";
            }
        }
    }

    public void addGuess(String str) {
        guesses += str;
    }

    public String getGuesses() {
        return guesses;
    }

    public String getLvl() {
        return lvl;
    }

    public String getWrongGuesses() {
        String guessList = "";
        for (int i = 0; i < guesses.length(); i++) {
            if (!(answer.contains(guesses.substring(i, i + 1)))) {
                guessList += guesses.charAt(i);
                if (i < guesses.length() - 1) {
                    guessList += ", ";
                }
            }
        }
        return guessList;
    }

    public int getLives() {
        return lives;
    }

    public void loseLife() {
        lives--;
    }
    public boolean inWord(String ltr) {
        if (answer.contains(ltr)) {
            return true;
        }
        return false;
    }

    public void printGuessedLetters(String guessedWord) {
        for (int i = 0; i < answer.length(); i++) {
            if (!guessedWord.contains(answer.substring(i, i + 1))) {
                System.out.print("_");
            } else {
                System.out.print(answer.charAt(i));
            }
        }
    }

    public boolean win(String guessedWord) {
        for (int i = 0; i < answer.length(); i++) {
            if (!guessedWord.contains(answer.substring(i, i + 1))) {
                return false;
            }
        }
        return true;
    }

    public void printGame() {
        System.out.print("|--------------------|\n| ");
        printGuessedLetters(guesses);
        for (int i = answer.length(); i < 19; i++) {
            System.out.print(" ");
        }
        System.out.println("|         Wrong Guesses: " + getWrongGuesses());
        System.out.println("|                    |");
        System.out.println("| You have " + getLives() + " lives   |");
        System.out.println("|--------------------|");
        System.out.print("Pick a letter: ");
        System.out.println();

    }
}
