import java.util.Random;
import java.util.Scanner;

public class L4Q5 {
    public static void main(String[] args) {
        System.out.println("===[DICE GAME]===");
        System.out.println();
        
        int player1Score = 0;
        int player2Score = 0;
        boolean player1Turn = true;
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (player1Score < 100 && player2Score < 100) {
            if (player1Turn) {
                player1Score = rollDice("Player 1", player1Score, scanner, random);
                if (player1Score >= 100) {
                    System.out.println("Player 1 wins!");
                    break;
                }
                player1Turn = false;
            } else {
                player2Score = rollDice("Player 2", player2Score, scanner, random);
                if (player2Score >= 100) {
                    System.out.println("Player 2 wins!");
                    break;
                }
                player1Turn = true;
            }
        }

        scanner.close();
    }

    public static int rollDice(String playerName, int currentScore, Scanner scanner, Random random) {
        int dice;
        boolean rolledSix;

        do {
            System.out.print(playerName + ", press [Enter] to roll the dice.");
            scanner.nextLine();
            dice = random.nextInt(6) + 1;
            currentScore += dice;
            System.out.println(playerName + ": " + dice);
            System.out.println("Total Score (" + playerName + "): " + currentScore);
            System.out.println();
            rolledSix = (dice == 6);
            if (rolledSix && currentScore < 100) {
                System.out.println(playerName + " rolled a 6! Roll again.");
                System.out.println();
            }
        } while (rolledSix && currentScore < 100);

        return currentScore;
    }
}
