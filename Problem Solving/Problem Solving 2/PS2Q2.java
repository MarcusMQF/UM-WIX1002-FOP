import java.util.Scanner;

public class PS2Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int correctAnswers = 0;
        int totalQuestions = 0;
        
        while (true) {
            System.out.print("Enter a number (-1 to quit): ");
            int number = scanner.nextInt();
            
            if (number == -1) {
                break;
            }
            
            System.out.print("Enter a factor : ");
            int factor = scanner.nextInt();
            
            boolean isFactor = (number % factor == 0);
            
            System.out.print(factor + " is a factor of " + number + "? (true/false): ");
            boolean userAnswer = scanner.nextBoolean();
            
            boolean isCorrect = (userAnswer == isFactor);
            if (isCorrect) {
                System.out.println("Your answer is correct.");
                correctAnswers++;
            } else {
                System.out.println("Your answer is incorrect.");
            }
            
            totalQuestions++;
        }
        
        // Display final score as a fraction after input -1 (Quit)
        System.out.println("The final score is " + correctAnswers + "/" + totalQuestions);
        
        scanner.close();
    }
}