import java.util.Scanner;

public class L5Q6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows for the Pascal Triangle: ");
        int numRows = scanner.nextInt();

        int[][] pascalTriangle = generatePascalTriangle(numRows);
        printPascalTriangle(pascalTriangle);

        scanner.close();
    }

    public static int[][] generatePascalTriangle(int numRows) {
        int[][] triangle = new int[numRows][numRows];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    triangle[i][j] = 1;
                } else {
                    triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
                }
            }
        }

        return triangle;
    }

    public static void printPascalTriangle(int[][] triangle) {
        for (int[] row : triangle) {
            for (int value : row) {
                if (value != 0) {
                    System.out.print(value + " ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
