import java.util.Scanner;

public class T2Q6 {
    public static void main(String[] args) {
        final double PI = 3.142;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the diameter: ");
        double diameter = scanner.nextDouble();

        CalCircumference(PI, diameter);

        scanner.close();
    }

    public static void CalCircumference(double PI, double diameter){
        double radius;
        radius = diameter/2;
        double circumference = 2 * PI * radius;

        System.out.println("The circumference is " + (String.format("%.3f", circumference)));
    }
}
