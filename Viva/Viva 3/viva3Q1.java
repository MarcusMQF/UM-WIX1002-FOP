class Potion{
    String ingredient;
    double volume;

    Potion(String ingredient, double volume){
        this.ingredient = ingredient;
        this.volume = volume;
    }

    void calculateConsumeIngredient(){
        System.out.println(volume + " ml of " + ingredient + " added to the container.");
    }
}

class PotionContainer {

    private double unicornTearsVolume = 0;
    private double dragonBloodVolume = 0;

    void addPotion(String ingredient, double volume){
        if(ingredient.equals("Unicorn Tears")){
            unicornTearsVolume += volume;
        } else if(ingredient.equals("Dragon Blood")){
            dragonBloodVolume += volume;
        }
    }

    void usePotion(String ingredient, double volume){
        if (ingredient.equals("Unicorn Tears")) {
            if (unicornTearsVolume >= volume) {
                unicornTearsVolume -= volume;
                System.out.println(volume + " ml of " + ingredient + " used.");
            } else {
                System.out.println("Not enough " + ingredient + " available.");
            }
        } else if (ingredient.equals("Dragon Blood")) {
            if (dragonBloodVolume >= volume) {
                dragonBloodVolume -= volume;
                System.out.println(volume + " ml of " + ingredient + " used.");
            } else {
                System.out.println("Not enough " + ingredient + " available.");
            }
        }
    }

    double getRemainingVolume(String ingredient){
        if (ingredient.equals("Unicorn Tears")) {
            return unicornTearsVolume;
        } else if (ingredient.equals("Dragon Blood")) {
            return dragonBloodVolume;
        }
        return 0.0;
    }

    boolean isEnoughForPotion(double requiredUnicornTears, double requiredDragonBlood) {
        return this.unicornTearsVolume >= requiredUnicornTears && 
               this.dragonBloodVolume >= requiredDragonBlood;
    }
}

public class viva3Q1 {
    public static void main(String[] args) {
        PotionContainer container = new PotionContainer();

        System.out.println("Adding potions to the container...");

        Potion unicornTears = new Potion("Unicorn Tears", 200.0);
        Potion dragonBlood = new Potion("Dragon Blood", 150.0);
        
        unicornTears.calculateConsumeIngredient();
        dragonBlood.calculateConsumeIngredient();
        
        container.addPotion("Unicorn Tears", 200.0);
        container.addPotion("Dragon Blood", 150.0);
        System.out.println("Potion container successfully initialized.\n");

        System.out.println("=== Using Potions ===");
        container.usePotion("Unicorn Tears", 50.0);
        System.out.println("Remaining volume of Unicorn Tears: " + 
        container.getRemainingVolume("Unicorn Tears") + " ml");

        container.usePotion("Dragon Blood", 30.0);  
        System.out.println("Remaining volume of Dragon Blood: " +   
        container.getRemainingVolume("Dragon Blood") + " ml");  

        System.out.println("\nAttempting to use more Dragon Blood than available...");  
        container.usePotion("Dragon Blood", 200.0);   
        System.out.println("Remaining volume of  Dragon Blood: " +  
        container.getRemainingVolume("Dragon Blood") + " ml"); 

        System.out.println("\n=== Checking Potion Availability for Invisibility Draught ===");  
        double requiredUnicornTears = 200.0;  
        double requiredDragonBlood = 150.0;  
        boolean readyForInvisibilityDraught =   
        container.isEnoughForPotion(requiredUnicornTears, requiredDragonBlood);  
  
        System.out.println("\nCan prepare Invisibility Draught?");  
        if (readyForInvisibilityDraught) {  
            System.out.println("Yes, we have enough Unicorn Tears and Dragon Blood!");  
        } else {  
            System.out.println("No, we do not have enough ingredients to prepare the Invisibility Draught."); 
        }

        System.out.println("\nFinal state of the potion container:");

        System.out.println("\n--- Potion Inventory ---");
        System.out.println("Unicorn Tears: " + container.getRemainingVolume("Unicorn Tears") + " ml");
        System.out.println("Dragon Blood: " + container.getRemainingVolume("Dragon Blood") + " ml");
    }
}
