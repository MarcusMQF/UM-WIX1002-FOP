import java.util.Arrays;

public class T10Q3 {
    public static void main(String[] args) {
        // Create array of Person objects
        Person[] people = {
            new Person("John"),
            new Person("Alice"), 
            new Person("Bob"),
            new Person("Zack"),
            new Person("Mary")
        };
 
        System.out.println("Before sorting:");
        for(Person p : people) {
            p.display();
        }
 
        // Sort the array
        Arrays.sort(people);
 
        System.out.println("\nAfter sorting:");
        for(Person p : people) {
            p.display();
        }
    }
}

class Person implements Comparable<Person> {
    private String name;
 
    public Person(String name) {
        this.name = name;
    }
 
    public String getName() {
        return name;
    }
 
    public void display() {
        System.out.println("Name: " + name);
    }
 
    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }
}
