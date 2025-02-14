public class Q5_2018S1 {
    public static void main(String[] args) {
        Apple redApple = new Apple("Red", 8);
        Apple greenApple = new Apple("Green", 11);
        Watermelon localWatermelon = new Watermelon("Local", 7.6);
        Watermelon importedWatermelon = new Watermelon("Imported", 4.0);
        
        Fruit[] fruits = {redApple, greenApple, localWatermelon, importedWatermelon};
        
        Fruit cheapest = fruits[0];
        for(Fruit fruit : fruits) {
            System.out.println(fruit.toString());
            if(fruit.totalPrice() < cheapest.totalPrice()) {
                cheapest = fruit;
            }
        }
        
        System.out.println("The cheapest item is");
        System.out.println(cheapest.toString());
    }
}

abstract class Fruit {
    private String name;
    private String type;
    
    public Fruit(String name, String type) {
        this.name = name;
        this.type = type;
    }
    
    public String getName() {
        return name;
    }
    
    public String getType() {
        return type;
    }
    
    public abstract double totalPrice();
    
    public String toString() {
        return type + " " + name;
    }
}

class Apple extends Fruit {
    private int quantity;
    
    public Apple(String type, int quantity) {
        super("Apple", type);
        this.quantity = quantity;
    }
    
    public double totalPrice() {
        if(getType().equals("Red")) {
            return quantity * 1.80;
        } else {
            return quantity * 1.20;
        }
    }
    
    public String toString() {
        return super.toString() + " - " + quantity + " = RM " + String.format("%.2f", totalPrice());
    }
}

class Watermelon extends Fruit {
    private double weight;
    
    public Watermelon(String type, double weight) {
        super("Watermelon", type);
        this.weight = weight;
    }
    
    public double totalPrice() {
        double pricePerKg;
        if(getType().equals("Local")) {
            if(weight < 2) pricePerKg = 2.25;
            else if(weight <= 5) pricePerKg = 1.95;
            else pricePerKg = 1.65;
        } else {
            if(weight < 2) pricePerKg = 3.75;
            else if(weight <= 5) pricePerKg = 3.45;
            else pricePerKg = 3.15;
        }
        return weight * pricePerKg;
    }
    
    public String toString() {
        return super.toString() + " - " + weight + "kg = RM " + String.format("%.2f", totalPrice());
    }
}



