import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Q4_2018S1 {
    public static void main(String[] args) {
        String inputfile = "Q4.txt";
        List<Participant> participants = readFile(inputfile);

        // Calculate the final scores
        for(Participant participant: participants){
            participant.setFinalScore(participant.calculateFinalScore());
        }

        // Sort participants by final score (Descending order)
        Collections.sort(participants, Comparator.comparingDouble(Participant::getFinalScore).reversed());

        // Print participants and their scores
        System.out.println("Participants and their scores: ");
        for(Participant participant : participants){
            System.out.printf("%s score %.2f%n", participant.getName(), participant.getFinalScore());
        }

        // Print the winner in index(0) as already descending sorted
        if(!participants.isEmpty()){
            System.out.printf("%s is the winner%n", participants.get(0).getName());
        }
    }

    public static List<Participant> readFile(String inputfile){
        List<Participant> participants = new ArrayList<>();

        try{
            BufferedReader reader = new BufferedReader(new FileReader(inputfile));
            String line;

            while((line = reader.readLine()) != null){ // Process each line
                String[] parts = line.split(" ");
                String name = parts[0]; // Extract the name
                double difficulty = Double.parseDouble(parts[parts.length - 1]);

                ArrayList<Double> scores = new ArrayList<>();

                for(int i = 1; i < parts.length - 1; i++){
                    scores.add(Double.parseDouble(parts[i]));
                }
                participants.add(new Participant(name, scores, difficulty)); 
                // Create new Participant object with name, scores, and difficulty and add it to participants list
            }
            reader.close();
        }catch(IOException e){
            e.getStackTrace();
        }

        return participants; // Return list of all participants read from file
    }

    public static class Participant {
        private String name;
        private List<Double> scores;
        private double difficulty;
        private double finalScore;

        public Participant(String name, List<Double> scores, double difficulty){
            this.name = name;
            this.scores = scores;
            this.difficulty = difficulty;
        }

        public String getName(){
            return name;
        }

        public double getFinalScore(){
            return finalScore;
        }

        public void setFinalScore(double finalScore){
            this.finalScore = finalScore;
        }

        public double calculateFinalScore(){
            List<Double> scoreList = new ArrayList<>(scores);
            Collections.sort(scoreList);

            scoreList.remove(0); // Remove highest score
            scoreList.remove(scoreList.size() - 1); // Remove lowest score

            double sum = 0;
            for(double score : scoreList){
                sum += score;
            } // Sum up the remainding score

            return sum * difficulty; // Return the final score
        }
    }
}