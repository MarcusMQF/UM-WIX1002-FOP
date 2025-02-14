import java.util.Scanner;

public class PS1Q1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the coordinate X and Y: ");
        int X = scanner.nextInt();
        int Y = scanner.nextInt();

        int initialX = X;
        int initialY = Y;

        int finalX, finalY;

        System.out.print("Enter the moves: ");
        String moves = scanner.next().toUpperCase();

        System.out.println("Initial Coordinate (" + initialX + ", " + initialY + ")");

        for (char move : moves.toCharArray()) {
            switch (move) {
                case 'U':
                    initialY++;
                    break;
                case 'D':
                    initialY--;
                    break;
                case 'L':
                    initialX--;
                    break;
                case 'R':
                    initialX++;
                    break;
                default:
                    System.out.println("Invalid Move: " + move);
                    break;
            }
        }

        finalX = initialX;
        finalY = initialY;

        System.out.println("Final Coordinate: (" + finalX + ", " + finalY + ")");
        scanner.close();
    }
}