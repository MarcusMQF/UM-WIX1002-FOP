import java.io.*;

public class L10Q3 {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String encodedFile = "encoded.txt";
        String decodedFile = "decoded.txt";
        int N = 2; // Shuffle twice

        // Encoding Process
        ShuffleCipher encoder = new ShuffleCipher(inputFile, encodedFile, N);
        encoder.encodeFile();

        // Decoding Process
        ShuffleCipher decoder = new ShuffleCipher(encodedFile, decodedFile, N);
        decoder.decodeFile();
    }
}

// Interface for encoding and decoding messages
interface MessageEncoder {
    String encode(String plainText);
    String decode(String cipherText);
}

// ShuffleCipher class implementing MessageEncoder
class ShuffleCipher implements MessageEncoder {
    private String inputFileName;
    private String outputFileName;
    private int N; // Number of shuffles

    public ShuffleCipher(String inputFileName, String outputFileName, int N) {
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
        this.N = N;
    }

    // Encoding method (shuffle N times)
    @Override
    public String encode(String plainText) {
        String shuffledText = plainText;
        for (int i = 0; i < N; i++) {
            shuffledText = shuffle(shuffledText);
        }
        return shuffledText;
    }

    // Decoding method (reverse shuffle N times)
    @Override
    public String decode(String cipherText) {
        String unshuffledText = cipherText;
        for (int i = 0; i < N; i++) {
            unshuffledText = unshuffle(unshuffledText);
        }
        return unshuffledText;
    }

    // Shuffle: Split in half, then interleave
    private String shuffle(String text) {
        int mid = (text.length() + 1) / 2; // Midpoint (first half may be longer if odd)
        String firstHalf = text.substring(0, mid);
        String secondHalf = text.substring(mid);
        StringBuilder shuffled = new StringBuilder();

        int i = 0, j = 0;
        while (i < firstHalf.length() || j < secondHalf.length()) {
            if (i < firstHalf.length()) shuffled.append(firstHalf.charAt(i++));
            if (j < secondHalf.length()) shuffled.append(secondHalf.charAt(j++));
        }
        return shuffled.toString();
    }

    // Unshuffle: Reverse the interleaving
    private String unshuffle(String text) {
        char[] original = new char[text.length()];
        int mid = (text.length() + 1) / 2;
        int i = 0, j = mid, k = 0;

        while (i < mid || j < text.length()) {
            if (i < mid) original[k++] = text.charAt(i++);
            if (j < text.length()) original[k++] = text.charAt(j++);
        }
        return new String(original);
    }

    // Process file for encoding
    public void encodeFile() {
        processFile(true);
    }

    // Process file for decoding
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
