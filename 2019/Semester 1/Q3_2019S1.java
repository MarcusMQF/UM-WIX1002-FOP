import java.util.Scanner;

public class Q3_2019S1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter genome string [quit to stop]: ");
            String genome = scanner.nextLine();

            // Exit if the user enters "quit"
            if (genome.equalsIgnoreCase("quit")) {
                break;
            }

            // Find and display genes
            boolean geneFound = false;
            int startIndex = 0;

            while (true) {
                // Find the start triplet "ATG"
                startIndex = genome.indexOf("ATG", startIndex);
                if (startIndex == -1) {
                    break; // No more "ATG" found
                }

                // Search for end triplets after "ATG"
                int endIndex = -1;
                String[] endTriplets = {"TAG", "TAA", "TGA"};
                for (String triplet : endTriplets) {
                    int tempIndex = genome.indexOf(triplet, startIndex + 3);
                    if (tempIndex != -1 && (endIndex == -1 || tempIndex < endIndex)) {
                        endIndex = tempIndex;
                    }
                }

                if (endIndex == -1) {
                    break; // No end triplet found
                }

                // Extract the gene
                String gene = genome.substring(startIndex + 3, endIndex);

                // Check if the gene is valid
                if (gene.length() % 3 == 0 && !containsInvalidTriplet(gene)) {
                    System.out.println(gene);
                    geneFound = true;
                }

                // Move the startIndex to continue searching
                startIndex = endIndex + 3;
            }

            if (!geneFound) {
                System.out.println("No gene is found");
            }
        }

        scanner.close();
    }

    // Helper method to check if the gene contains invalid triplets
    private static boolean containsInvalidTriplet(String gene) {
        String[] invalidTriplets = {"ATG", "TAG", "TAA", "TGA"};
        for (String triplet : invalidTriplets) {
            if (gene.contains(triplet)) {
                return true;
            }
        }
        return false;
    }
}
