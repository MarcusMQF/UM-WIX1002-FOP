import java.util.Scanner;

public class Q5_2019S2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter values for a, b and c: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        
        QuadraticEquation calc = new QuadraticEquation(a, b, c);
        
        System.out.printf("The equation is: %dx(^2)+(%d)x+(%d)", a, b, c);
        double discriminant = calc.Discriminant();
        
        System.out.println("\nDiscriminant: " + discriminant);
        
        if(discriminant == 0){
            double root1 =  calc.calcRoot1(); //Both root are the same
            System.out.println("Same roots: " + root1);
        }else if(discriminant < 0){
            System.out.println("The equation has no roots");
        }else if(discriminant > 0){
            double root1 = calc.calcRoot1();
            double root2 = calc.calcRoot2();
            System.out.println("The roots: " + root1 + "and" + root2);
        }

        scanner.close();
    }
}

class QuadraticEquation {
    private int a, b, c;
    
    public QuadraticEquation(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public int getA(){
        return a;
    }
    
    public int getB(){
        return b;
    }
    
    public int getC(){
        return c;
    }
    
    public double Discriminant(){
        return Math.pow(b, 2) - (4*a*c);
    }
    
    public double calcRoot1(){
        double discriminant = Discriminant();
        
        return (-b + Math.sqrt(discriminant)) / (2 * a);
    }
    
    public double calcRoot2(){
        double discriminant = Discriminant();
        
        return (-b - Math.sqrt(discriminant)) / (2 * a);
    }
}
