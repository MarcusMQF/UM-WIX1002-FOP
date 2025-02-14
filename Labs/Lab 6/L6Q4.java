public class L6Q4 {
    public static int findGCD(int a, int b) {
        // Ensure a and b are positive
        a = Math.abs(a);
        b = Math.abs(b);
        
        // Base case: if b is 0, then GCD is a
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    public static void main(String[] args) {
        // Test case 1: GCD of 24 and 8
        int num1 = 24;
        int num2 = 8;
        System.out.println("GCD of " + num1 + " and " + num2 + " is: " + findGCD(num1, num2));
        
        // Test case 2: GCD of 200 and 625
        int num3 = 200;
        int num4 = 625;
        System.out.println("GCD of " + num3 + " and " + num4 + " is: " + findGCD(num3, num4));
    }
}
