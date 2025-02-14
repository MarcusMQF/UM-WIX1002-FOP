public class T4Q4 {
    public static void main(String[] args) {
        String input = "Hello, World!";
        int length = input.length();
        
        // Display the string in reverse order
        for (int i = length - 1; i >= 0; i--) {
            System.out.print(input.charAt(i));
        }
        
        // Print the length of the string
        System.out.println("\nLength of the string: " + length);
    }
}
