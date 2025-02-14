/*
// Define the PaySystem class
class PaySystem {
    protected double payRate; // Pay rate per hour
    protected double hours;   // Number of hours worked

    // Constructor to initialize instance variables
    public PaySystem(double payRate, double hours) {
        this.payRate = payRate;
        this.hours = hours;
    }

    // Method to calculate total pay
    public double calculateTotalPay() {
        return payRate * hours;
    }

    // Method to display total payment
    public void displayTotalPayment() {
        System.out.println("Total Payment: " + calculateTotalPay());
    }
}

// Define the RegularPay class (inherits from PaySystem)
class RegularPay extends PaySystem {
    // Constructor
    public RegularPay(double payRate, double hours) {
        super(payRate, hours); // Call the superclass constructor
    }
}

// Define the SpecialPay class (inherits from PaySystem)
class SpecialPay extends PaySystem {
    // Constructor
    public SpecialPay(double payRate, double hours) {
        super(payRate, hours); // Call the superclass constructor
    }

    // Override the calculateTotalPay method to include 30% commission
    @Override
    public double calculateTotalPay() {
        return super.calculateTotalPay() * 1.30; // Add 30% commission
    }
}
*/
