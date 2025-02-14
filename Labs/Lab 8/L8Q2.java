public class L8Q2 {
    public static void main(String[] args) {
        try {
            // Create a new account
            BankAccount account = new BankAccount("John Doe", "A12345678", 1000.0);
            
            // Display initial account info
            account.displayInfo();
            
            // Test deposit
            System.out.println("\nMaking a deposit...");
            account.deposit(500.0);
            
            // Test withdrawal
            System.out.println("\nMaking a withdrawal...");
            account.withdraw(200.0);
            
            // Test invalid operations
            System.out.println("\nTesting invalid operations:");
            System.out.println("Attempting to withdraw more than balance...");
            account.withdraw(2000.0);
            
            System.out.println("\nAttempting to deposit negative amount...");
            account.deposit(-100.0);
            
            // Final account status
            account.displayInfo();
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

class BankAccount {
    private String name;
    private String idNumber;  // IC or passport number
    private double balance;
    
    // Constructor
    public BankAccount(String name, String idNumber, double initialDeposit) {
        if (initialDeposit < 0) {
            throw new IllegalArgumentException("Initial deposit cannot be negative");
        }
        this.name = name;
        this.idNumber = idNumber;
        this.balance = initialDeposit;
    }
    
    // Deposit method
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit amount must be positive");
            return;
        }
        balance += amount;
        System.out.printf("Deposited: $%.2f\n", amount);
        displayBalance();
    }
    
    // Withdraw method
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive");
            return;
        }
        if (amount > balance) {
            System.out.println("Insufficient funds");
            return;
        }
        balance -= amount;
        System.out.printf("Withdrawn: $%.2f\n", amount);
        displayBalance();
    }
    
    // Display balance
    public void displayBalance() {
        System.out.printf("Current balance: $%.2f\n", balance);
    }
    
    // Display account info
    public void displayInfo() {
        System.out.println("\nAccount Information:");
        System.out.println("Name: " + name);
        System.out.println("ID Number: " + idNumber);
        displayBalance();
    }
}
