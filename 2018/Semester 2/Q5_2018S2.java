import java.util.Scanner;

public class Q5_2018S2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int grammarMarks, spellingMarks, lengthMarks, contentMarks;

        do {
            System.out.print("Enter the marks for Grammar (maximum 30 marks): ");
            grammarMarks = scanner.nextInt();
            if (grammarMarks < 0 || grammarMarks > 30) {
                System.out.println("Error: Grammar marks must be between 0 and 30.");
                System.out.println();
            }
        } while (grammarMarks < 0 || grammarMarks > 30);

        do {
            System.out.print("Enter the marks for Spelling (maximum 20 marks): ");
            spellingMarks = scanner.nextInt();
            if (spellingMarks < 0 || spellingMarks > 20) {
                System.out.println("Error: Spelling marks must be between 0 and 20.");
                System.out.println();
            }
        } while (spellingMarks < 0 || spellingMarks > 20);

        do {
            System.out.print("Enter the marks for Length (maximum 20 marks): ");
            lengthMarks = scanner.nextInt();
            if (lengthMarks < 0 || lengthMarks > 20) {
                System.out.println("Error: Length marks must be between 0 and 20.");
                System.out.println();
            }
        } while (lengthMarks < 0 || lengthMarks > 20);

        do {
            System.out.print("Enter the marks for Content (maximum 30 marks): ");
            contentMarks = scanner.nextInt();
            if (contentMarks < 0 || contentMarks > 30) {
                System.out.println("Error: Content marks must be between 0 and 30.");
                System.out.println();
            }
        } while (contentMarks < 0 || contentMarks > 30);

        Essay essay = new Essay();
        essay.setScore(grammarMarks, spellingMarks, lengthMarks, contentMarks);

        System.out.println("Essay score:");
        System.out.println("Grammar: " + essay.getGrammarScore());
        System.out.println("Spelling: " + essay.getSpellingScore());
        System.out.println("Length: " + essay.getLengthScore());
        System.out.println("Content: " + essay.getContentScore());
        System.out.println("Total score: " + essay.getScore());
        System.out.println("Essay grade: " + essay.getLetterGrade());
        
        scanner.close();
    }
}

class GradedActivity {
    private double numericScore;
    private char letterGrade;

    public void setScore(double score) {
        numericScore = score; // Set the instance variable
        setLetterGrade(); // Call the method to set the letter grade based on numericScore
    }

    private void setLetterGrade() {
        if (numericScore >= 90)
            letterGrade = 'A';
        else if (numericScore >= 80)
            letterGrade = 'B';
        else if (numericScore >= 70)
            letterGrade = 'C';
        else if (numericScore >= 60)
            letterGrade = 'D';
        else
            letterGrade = 'F';
    }

    public double getScore() {
        return numericScore;
    }

    public char getLetterGrade() {
        return letterGrade;
    }
}

class Essay extends GradedActivity {
    private int grammarScore;
    private int spellingScore;
    private int lengthScore;
    private int contentScore;

    public void setScore(int grammar, int spelling, int length, int content) {
        grammarScore = grammar;
        spellingScore = spelling;
        lengthScore = length;
        contentScore = content;
        
        super.setScore(grammarScore + spellingScore + lengthScore + contentScore); 
        // Pass the total score of the essay
    }

    public int getGrammarScore() {
        return grammarScore;
    }

    public int getSpellingScore() {
        return spellingScore;
    }

    public int getLengthScore() {
        return lengthScore;
    }

    public int getContentScore() {
        return contentScore;
    }
}


