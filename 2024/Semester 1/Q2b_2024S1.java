import java.util.Scanner;

public class Q2b_2024S1 {
    public static void main(String[] args) { 

        try(Scanner scanner = new Scanner(System.in)){
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            checkAge(age);
            System.out.println("Valid age");

        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean checkAge(int age) throws InvalidAgeException {
        if(age < 18){
            throw new InvalidAgeException("Invalid age. Age must be 18 and above.");
        }
        return true;
    }

    public static class InvalidAgeException extends Exception {
        public InvalidAgeException(String message){
            super(message);
        }
    }
}
