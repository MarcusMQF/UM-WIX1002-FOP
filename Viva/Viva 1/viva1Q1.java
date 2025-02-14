import java.util.Scanner;
import java.util.InputMismatchException;

public class viva1Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Enter a number: ");
                num = scanner.nextInt();
                
                if (num < 0) {
                    System.out.println("Error: Please enter a positive number!");
                } else {
                    validInput = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid number!");
                scanner.nextLine(); // Clear invalid input
            }
        }

        do {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
        } while (num > 9);

        System.out.println("Sum of digits until single digit: " + num);
        scanner.close();
    }
}
