import java.io.*;
import java.util.*;

public class L7Q5 {
    public static void main(String[] args) {
        try (DataInputStream input = new DataInputStream(new FileInputStream("person.dat"))) {
            // Read total number of records
            int totalRecords = input.readInt();
            System.out.println("Total records: " + totalRecords);
            
            // Create list to store Person objects
            ArrayList<Person> people = new ArrayList<>();
            
            // Read each record
            for (int i = 0; i < totalRecords; i++) {
                String name = input.readUTF();      // Read name
                int age = input.readInt();          // Read age
                char gender = input.readChar();     // Read gender
                
                people.add(new Person(name, age, gender));
            }
            
            // Sort people by name
            Collections.sort(people);
            
            // Display sorted records
            System.out.println("\nRecords sorted by name:");
            System.out.println("----------------------------------------");
            for (Person p : people) {
                System.out.println(p);
            }
            
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

class Person implements Comparable<Person> {
    private String name;
    private int age;
    private char gender;
    
    public Person(String name, int age, char gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }
    
    // Implement compareTo for sorting by name
    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }
    
    @Override
    public String toString() {
        return String.format("Name: %-20s Age: %-3d Gender: %c", name, age, gender);
    }
}
