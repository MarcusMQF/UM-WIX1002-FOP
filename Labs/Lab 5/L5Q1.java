import java.util.Random;
import java.util.Scanner;

public class L5Q1 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter N Students: ");
        int n = scanner.nextInt();

        // Generate and store random score
        int[] scores = new int[n];
        for(int i = 0; i < n; i++) {
            scores[i] = random.nextInt(101);
        }

        // Find highest and lowest score
        int highest = scores[0];
        int lowest = scores[0];
        double sum = 0;

        for(int i = 1; i < scores.length; i++){
            if(scores[i] > highest) {
                highest = scores[i];
            }

            if(scores[i] < lowest) {
                lowest = scores[i];
            }
            sum += scores[i];
        }

        double average = sum / n;

        // Display the results
        System.out.println("\nList of the scores: ");
        for(int i = 0; i < scores.length; i++){
            System.out.println("Student " + (i + 1) + ": " + scores[i]);
        }

        System.out.println("\nHighest Score: " + highest);
        System.out.println("Lowest Score: " + lowest);
        System.out.println("Average Score: " + average);

        scanner.close();
    }
}
