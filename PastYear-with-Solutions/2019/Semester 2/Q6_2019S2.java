import java.util.Scanner;

public class Q6_2019S2 {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

        // Input for Order object
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.print("Enter customer id: ");
        String customerID = scanner.nextLine();
        System.out.print("Enter quantity ordered: ");
        int quantityOrdered = scanner.nextInt();
        System.out.print("Enter price per unit: ");
        double unitPrice = scanner.nextDouble();

        // Create Order object
        Order order = new Order(customerName, customerID, quantityOrdered, unitPrice);
        System.out.println("\n" + order.toString());

        // Input for ShippeoOrder object
        scanner.nextLine(); // Consume the leftover newline
        System.out.print("\nEnter customer name for shipped order: ");
        String shippedCustomerName = scanner.nextLine();
        System.out.print("Enter customer id for shipped order: ");
        String shippedCustomerID = scanner.nextLine();
        System.out.print("Enter quantity ordered for shipped order: ");
        int shippedQuantityOrdered = scanner.nextInt();
        System.out.print("Enter price per unit for shipped order: ");
        double shippedUnitPrice = scanner.nextDouble();

        // Create ShippeoOrder object
        ShippeoOrder shippedOrder = new ShippeoOrder(shippedCustomerName, shippedCustomerID, shippedQuantityOrdered, shippedUnitPrice);
        System.out.println("\n" + shippedOrder.toString());

        scanner.close();
     
    }
}

class Order {
    private String customerName;
    private String customerID;
    private int quantityOrdered;
    private double unitPrice;

    // No-argument constructor with default values
    public Order() {
        this.customerName = "Unknown";
        this.customerID = "Unknown";
        this.quantityOrdered = 0;
        this.unitPrice = 0.0;
    }

    // Parameterized constructor
    public Order(String customerName, String customerID, int quantityOrdered, double unitPrice) {
        this.customerName = customerName;
        this.customerID = customerID;
        this.quantityOrdered = quantityOrdered;
        this.unitPrice = unitPrice;
    }

    // Accessor methods
    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerID() {
        return customerID;
    }

    public int getQuantityOrdered() {
        return quantityOrdered;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    // Mutator methods
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setQuantityOrdered(int quantityOrdered) {
        this.quantityOrdered = quantityOrdered;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    // Compute total price
    public double computeTotalPrice() {
        return quantityOrdered * unitPrice;
    }

    // Override toString() method
    @Override
    public String toString() {
        return "Order Details:\n" +
               "Customer Name: " + customerName + "\n" +
               "Customer ID: " + customerID + "\n" +
               "Quantity Ordered: " + quantityOrdered + "\n" +
               "Unit Price: $" + unitPrice + "\n" +
               "Total Price: $" + computeTotalPrice();
    }
}

// ShippeoOrder subclass
class ShippeoOrder extends Order {
    private static final double SHIPPING_CHARGE = 4.00;

    // No-argument constructor
    public ShippeoOrder() {
        super();
    }

    // Parameterized constructor
    public ShippeoOrder(String customerName, String customerID, int quantityOrdered, double unitPrice) {
        super(customerName, customerID, quantityOrdered, unitPrice);
    }

    // Override computeTotalPrice() to include shipping charge
    @Override
    public double computeTotalPrice() {
        return super.computeTotalPrice() + SHIPPING_CHARGE;
    }

    // Override toString() method
    @Override
    public String toString() {
        return "ShippeoOrder Details:\n" +
               "Customer Name: " + getCustomerName() + "\n" +
               "Customer ID: " + getCustomerID() + "\n" +
               "Quantity Ordered: " + getQuantityOrdered() + "\n" +
               "Unit Price: $" + getUnitPrice() + "\n" +
               "Shipping Charge: $" + SHIPPING_CHARGE + "\n" +
               "Total Price (including shipping): $" + computeTotalPrice();
    }
}
