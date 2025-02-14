public class L6Q6 {
    // Method to check if a number is prime
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
    
    // Method to reverse a number
    public static int reverseNumber(int num) {
        int reversed = 0;
        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return reversed;
    }
    
    // Method to check if a number is palindrome 
    public static boolean isPalindrome(int num) {
        return num == reverseNumber(num);
    }
    
    // Method to check if a number is palindromic prime
    public static boolean isPalindromicPrime(int num) {
        return isPrime(num) && isPalindrome(num);
    }
    
    // Method to check if a number is emirp
    public static boolean isEmirp(int num) {
        if (isPalindrome(num)) return false;  // Emirp cannot be palindromic
        return isPrime(num) && isPrime(reverseNumber(num));
    }
    
    public static void main(String[] args) {
        System.out.println("First 20 Palindromic Primes:");
        int count = 0;
        int num = 2;
        while (count < 20) {
            if (isPalindromicPrime(num)) {
                System.out.print(num + " ");
                count++;
            }
            num++;
        }
        
        System.out.println("\n\nFirst 20 Emirps:");
        count = 0;
        num = 2;
        while (count < 20) {
            if (isEmirp(num)) {
                System.out.print(num + " ");
                count++;
            }
            num++;
        }
    }
}
