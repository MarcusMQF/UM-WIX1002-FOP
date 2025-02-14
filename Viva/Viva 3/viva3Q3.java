class Pet {
    String name, species, healthRecord, adopterName, breed;
    int age;
    boolean isAdopted;

    Pet(String name, String species, String breed,  int age, String healthRecord) {
        this.name = name;
        this.species = species;
        this.healthRecord = healthRecord;
        this.age = age;
        this.breed = breed;
        this.isAdopted = false;
    }

    void adopt(String adopterName){
        this.isAdopted = true;
        this.adopterName = adopterName;
    }

    void getDetails(){
        System.out.println("PetName: " + name);
        System.out.println("Species: " + species);
        System.out.println("Breed: " + breed);
        System.out.println("Age: " + age);
        System.out.println("HealthRecord: " + healthRecord);
        System.out.println("Adopted: " + (isAdopted ? "adopted" : "not adopted"));
        System.out.println("AdopterName: " + (adopterName == null ? "null" : adopterName));
        System.out.println();
    }
}

class Adopter {
    String name, preferredSpecies, preferredAgeName;

    Adopter(String name, String preferredSpecies, String preferredAgeName) {
        this.name = name;
        this.preferredSpecies = preferredSpecies;
        this.preferredAgeName = preferredAgeName;
    }

    void viewMatchingPets(PetAdoptionCentre centre){
        for (Pet pet : centre.pets) {
            if (pet != null && !pet.isAdopted && pet.species.equals(preferredSpecies)) {
                // Parse age range
                String[] ageRange = preferredAgeName.split("-");
                int minAge = Integer.parseInt(ageRange[0]);
                int maxAge = Integer.parseInt(ageRange[1]);
                
                if (pet.age >= minAge && pet.age <= maxAge) {
                    pet.getDetails();
                }
            }
        }
    }
}

class PetAdoptionCentre {
    Pet[] pets;
    int currentSize;
    int maxSize = 10;

    // Constructor
    PetAdoptionCentre(int maxSize){
        this.maxSize = maxSize;
        this.pets = new Pet[maxSize];
        this.currentSize = 0;
    }

    // Add this no-argument constructor
    PetAdoptionCentre() {
        this.pets = new Pet[maxSize];  // uses default maxSize of 10
        this.currentSize = 0;
    }

    void addPet(Pet pet){
        if (currentSize < maxSize) {
            pets[currentSize++] = pet;
        }
    }

    void adoptPet(Pet pet, Adopter adopter){
        if (pet != null && !pet.isAdopted) {
            pet.adopt(adopter.name);
        }
    }

    void viewAvailablePets(){
         // Sort pets by age
         for (int i = 0; i < currentSize - 1; i++) {
            for (int j = 0; j < currentSize - i - 1; j++) {
                if (pets[j].age > pets[j + 1].age) {
                    // Swap
                    Pet temp = pets[j];
                    pets[j] = pets[j + 1];
                    pets[j + 1] = temp;
                }
            }
        }

        // Display available pets
        for (int i = 0; i < currentSize; i++) {
            if (!pets[i].isAdopted) {
                pets[i].getDetails();
            }
        }
    }

    Pet getPetByName(String petName) {
        for (int i = 0; i < currentSize; i++) {
            if (pets[i].name.equals(petName)) {
                return pets[i];
            }
        }
        return null;
    }
}

public class viva3Q3 {
    public static void main(String[] args) {
        PetAdoptionCentre centre = new PetAdoptionCentre(10);

        // Adding pets to the centre
        centre.addPet(new Pet("Buddy", "Dog", "Labrador", 3, "Healthy"));
        centre.addPet(new Pet("Whiskers", "Cat", "Siamese", 2, "Vaccinated"));

        // Viewing available pets
        System.out.println("Available pets:");
        centre.viewAvailablePets();

        // Adopter matching and adoption process
        Adopter adopter1 = new Adopter("John", "Dog", "1-4");
        System.out.println("\nMatching pets for John:");  
        adopter1.viewMatchingPets(centre);  
        
        System.out.println("\nJohn adopts Buddy:");  
        centre.adoptPet(centre.getPetByName("Buddy"),adopter1);  

        System.out.println("\nAvailable pets after adoption:");  
        centre.viewAvailablePets();
    }
}
