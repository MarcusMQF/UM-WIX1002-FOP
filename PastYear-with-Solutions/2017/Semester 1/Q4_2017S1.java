import java.util.Scanner;

public class Q4_2017S1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // First complex number input
        System.out.print("First complex number: Enter a number for the real part: ");
        double real1 = scanner.nextDouble();
        System.out.print("First complex number: Enter a number for the imaginary part: ");
        double imag1 = scanner.nextDouble();
        
        // Second complex number input
        System.out.print("Second complex number: Enter a number for the real part: ");
        double real2 = scanner.nextDouble();
        System.out.print("Second complex number: Enter a number for the imaginary part: ");
        double imag2 = scanner.nextDouble();
        
        // Create Complex objects
        Complex num1 = new Complex(real1, imag1);
        Complex num2 = new Complex(real2, imag2);
        
        // Perform calculations and display results
        Complex sum = num1.addComplexNum(num2);
        Complex difference = num1.subtractComplexNum(num2);
        
        System.out.println("\nFirst complex number: " + num1);
        System.out.println("Second complex number: " + num2);
        System.out.println("Addition of the two complex numbers: " + sum);
        System.out.println("Subtraction of the two complex numbers: " + difference);
        
        scanner.close();
    }
}

class Complex {
    private double real;
    private double imaginary;
    
    // No-argument constructor
    public Complex() {
        this.real = 0.0;
        this.imaginary = 0.0;
    }
    
    // Constructor with arguments
    public Complex(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    
    // Add two complex numbers
    public Complex addComplexNum(Complex other) {
        double newReal = this.real + other.real;
        double newImaginary = this.imaginary + other.imaginary;
        return new Complex(newReal, newImaginary);
    }
    
    // Subtract two complex numbers
    public Complex subtractComplexNum(Complex other) {
        double newReal = this.real - other.real;
        double newImaginary = this.imaginary - other.imaginary;
        return new Complex(newReal, newImaginary);
    }
    
    // Display complex number in (a, b) format
    public String toString() {
        String realStr = (real == (int)real) ? String.format("%.0f", real) : String.valueOf(real);
        String imagStr = (imaginary == (int)imaginary) ? String.format("%.0f", imaginary) : String.valueOf(imaginary);
        return "(" + realStr + " + " + imagStr + "i)";
    }
}
