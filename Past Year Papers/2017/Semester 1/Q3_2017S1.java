import java.io.*;
import java.util.Random;

public class Q3_2017S1 {
    public static void main(String[] args) {
        String fileName = "data.txt";
        char[] randomString = generateRandomString(6);
        
        System.out.println("The string generated is: " + new String(randomString));

        // Write the string to a file using BufferedWriter
        writeToFile(fileName, randomString);

        // Read the original string from file
        char[] originalString = readFromFile(fileName);
        if (originalString == null) return;

        // Sort in ascending order
        char[] ascendingSorted = bubbleSort(originalString.clone(), '>');
        System.out.println("String sorted in ascending order: " + new String(ascendingSorted));

        // Sort in descending order
        char[] descendingSorted = bubbleSort(originalString.clone(), '<');
        System.out.println("String sorted in descending order: " + new String(descendingSorted));

        // Display original string from file
        System.out.println("Original string from file: " + new String(originalString));
    }

    // Generate a random string of given length from the allowed ASCII characters
    public static char[] generateRandomString(int length) {
        Random rand = new Random();
        char[] str = new char[length];

        for (int i = 0; i < length; i++) {
            if (rand.nextBoolean()) {
                str[i] = (char) (rand.nextInt(26) + 65); // Uppercase A-Z (ASCII 65-90)
            } else {
                str[i] = (char) (rand.nextInt(26) + 97); // Lowercase a-z (ASCII 97-122)
            }
        }
        return str;
    }

    public static char[] bubbleSort(char[] array, char order) {
        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if ((order == '>' && array[j] > array[j + 1]) || (order == '<' && array[j] < array[j + 1])) {
                    // Swap elements
                    char temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // Stop if already sorted
        }
        return array;
    }

    // Write a character array to a file using BufferedWriter
    public static void writeToFile(String fileName, char[] data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(data);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Read the original string from the file
    public static char[] readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            return reader.readLine().toCharArray();
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
            return null;
        }
    }
}

