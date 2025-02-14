import java.util.Scanner;

public class T2Q7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter value in inch: ");
        double inch = scanner.nextDouble();
        double cm = inch * 2.54;
        double m = cm / 100;

        System.out.println(String.format("%.2f", inch) + " inches = " + (String.format("%.2f", m)) + " meters");

        scanner.close();
    }
}
