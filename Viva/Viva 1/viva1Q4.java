import java.util.Scanner;

public class viva1Q4 {

    private static boolean hasPizzaOrder = false;
    private static boolean hasDrinksOrder = false;
    private static boolean hasDessertsOrder = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        double totalBill = 0;

        while (running) {
            System.out.println("Welcome to Maroni's Pizza!");
            System.out.println("1. Pizza");
            System.out.println("2. Drinks");
            System.out.println("3. Desserts");
            System.out.println("4. CHECKOUT");
            System.out.println();
            System.out.print("Pick an option: ");
            int choice = scanner.nextInt();
            System.out.println();

            switch (choice) {
                case 1 -> totalBill = Pizza(scanner, totalBill);
                case 2 -> totalBill = Drinks(scanner, totalBill);
                case 3 -> totalBill = Desserts(scanner, totalBill);
                case 4 -> {
                    CHECKOUT(totalBill);
                    running = false;
                }
                default -> System.out.println("Invalid option. Please try again.");
            }

            if (running) {
                clearConsole();
            }
        }

        scanner.close();
    }

    public static void clearConsole() {
        // ANSI escape code to clear the console
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static double Pizza(Scanner scanner, double totalBill) {
        double peperoni = 15;
        double supreme = 10;
        double vegan = 12;
        double beef = 22;
        double margherita = 9;

        boolean backToMainMenu = false;
        boolean PizzaOrder = false;

        while (!backToMainMenu) {
            System.out.println("PIZZA");
            System.out.println("1. Chicken Peperoni - RM 15");
            System.out.println("2. Chicken Supreme - RM 10");
            System.out.println("3. Vegan Indulgence - RM 12");
            System.out.println("4. Beef Delight - RM 22");
            System.out.println("5. Margherita - RM 9");
            System.out.println("6. BACK TO MAIN MENU");
            System.out.println();
            System.out.print("Pick an option: ");
            int pizzaChoice = scanner.nextInt();

            if(pizzaChoice >= 1 && pizzaChoice <= 5) {
                PizzaOrder = true;
            }
            if(PizzaOrder) {
                hasPizzaOrder = true;
            }

            switch (pizzaChoice) {
                case 1 -> {
                    System.out.println("Chicken Peperoni added to cart.");
                    totalBill += peperoni;
                    System.out.println("Current Total: RM " + totalBill);
                    System.out.println();
                }
                case 2 -> {
                    System.out.println("Chicken Supreme added to cart.");
                    totalBill += supreme;
                    System.out.println("Current Total: RM " + totalBill);
                    System.out.println();
                }
                case 3 -> {
                    System.out.println("Vegan Indulgence added to cart.");
                    totalBill += vegan;
                    System.out.println("Current Total: RM " + totalBill);
                    System.out.println();
                }
                case 4 -> {
                    System.out.println("Beef Delight added to cart.");
                    totalBill += beef;
                    System.out.println("Current Total: RM " + totalBill);
                    System.out.println();
                }
                case 5 -> {
                    System.out.println("Margherita added to cart.");
                    totalBill += margherita;
                    System.out.println("Current Total: RM " + totalBill);
                    System.out.println();
                }
                case 6 -> backToMainMenu = true;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
        return totalBill;
    }

    public static double Drinks(Scanner scanner, double totalBill) {
        double strawberrySmoothie = 8;
        double bananaSmoothie = 8;
        double mocktail = 12;
        double softDrinks = 5;
        double mineralWater = 3;

        boolean backToMainMenu = false;
        boolean DrinksOrder = false;

        while (!backToMainMenu) {
            System.out.println("DRINKS");
            System.out.println("1. Strawberry Smoothie - RM 8");
            System.out.println("2. Banana Smoothie - RM 8");
            System.out.println("3. Mocktail - RM 12");
            System.out.println("4. Soft Drinks - RM 5");
            System.out.println("5. Mineral Water - RM 3");
            System.out.println("6. BACK TO MAIN MENU");
            System.out.println();
            System.out.print("Pick an option: ");
            int drinksChoice = scanner.nextInt();

            if(drinksChoice >= 1 && drinksChoice <= 5) {
                DrinksOrder = true;
            }
            if(DrinksOrder){
                hasDrinksOrder = true;
            }

            switch (drinksChoice) {
                case 1 -> {
                    System.out.println("Strawberry Smoothie added to cart.");
                    totalBill += strawberrySmoothie;
                    System.out.println("Current Total: RM " + totalBill);
                    System.out.println();
                }
                case 2 -> {
                    System.out.println("Banana Smoothie added to cart.");
                    totalBill += bananaSmoothie;
                    System.out.println("Current Total: RM " + totalBill);
                    System.out.println();
                }
                case 3 -> {
                    System.out.println("Mocktail added to cart.");
                    totalBill += mocktail;
                    System.out.println("Current Total: RM " + totalBill);
                    System.out.println();
                }
                case 4 -> {
                    System.out.println("Soft Drinks added to cart.");
                    totalBill += softDrinks;
                    System.out.println("Current Total: RM " + totalBill);
                    System.out.println();
                }
                case 5 -> {
                    System.out.println("Mineral Water added to cart.");
                    totalBill += mineralWater;
                    System.out.println("Current Total: RM " + totalBill);
                    System.out.println();
                }
                case 6 -> backToMainMenu = true;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
        return totalBill;
    }

    public static double Desserts(Scanner scanner, double totalBill) {
        double tiramisu = 10;
        double strawberryShortcake = 10;
        double greenJello = 4;
        double cremeBrulle = 15;
        double rashberryPie = 20;

        boolean backToMainMenu = false;
        boolean DessertsOrder = false;

        while (!backToMainMenu) {
            System.out.println("DESSERTS");
            System.out.println("1. Tiramisu - RM 7");
            System.out.println("2. Strawberry Shortcake - RM 10");
            System.out.println("3. Green Jello - RM 4");
            System.out.println("3. Creme Brulle - RM 15");
            System.out.println("3. Rashberry Pie - RM 20");
            System.out.println("3. BACK TO MAIN MENU");
            System.out.println();
            System.out.print("Pick an option: ");
            int dessertsChoice = scanner.nextInt();

            if(dessertsChoice >= 1 && dessertsChoice <= 5) {
                DessertsOrder = true;
            }
            if(DessertsOrder){
                hasDessertsOrder = true;
            }

            switch (dessertsChoice) {
                case 1 -> {
                    System.out.println("Tiramisu added to cart.");
                    totalBill += tiramisu;
                    System.out.println("Current Total: RM " + totalBill);
                    System.out.println();
                }
                case 2 -> {
                    System.out.println("Strawberry Shortcake added to cart.");
                    totalBill += strawberryShortcake;
                    System.out.println("Current Total: RM " + totalBill);
                    System.out.println();
                }
                case 3 -> {
                    System.out.println("Green Jello added to cart.");
                    totalBill += greenJello;
                    System.out.println("Current Total: RM " + totalBill);
                    System.out.println();
                }
                case 4 -> {
                    System.out.println("Creme Brulle added to cart.");
                    totalBill += cremeBrulle;
                    System.out.println("Current Total: RM " + totalBill);
                    System.out.println();
                }
                case 5 -> {
                    System.out.println("Rashberry Pie added to cart.");
                    totalBill += rashberryPie;
                    System.out.println("Current Total: RM " + totalBill);
                    System.out.println();
                }
                case 6 -> backToMainMenu = true;
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
        return totalBill;
    }

    public static void CHECKOUT(double totalBill) {
        System.out.println("[CHECKOUT]");
        System.out.println();
        
        if(hasPizzaOrder && hasDrinksOrder && hasDessertsOrder) {
            double discount = totalBill * 0.20;  // Calculate 20% discount
            double discountedTotal = totalBill - discount;
            
            System.out.println("Original Bill: RM " + totalBill);
            System.out.println("You ordered from all categories!");
            System.out.println("20% Discount Applied: -RM " + String.format("%.2f", discount));
            System.out.println("Final Total Bill: RM " + String.format("%.2f", discountedTotal));
        } else {
            System.out.println("Total Bill: RM " + totalBill);
        }
        
        System.out.println("Thank you for your order!");
    }
}
