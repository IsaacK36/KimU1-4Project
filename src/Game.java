public class Game {
    private String answer;

    public Game() {
        if ((int) (Math.random() * 2) == 1) {
            answer = "crab";
        } else {
            answer = "banana";
        }
    }

    public boolean inWord(String ltr) {
        for (int i = 0; i < answer.length(); i++) {
            if (answer.indexOf(ltr) != -1) {
                return true;
            }
        }
        return false;
    }

    public void printGuessedLetters() {
        for (int i = 0; i < answer.length(); i++) {
            System.out.print("_");
        }
        System.out.println();
    }
    public void printGuessedLetters(String guessedWord) {
        for (int i = 0; i < answer.length(); i++) {
            if (guessedWord.indexOf(answer.substring(i, i + 1)) == -1) {
                System.out.print("_");
            } else {
                System.out.print(answer.substring(i, i + 1));
            }
        }
        System.out.println();
    }

    public boolean win(String guessedWord) {
        for (int i = 0; i < answer.length(); i++) {
            if (guessedWord.indexOf(answer.substring(i, i + 1)) == -1) {
                return false;
            }
        }
        return true;
    }

}
