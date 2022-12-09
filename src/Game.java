public class Game {
    private String answer;

    private int lives;
    private String lvl;
    private String guesses;

    public Game() {
        lvl = "normal";
        lives = 6;
        guesses = "";
        int r = (int) (Math.random() * 10);
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

    /**
     *
     * @param lvl represents the difficulty level of the game
     */
    public Game(String lvl) {
        guesses = "";
        lives = 6;
        int r = (int) (Math.random() * 10);
        if (lvl.equals("hard")) {
            if (r == 9) {
                answer = "nymph";
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
                answer = "call";
            } else if (r == 5) {
                answer = "camel";
            } else if (r == 4) {
                answer = "mammoth";
            } else if (r == 3) {
                answer = "orange";
            } else if (r == 2) {
                answer = "cancer";
            } else if (r == 1) {
                answer = "calculus";
            } else if (r == 0) {
                answer = "apple";
            }
        }
    }

    /**
     *
     * @return The method returns the answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * The method adds a letter to the list of letters the user has guessed
     * @param str represents a letter the user guessed.
     */
    public void addGuess(String str) {
        guesses += str;
    }

    /**
     *
     * @return The method returns the letters the user has guessed.
     */
    public String getGuesses() {
        return guesses;
    }

    /**
     *
     * @return The method returns the difficulty level of the game
     */
    public String getLvl() {
        return lvl;
    }


    /**
     *
     * @return The method returns the letters the user guessed that are not in the word
     */
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

    /**
     *
     * @return The method returns the number of lives the user has left
     */
    public int getLives() {
        return lives;
    }

    /**
     * The method substracts 1 from the variable lives
     */
    public void loseLife() {
        lives--;
    }
    /**
     *
     * @param ltr represents a letter that the user guessed
     * @return The method returns true if parameter ltr is in the instance variable answer
     */
    public boolean inWord(String ltr) {
        if (answer.contains(ltr)) {
            return true;
        }
        return false;
    }

    /**
     * @param guessedWord represents the all the letters the user has guessed
     * The method prints the letters that the user guessed in the form of a list
     */
    public void printGuessedLetters(String guessedWord) {
        for (int i = 0; i < answer.length(); i++) {
            if (!guessedWord.contains(answer.substring(i, i + 1))) {
                System.out.print("_");
            } else {
                System.out.print(answer.charAt(i));
            }
        }
    }

    /**
     *
     * @param guessedWord represents all the letters the user guessed.
     * @return The method returns true if the user has guessed all the letters in the answer
     */
    public boolean win(String guessedWord) {
        for (int i = 0; i < answer.length(); i++) {
            if (!guessedWord.contains(answer.substring(i, i + 1))) {
                return false;
            }
        }
        return true;
    }

    /**
     * The method prints the game
     */
    public void printGame() {
        System.out.print("|--------------------|\n| ");
        printGuessedLetters(guesses);
        for (int i = answer.length(); i < 19; i++) {
            System.out.print(" ");
        }
        System.out.println("|           Wrong Guesses: " + getWrongGuesses());
        System.out.println("|                    |");
        System.out.println("| You have " + getLives() + " lives   |");
        System.out.println("|--------------------|");
        System.out.print("Pick a letter: ");
    }

    /**
     * The method prints the game at the end
     */
    public void printGameEnd() {
        System.out.print("|--------------------|\n| ");
        printGuessedLetters(guesses);
        for (int i = answer.length(); i < 19; i++) {
            System.out.print(" ");
        }
        System.out.println("|           Wrong Guesses: " + getWrongGuesses());
        System.out.println("|                    |");
        System.out.println("|                    |");
        System.out.println("|--------------------|");
    }
}