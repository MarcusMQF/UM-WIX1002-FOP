import java.util.Random;

public class T1Q4 {
    public static void main(String[] args) {
        playGame();
    }

    public static void playGame(){
        Random random = new Random();

        int player1Score = rollDice(random);
        int player2Score = rollDice(random);

        printResult(player1Score, player2Score);

        determineWinner(player1Score, player2Score);

    }

    public static int rollDice(Random random){
        return random.nextInt(6) + 1;
    }

    public static void printResult(int player1, int player2){
        System.out.println("Player 1's rolled: " + player1);
        System.out.println("Player 2's rolled: " + player2);
    }

    public static void determineWinner(int player1, int player2){
        String winner = (player1 > player2) ? "Winner 1 is Winner!" : "Winner 2 is Winner!";
        System.out.println(winner);
    }
}

