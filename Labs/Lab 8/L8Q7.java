import java.util.Scanner;

public class L8Q7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input money amount
        System.out.print("Enter the amount of money: RM ");
        double amount = scanner.nextDouble();

        // Create Money object and round the amount
        Money money1 = new Money(amount);
        money1.roundAmount();

        // Display breakdown
        System.out.println("\nBreakdown of RM" + money1.getAmount() + ":");
        money1.breakdown();

        // Adding another Money object
        System.out.print("\nEnter another amount to add: RM ");
        double amountToAdd = scanner.nextDouble();
        Money money2 = new Money(amountToAdd);
        money2.roundAmount();

        Money total = money1.add(money2);
        System.out.println("\nAfter addition (RM" + money1.getAmount() + " + RM" + money2.getAmount() + "): RM " + total.getAmount());

        // Subtracting another Money object
        System.out.print("\nEnter another amount to subtract: RM ");
        double amountToSubtract = scanner.nextDouble();
        Money money3 = new Money(amountToSubtract);
        money3.roundAmount();

        Money difference = money1.subtract(money3);
        System.out.println("\nAfter subtraction (RM" + money1.getAmount() + " - RM" + money3.getAmount() + "): RM " + difference.getAmount());

        scanner.close();
    }
}

class Money {
    private double amount;

    // Constructor
    public Money(double amount) {
        this.amount = amount;
    }

    // Rounding Method
    public void roundAmount() {
        double cents = amount * 100 % 10; // Extract last decimal place
        if (cents == 1 || cents == 2) {
            amount = Math.floor(amount * 10) / 10; // Round down to .10
        } else if (cents == 3 || cents == 4 || cents == 6 || cents == 7) {
            amount = Math.floor(amount * 10) / 10 + 0.05; // Round to .15
        } else if (cents == 8 || cents == 9) {
            amount = Math.ceil(amount * 10) / 10; // Round up to .20
        }
    }

    // Breakdown into notes and coins
    public void breakdown() {
        int totalCents = (int) Math.round(amount * 100); // Convert to cents
        int[] notes = {10000, 5000, 1000, 500, 100}; // RM100, RM50, RM10, RM5, RM1
        int[] coins = {50, 20, 10, 5}; // 50c, 20c, 10c, 5c

        System.out.println("Notes:");
        for (int note : notes) {
            int count = totalCents / note;
            if (count > 0) {
                System.out.println("RM " + (note / 100) + " x " + count);
            }
            totalCents %= note;
        }

        System.out.println("Coins:");
        for (int coin : coins) {
            int count = totalCents / coin;
            if (count > 0) {
                System.out.println(coin + " cent x " + count);
            }
            totalCents %= coin;
        }
    }

    // Get rounded amount
    public double getAmount() {
        return amount;
    }

    // Addition method
    public Money add(Money other) {
        return new Money(this.amount + other.amount);
    }

    // Subtraction method
    public Money subtract(Money other) {
        return new Money(this.amount - other.amount);
    }
}

