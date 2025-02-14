import java.io.*;
import java.io.FileReader;

public class Q4_2016S1 {
    public static void main(String[] args) {
        
        String inputFile = "Q4.txt";
        
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))){
            String line;

            while((line = reader.readLine()) != null){
                String password = line;
                checkPassword(password);
            }
            
        }catch(IOException e){
            e.printStackTrace();
            
        }
    }
        
    public static void checkPassword(String password) {
    int charCount = password.length();
    int upperCount = 0, lowerCount = 0, digitCount = 0, nonAlphanumericCount = 0;

    // Loop through each character in the password
    for (char ch : password.toCharArray()) {
        if (Character.isUpperCase(ch)) {
            upperCount++;
        } else if (Character.isLowerCase(ch)) {
            lowerCount++;
        } else if (Character.isDigit(ch)) {
            digitCount++;
        } else if (!Character.isWhitespace(ch) && !Character.isLetterOrDigit(ch)) {
            nonAlphanumericCount++;
        }
    }

    // Check if password meets all the criteria
    if (charCount >= 8 && upperCount > 0 && lowerCount > 0 && digitCount > 0 && nonAlphanumericCount > 0) {
        System.out.println("Strong Password");
    } else {
        System.out.println("Not a Strong Password");
    }
}

}
