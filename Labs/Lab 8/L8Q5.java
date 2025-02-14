import java.util.Random;
import java.util.Scanner;

public class L8Q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get player names
        System.out.print("Enter Player 1 name: ");
        String player1 = scanner.nextLine();
        System.out.print("Enter Player 2 name: ");
        String player2 = scanner.nextLine();

        // Create player objects
        Game p1 = new Game(player1);
        Game p2 = new Game(player2);

        // Game loop
        while (true) {
            if (p1.move()) {
                System.out.println(player1 + " wins the game!");
                break;
            }
            if (p2.move()) {
                System.out.println(player2 + " wins the game!");
                break;
            }
        }

        scanner.close();
    }
}

class Game {
    private String playerName;
    private int score;
    private Random rand;

    // Constructor
    public Game(String name) {
        this.playerName = name;
        this.score = 0;
        this.rand = new Random();
    }

    // Method to roll the dice and update the score
    public boolean move() {
        int roll = rand.nextInt(6) + 1; // Generates a number between 1-6
        score += roll;
        System.out.println(playerName + " rolled a " + roll + ". Total score: " + score);

        if (score >= 100) {
            return true; // Player wins
        }
        return false; // Continue game
    }
}
