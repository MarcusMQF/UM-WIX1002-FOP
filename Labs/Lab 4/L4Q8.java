import java.util.ArrayList;
import java.util.Random;

public class L4Q8 {
    public static void main(String[] args){
        // Generate a random integer n between 0 and 100
        Random rand = new Random();
        int n = rand.nextInt(101);
        
        // Generate the first n prime numbers
        ArrayList<Integer> primes = generateFirstNPrimes(n);
        
        // Print the prime numbers
        System.out.println("The first " + n + " prime numbers are:");
        for(int prime : primes){
            System.out.print(prime + " ");
        }
    }
    
    public static ArrayList<Integer> generateFirstNPrimes(int n){
        ArrayList<Integer> primes = new ArrayList<>();
        int num = 2;
        
        while(primes.size() < n){
            if(isPrime(num)){
                primes.add(num);
            }
            num++;
        }
        
        return primes;
    }
    
    public static boolean isPrime(int num){
        if(num <= 1){
            return false;
        }
        
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        
        return true;
    }
}