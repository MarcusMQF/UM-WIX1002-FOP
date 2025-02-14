import java.util.Scanner;

public class Q1_2018S1 {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);

        int num, sum = 0;
        do{
            System.out.print("Enter an integer number, -1 to quit: ");
            num = a.nextInt();

            if(num == -1)
                continue;

            if(num % 2 == 1)
                System.out.println("The number is an odd number");
            else
                System.out.println("The number is an even number");
            sum += num;
        } while(num != -1);

        System.out.printf("The sum of all integers number(s) is: %d\n", sum);
        a.close(); // not necessary but good practice
    }
}
