import java.io.*;
import java.util.*;

public class Q4_2019S1 {
    public static void main(String[] args) {
        String filePath = "MyAmbitious.txt";
        int numberofWords = 0;
        int numberofSentences = 0;
        HashMap<Character, Integer> characterFrequency = new HashMap<>();
        
        try(Scanner scanner = new Scanner(new FileInputStream(filePath))){
            scanner.nextLine(); // Skip the first line
            //Stringbuilder line = scanner.nextLine(); // Read all until a next Line input "\n"
            
            StringBuilder essayContent = new StringBuilder();
            
            while(scanner.hasNextLine()){
                //line = line.toUpperCase();
                essayContent.append(scanner.nextLine()).append(" ");
            }
            
            //Convert the essay content to a single string
            String essay = essayContent.toString().trim();
            
            System.out.println("The essay is:\n" + essay);
            
            //Count sentences, words and letter frequencies
            numberofSentences = essay.split("\\.").length; //Use escape character to escape the "\" as "." has special meaning in regex
            numberofWords = essay.split(" ").length;
            
            //Count letter frequenies
            for(int i = 0; i < essay.length(); i++){
                char c = essay.toUpperCase().charAt(i);
                if(Character.isLetter(c)){
                    characterFrequency.put(c, characterFrequency.getOrDefault(c, 0) + 1);
                }
            }
            
            //Print results
            System.out.println("Number of sentences: " + numberofSentences);
            System.out.println("Number of words: " + numberofWords);
            
            //Print letter frequencies
            System.out.println("Letter Frequencies: ");
            for(char c = 'A'; c <= 'Z'; c++){
                int frequency = characterFrequency.getOrDefault(c, 0);
                System.out.print(c + ": " + frequency + " ");
            }
            
        }catch (FileNotFoundException e){
            System.out.println("File Not Found");
        }
    }
}