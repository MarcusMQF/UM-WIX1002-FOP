public class Q4_2019S2 {
    public static void main(String[] args) {
        Pizza pizza1 = new Pizza("Large", 0, 0, 0);
        pizza1.display();
    }
}

class Pizza{
    private String size;
    private int numOfCheeseTopping;
    private int numOfBeefTopping;
    private int numOfChickenTopping;
    
    public Pizza(String size, int numOfCheeseTopping, int numOfBeefTopping, int numOfChickenTopping){
        validateSize(size); 
        
        this.size = size;
        this.numOfCheeseTopping = numOfCheeseTopping;
        this.numOfBeefTopping = numOfBeefTopping;
        this.numOfBeefTopping = numOfChickenTopping;
    }
    
    public String getSize(){
        return size;
    }
    
    public int getNumOfCheeseTopping(){
        return numOfCheeseTopping;
    }
    
    public int getNumOfBeefTopping(){
        return numOfBeefTopping;
    }
    
    public int getNumOfChickenTopping(){
        return numOfChickenTopping;
    }
    
    // Validate pizza size
    private void validateSize(String size) {
        if (!size.equalsIgnoreCase("small") && !size.equalsIgnoreCase("medium") && !size.equalsIgnoreCase("large")) {
            System.out.println("Error: Invalid pizza size. Must be Small, Medium, or Large.");
            throw new IllegalArgumentException("Invalid pizza size. Must be Small, Medium, or Large.");
        }
    }
    
    public double ComputeCost(String size, int numOfCheeseTopping, int numOfBeefTopping, int numOfChickenTopping){
        double costPerSize = 0;
        
        double totalTopping = numOfCheeseTopping + numOfChickenTopping + numOfBeefTopping;
        double totalCostTopping = totalTopping * 2;
        
        if(size.equalsIgnoreCase("large")){
            costPerSize = 14; 
        }else if(size.equalsIgnoreCase("small")){
            costPerSize = 10;
        }else if(size.equalsIgnoreCase("medium")){
            costPerSize = 12;
        }
        return costPerSize + totalCostTopping;
    }
    
    public void display(){
        System.out.println("The size of Pizza: " + size);
        System.out.println("Quantity of Cheese Topping: " + numOfCheeseTopping);
        System.out.println("Quantity of Beef Topping: " + numOfBeefTopping);
        System.out.println("Quantity of Chicken Topping: " + numOfChickenTopping);
        double totalCost = ComputeCost(size, numOfCheeseTopping, numOfBeefTopping, numOfChickenTopping);
        System.out.println("Total Cost: RM" + String.format("%.2f", totalCost));
    }
}
