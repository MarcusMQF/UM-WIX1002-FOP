import java.util.Scanner; 

public class Q2_2017S1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the initial tuition fee (i.e year 1): ");
        int initialFee = scanner.nextInt();

        System.out.print("Enter the yearly rate of increment (e.g enter 5.2 for 5.2 %): ");
        double rate = scanner.nextDouble();

        System.out.print("Enter the year for which you wish to compute the tuition fee for: ");
        int year = scanner.nextInt();

        double computedFee = computeFee(initialFee, rate, year);

        System.out.println();
        System.out.println("Computed tuition fee for year " + year + " is: " + String.format("%.2f", computedFee));

        scanner.close();
    }

    public static double computeFee(int initialFee, double rate, int year) {
        double computedFee = initialFee;

        for(int i = 1; i < year; i++) {
            computedFee += computedFee * (rate / 100);
        }
        return computedFee;
    }
}
