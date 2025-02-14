import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Q1_2024S2 {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("input.txt"))) {
            
            // Keep track of which game we're processing
            int gameNumber = 1;

            // Continue reading while there are more lines in the file
            while (scanner.hasNextLine()) {
                // Create array to store 3 lines representing the Tic Tac Toe board
                String[] board = new String[3];

                // Read 3 lines from file for current board
                for (int i = 0; i < 3; i++) {
                    board[i] = scanner.nextLine();
                }

                // Check if there's a separator line after the board
                if (scanner.hasNextLine()) {
                    String separator = scanner.nextLine();
                    // Verify separator is correct format
                    if (!separator.equals("#")) {
                        System.out.println("Invalid input format.");
                        return;
                    }
                }

                // Print current game number and board
                System.out.println("Game " + gameNumber + ":");
                System.out.println("Tic-Tac-Toe Board:");

                // Print each row, replacing dots with spaces and add a space between each character
                for (String row : board) {
                    System.out.println(row.replace(".", " ").replace("", " ").trim());
                }

                 // Check and print winner for current game
                String result = checkWinner(board);
                System.out.println("Winner: " + result);
                System.out.println();

                // Move to next game
                gameNumber++;
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found.");
        }
    }

    private static String checkWinner(String[] board) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) != '.' && board[i].charAt(0) == board[i].charAt(1) && board[i].charAt(1) == board[i].charAt(2)) {
                return String.valueOf(board[i].charAt(0));
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(i) != '.' && board[0].charAt(i) == board[1].charAt(i) && board[1].charAt(i) == board[2].charAt(i)) {
                return String.valueOf(board[0].charAt(i));
            }
        }

        // Check diagonals
        if (board[0].charAt(0) != '.' && board[0].charAt(0) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(2)) {
            return String.valueOf(board[0].charAt(0));
        }
        if (board[0].charAt(2) != '.' && board[0].charAt(2) == board[1].charAt(1) && board[1].charAt(1) == board[2].charAt(0)) {
            return String.valueOf(board[0].charAt(2));
        }

        // Only check for ongoing game if no winner found
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == '.') {
                    return "None (on going)";
                }
            }
        }

        return "Draw";
    }
}