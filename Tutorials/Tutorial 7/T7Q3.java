import java.io.*;

public class T7Q3 {
    public static void main(String[] args) {
        try {
            // Write the sentence to a text file in binary format
            PrintWriter writer = new PrintWriter(new FileOutputStream("data.txt"));
            String sentence = "The quick brown fox jumps over the lazy dog.";
            for (int i = 0; i < sentence.length(); i++) {
                int asciiCode = sentence.charAt(i);
                String binary = String.format("%8s", Integer.toBinaryString(asciiCode)).replace(' ', '0');
                writer.write(binary + " ");
            }
            writer.close();
            System.out.println("Sentence written to data.txt in binary format.");

            // Read the binary data from the text file and display the sentence
            BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                String[] binaryValues = line.split(" ");
                for (String binaryValue : binaryValues) {
                    int asciiCode = Integer.parseInt(binaryValue, 2);
                    sb.append((char) asciiCode);
                }
            }
            reader.close();
            System.out.println("Sentence read from data.txt: " + sb.toString());
        } catch (IOException e) {
            System.out.println("An error occurred while accessing the file.");
            e.printStackTrace();
        }
    }
}
