import java.util.Scanner;

public class Q2_2018S2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of bags sold: ");
        int bags = scanner.nextInt();

        System.out.print("Enter the weight per bag (kilogram): ");
        double weight = scanner.nextDouble();

        double price = totalPriceTax(bags, weight);

        System.out.println();
        System.out.println("Price per kilogram: $5.99");
        System.out.println("Sales tax: 7.25%");
        System.out.println("Total price after tax: $" + price);

        scanner.close();
    }

    public static double totalPriceTax(int bags, double weight) {
        double price = 5.99;
        double tax = 7.25;

        double totalPrice = bags * weight * price * (1 + tax / 100);
        double totalPriceTax = totalPrice + totalPrice * 0.0725;

        return totalPriceTax;
    }
}
