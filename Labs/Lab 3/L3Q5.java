import java.util.Scanner;

public class L3Q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter value for a: ");
        double a = scanner.nextDouble();
        
        System.out.print("Enter value for b: ");
        double b = scanner.nextDouble();
        
        System.out.print("Enter value for c: ");
        double c = scanner.nextDouble();
        
        System.out.print("Enter value for d: ");
        double d = scanner.nextDouble();
        
        System.out.print("Enter value for e: ");
        double e = scanner.nextDouble();
        
        System.out.print("Enter value for f: ");
        double f = scanner.nextDouble();
        
        double denominator = (a * d) - (b * c);
        
        if (denominator == 0) {
            System.out.println("The equation has no solution");
        } else {
            double x = (e * d - b * f) / denominator;
            double y = (a * f - e * c) / denominator;
            
            System.out.printf("x = %.2f\n", x);
            System.out.printf("y = %.2f\n", y);
        }
        
        scanner.close();
    }
}
