import java.io.*;

public class L7Q4 {
    public static void main(String[] args) {
        try {
            // Specify the file path
            String filePath = "original.txt";
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            int charCount = 0;
            int wordCount = 0;
            int lineCount = 0;
            String line;

            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                lineCount++;
                
                // Count characters (including spaces)
                charCount += line.length();
                
                // Count words (assuming words are separated by single spaces)
                if (!line.isEmpty()) {
                    String[] words = line.split(" ");
                    wordCount += words.length;
                }
            }

            reader.close();

            // Display results
            System.out.println("File Statistics:");
            System.out.println("Number of characters: " + charCount);
            System.out.println("Number of words: " + wordCount);
            System.out.println("Number of lines: " + lineCount);

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}