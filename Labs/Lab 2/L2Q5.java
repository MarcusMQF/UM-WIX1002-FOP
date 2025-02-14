import java.util.Random;

public class L2Q5 {
    public static void main(String[] args) {
        // Create Random object
        Random random = new Random();
        
        // Generate random number between 0 and 10000
        int number = random.nextInt(10001); // 10001 because nextInt is exclusive
        int sum = 0;
    
        int originalNumber = number; // Store original number for display
    
        while (number > 0) {
            sum += number % 10;    // Add rightmost digit to sum
            number = number / 10;   // Remove rightmost digit
        }
        
        // Display results
        System.out.println("Generated number: " + originalNumber);
        System.out.println("Sum of digits: " + sum);
    }
}