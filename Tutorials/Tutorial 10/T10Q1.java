public class T10Q1 {
    public static void main(String[] args) {
        // Create discount policies
        BulkDiscount bulkDiscount = new BulkDiscount(5, 0.15);
        OtherDiscount otherDiscount = new OtherDiscount();
        CombineDiscount combineDiscount = new CombineDiscount(bulkDiscount, otherDiscount);
        
        // Test cases
        int[] quantities = {1, 4, 7, 10};
        double itemCost = 100.0;
        
        System.out.println("Testing different discount policies:");
        System.out.println("Item cost: $" + itemCost);
        
        for (int quantity : quantities) {
            System.out.println("\nQuantity: " + quantity);
            System.out.printf("Bulk Discount: $%.2f%n", 
                bulkDiscount.computeDiscount(quantity, itemCost));
            System.out.printf("Other Discount: $%.2f%n", 
                otherDiscount.computeDiscount(quantity, itemCost));
            System.out.printf("Combined Discount (Max): $%.2f%n", 
                combineDiscount.computeDiscount(quantity, itemCost));
        }
    }
}

abstract class DiscountPolicy {
    public abstract double computeDiscount(int count, double itemCost);
}

class BulkDiscount extends DiscountPolicy {
    private int minimum;
    private double discountRate;
    
    public BulkDiscount(int minimum, double discountRate) {
        this.minimum = minimum;
        this.discountRate = discountRate;
    }
    
    @Override
    public double computeDiscount(int count, double itemCost) {
        if (count >= minimum) {
            return count * itemCost * discountRate;
        }
        return 0;
    }
}

class OtherDiscount extends DiscountPolicy {
    @Override
    public double computeDiscount(int count, double itemCost) {
        double discountRate;
        
        if (count <= 2) {
            discountRate = 0;
        } else if (count <= 5) {
            discountRate = 0.10;
        } else if (count <= 8) {
            discountRate = 0.20;
        } else {
            discountRate = 0.30;
        }
        
        return count * itemCost * discountRate;
    }
}

class CombineDiscount extends DiscountPolicy {
    private DiscountPolicy policy1;
    private DiscountPolicy policy2;
    
    public CombineDiscount(DiscountPolicy policy1, DiscountPolicy policy2) {
        this.policy1 = policy1;
        this.policy2 = policy2;
    }
    
    @Override
    public double computeDiscount(int count, double itemCost) {
        double discount1 = policy1.computeDiscount(count, itemCost);
        double discount2 = policy2.computeDiscount(count, itemCost);
        return Math.max(discount1, discount2);
    }
}
