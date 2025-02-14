import java.util.Scanner;

public class Q1_2020S1 {
    public static void main (String[] args) {
        System.out.println("This program changes all odd numbers in an array into even numbers.");

        Scanner s = new Scanner(System.in); 
        int size = 5;
        int num[] = new int[size];
        System.out.print("Enter five integer numbers: ");

        for (int i = 0; i < size; i++) {
            num[i] = s.nextInt();
        }

        for (int i = 0; i < size; i++) {
            num[i] = convert(num[i]);
        }

        System.out.print("The numbers are: ");
        for (int i = 0; i < size; i++) {
            System.out.print(num[i] + " ");
        }

        s.close();
    }

    public static int convert(int n) {
        if (n % 2 != 0) {
            return n + 1;
        }
        return n;
    }
}