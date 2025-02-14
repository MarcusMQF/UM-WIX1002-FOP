import java.util.Random;

public class T1Q6 {
    public static void main(String[] args) {
        Random random = new Random();
        int min = Integer.MAX_VALUE;  // Start with maximum possible value
        
        for(int i = 0; i < 10; i++){
           int generatedNum = random.nextInt(100) + 1;
           System.out.println("Random Number " + (i+1) + ": " + generatedNum);
           min = Math.min(min, generatedNum);
        }
        
        System.out.println("The minimum number is: " + min);
    }
}

/*
 * public class T1Q6 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = new int[10];  // Array to store the random numbers
        
        // Generate and store random numbers
        for(int i = 0; i < 10; i++){
           numbers[i] = random.nextInt(10) + 1;
           System.out.println("Random Number " + (i+1) + ": " + numbers[i]);
        }
        
        // Find and print minimum number
        int min = findMin(numbers);
        System.out.println("The minimum number is: " + min);
    }

    public static int findMin(int[] numbers){
        int min = numbers[0];  // Start with first number as minimum
        
        // Compare with rest of the numbers
        for(int i = 1; i < numbers.length; i++){
            if(numbers[i] < min){
                min = numbers[i];
            }
        }
        return min;
    }
}
 */