import java.util.Scanner;

public class L6Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 

        System.out.println("Enter a number of copy: ");
        int n = scanner.nextInt();

        System.out.println("Enter a character to copy: ");
        char c = scanner.next().charAt(0);

        multiPrint(n, c);

        scanner.close();
    }

    public static void multiPrint(int n, char c) {
        // Print Triangle
        System.out.println("\nTriangle Pattern:");
        for(int i = 1; i <= n; i++) {
            // Print spaces
            for(int j = n-i; j > 0; j--) {
                System.out.print(" ");
            }
            // Print characters
            for(int k = 1; k <= (2*i-1); k++) {
                System.out.print(c);
            }
            System.out.println();
        }

        // Print Diamond
        System.out.println("\nDiamond Pattern:");
        // Upper half of diamond
        for(int i = 1; i <= n; i++) {
            // Print spaces
            for(int j = n-i; j > 0; j--) {
                System.out.print(" ");
            }
            // Print characters
            for(int k = 1; k <= (2*i-1); k++) {
                System.out.print(c);
            }
            System.out.println();
        }
        // Lower half of diamond
        for(int i = n-1; i >= 1; i--) {
            // Print spaces
            for(int j = n-i; j > 0; j--) {
                System.out.print(" ");
            }
            // Print characters
            for(int k = 1; k <= (2*i-1); k++) {
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
