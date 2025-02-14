import java.util.Random;
import java.util.Scanner;

public class L9Q4 {

    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Choose a game to play:");
        System.out.println("1. Roll Two Dice");
        System.out.println("2. Roll One Die");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();

        DiceGame game;
        if (choice == 1) {
            game = new FirstDiceGame();
        } else if (choice == 2) {
            game = new SecondDiceGame();
        } else {
            System.out.println("Invalid choice. Exiting...");
            return;
        }

        game.play();
    }
}

abstract class DiceGame {
    protected int score;
    protected Random random;

    public DiceGame() {
        score = 0;
        random = new Random();
    }

    public int getScore() {
        return score;
    }

    // Abstract method to play the game
    public abstract void play();

    // Roll a single die
    protected int rollDie() {
        return random.nextInt(6) + 1; // Returns a random number between 1 and 6
    }
}

class FirstDiceGame extends DiceGame {
    @Override
    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (score < 100) {
            System.out.println("Current Score: " + score);
            System.out.print("\nPress Enter to roll two dice...\n");
            scanner.nextLine();

            int die1 = rollDie();
            int die2 = rollDie();
            System.out.println("You rolled: " + die1 + " and " + die2);

            int turnScore = die1 + die2;
            score += turnScore;
            System.out.println("You scored: " + turnScore + " points this turn.");

            if (die1 == die2) {
                System.out.println("Both dice are equal! You get to roll again.");
            } else {
                System.out.println("No extra roll. Your total score is now: " + score);
            }
        }
        System.out.println("Congratulations! You reached 100 points or more. You win!");

        scanner.close();
    }
}

class SecondDiceGame extends DiceGame {
    @Override
    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (score < 100) {
            System.out.println("Current Score: " + score);
            System.out.print("\nPress Enter to roll one die...\n");
            scanner.nextLine();

            int die = rollDie();
            System.out.println("You rolled: " + die);

            if (die == 6) {
                System.out.println("You rolled a 6! You get to roll again.");
                System.out.print("Press Enter to roll again...");
                scanner.nextLine();

                int secondDie = rollDie();
                System.out.println("You rolled: " + secondDie);

                if (secondDie == 6) {
                    System.out.println("You rolled a 6 again! No points this turn.");
                } else {
                    int turnScore = die + secondDie;
                    score += turnScore;
                    System.out.println("You scored: " + turnScore + " points this turn.");
                }
            } else {
                score += die;
                System.out.println("You scored: " + die + " points this turn.");
            }

            if (score > 100) {
                System.out.println("You exceeded 100 points. Last score not counted. Roll again next turn.");
                score -= die; // Subtract the last score to keep it under 100
            }

            System.out.println("Your total score is now: " + score);
        }
        System.out.println("Congratulations! You reached 100 points. You win!");
        
        scanner.close();
    }
}
