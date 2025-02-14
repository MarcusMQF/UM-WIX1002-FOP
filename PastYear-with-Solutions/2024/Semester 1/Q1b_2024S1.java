import java.util.Scanner;

public class Q1b_2024S1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int n = scanner.nextInt();

        double sum = 0;

        for(int i = 1; i <= n; i++){
            sum += 1.0/i;
        }

        System.out.println("Sum: " + sum);

        scanner.close();
    }
}
