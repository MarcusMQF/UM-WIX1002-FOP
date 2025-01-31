import java.util.Random;

public class Q4_2024S1 {
    public static void main(String[] args) {
        // Initialize the seating plan
        int[][] seatingPlan = initializeSeatingPlan();

        // Analyze the seating plan
        analyzeSeating(seatingPlan);

        printSeatingPlan(seatingPlan);
    }

    // Method to initialize the seating plan
    public static int[][] initializeSeatingPlan() {
        Random random = new Random();
        int m = 5; // Number of rows (example value)
        int n = 5; // Number of columns (example value)
        int[][] seatingPlan = new int[m][n];

        // Fill the seating plan with random values (0 or 1)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                seatingPlan[i][j] = random.nextInt(2); // 0 or 1
            }
        }

        return seatingPlan;
    }

    public static void analyzeSeating(int[][] seatingPlan) {
        int totalOccupied = 0;
        int maxOccupiedRow = 0;
        int maxOccupiedCount = 0;

        // Iterate through the seating plan
        for (int i = 0; i < seatingPlan.length; i++) {
            int rowOccupied = 0;

            for (int j = 0; j < seatingPlan[i].length; j++) {
                if (seatingPlan[i][j] == 1) {
                    totalOccupied++;
                    rowOccupied++;
                }
            }

            // Check if this row has the maximum occupied seats
            if (rowOccupied > maxOccupiedCount) {
                maxOccupiedCount = rowOccupied;
                maxOccupiedRow = i;
            }
        }

        // Print the results
        System.out.println("Total occupied seats: " + totalOccupied);
        System.out.println("Row with the most occupied seats: Row " + (maxOccupiedRow + 1) + " with " + maxOccupiedCount + " seats.");
    }

    public static void printSeatingPlan(int[][] seatingPlan) {
        for (int i = 0; i < seatingPlan.length; i++) {
            for (int j = 0; j < seatingPlan[i].length; j++) {
                System.out.print(seatingPlan[i][j] + " ");
            }
            System.out.println(); // Move to the next line after each row
        }
    }
}
