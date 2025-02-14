import java.util.Scanner;

public class L3Q6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the radius of the circle: ");
        double radius = scanner.nextDouble();
        
        System.out.print("Enter x coordinate of the point: ");
        double x = scanner.nextDouble();
        
        System.out.print("Enter y coordinate of the point: ");
        double y = scanner.nextDouble();
        
        // Calculate distance from origin using distance formula
        double distance = Math.sqrt(x * x + y * y);
        
        if (distance < radius) {
            System.out.println("The point is inside the circle");
        } else if (distance == radius) {
            System.out.println("The point is on the circle");
        } else {
            System.out.println("The point is outside the circle");
        }
        
        scanner.close();
    }
}
