/*

// Assuming we have String[] sentence already defined
String[] reversed = new String[sentence.length];

// Reverse array order and each string
for (int i = 0; i < sentence.length; i++) {
    // Get string from end of original array
    String word = sentence[sentence.length - 1 - i];
    
    // Reverse the string itself
    StringBuilder sb = new StringBuilder(word);
    reversed[i] = sb.reverse().toString();
}

// Display the reversed array
for (String word : reversed) {
    System.out.println(word);
}

 */

public class T5Q5{
    public static void main(String[] args) {
        String[] sentences = {"Hello World"};
        String[] reversed = new String[sentences.length];

        for(int i = 0; i < sentences.length; i++){
            String word = sentences[sentences.length - 1 - i];
            StringBuilder sb = new StringBuilder(word);
            reversed[i] = sb.reverse().toString();
        }

        for(String word : reversed){
            System.out.println(word);
        }
    }
}

// In case to reverse the order of the words in the sentence:
/*
public class T5Q5 {
    public static void main(String[] args) {
        // Test sentence
        String sentence = "Hello World";
        
        // Split sentence into words
        String[] words = sentence.split(" ");
        
        // Create array for reversed order
        String[] reversed = new String[words.length];
        
        // Reverse word order
        for(int i = 0; i < words.length; i++) {
            reversed[i] = words[words.length - 1 - i];
        }
        
        // Join and print reversed sentence
        String result = String.join(" ", reversed); // combine words with spaces
        System.out.println("Original: " + sentence);
        System.out.println("Reversed: " + result);
    }
}
*/
