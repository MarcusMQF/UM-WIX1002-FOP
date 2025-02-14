import java.util.Random;
import java.util.Scanner;

public class L6Q5 {
    // Method to check if third parameter equals multiplication of first two parameters
    public static boolean checkMultiplication(int num1, int num2, int answer) {
        return (num1 * num2) == answer;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        
        while (true) {
            // Generate two random numbers between 0 and 12
            int num1 = random.nextInt(13);  // 0 to 12
            int num2 = random.nextInt(13);  // 0 to 12
            
            System.out.println("Enter negative number to quit.");
            System.out.print(num1 + " x " + num2 + " = ");
            
            // Get user's answer
            int userAnswer = scanner.nextInt();
            
            // Check if user wants to quit
            if (userAnswer < 0) {
                break;
            }
            
            // Check if answer is correct using our method
            if (checkMultiplication(num1, num2, userAnswer)) {
                score++;
            }
        }
        
        System.out.println("Your Score is " + score);
        scanner.close();
    }
}
