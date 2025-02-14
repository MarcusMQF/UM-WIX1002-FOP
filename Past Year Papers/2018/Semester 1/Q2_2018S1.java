import java.util.Random;
import java.util.Scanner;

public class Q2_2018S1 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter N number: ");
        int N = scanner.nextInt();

        int[] GeneratedNum = new int[N];
        int AAA = 0, AA = 0, A = 0;

        // Generate N random numbers
        System.out.print("The random numbers are: ");
        for(int i = 0; i < N; i++){
            int MIN = 50;
            int MAX = 150;
            GeneratedNum[i] = random.nextInt(MAX - MIN + 1) + MIN;
            System.out.print(GeneratedNum[i] + " ");
        }

        // Count the number of numbers in each group
        for(int counts : GeneratedNum){
            int LastDigit = counts % 10;
            if(LastDigit >= 0 && LastDigit <= 3){
                AAA++;
            }else if(LastDigit >= 4 && LastDigit <= 6){
                AA++;
            }else if(LastDigit >= 7 && LastDigit <= 9){
                A++;
            }
        }

        System.out.println("\nGroup AAA: " + AAA);
        System.out.println("Group AA: " + AA);
        System.out.println("Group A: " + A);

        scanner.close();
    }
}
