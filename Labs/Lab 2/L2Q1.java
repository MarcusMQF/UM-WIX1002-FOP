import java.util.Scanner;

public class L2Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the degree Fahrenheit: ");
        double fahrenheit = scanner.nextDouble();

        double celcius = (fahrenheit-32)/1.8;

        System.out.println("The celcius is " + celcius);

        scanner.close();
    }
}