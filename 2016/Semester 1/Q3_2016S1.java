import java.util.Random;
import java.util.Scanner;

public class Q3_2016S1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.print("Enter the number of random integer: ");
        int n = scanner.nextInt();
        
        int[] Array = new int[n];
        String[] StringArray = new String[n];
        
        // Print the random Integer array
        for(int i = 0; i < n; i ++){
            Array[i] = random.nextInt(1001);
            StringArray[i] = String.valueOf(Array[i]);
        }
        
        // Print out the Random Integer Array
        System.out.println("The random integer: " + String.join(" ",StringArray));
        
        // Find the maximum number
        int max = -1;
        for(int array: Array){
            if(array > max){
                max = array;
            }
        }
        
        System.out.println("Maximum number: " + max);
        
        // Find the approxmimation of the integer (95 = 100, 511 = 510, 875 = 880)  
        System.out.print("The approximation of the integer to the nearest tenth: ");
        for (int num : Array) {
            int lastDigit = num % 10;
            int roundedNum;
            
            if (lastDigit >= 5) {
                roundedNum = num + (10 - lastDigit);  // Round up
            } else {
                roundedNum = num - lastDigit;  // Round down
            }
            
            System.out.print(roundedNum + " ");
        }
        
        // Reverse order 
        System.out.println();
        System.out.print("The random integer in reverse order: ");
        for(int num: Array){
            int reversedNum = 0;
            while(num != 0){
                int lastDigit = num % 10; // Extract Last Digit
                reversedNum = reversedNum * 10 + lastDigit;
                num /= 10;
            }
            
            System.out.print(reversedNum + " ");
        }

        scanner.close();
    }
}
