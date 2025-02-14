import java.util.Scanner;

public class Q4_2018S2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        // Prompt user for input
        System.out.print("Enter the values for a, b, c, d, e and f : ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double d = input.nextDouble();
        double e = input.nextDouble();
        double f = input.nextDouble();
        
        // Create LinearEquation object
        LinearEquation equation = new LinearEquation(a, b, c, d, e, f);
        
        // Display the equation
        System.out.println("\nThe equation :");
        System.out.println(equation.toString());
        
        // Check if solvable and display results
        if (equation.isSolvable()) {
            System.out.printf("\nx = %.0f ; y = %.0f", 
                equation.computeX(), equation.computeY());
        } else {
            System.out.println("\nThe equation has no solution");
        }
        
        input.close();
    }
}

class LinearEquation {
    // Private data fields
    private double a, b, c, d, e, f;
    
    // Constructor
    public LinearEquation(double a, double b, double c, double d, double e, double f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }
    
    // Check if equation is solvable
    public boolean isSolvable() {
        return (a * d - b * c) != 0;
    }
    
    // Compute x value
    public double computeX() {
        return (e * d - b * f) / (a * d - b * c);
    }
    
    // Compute y value
    public double computeY() {
        return (a * f - e * c) / (a * d - b * c);
    }
    
    // Return the equation as a string
    @Override
    public String toString() {
        return String.format("%.0fx + %.0fy = %.0f\n%.0fx + %.0fy = %.0f", 
            a, b, e, c, d, f);
    }
}
