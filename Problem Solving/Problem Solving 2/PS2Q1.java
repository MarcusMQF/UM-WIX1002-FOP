import java.util.Random;
import java.util.Scanner;

public class PS2Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.print("Enter the number of staff [N]: ");
        int n = scanner.nextInt();
        
        int weekendDutyCount = 0;
        
        for (int i = 0; i < n; i++) {
            int staffId = random.nextInt(90000) + 10000;
            System.out.println("Staff ID : " + staffId);
            
            int secondDigit = (staffId / 1000) % 10;
            int fourthDigit = (staffId / 10) % 10;
            
            boolean isSelected = (secondDigit % 2 == 1) && (fourthDigit % 2 == 0);
            
            if (isSelected) {
                System.out.println("Weekend Duty");
                weekendDutyCount++;
            } else {
                System.out.println("Weekend Off");
            }
        }
        
        System.out.println("The number of staffs work during weekend is " + weekendDutyCount);
        
        scanner.close();
    }
}

