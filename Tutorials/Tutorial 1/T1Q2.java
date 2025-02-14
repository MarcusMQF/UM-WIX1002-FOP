import java.util.Random;

public class T1Q2 {
    public static void main(String[] args) {
        Random random = new Random();
        int number = random.nextInt(100) + 1;

        String result = (number > 50) ? "The random number is greater than 50" : "The random number is lower than 50";
        System.out.println(result);
    }
}
