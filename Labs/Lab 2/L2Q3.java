import java.util.Random;

public class L2Q3 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] GeneratedNum = new int[3];

        System.out.print("Three Generated Number: ");
        for(int i = 0; i < 3; i++){
            int MAX = 51;
            int MIN = 10;
            GeneratedNum[i] = random.nextInt(MIN, MAX);
            System.out.print(GeneratedNum[i] + " ");
        }

        int sum = GeneratedNum[0] + GeneratedNum[1] + GeneratedNum[2];
        double average = sum/3;

        System.out.println("The sum of three number is " + sum);
        System.out.println("The average of three num is " + String.format("%.2f",average));
    }
}
