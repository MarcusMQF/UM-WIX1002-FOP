import java.util.Random;

public class T1Q11 {
    public static void main(String[] args) {
        Random random = new Random();
        int[] GeneratedNum = new int[5];

        System.out.print("Generated Number: ");

        for(int i = 0; i < 5; i++){
            GeneratedNum[i] = random.nextInt(100)+1;
            System.out.print(GeneratedNum[i] + " ");
        }

        // Sort in descending order using bubble sort
        for(int i = 0; i < GeneratedNum.length - 1; i++) {
            for(int j = 0; j < GeneratedNum.length - i - 1; j++) {
                if(GeneratedNum[j] < GeneratedNum[j + 1]) {
                    // Swap elements
                    int temp = GeneratedNum[j];
                    GeneratedNum[j] = GeneratedNum[j + 1];
                    GeneratedNum[j + 1] = temp;
                }
            }
        }

        // Display sorted numbers
        System.out.print("\nNumbers in descending order: ");
        for(int num : GeneratedNum) {
            System.out.print(num + " ");
        }
    }
}

// Display a list of 5 random numbers in descending order. (Sort)