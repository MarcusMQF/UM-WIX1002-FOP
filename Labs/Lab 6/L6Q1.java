public class L6Q1 {
    public static String getTriangularNumber(int n) {
        int sum = 0;
        StringBuilder process = new StringBuilder();
        
        for (int i = 1; i <= n; i++) {
            sum += i;
            process.append(i);
            if (i < n) {
                process.append(" + ");  
            }
        }
        process.append(" = ").append(sum);
        return process.toString();
    }
    
    public static void main(String[] args) {
        System.out.println("First 20 Triangular Numbers:");
        for (int i = 1; i <= 20; i++) {
            String calculation = getTriangularNumber(i);
            System.out.printf("T(%d) = %s\n", i, calculation);
        }
    }
}
