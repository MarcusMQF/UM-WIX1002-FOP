import java.util.Scanner;

public class L3Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the first integer: ");
        double num1 = scanner.nextDouble();
        double num2 = scanner.nextDouble();

        System.out.print("Enter the operator (+, -, *, /): ");
        char operator = scanner.next().charAt(0);

        switch(operator) {
            case '+':
                System.out.println(num1 + " + " + num2 + " = " + String.format("%.2f",(num1 + num2)));
                break;
            case '-':
                System.out.println(num1 + " - " + num2 + " = " + String.format("%.2f",(num1 - num2)));
                break;
            case '*':
                System.out.println(num1 + " * " + num2 + " = " + String.format("%.2f",(num1 * num2)));
                break;
            case '/':
                if(num2 != 0) {
                    System.out.println(num1 + " / " + num2 + " = " + String.format("%.2f",(num1 / num2)));
                } else {
                    System.out.println("Cannot divide by zero!");
                }
                break;
            case '%':
                if(num2 != 0) {
                    System.out.println(num1 + " % " + num2 + " = " + String.format("%.2f",(num1 % num2)));
                } else {
                    System.out.println("Cannot divide by zero!");
                }
                break;
            default:
                System.out.println("Invalid operator!");
        }

        scanner.close();
    }
}
