import java.util.Random;

public class L4Q6 {
    public static void main(String[] args) {
        Random random = new Random();

        int GeneratedNumber = random.nextInt(Integer.MAX_VALUE);
        System.out.println("Generated Number: " + GeneratedNumber);

        int count = DigitCount(GeneratedNumber);
        System.out.println("Number of Digits: " + count);

    }

    public static int DigitCount(int GeneratedNumber){
        int count = 0;

        if(GeneratedNumber == 0){
            return 1;
        }
        while(GeneratedNumber > 0){
            GeneratedNumber = GeneratedNumber / 10;
            count++;
        }

        return count;
    }
}
