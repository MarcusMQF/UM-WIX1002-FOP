import java.util.Scanner;

public class L2Q6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Get water amount in grams and convert to kg
        System.out.print("Enter the amount of water in gram: ");
        double waterInGrams = input.nextDouble();
        double M = waterInGrams / 1000; // Convert grams to kg
        
        // Get temperatures in Fahrenheit
        System.out.print("Enter the initial temperature in Fahrenheit: ");
        double initialTempF = input.nextDouble();
        
        System.out.print("Enter the final temperature in Fahrenheit: ");
        double finalTempF = input.nextDouble();
        
        // Convert temperatures from Fahrenheit to Celsius
        double initialTempC = (initialTempF - 32) * 5/9;
        double finalTempC = (finalTempF - 32) * 5/9;
        
        // Calculate energy using the formula Q = M * (final temp - initial temp) * 4184
        double Q = M * (finalTempC - initialTempC) * 4184;
        
        // Display result in scientific notation
        System.out.printf("The energy needed is %.6e%n", Q);
        
        input.close();
    } 
}