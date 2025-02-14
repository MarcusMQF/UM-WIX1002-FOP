import java.util.Scanner;

public class Q3_2018S1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter font size: ");
        int fontSize = scanner.nextInt();

        System.out.print("Enter font type: ");
        char fontType = scanner.next().charAt(0);

        System.out.print("Enter format (1 - Vertical, 2 - Horizontal): ");
        int format = scanner.nextInt();

        if(format == 1){
            printVertical(fontSize, fontType);
        }else if(format == 2){
            printHorizontal(fontSize, fontType);
        }

        scanner.close();
    }

    public static void printVertical(int fontSize, char fontType){
        int height = (2*fontSize) + 3;
        int width = fontSize + 2;

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(i == 0 || i == height/2 || i == height - 1){
                    System.out.print(fontType);
                }else if(j == 0 || j == width - 1){
                    System.out.print(fontType);
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void printHorizontal(int fontSize, char fontType) {
        int height = fontSize + 2;
        int width = (2 * fontSize) + 3;
    
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || i == height - 1) {
                    System.out.print(fontType);
                } else if (j == 0 || j == width/2 || j == width - 1) {
                    System.out.print(fontType);
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
