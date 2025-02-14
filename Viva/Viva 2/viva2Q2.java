import java.util.Scanner;

public class viva2Q2 {

    // Method to calculate the area of a circle
    public static double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }

    // Method to calculate the area of a rectangle
    public static double calculateRectangleArea(double length, double width) {
        return length * width;
    }

    // Method to calculate the area of a triangle
    public static double calculateTriangleArea(double base, double height) {
        return (base * height) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to choose a shape
        System.out.println("Choose a shape to calculate the area:");
        System.out.println("1. Circle");
        System.out.println("2. Rectangle");
        System.out.println("3. Triangle");
        System.out.print("Enter your choice (1, 2, or 3): ");
        int choice = scanner.nextInt();

        double area = 0;

        switch (choice) {
            case 1: // Circle
                System.out.print("Enter the radius of the circle: ");
                double radius = scanner.nextDouble();
                area = calculateCircleArea(radius);
                System.out.printf("The area of the circle is: %.2f\n", area);
                break;

            case 2: // Rectangle
                System.out.print("Enter the length of the rectangle: ");
                double length = scanner.nextDouble();
                System.out.print("Enter the width of the rectangle: ");
                double width = scanner.nextDouble();
                area = calculateRectangleArea(length, width);
                System.out.printf("The area of the rectangle is: %.2f\n", area);
                break;

            case 3: // Triangle
                System.out.print("Enter the base of the triangle: ");
                double base = scanner.nextDouble();
                System.out.print("Enter the height of the triangle: ");
                double height = scanner.nextDouble();
                area = calculateTriangleArea(base, height);
                System.out.printf("The area of the triangle is: %.2f\n", area);
                break;

            default:
                System.out.println("Invalid choice. Please select 1, 2, or 3.");
                break;
        }

        scanner.close();
    }
}
