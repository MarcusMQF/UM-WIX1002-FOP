import java.util.Scanner;

public class Q2_2019S2 {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of bags sold: ");
        int numberOfBags = scanner.nextInt();
        
        System.out.print("Enter the weight per bag (kilogram): ");
        double weight = scanner.nextInt();
        
        double totalPrice = weight * numberOfBags * 5.99;
        double totalPriceWithTax = totalPrice + (totalPrice*0.0725);
        
        System.out.println("\nPrice per kilogram: $5.99");
        System.out.println("Sales tax:          7.25%");
        System.out.println("Total price:        $" + String.format("%.2f", totalPriceWithTax));
        
        scanner.close();
    }
}
