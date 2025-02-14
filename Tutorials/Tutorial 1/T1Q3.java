import java.util.Scanner;

public class T1Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int marks;
        System.out.println("Enter your marks: ");
        marks = scanner.nextInt();

        String grade = (marks > 40) ? "You had Pass!" : "You had fail";
        System.out.println(grade);

        scanner.close();
    }
}
