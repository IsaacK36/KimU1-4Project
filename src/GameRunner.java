import java.util.Objects;
import java.util.Scanner;

public class GameRunner {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean retry = true;
        while (retry) {
            Game word = new Game();
            word.printGuessedLetters("");
            System.out.println();
            while (!word.win(word.getGuesses()) && word.getLives() > 0) {
                word.printGame();
                String guessedLetter = scan.nextLine();
                word.addGuess(guessedLetter);
                if (!(word.inWord(guessedLetter))) {
                    word.loseLife();
                }
            }
            if (word.getLives() != 0) {
                System.out.println("You Win!");
            } else {
                System.out.println("You Lose");
            }
            word.printGame();
            System.out.print("Press y to play again: ");
            if (!(scan.nextLine().equals("y"))) {
                retry = false;
            }
        }

    }
}