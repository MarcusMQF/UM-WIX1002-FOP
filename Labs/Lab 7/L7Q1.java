import java.io.*;
import java.util.Scanner;

public class L7Q1 {
    public static void main(String[] args) {
        try {
            // Write the course information to a binary file
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("coursename.dat"));
            out.writeObject(new String[] {"WXES1116", "Programming I"});
            out.writeObject(new String[] {"WXES1115", "Data Structure"});
            out.writeObject(new String[] {"WXES1110", "Operating System"});
            out.writeObject(new String[] {"WXES1112", "Computing Mathematics I"});
            out.close();

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a course code: ");
            String courseCode = scanner.nextLine();

            ObjectInputStream in = new ObjectInputStream(new FileInputStream("coursename.dat"));
            boolean found = false;
            while (true) {
                try {
                    String[] courseInfo = (String[]) in.readObject();
                    if (courseInfo[0].equals(courseCode)) {
                        System.out.println("The course name for " + courseCode + " is: " + courseInfo[1]);
                        found = true;
                        break;
                    }
                } catch (EOFException e) {
                    break;
                }
            }
            in.close();
            scanner.close();

            if (!found) {
                System.out.println("Course code not found in the file.");
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}