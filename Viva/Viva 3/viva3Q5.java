import java.util.ArrayList;

class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String accountHolderName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialDeposit;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Depositing $" + amount + " into account " + accountNumber + "...");
            System.out.println("New balance: $" + balance);
        }
    }

    // Withdraw method
    public boolean withdraw(double amount) {
        if (amount <= balance && amount > 0) {
            balance -= amount;
            System.out.println("Withdrawing $" + amount + " from account " + accountNumber + "...");
            System.out.println("New balance: $" + balance);
            return true;
        }
        return false;
    }

    // Accessors
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }
}

class Customer {
    private String name;
    private String customerId;
    private ArrayList<BankAccount> accounts;

    // Constructor
    public Customer(String name, String customerId) {
        this.name = name;
        this.customerId = customerId;
        this.accounts = new ArrayList<>();
    }

    // Add account method
    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    // Get account by number
    public BankAccount getAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    // Accessors
    public String getName() {
        return name;
    }

    public String getCustomerId() {
        return customerId;
    }

    // Display all accounts
    public void displayAccounts() {
        for (BankAccount account : accounts) {
            System.out.println("Account Number: " + account.getAccountNumber() + 
                             ", Balance: $" + account.getBalance());
        }
    }
}

class Bank {
    private String bankName;
    private ArrayList<Customer> customers;

    // Constructor
    public Bank(String bankName) {
        this.bankName = bankName;
        this.customers = new ArrayList<>();
    }

    // Add customer
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    // Get customer by ID
    public Customer getCustomer(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        return null;
    }

    // Display all customers
    public void displayAllCustomers() {
        System.out.println("Displaying all customers of " + bankName + ":");
        for (Customer customer : customers) {
            System.out.println("Customer: " + customer.getName() + 
                             ", ID: " + customer.getCustomerId());
        }
    }
}

public class viva3Q5 {
    public static void main(String[] args) {
        // Create a new bank
        Bank simpleBank = new Bank("SimpleBank");
        System.out.println("Welcome to SimpleBank!");

        // Create a new customer
        Customer johnDoe = new Customer("John Doe", "C001");
        System.out.println("Creating a new customer: John Doe (ID: C001)");

        // Create a bank account for the customer
        BankAccount savingsAccount = new BankAccount("A1001", "John Doe", 500.0);
        System.out.println("Adding a savings account for John Doe with account number " +
                         "A1001 and an initial deposit of $500.");

        // Add account to customer
        johnDoe.addAccount(savingsAccount);

        // Add customer to bank
        simpleBank.addCustomer(johnDoe);

        // Perform some transactions
        savingsAccount.deposit(200.0);
        savingsAccount.withdraw(100.0);

        // Display customer's accounts
        System.out.println("Displaying all accounts for customer John Doe:");
        johnDoe.displayAccounts();

        // Display all customers
        simpleBank.displayAllCustomers();
    }
}
