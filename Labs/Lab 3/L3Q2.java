import java.util.Random;

public class L3Q2 {
    public static void main(String[] args) {
        Random random = new Random();
        int GeneratedNum = random.nextInt(5);

        switch (GeneratedNum) {
            case 0:
                System.out.println("0 is zero.");
                break;
            case 1:
                System.out.println("1 is one.");
                break;
            
            case 2:
                System.out.println("2 is two.");
                break;
            
            case 3:
                System.out.println("3 is three.");
                break;
            case 4:
                System.out.println("4 is four.");
                break;

            case 5:
                System.out.println("5 is five.");
                break;
        }
    }
}
