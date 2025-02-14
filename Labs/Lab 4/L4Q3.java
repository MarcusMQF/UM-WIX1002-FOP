import java.util.Scanner;
import java.util.ArrayList;

public class L4Q3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> scores = new ArrayList<Integer>();

        int score = 0;
        int sum = 0;
        int minScore = Integer.MAX_VALUE;
        int maxScore = Integer.MIN_VALUE;

        do{
            System.out.print("Enter a score [negative score to quit]: ");
            score = scanner.nextInt();
            if(score >= 0){
                scores.add(score);
                sum += score;
                if(score < minScore){
                    minScore = score;
                }
                if(score > maxScore){
                    maxScore = score;
                }
            }
        }while(score > 0);

        if(!scores.isEmpty()){
            double average = (double)sum / scores.size();
            double sumOfSquares = 0.0;

            for(int s : scores){
                sumOfSquares += Math.pow(s, 2);
            }
            double standardDeviation = Math.sqrt((sumOfSquares - (Math.pow(sum, 2) / scores.size())) / (scores.size() - 1));

            System.out.println("Minimum Score: " + minScore);
            System.out.println("Maximum Score: " + maxScore);
            System.out.println("Average Score: " + String.format("%.2f", average));
            System.out.println("Standard Deviation: " + String.format("%.2f", standardDeviation));

        }else{
            System.out.println("No scores entered.");
        }

        scanner.close();
    }
}
