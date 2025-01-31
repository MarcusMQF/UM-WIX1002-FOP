import java.io.*;

public class Q5_2024S1 {
    public static void main(String[] args) {
        // Define the file paths
        String inputFilePath = "participants.txt";
        String outputFilePath = "grouping.txt";

        // Create a 4x4 array to store participant information
        String[][] participants = new String[4][4];
        int participantCount = 0;

        // Declare reader and writer outside the try block
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            // Initialize reader and writer
            reader = new BufferedReader(new FileReader(inputFilePath));
            writer = new BufferedWriter(new FileWriter(outputFilePath));

            // Read the file line by line
            String line;
            while ((line = reader.readLine()) != null && participantCount < 4) {
                String[] parts = line.split(",");

                // Trim and store each part in the array
                for (int i = 0; i < 4; i++) {
                    participants[participantCount][i] = parts[i].trim();
                }

                participantCount++;
            }

            // Compare addresses to form pairs
            boolean[] paired = new boolean[4];
            String[] seats = {"A", "B", "C", "D"};
            String[] seatingArrangement = new String[4]; // To store the final seating arrangement
            int pairCount = 0; // To track the number of pairs

            for (int i = 0; i < 4; i++) {
                if (!paired[i]) { // Check if participants[i] is not already paired
                    for (int j = i + 1; j < 4; j++) {
                        if (!paired[j] && isSameAddress(participants[i][3], participants[j][3]) &&
                            !participants[i][1].equals(participants[j][1])) { // Check for different genders
                            paired[i] = true;
                            paired[j] = true;

                            // Write the pair to the file
                            pairCount++;
                            writer.write("Pair " + pairCount + ": " + participants[i][0] + " (" + participants[i][1] + ", " + participants[i][2] +
                                    ") and " + participants[j][0] + " (" + participants[j][1] + ", " + participants[j][2] + ")");
                            writer.newLine();

                            // Assign seats facing each other (A-C or B-D)
                            if (pairCount == 1) {
                                seatingArrangement[0] = participants[i][0] + ", " + participants[i][2] + " years old";
                                seatingArrangement[2] = participants[j][0] + ", " + participants[j][2] + " years old";
                            } else if (pairCount == 2) {
                                seatingArrangement[1] = participants[i][0] + ", " + participants[i][2] + " years old";
                                seatingArrangement[3] = participants[j][0] + ", " + participants[j][2] + " years old";
                            }
                        }
                    }
                }
            }

            // Write the seating arrangement to the file
            writer.newLine();
            writer.write("Seating Arrangement:");
            writer.newLine();
            for (int i = 0; i < 4; i++) {
                writer.write("Seat " + seats[i] + ": " + seatingArrangement[i]);
                writer.newLine();
            }

        } catch (FileNotFoundException e) {
            // Handle the case where the file is not found
            System.out.println("File not found");
        } catch (IOException e) {
            // Handle the case where an I/O exception occurs
            System.out.println("An error occurred while reading or writing the file");
        } finally {
            // Close the reader and writer
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("An error occurred while closing the reader");
            }

            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("An error occurred while closing the writer");
            }
        }

        // Print the participant information
        for (int i = 0; i < participantCount; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(participants[i][j] + "\t"); // Formatting the output
            }
            System.out.println();
        }
    }

    // Helper method to compare addresses
    public static boolean isSameAddress(String address1, String address2) {
        // Normalize addresses by removing extra spaces and converting to lowercase
        String normalizedAddress1 = address1.replaceAll("\\s+", "").toLowerCase();
        String normalizedAddress2 = address2.replaceAll("\\s+", "").toLowerCase();
        return normalizedAddress1.equals(normalizedAddress2);
    }
}