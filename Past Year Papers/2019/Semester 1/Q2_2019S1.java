import java.util.Scanner;
import java.util.Random;

public class Q2_2019S1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        System.out.print("Enter N: ");
        int n = scanner.nextInt();
        
        int[][] MatrixA = new int[n][n];
        int[][] MatrixB = new int[n][n];
        
        /*
        int MIN = -9;
                int MAX = 9;
                MatrixA[i][j] = random.nextInt((MAX - MIN) + 1) + MIN;
        */
        
        // Generate matrix
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                MatrixA[i][j] = random.nextInt(10);
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                MatrixB[i][j] = random.nextInt(10);
            }
        }
        
        // Display matrix
        
        System.out.println("Matrix A: ");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(MatrixA[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println();
        
        System.out.println("Matrix B: ");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(MatrixB[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println();
        
        // Add two matrix
        System.out.println("Matrix A + Matrix B: ");
        int[][] result = AddTwoMatrices(MatrixA, MatrixB);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println();
        
        // Multiply two matrix
        System.out.println("Matrix A * Matrix B: ");
        int[][] result2 = MultiplyTwoMatrices(MatrixA, MatrixB);
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(result2[i][j] + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
    
    public static int[][] AddTwoMatrices(int[][] a, int[][] b){
        int[][] result = new int[a.length][b[0].length]; // Size column of MatrixB of its first row
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < b[0].length; j++){
                result[i][j] = a[i][j] + b[i][j];
            }
        }
            
        return result;
    }
    
    public static int[][] MultiplyTwoMatrices(int[][] a, int[][] b){
        int[][] result2 = new int[a.length][b[0].length]; // Size column of MatrixB of its first row
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < b[0].length; j++){
                for(int k = 0; k < a[0].length; k++){
                    result2[i][j] = result2[i][j] + (a[i][k] * b[k][j]);
                }
            }
        }
            
        return result2;
    }
}
