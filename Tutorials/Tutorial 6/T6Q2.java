import java.util.Scanner;
import java.util.ArrayList;

public class T6Q2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();

        System.out.print("Enter three number: ");
        for(int i = 0; i < 3; i++){
            list.add(scanner.nextInt());
        }

        // Display the list
        System.out.print("The numbers input is: ");
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        System.out.println();

        // Sort the list in descending order
        System.out.print("The numbers in descending order is: ");
        list = DescendingOrder(list);
        for(int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        scanner.close();
    }

    public static ArrayList<Integer> DescendingOrder(ArrayList<Integer> list) {
        for(int i = 0; i < list.size(); i++){
            for(int j = i + 1; j < list.size(); j++){
                if(list.get(i) < list.get(j)){
                    int temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }

        return list;
    }
}
