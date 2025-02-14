import java.util.Scanner;

public class PS1Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalSales = 0.0;
        
        while(true){
            System.out.print("Enter the type of durian [Quit] to terminate: ");
            String durianType = scanner.next();
            
            if(durianType.equalsIgnoreCase("Quit")){
                break;
            }
        
            double price = 0.0;
            switch(durianType.toUpperCase()){
                case "MK":
                    price = 25;
                    break;
                case "HL":
                    price = 22;
                    break;
                case "D24":
                    price = 20;
                    break;
                case "UM":
                    price = 18;
                    break;
            }
            
            System.out.print("Enter the sales in kg: ");
            double sales = scanner.nextDouble();
        
            totalSales += price * sales;
        }
        
        System.out.printf("Total Sales : %.2f%n", totalSales);
        
        scanner.close();
    }
}