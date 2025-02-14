import java.util.Scanner;

public class L4Q4 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        
        // Get input from user
        System.out.print("Enter the year: ");
        int year = scanner.nextInt();
        System.out.print("Enter first day of the year (0-Sun, 1-Mon, ..., 6-Sat): ");
        int firstDay = scanner.nextInt();
        
        // Print calendars for May and August
        printCalendar(5, firstDay, year);  // May is month 5
        System.out.println();
        printCalendar(8, firstDay, year);  // August is month 8
        
        scanner.close();
    }
    
    public static void printCalendar(int month, int firstDayOfYear, int year){
        // Month names
        String monthName = (month == 5) ? "May" : "August";
        
        // Calculate the first day of the month
        int daysBeforeMonth = getDaysBeforeMonth(month);
        int firstDayOfMonth = (firstDayOfYear + daysBeforeMonth) % 7;
        
        // Get number of days in the month
        int daysInMonth = getDaysInMonth(month, year);
        
        // Print calendar header
        System.out.println("\n" + monthName + " " + year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");
        
        // Print leading spaces
        for(int i = 0; i < firstDayOfMonth; i++) {
            System.out.print("    ");
        }
        
        // Print days
        for(int day = 1; day <= daysInMonth; day++){
            System.out.printf("%3d ", day);
            
            // New line after Saturday
            if((day + firstDayOfMonth) % 7 == 0){
                System.out.println();
            }
        }
        System.out.println();
    }
    
    public static int getDaysBeforeMonth(int month){
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31};
        int days = 0;
        for(int i = 1; i < month; i++){
            days += daysInMonth[i-1];
        }
        return days;
    }
    
    public static int getDaysInMonth(int month, int year){
        if(month == 5) return 31;  // May
        if(month == 8) return 31;  // August
        return 30;  // Default (not needed for this problem)
    }
}
