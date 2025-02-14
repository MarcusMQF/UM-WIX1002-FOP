import java.util.*;

public class L8Q1 {
    public static void main(String[] args) {
        // Test all three constructors
        System.out.println("Testing Number a (10 random numbers 0-100):");
        Number a = new Number();
        displayAllInfo(a);
        
        System.out.println("\nTesting Number b (5 random numbers 0-100):");
        Number b = new Number(5);
        displayAllInfo(b);
        
        System.out.println("\nTesting Number c (4 random numbers 0-50):");
        Number c = new Number(4, 50);
        displayAllInfo(c);
    }
    
    // Helper method to display all information for a Number object
    private static void displayAllInfo(Number num) {
        num.displayAll();
        num.displayEven();
        num.displayPrime();
        num.displayMax();
        num.displayMin();
        num.displayAverage();
        num.displaySquare();
    }
}

class Number {
    private int[] numbers;
    
    // Default constructor - generates 10 random numbers (0-100)
    public Number() {
        this(10);
    }
    
    // Constructor with size parameter (0-100)
    public Number(int size) {
        this(size, 100);
    }
    
    // Constructor with size and range parameters
    public Number(int size, int range) {
        numbers = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            numbers[i] = rand.nextInt(range + 1);
        }
    }
    
    // Display all numbers
    public void displayAll() {
        System.out.print("All numbers: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    // Display even numbers
    public void displayEven() {
        System.out.print("Even numbers: ");
        for (int num : numbers) {
            if (num % 2 == 0) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }
    
    // Display prime numbers
    public void displayPrime() {
        System.out.print("Prime numbers: ");
        for (int num : numbers) {
            if (isPrime(num)) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }
    
    // Helper method to check if a number is prime
    private boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    
    // Display maximum number
    public void displayMax() {
        int max = Arrays.stream(numbers).max().getAsInt();
        System.out.println("Maximum number: " + max);
    }
    
    // Display minimum number
    public void displayMin() {
        int min = Arrays.stream(numbers).min().getAsInt();
        System.out.println("Minimum number: " + min);
    }
    
    // Display average
    public void displayAverage() {
        double avg = Arrays.stream(numbers).average().getAsDouble();
        System.out.println("Average: " + String.format("%.2f", avg));
    }
    
    // Display square numbers
    public void displaySquare() {
        System.out.print("Square numbers: ");
        for (int num : numbers) {
            if (isSquare(num)) {
                System.out.print(num + " ");
            }
        }
        System.out.println();
    }
    
    // Helper method to check if a number is a perfect square
    private boolean isSquare(int num) {
        if (num < 0) return false;
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}
