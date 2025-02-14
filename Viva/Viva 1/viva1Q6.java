import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class viva1Q6 {
    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> score = new ArrayList<Integer>();
        int Temp, LastNumber;
        int sum = 0;

        System.out.print("Enter numbers: ");
                    
        while(true){ // Make sure if there is 0, value behind that will not added into Temp
            Temp = scanner.nextInt();
            score.add(Temp);
            if(Temp == 0){
                break;
            }
        }
        
        Collections.sort(score, Collections.reverseOrder());
        System.out.println(score);
        
        int i = 0;
        LastNumber = score.get(i); // After descending order, the last number is first number, and it is largest
        
        do{
            i++; 
        }while(score.get(i) == score.get(i-1)); // If score(1) == score(0), then loop continue

        System.out.print("The largest number is " + LastNumber + "\nThe occurrence count of the largest number is " + i);

        int j = i;  // Store the j value with the highest score position  
        LastNumber = score.get(i);  // Get first number after largest numbers
        
        do{
            i++;
        }while(score.get(i) == score.get(i-1));

        System.out.println("\nThe second-largest mumber is " + LastNumber + "\nThe occurrence count of the second-largest number is " + (i - j));
        
        for(i = 0; i < score.size(); i++){
            sum = sum + score.get(i);
        }
        System.out.println("The total sum of all numbers is " + sum);
        
        if(score.get(score.size() - 1) < 0){
            System.out.println("Negative numbers were entered.");
        } // This checks if the last score in the sorted list is negative. 

        scanner.close();
    }
}
