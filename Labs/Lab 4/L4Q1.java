import java.util.Scanner;

public class L4Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an Integer: ");
        int num = scanner.nextInt();

        StringBuilder factors = new StringBuilder();

        System.out.print("The factors are: ");
        for(int i = 1; i <= num; i++ ){
            if(num % i == 0){
                factors.append(i).append(", ");
            }
        }

        if(factors.length() > 0){
            factors.setLength(factors.length() - 2);
        }

        System.out.println(factors.toString());

        scanner.close();
    }
}
