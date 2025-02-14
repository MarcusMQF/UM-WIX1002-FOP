public class T10Q2 {
    public static void main(String[] args) {
        // Create accounts with different balances
        SavingAccount savings1 = new SavingAccount(10000);
        SavingAccount savings2 = new SavingAccount(50000);
        FixedAccount fixed1 = new FixedAccount(10000);
        FixedAccount fixed2 = new FixedAccount(50000);
        
        // Test and display results
        System.out.println("Monthly Interest Calculations:");
        System.out.println("-----------------------------------------");
        
        System.out.printf("Savings Account 1 (Balance: $%.2f)%n", savings1.getBalance());
        System.out.printf("Monthly Interest: $%.2f%n%n", savings1.computeInterest());
        
        System.out.printf("Savings Account 2 (Balance: $%.2f)%n", savings2.getBalance());
        System.out.printf("Monthly Interest: $%.2f%n%n", savings2.computeInterest());
        
        System.out.printf("Fixed Account 1 (Balance: $%.2f)%n", fixed1.getBalance());
        System.out.printf("Monthly Interest: $%.2f%n%n", fixed1.computeInterest());
        
        System.out.printf("Fixed Account 2 (Balance: $%.2f)%n", fixed2.getBalance());
        System.out.printf("Monthly Interest: $%.2f%n", fixed2.computeInterest());
    }
}

interface Interest {
    double computeInterest();
}

class SavingAccount implements Interest {
    private double balance;
    private static final double ANNUAL_INTEREST_RATE = 0.005; // 0.5%
    
    public SavingAccount(double balance) {
        this.balance = balance;
    }
    
    @Override
    public double computeInterest() {
        return (balance * ANNUAL_INTEREST_RATE) / 12; // Monthly interest
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
}

class FixedAccount implements Interest {
    private double balance;
    private static final double ANNUAL_INTEREST_RATE = 0.03; // 3%
    
    public FixedAccount(double balance) {
        this.balance = balance;
    }
    
    @Override
    public double computeInterest() {
        return (balance * ANNUAL_INTEREST_RATE) / 12; // Monthly interest
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
