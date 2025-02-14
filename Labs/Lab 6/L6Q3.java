import java.util.Scanner;

public class L6Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[10];

        System.out.print("Enter 10 numbers: ");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        int[] reverse = new int[numbers.length];

        for(int i = 0; i < numbers.length; i++){
            reverse[i] = numbers[numbers.length - i - 1];
        }

        System.out.print("Original Array: ");
        for(int num: numbers){
            System.out.print(num + " ");
        }

        System.out.print("\nReversed Array: ");
        for(int reversed: reverse){
            System.out.print(reversed + " ");
        }

        scanner.close();
    }
}
