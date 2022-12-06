import java.util.Scanner;

public class GameRunner {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("\nH   A   N   G   M   A   N\n");
        boolean retry = true;
        Game word = new Game();
        while (retry == true) {
            System.out.print("The difficulty is set to " + word.getLvl() + ". ");
            if (scan.nextLine().equals("y")) {
                word = new Game("hard");
            }
            while (!word.win(word.getGuesses()) && word.getLives() > 0) {
                word.printGame();
                String guessedLetter = scan.nextLine();
                word.addGuess(guessedLetter);
                if (!(word.inWord(guessedLetter))) {
                    word.loseLife();
                }
            }
            if ((word.getLives() != 0)) {
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