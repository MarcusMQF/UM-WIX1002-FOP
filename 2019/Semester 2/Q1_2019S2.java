//import java.util.Scanner; // no use

public class Q1_2019S2 {
    public static void main(String[] args) {
        int[] num = {66, 15, 20, 27, 74, 33};
        int cnt = 0;
        
        for(int k = 0; k < num.length; k++){
            if(isEven(k))
                cnt++;
        }
        
        System.out.println("The num of even integers is " + cnt);
        System.out.println("The biggest integer is " + findMax(num));
    }
    
    public static boolean isEven(int a){
        return (a % 2 == 0);
    }
    
    public static int findMax(int[] a){
        int max = a[0];
        for(int n = 0; n < a.length; n++){
            if(a[n] > max){
                max = a[n];
            }
        }
        return max;
    }
}