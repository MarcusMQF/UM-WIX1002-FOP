import java.util.Scanner;

public class viva1Q2{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number (n, a, b): ");
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int steps = findMinSteps(n, a, b);
        System.out.println(steps);

        scanner.close();
    }

    public static int findMinSteps(int n, int a, int b){
        if(n < 1) return -1; // Check the number input have negative value or not
        
        int steps = 0;
        while(n > 1){  // Change condition to n > 1 as goal is to reach 1
            if(n % b == 0){  // Check if divisible by b
                n = n / b;
            }else{
                n = n - a;  // Subtract a
            }
            steps++;
            
            if(n < 1) return -1;  // If n becomes less than 1, it's impossible
        }
        
        return steps;
    }
}