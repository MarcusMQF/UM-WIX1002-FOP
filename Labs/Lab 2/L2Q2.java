import java.util.Scanner;

public class L2Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the price of the car: ");
        double P = scanner.nextDouble();

        System.out.print("Enter the down payment: ");
        double D = scanner.nextDouble();

        System.out.print("Enter the Interest Rate in %: ");
        double R = scanner.nextDouble();

        System.out.print("Enter the loan duration in year: ");
        double Y = scanner.nextDouble();

        calc(P,D,R,Y);

        scanner.close();
    }

    public static void calc(double P, double D, double R, double Y){
        double M = 0;
        M = (P-D)*(1+R*Y/100)/(Y*12);

        System.out.println("The Monthly payment is " + String.format("%/2f", M));
    }
}