import java.util.Scanner;

public class GameRunner {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean retry = true;
        Game word = new Game();
        while (retry == true) {
            System.out.print("You have " + word.getLives() + " lives. Would you like to change this?: ");
            if (scan.nextLine().equals("y")) {
                System.out.print("What would you like to set lives to?: ");
                word = new Game(scan.nextInt());
            }
            System.out.println();
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