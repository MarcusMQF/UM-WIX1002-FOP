import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Q3_2020S1 {
    public static void main(String[] args) {
        String filePath = "raw.txt";
        
        try(Scanner scanner = new Scanner(new FileInputStream(filePath))){
            int[] nums = new int[50];
            int count = 0;
            
            while(scanner.hasNextLine()){
                String line = scanner.nextLine();
                String parts[] = line.split(" ");
                
                for(String part : parts){
                    int num = Integer.parseInt(part);
                    nums[count] = num;
                    count++;
                }
                
                // Print the array
                System.out.println("The original numbers from the file: ");
                for(int i = 0; i < nums.length; i++){
                    System.out.print(nums[i] + " ");
                }
                System.out.println();
                
                checkFrequency(nums);
                
            }
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }
    
    public static void checkFrequency(int[] nums){
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        
        // Count the frequency of each number
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Print the frequency distribution table
        System.out.println("Frequency Distribution Table");
        for (int i = 2; i <= 10; i += 2) {
            System.out.println(i + " : " + frequencyMap.getOrDefault(i, 0));
        }
        
        // Find the mode
        int mode = -1; // Initialize mode 
        int maxFrequency = 0; // Initialize maximum frequency

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int number = entry.getKey();
            int frequency = entry.getValue();

            // Update mode if current number has higher frequency
            if (frequency > maxFrequency) {
                mode = number;
                maxFrequency = frequency;
            }
        }

        // Print the mode
        System.out.println("The mode of the dataset is: " + mode);
    }
}