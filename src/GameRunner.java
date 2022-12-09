import java.util.Scanner;

public class GameRunner {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("\nH   A   N   G   M   A   N\n");

        Game word = new Game();
        while (true) {
            System.out.println("The difficulty is set to " + word.getLvl());
            while (!word.win(word.getGuesses()) && word.getLives() > 0) {
                word.printGame();
                String guessedLetter = scan.nextLine();
                if (guessedLetter.length() == 1) {
                    word.addGuess(guessedLetter);
                    if (!(word.inWord(guessedLetter))) {
                        word.loseLife();
                    }
                } else {
                    System.out.println("pick A LETTER");
                }

            }
            word.printGameEnd();

            if ((word.getLives() != 0)) {
                System.out.println("You Win!");
            } else {
                System.out.println("You Lose");
            }

            System.out.println("The word was: " + word.getAnswer());

            System.out.print("\nPress y to play again: ");
            if (!(scan.nextLine().equals("y"))) {
                break;
            }

            System.out.print("Set difficulty(normal or hard): ");
            word = new Game(scan.nextLine());
        }
        System.out.println("Thanks for playing!");

    }
}