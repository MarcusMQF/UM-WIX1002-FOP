import java.util.Scanner;

public class T3Q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter first number: ");
        int num1 = scanner.nextInt();
        
        System.out.print("Enter second number: ");
        int num2 = scanner.nextInt();
        
        System.out.print("Enter third number: ");
        int num3 = scanner.nextInt();
        
        if (num1 >= num2 && num1 >= num3) {
            System.out.println("Largest number is: " + num1);
        } else if (num2 >= num1 && num2 >= num3) {
            System.out.println("Largest number is: " + num2);
        } else {
            System.out.println("Largest number is: " + num3);
        }
        
        scanner.close();
    }
}
