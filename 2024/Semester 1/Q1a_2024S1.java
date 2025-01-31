import java.util.Scanner;

public class Q1a_2024S1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int negativeCount = 0;
        int positiveCount = 0;
        int zeroCount = 0;

        while(true){
            try{
                System.out.print("Enter a number ('X' to quit): ");
                String num = scanner.nextLine();

                if(!num.isEmpty() && Character.toUpperCase(num.charAt(0)) == 'X'){
                    break;
                }
                
                int number = Integer.parseInt(num);

                if(number < 0){
                    negativeCount++;
                }else if(number > 0){
                    positiveCount++;
                }else{
                    zeroCount++;
                }
            }catch(NumberFormatException e){
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        System.out.println();
        System.out.println("Number of positive numbers: " + positiveCount);
        System.out.println("Number of negative numbers: " + negativeCount);
        System.out.println("Number of zeros: " + zeroCount);

        scanner.close();
    }
}