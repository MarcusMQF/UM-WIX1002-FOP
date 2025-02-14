import java.io.*;

public class L7Q3 {
    public static void main(String[] args) {
        try {
            // Create readers and writers
            BufferedReader reader = new BufferedReader(new FileReader("original.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("reverse.txt"));

            String line;
            // Read each line from the input file
            while ((line = reader.readLine()) != null) {
                // Reverse the line
                StringBuilder reversed = new StringBuilder(line).reverse();
                
                // Write reversed line to output file
                writer.write(reversed.toString());
                writer.newLine();
            }

            // Close the files
            reader.close();
            writer.close();
            
            System.out.println("File has been reversed successfully.");
            
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
