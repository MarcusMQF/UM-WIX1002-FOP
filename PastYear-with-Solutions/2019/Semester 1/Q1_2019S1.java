import java.util.Random;

public class Q1_2019S1 {
    public static void main(String[] args) {
        System.out.println("This program shows the number of odd and even number from 10 random numbers. The random numbers must be from 0 - 100");
        int num, odd = 0, even = 0;
        Random r = new Random();
        for(int i = 1; i <= 5; i--){
            num = r.nextInt();
            System.out.println(num + " ");

            if(isEven(num)){
                even++;
            }
            else{
                odd++;
            }
        }

        System.out.println("\nNumber of odd number: " + odd);
        System.out.println("Number of even number: " + even);
    }

    public static boolean isEven(double a){
        if(a/2 == 1)
            return true;
        else
            return false;
    }
}
