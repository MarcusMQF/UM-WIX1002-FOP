import java.util.Random;
import java.util.Scanner;

public class Q3_2016S1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of random integer: ");
        int n = scanner.nextInt();
        
        int[] Array = new int[n];
        String[] StringArray = new String[n];
        
        display(Array, null, n, StringArray);
        
        findMax(Array);
        
        // Find the approxmimation of the integer (95 = 100, 511 = 510, 875 = 880)  
        Approximation(Array);
        
        System.out.println();
        ReverseOrder(Array);

        scanner.close();
    }

    public static void display(int[] Array, Random random, int n, String[] StringArray){
        // Print the random Integer array
        for(int i = 0; i < n; i ++){
            Array[i] = random.nextInt(1001);
            StringArray[i] = String.valueOf(Array[i]);
        }
        
        // Print out the Random Integer Array
        System.out.println("The random integer: " + String.join(" ",StringArray));
    }

    public static void findMax(int[] Array){
        int max = -1;
        for(int array: Array){
            if(array > max){
                max = array;
            }
        }
        
        System.out.println("Maximum number: " + max);
    }

    public static void Approximation(int[] Array){
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
    }

    public static void ReverseOrder(int[] Array){
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
    }
}
