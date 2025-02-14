import java.util.Scanner;

public class T1Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a;
        double b; 

        System.out.print("Enter the number 1: ");
        a = scanner.nextDouble();

        System.out.print("Enter the number 2: ");
        b = scanner.nextDouble();

        double result = multiplication(a,b);
        System.out.printf("The multiplication result is %.2f", result);

        scanner.close();
    }

    public static double multiplication(double a, double b){
        double multi = a*b;
        return multi;
    } 
}


