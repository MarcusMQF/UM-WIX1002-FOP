import java.util.Random;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

public class L5Q5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        ArrayList<Integer> GeneratedNums = new ArrayList<Integer>();
        boolean first = true;
        boolean firstDescending = true;

        System.out.println("A List of 20 random integer within 0 to 100");
        for(int i = 0; i < 20; i++){
            int GeneratedNum = random.nextInt(101);
            GeneratedNums.add(GeneratedNum);
            if(!first){
                System.out.print(", ");
            }
            System.out.print(GeneratedNum);
            first = false;
        }
        System.out.println();

        Collections.sort(GeneratedNums, Collections.reverseOrder());

        System.out.println("The list of numbers in descending order");
        for(int value: GeneratedNums){
            if(!firstDescending){
                System.out.print(", ");
            }
            System.out.print(value);
            firstDescending = false;
        }
        System.out.println();

        System.out.print("Enter a number to search: ");
        int search = scanner.nextInt();

        if(GeneratedNums.contains(search)){
            System.out.println("The number " + search + " is found in the list");
        }else{
            System.out.println("The number " + search + " is not found in the list");
        }

        int LinearSearch = LinearSearch(GeneratedNums, search);
        System.out.println("Linear Search Loop - " + LinearSearch);

        int BinarySearch = BinarySearch(GeneratedNums, search);
        System.out.println("Binary Search Loop - " + BinarySearch);

        scanner.close();
    }

    public static int LinearSearch(ArrayList<Integer> list, int search){
        int loop = 0;
        for(int num : list){
            loop++;
            if(num == search){
                break;
            }
        }

        return loop;
    }

    public static int BinarySearch(ArrayList<Integer> list, int search){
        int loop = 0;
        int low = 0;
        int high = list.size() - 1;
        int mid = 0;

        while(low <= high){
            loop++;
            mid = (low + high) / 2;
            if(list.get(mid) == search){
                break;
            }else if(list.get(mid) < search){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }

        return loop;
    }
}
