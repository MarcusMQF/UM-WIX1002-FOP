public class L8Q6 {
    public static void main(String[] args) {
        // Create three burger stalls
        BurgerStall stall1 = new BurgerStall(101);
        BurgerStall stall2 = new BurgerStall(102);
        BurgerStall stall3 = new BurgerStall(103);

        // Simulate burger sales
        stall1.sold(50);
        stall2.sold(30);
        stall3.sold(40);
        stall1.sold(20); // Additional sales for stall 1
        stall3.sold(10); // Additional sales for stall 3

        // Display sales data
        stall1.display();
        stall2.display();
        stall3.display();

        // Display total burgers sold across all stalls
        System.out.println("Total Burgers Sold in All Stalls: " + BurgerStall.getTotalBurgersSold());
    }
}

class BurgerStall {
    private int stallID;
    private int burgersSold;
    private static int totalBurgersSold = 0; // Shared among all instances

    // Constructor
    public BurgerStall(int id) {
        this.stallID = id;
        this.burgersSold = 0;
    }

    // Method to record burger sales
    public void sold(int n) {
        if (n > 0) {
            burgersSold += n;
            totalBurgersSold += n;
        }
    }

    // Display burger sales for this stall
    public void display() {
        System.out.println("Stall ID: " + stallID + " | Burgers Sold: " + burgersSold);
    }

    // Static method to get total burgers sold across all stalls
    public static int getTotalBurgersSold() {
        return totalBurgersSold;
    }
}

