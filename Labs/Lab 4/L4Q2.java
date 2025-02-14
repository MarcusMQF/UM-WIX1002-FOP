import java.util.Scanner;

public class L4Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an Integer: ");
        int num = scanner.nextInt();

        int sum = 0;
        for(int i = 1; i <= num; i++ ){
            for(int j = 1; j <= i; j++){
                sum += j;
            }
        }

        System.out.println("The sum of the series is: " + sum);

        scanner.close();
    }
}
