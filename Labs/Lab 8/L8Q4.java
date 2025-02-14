import java.util.Scanner;

public class L8Q4 {
    public static void main(String[] args) {
        Fraction fraction = new Fraction();
        fraction.input();
        fraction.reduce();
        fraction.display();
    }
}

class Fraction {
    private int numerator, denominator;

    // Method to accept user input
    public void input() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the numerator: ");
        numerator = scanner.nextInt();

        do {
            System.out.print("Enter the denominator (not zero): ");
            denominator = scanner.nextInt();
        } while (denominator == 0); // Prevent division by zero
        
        scanner.close(); 
    }

    // Mutator methods (setters)
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        if (denominator != 0) {
            this.denominator = denominator;
        } else {
            System.out.println("Denominator cannot be zero.");
        }
    }

    // Accessor methods (getters)
    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    // Method to reduce the fraction
    public void reduce() {
        int gcd = findGCD(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    // Helper method to find GCD
    private int findGCD(int a, int b) {
        if (b == 0)
            return Math.abs(a);
        return findGCD(b, a % b);
    }

    // Method to display the fraction
    public void display() {
        System.out.println("Reduced Fraction: " + numerator + "/" + denominator);
    }
}
