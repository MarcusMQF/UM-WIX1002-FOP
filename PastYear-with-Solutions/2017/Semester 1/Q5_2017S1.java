import java.util.Scanner;

public class Q5_2017S1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get validated scores using a reusable method
        int grammar = getValidScore(scanner, "Enter the grammar score (maximum 30 marks): ", 30);
        int spelling = getValidScore(scanner, "Enter the spelling score (maximum 20 marks): ", 20);
        int length = getValidScore(scanner, "Enter the length score (maximum 20 marks): ", 20);
        int content = getValidScore(scanner, "Enter the content score (maximum 30 marks): ", 30);

        // Create Essay object and display results
        Essay essay = new Essay(grammar, spelling, length, content);
        System.out.println("\nEssay score: ");
        System.out.println(essay.toString());

        scanner.close();
    }

    private static int getValidScore(Scanner scanner, String prompt, int maxScore) {
        int score;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                score = scanner.nextInt();
                if (score >= 0 && score <= maxScore) {
                    break; // Valid score, exit the loop
                } else {
                    System.out.println("Error: Score must be between 0 and " + maxScore + ". Please try again.");
                }
            } else {
                System.out.println("Error: Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
        }
        return score;
    }
}

class GradedActivity {
    double score;

    public void setScore(double score){
        this.score = score;
    }

    public double getScore(){
        return score;
    }

    public char getGrade(){
        char grade;
        if(score >= 90){
            grade = 'A';
        } else if(score >= 80){
            grade = 'B';
        } else if(score >= 70){
            grade = 'C';
        } else if(score >= 60){
            grade = 'D';
        } else {
            grade = 'F';
        }
        return grade;
    }

    @Override
    public String toString() {
        return "\n\nTotal score: " + score + "\nEssay grade: " + getGrade();
    }
}

class Essay extends GradedActivity {
    int grammar;
    int spelling;
    int length;
    int content;

    public Essay(int grammar, int spelling, int length, int content){
        this.grammar = grammar;
        this.spelling = spelling;
        this.length = length;
        this.content = content;
        setScore(grammar + spelling + length + content);
    }

    @Override
    public String toString() {
        return "Grammar: " + grammar + "\nSpelling: " + spelling + "\nLength: " + length + "\nContent: " + content + super.toString();
    }
}
