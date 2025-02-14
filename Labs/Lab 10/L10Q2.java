import java.io.*;

public class L10Q2 {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String encodedFile = "encoded.txt";
        String decodedFile = "decoded.txt";
        int shift = 3; // Shift by 3 characters

        // Encoding Process
        SubstitutionCipher encoder = new SubstitutionCipher(inputFile, encodedFile, shift);
        encoder.encodeFile();

        // Decoding Process
        SubstitutionCipher decoder = new SubstitutionCipher(encodedFile, decodedFile, shift);
        decoder.decodeFile();
    }
}

// Interface for encoding and decoding messages
interface MessageEncoder {
    String encode(String plainText);
    String decode(String cipherText);
}

// Implementation of Substitution Cipher
class SubstitutionCipher implements MessageEncoder {
    private String inputFileName;
    private String outputFileName;
    private int shift;

    public SubstitutionCipher(String inputFileName, String outputFileName, int shift) {
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
        this.shift = shift;
    }

    // Method to encode the message using a shift
    @Override
    public String encode(String plainText) {
        return shiftText(plainText, shift);
    }

    // Method to decode the message by reversing the shift
    @Override
    public String decode(String cipherText) {
        return shiftText(cipherText, -shift);
    }

    // Utility method to shift text based on a given shift value
    private String shiftText(String text, int shiftValue) {
        StringBuilder result = new StringBuilder();
        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                result.append((char) ((ch - base + shiftValue + 26) % 26 + base));
            } else {
                result.append(ch); // Keep non-alphabet characters unchanged
            }
        }
        return result.toString();
    }

    // Method to process file encoding
    public void encodeFile() {
        processFile(true);
    }

    // Method to process file decoding
    public void decodeFile() {
        processFile(false);
    }

    // Reads from input file, applies encoding/decoding, and writes to output file
    private void processFile(boolean isEncoding) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String result = isEncoding ? encode(line) : decode(line);
                writer.write(result);
                writer.newLine();
            }
            System.out.println((isEncoding ? "Encoding" : "Decoding") + " completed. Output saved in: " + outputFileName);

        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }
}
