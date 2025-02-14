import java.util.Scanner;
import java.util.Random;

public class L5Q3 {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter N Employee: ");
        int n = scanner.nextInt();

        for(int i = 1; i <= n; i++) {
            System.out.println("\nEmployee " + i + ": ");
            int[] hours = WorksHours();
        }

        scanner.close();
    }

    public static int[] WorksHours() {
        Random random = new Random();
        int[] hours = new int[7];
        int sum = 0;

        System.out.println("Working hours for each day: ");
        for (int i = 0; i < 7; i++) {
            hours[i] = random.nextInt(8) + 1;
            System.out.println("Day " + (i + 1) + ": " + hours[i]);
            sum += hours[i];
        }
        System.out.println("Total hours: " + sum);

        return hours;
    }
}
