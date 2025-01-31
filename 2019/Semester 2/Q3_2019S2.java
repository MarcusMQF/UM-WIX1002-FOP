import java.util.Random;
import java.util.Scanner;

public class Q3_2019S2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        while(true){
            int num1 = random.nextInt(100);
            int num2 = random.nextInt(100);
            
            System.out.printf("What is %d + %d ?", num1, num2);
            int ans = scanner.nextInt();
            
            if(ans != (num1 + num2)){
                System.out.printf("%d + %d = %d is false", num1, num2, ans);
            }else{
                System.out.printf("%d + %d = %d is true", num1, num2, ans);
            }
            
            scanner.nextLine();
            System.out.println("\nDo you want to try another question (y/n)?");
            String again = scanner.nextLine();
            
            if(again.equalsIgnoreCase("n")){
                break;
            }
        }
        
        scanner.close();
    }
}
