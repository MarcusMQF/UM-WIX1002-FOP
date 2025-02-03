import java.util.Random;
import java.util.Scanner;

public class Q2_2016S1 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        
        // Initialize variables
        int playerChoice, computerChoice;
        String player = "";
        String computer = "";
        int playerWins = 0;
        int computerWins = 0;
        boolean won = false;
        
        do{
            System.out.print("Enter 1. Paper  2. Scissor  3. Rock: ");
            playerChoice = scanner.nextInt();
            
            // Validate player input
            if (playerChoice < 1 || playerChoice > 3) {
                System.out.println("Invalid choice. Please choose 1, 2, or 3.");
                continue;
            }
            
            // Map player choice to string
            switch (playerChoice) {
                case 1 -> player = "Paper";
                case 2 -> player = "Scissor";
                case 3 -> player = "Rock";
            }
            
            // Generate a random computer's choice
            computerChoice = random.nextInt(3) + 1;
            
            // Map computer choice to string
            switch (computerChoice) {
                case 1 -> computer = "Paper";
                case 2 -> computer = "Scissor";
                case 3 -> computer = "Rock";
            }
            
            System.out.println("Player: " + player + " ----- Computer: " + computer);
            
            // Determine the winner
            int result = checkWinner(playerChoice, computerChoice);
            if (result == 1) {
                playerWins++;
                System.out.println("Player win " + playerWins + " time(s)");
                System.out.println();
            } else if (result == -1) {
                computerWins++;
                System.out.println("Computer win " + computerWins + " time(s)");
                System.out.println();
            } else {
                System.out.println();
            }
            
            if(playerWins == 3 || computerWins == 3){
                won = true;
            }
            
            if(playerWins == 3){
                System.out.println("Player wins the game.");
            }else if(computerWins == 3){
                System.out.println("Computer wins the game.");
            }
            
        }while (!won);
        
        scanner.close();
    }
    
    public static int checkWinner(int playerChoice, int computerChoice) {
        // 1: Player wins, -1: Computer wins, 0: Tie
        if (playerChoice == computerChoice) {
            return 0;
        }
        
        switch (playerChoice) {
            case 1: // Player chose Paper
                if (computerChoice == 3) return 1; // Paper beats Rock
                else return -1; // Scissor beats Paper
            case 2: // Player chose Scissor
                if (computerChoice == 1) return 1; // Scissor beats Paper
                else return -1; // Rock beats Scissor
            case 3: // Player chose Rock
                if (computerChoice == 2) return 1; // Rock beats Scissor
                else return -1; // Paper beats Rock
            default:
                return 0; // Invalid case (should not happen)
        }
    }
}
