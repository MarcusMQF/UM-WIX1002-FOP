public class L5Q4 {
    public static void main(String[] args) {
        int matrix[][] = {
            {1, 5, 7},
            {3, 6, 9},
            {5, 3, 8}
        };

        System.out.println("The original matrix: ");
        printMatrix(matrix);

        int[][] rotatedMatrix = rotateMatrix(matrix);

        System.out.println("The rotated matrix: ");
        printMatrix(rotatedMatrix);
    }

    public static void printMatrix(int[][] matrix){
        for(int[] row : matrix){
            for(int value : row){
                System.out.print(value + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[][] rotateMatrix(int[][] matrix){
        int n = matrix.length;
        int[][] rotated = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - 1 - i] = matrix[i][j];
            }
        }

        return rotated;
    }
}
