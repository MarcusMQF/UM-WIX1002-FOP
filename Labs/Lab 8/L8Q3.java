import java.util.Scanner;

public class L8Q3 {
    public static void main(String[] args) {
        // Create an object of WeightCalculator
        WeightCalculator calculator = new WeightCalculator();

        // Accept user input for age and height
        calculator.inputData();

        // Display the results
        calculator.displayResults();
    }
}

class WeightCalculator {
    // Fields to store age and height
    private int age;
    private double height;

    // Method to accept user input for age and height
    public void inputData() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your age: ");
        age = scanner.nextInt();

        System.out.print("Enter your height (in cm): ");
        height = scanner.nextDouble();

        scanner.close(); // Close the scanner to avoid resource leak
    }

    // Method to calculate the recommended weight
    public double calculateRecommendedWeight() {
        return (height - 100 + age / 10.0) * 0.9;
    }

    // Method to display the user's age, height, and recommended weight
    public void displayResults() {
        double recommendedWeight = calculateRecommendedWeight();
        System.out.println("\nUser Details:");
        System.out.println("Age: " + age);
        System.out.println("Height: " + height + " cm");
        System.out.printf("Recommended Weight: %.2f kg%n", recommendedWeight);
    }
}
