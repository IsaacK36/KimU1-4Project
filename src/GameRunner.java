import java.util.Scanner;

public class GameRunner {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome!");
        boolean retry = true;
        while (retry == true) {
            Game word = new Game(); //
            String guessedWord = "";
            int lives = 6;
            word.printGuessedLetters();
            System.out.println();
            while (word.win(guessedWord) == false && lives > 0) {
                System.out.print("Pick a letter: "); //
                String guessedLetter = scan.nextLine();
                guessedWord += guessedLetter;
                if (!(word.inWord(guessedLetter))) {
                    lives -= 1;
                }
                word.printGuessedLetters(guessedWord);
                System.out.println("Lives: " + lives);
            }
            System.out.println("You Win!");
            System.out.print("Press y to play again: ");
            if (!(scan.nextLine().equals("y"))) {
                retry = false;
            }
        }

    }
}
