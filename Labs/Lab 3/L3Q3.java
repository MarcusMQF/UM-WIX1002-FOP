import java.util.Scanner;

public class L3Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double commission;

        System.out.print("Enter sales volume: ");
        double sales = scanner.nextDouble();

        if (sales <= 100) {
            commission = sales * 0.05;
        } else if (sales <= 500) {
            commission = sales * 0.075; 
        } else if (sales <= 1000) {
            commission = sales * 0.10;  
        } else {
            commission = sales * 0.125; 
        }

        System.out.printf("Commission: RM%.2f\n", commission);
        
        scanner.close();
    }
}
