import java.text.DecimalFormat;
import java.util.Scanner;

public class L4Q7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Principal, Yearly Interest Rate, Total Number of Months
        System.out.print("Enter Principal Amount: ");
        double principal = scanner.nextDouble();

        System.out.print("Enter Yearly Interest Rate in %: ");
        double yearlyInterestRate = scanner.nextDouble();

        System.out.print("Enter Total Number of Months: ");
        int totalMonths = scanner.nextInt();

        // Calculate Monthly Payment (M)
        double monthlyInterestRate = yearlyInterestRate / (12 * 100);
        double monthlyPayment = (principal * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -totalMonths));

        // Print Monthly Payment
        DecimalFormat df = new DecimalFormat("0.00"); // Ensure two decimal places, including zero

        // Generate Amortization Table
        System.out.println("\nMonth\tMonthly Payment\tPrincipal\tInterest\tUnpaid Balance\tTotal Interest");

        double remainingPrincipal = principal;
        double totalInterestPaid = 0;

        for (int month = 1; month <= totalMonths; month++) {
            // Calculate Interest Due (L)
            double interestDue = remainingPrincipal * monthlyInterestRate;

            // Calculate Principal Portion Due (C)
            double principalDue = monthlyPayment - interestDue;

            // Update Remaining Principal Balance (R)
            remainingPrincipal -= principalDue;

            // Update Total Interest Paid
            totalInterestPaid += interestDue;

            // Print the row
            System.out.println(month + "\t" + df.format(monthlyPayment) + "\t\t" + df.format(principalDue) + "\t\t" + df.format(interestDue) + "\t\t" + df.format(remainingPrincipal) + "\t\t" + df.format(totalInterestPaid));
        }

        scanner.close();
    }
}