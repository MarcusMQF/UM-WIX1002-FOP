import java.util.Random;
import java.util.Scanner;

public class T1Q12 {
    public static void main(String[] args) {
        
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        int Tries = 8;
        int GenerateNumber = random.nextInt(100) + 1;
        boolean guessedCorrectly = false;

        System.out.println("I'm thinking of a number between 1 and 100. You have " + Tries + " tries to guess it.");

        for (int i = 0; i < Tries; i++) {

            System.out.println("Enter your guess (Try " + (i+1) + "/" + Tries + "): ");
            int GuessNumber = scanner.nextInt();

            if(GuessNumber <= GenerateNumber){
                System.out.println("Your number is lower than the generated number\n");
            }else if(GuessNumber >= GenerateNumber){
                System.out.println("Your number is higher than the generated number\n");
            }else{
                System.out.println("You guessed the number! Congrats!\n");
                guessedCorrectly = true;
                break;
            }

        }

        if(!guessedCorrectly){
            System.out.println("Game Over. The number was: " + GenerateNumber);
        }

        scanner.close();
    }
}
