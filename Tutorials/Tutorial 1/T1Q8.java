import java.util.Scanner;

public class T1Q8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countU = 0;
        int countM = 0;

        System.out.print("Enter a sentences: ");
        String sentence = scanner.nextLine();

        sentence = sentence.toUpperCase();

        for(int i = 0; i < sentence.length(); i++){
            if(sentence.charAt(i) == 'U'){
                countU++;
            }
            if(sentence.charAt(i) == 'M'){
                countM++;
            }
        }

        System.out.println("The sentences have " + countU + " U");
        System.out.println("The sentences have " + countM + " M");
        scanner.close();
    }
}