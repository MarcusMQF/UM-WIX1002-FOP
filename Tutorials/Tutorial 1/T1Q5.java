import java.util.Scanner;

public class T1Q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Enter the rectangle length: ");
        double length = scanner.nextDouble();

        System.out.printf("Enter the rectangle width: ");
        double width = scanner.nextDouble();

        double results = calculate(length, width);
        System.out.printf("The perimeter of the rectangle is %.2f cm", results);

        scanner.close(); 
    }

    public static double calculate(double length, double width){
        double perimeter = (length*2) + (width*2);

        return perimeter;
    }
}
