/*
// Define the PurchaseSystem class
class PurchaseSystem {
    protected String productCode; // Product code
    protected double unitPrice;   // Unit price of the product
    protected int quantity;       // Quantity of the product
    protected double totalPrice;  // Total price of the purchase

    // Constructor to initialize instance variables
    public PurchaseSystem(String productCode, double unitPrice, int quantity) {
        this.productCode = productCode;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        computeTotalPrice(); // Calculate total price
    }

    // Method to compute total price
    public void computeTotalPrice() {
        totalPrice = unitPrice * quantity;
    }

    // Method to display purchase details
    public void display() {
        System.out.println("Product Code: " + productCode);
        System.out.println("Unit Price: " + unitPrice);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Price: " + totalPrice);
    }
}

// Define the SugarPurchase class (inherits from PurchaseSystem)
class SugarPurchase extends PurchaseSystem {
    private double sugarWeight; // Sugar weight attribute

    // Constructor to initialize instance variables
    public SugarPurchase(String productCode, double unitPrice, int quantity, double sugarWeight) {
        super(productCode, unitPrice, quantity); // Call the superclass constructor
        this.sugarWeight = sugarWeight;
        computeTotalPrice(); // Recalculate total price with sugar weight
    }

    // Override the computeTotalPrice method to include sugar weight
    @Override
    public void computeTotalPrice() {
        totalPrice = unitPrice * quantity * sugarWeight;
    }
}
*/
