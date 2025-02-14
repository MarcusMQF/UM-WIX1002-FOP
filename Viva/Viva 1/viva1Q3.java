import java.util.Scanner;

public class viva1Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        boolean isPrime = true;
        int count = 0;
        int factorSum = 0;
        long product = 1L;

        while (true) {
            System.out.print("Enter a positive number greater than 1: ");
            num = scanner.nextInt();

            if (num > 1) {
                break;
            } else {
                System.out.println("The input should be a positive integer greater than 1.");
            }
        }

        // Count factors first
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }

        // Check if number is prime
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }

        if (isPrime) {
            System.out.println(num + " is a prime number.");
        } else {
            // Print factor count first
            System.out.println(num + " is not a prime number, it has " + count + " factors");
            
            // Then print the factors
            System.out.print("The factors of this integer are: ");
            boolean firstFactor = true;
            for (int i = 1; i <= num; i++) {
                if (num % i == 0) {
                    if (!firstFactor) {
                        System.out.print(", ");
                    }
                    System.out.print(i);
                    firstFactor = false;
                    factorSum += i;
                    
                    // Check if multiplication will exceed Long.MAX_VALUE
                    if (product != 0 && i != 0 && product > Integer.MAX_VALUE / i) {
                        product = 0; // Use 0 to indicate overflow
                    } else {
                        product *= i;
                    }
                }
            }
            System.out.println();

            System.out.println("The sum of the factors is " + factorSum);
            
            if (product > Integer.MAX_VALUE || product == 0) {
                System.out.println("The product of the factors is too large to display");
            } else {
                System.out.println("The product of the factors is " + product);
            }

            // Check if perfect number
            if (factorSum - num == num) {
                System.out.println(num + " is a perfect number.");
            } else {
                System.out.println(num + " is not a perfect number.");
            }

            // Print prime numbers between 2 and num
            System.out.print("Prime numbers between 2 and " + num + ": ");
            boolean firstPrime = true;
            for (int i = 2; i <= num; i++) {
                boolean currentIsPrime = true;
                for (int j = 2; j <= Math.sqrt(i); j++) {
                    if (i % j == 0) {
                        currentIsPrime = false;
                        break;
                    }
                }
                if (currentIsPrime) {
                    if (!firstPrime) {
                        System.out.print(", ");
                    }
                    System.out.print(i);
                    firstPrime = false;
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
