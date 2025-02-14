import java.util.Random;

public class L3Q4 {
    public static void main(String[] args) {
        int player1Score = Player1();
        int player2Score = Player2();
        winner(player1Score, player2Score);
    }
    
    public static int Player1() {
        Random random = new Random();
        
        int firstRoll = random.nextInt(6) + 1;
        int secondRoll = random.nextInt(6) + 1;
        int totalScore = firstRoll + secondRoll;
        
        System.out.println("Player 1 first roll: " + firstRoll);
        System.out.println("Player 1 second roll: " + secondRoll);
        System.out.println("Player 1 total score: " + totalScore);
        System.out.println();
        
        return totalScore;
    }
    
    public static int Player2() {
        Random random = new Random();
        
        int firstRoll = random.nextInt(6) + 1;
        int secondRoll = random.nextInt(6) + 1;
        int totalScore = firstRoll + secondRoll;
        
        System.out.println("Player 2 first roll: " + firstRoll);
        System.out.println("Player 2 second roll: " + secondRoll);
        System.out.println("Player 2 total score: " + totalScore);
        System.out.println();
        
        return totalScore;
    }
    
    public static void winner(int score1, int score2) {
        if (score1 > score2) {
            System.out.println("Player 1 won!");
        } else if (score2 > score1) {
            System.out.println("Player 2 won!");
        } else {
            System.out.println("Tie");
        }
    }
}
