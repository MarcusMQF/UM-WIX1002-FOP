class Creature {
    String species, habitat;
    double magicPower;

    Creature(String species, String habitat, double magicPower){
        this.species = species;
        this.habitat = habitat;
        this.magicPower = magicPower;
    }

    void feed(double foodAmount){
        magicPower += foodAmount;
        System.out.println(species + "'s magic power increased to " + magicPower + ".");
    }

    void displayInfo(){
        System.out.println("Species: " + species);
        System.out.println("Magic Power: " + magicPower);
        System.out.println("Habitat: " + habitat);
    }
}

class Zoo {

    private Creature[] creatures;
    private int currentSize;
    private int maxSize;

    Zoo(int maxSize) {
        this.maxSize = maxSize;
        this.creatures = new Creature[maxSize];
        this.currentSize = 0;
    }

    // Add new creature to the zoo
    String addCreature(String species, double magicPower, String habitat) {
        if (currentSize >= maxSize) {
            return "Zoo is full! Cannot add more creatures.";
        }
        
        creatures[currentSize] = new Creature(species, habitat, magicPower);
        currentSize++;
        return species + " added to the zoo.";
    }

    // Feed a specific creature
    void feedCreature(String species, double foodAmount) {
        for (int i = 0; i < currentSize; i++) {
            if (creatures[i].species.equals(species)) {
                creatures[i].feed(foodAmount);
                return;
            }
        }
    }

    // Display all creatures in the zoo
    void displayAllCreatures() {
        for (int i = 0; i < currentSize; i++) {
            creatures[i].displayInfo();
            System.out.println(); // Add blank line between creatures
        }
    }


}

public class viva3Q2 {
    public static void main(String[] args) {
        Zoo myZoo = new Zoo(3);

        // Add creatures to the zoo
        System.out.println(myZoo.addCreature("Panda", 150.0, "Mountains"));
        System.out.println(myZoo.addCreature("Dragon", 300.0, "Cave"));
        System.out.println(myZoo.addCreature("Master Oogway", 200.0, "Forest"));

        // Try adding one more creature to the full zoo
        System.out.println(myZoo.addCreature("Patrick Star", 250.0, "Rock"));

        // Display all creatures in the zoo
        myZoo.displayAllCreatures();

        // Feed the Dragon
        myZoo.feedCreature("Dragon", 50.0);

        // Display updated creature details
        myZoo.displayAllCreatures();
    }
}
