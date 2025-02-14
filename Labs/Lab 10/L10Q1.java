import java.util.Scanner;

public class L10Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Permanent Employee Input
        System.out.print("Enter Permanent Employee Name: ");
        String perName = scanner.nextLine();
        System.out.print("Enter Category (A/B/C): ");
        char category = scanner.next().charAt(0);
        PermanentEmployee pe = new PermanentEmployee(perName, category);
        pe.display();

        // Contract Staff Input
        scanner.nextLine(); // Consume newline
        System.out.print("\nEnter Contract Staff Name: ");
        String conName = scanner.nextLine();
        System.out.print("Enter Total Sales: RM ");
        double sales = scanner.nextDouble();
        ContractStaff cs = new ContractStaff(conName, sales);
        cs.display();

        // Temporary Staff Input
        scanner.nextLine(); // Consume newline
        System.out.print("\nEnter Temporary Staff Name: ");
        String tempName = scanner.nextLine();
        System.out.print("Enter Hours Worked: ");
        int hours = scanner.nextInt();
        TemporaryStaff ts = new TemporaryStaff(tempName, hours);
        ts.display();

        scanner.close();
    }
}

abstract class Employee {
    protected String name;
    protected String type;

    public Employee(String name, String type) {
        this.name = name;
        this.type = type;
    }

    // Abstract method to calculate salary
    public abstract double calculateSalary();

    // Display employee details
    public void display() {
        System.out.println("\nEmployee Name: " + name);
        System.out.println("Employee Type: " + type);
        System.out.println("Total Salary: RM " + calculateSalary());
    }
}

class PermanentEmployee extends Employee {
    private char category;

    public PermanentEmployee(String name, char category) {
        super(name, "Permanent Employee");
        this.category = category;
    }

    @Override
    public double calculateSalary() {
        switch (category) {
            case 'A': return 4000;
            case 'B': return 3000;
            case 'C': return 2000;
            default: return 0;
        }
    }
}

class ContractStaff extends Employee {
    private double totalSales;

    public ContractStaff(String name, double totalSales) {
        super(name, "Contract Staff");
        this.totalSales = totalSales;
    }

    @Override
    public double calculateSalary() {
        return 500 + (0.5 * totalSales); // Base salary + 50% commission
    }
}

class TemporaryStaff extends Employee {
    private int hoursWorked;

    public TemporaryStaff(String name, int hoursWorked) {
        super(name, "Temporary Staff");
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * 15; // RM15 per hour
    }
}
