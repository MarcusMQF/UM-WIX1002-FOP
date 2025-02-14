import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class viva2Q1 {
    private static Scanner scanner = new Scanner(System.in);
    private static double balance = 0.0;
    private static List<String> transactionHistory = new ArrayList<>();
    public static void main(String[] args) { 
        int choice = 0;
        System.out.println("Welcome to the Bank!");

        do{
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch(choice){
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    viewTransactionHistory();
                    break;
                case 5:
                    System.out.println();
                    System.out.println("Thank you for using the Bank!");
                    System.out.println("Your final balance is: RM " + String.format("%.2f", balance));
                    break;
                default:
                    System.out.println("\u001B[31mInvalid choice!\u001B[0m");
            }
            System.out.println();
            if (choice != 5) {
                System.out.print("\u001B[32m[Press Enter to Continue]\u001B[0m");
                scanner.nextLine(); // Wait for the user to press Enter
            }
            System.out.println();
        }while(choice != 5);

        scanner.close();
    }

    public static void checkBalance() {
        System.out.println("Current Balance: RM " + String.format("%.2f", balance));
    }

    public static void deposit(){
        System.out.print("Enter amount to deposit: RM ");
        double amount = scanner.nextDouble();
        balance += amount;
        scanner.nextLine(); // Consume the newline character
        transactionHistory.add("Deposited: RM " + String.format("%.2f", amount));
        System.out.println("Your balance is now: RM " + String.format("%.2f", balance));
    }

    public static void withdraw(){
        System.out.print("Enter amount to withdraw: RM ");
        double amount = scanner.nextDouble();
        if(amount <= balance){
            balance -= amount;
            scanner.nextLine(); // Consume the newline character
            System.out.println("Your balance is now: RM " + String.format("%.2f", balance));
            transactionHistory.add("Withdrew: RM " + String.format("%.2f", amount));
        } else {
            System.out.println("\u001B[31mInsufficient funds!\u001B[0m");
            scanner.nextLine(); // Wait for the user to press Enter
        }
    }

    public static void viewTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            System.out.println("Transaction History:");
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }
}