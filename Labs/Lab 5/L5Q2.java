import java.util.Random;

public class L5Q2 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = new int[10];
        int count = 0;
        
        // Fill array with non-duplicate numbers
        while (count < 10) {
            int newNum = random.nextInt(21); // 0-20
            boolean isDuplicate = false;
            
            // Check if number already exists
            for (int i = 0; i < count; i++) {
                if (numbers[i] == newNum) {
                    isDuplicate = true;
                    break;
                }
            }
            
            // Add number if not duplicate
            if (!isDuplicate) {
                numbers[count] = newNum;
                count++;
            }
        }
        
        // Display the numbers
        System.out.println("The non-duplicate random numbers are:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }
}
