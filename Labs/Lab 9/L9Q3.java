import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L9Q3 {
    public static void main(String[] args) {
        // Create a Lecturer object
        Lecturer lecturer = new Lecturer("Dr. Smith", "Female", "1980-12-25", "lecturer.txt");
        // Display lecturer profile and course details
        lecturer.display();
    }
}

class PersonProfile {
    private String name;
    private String gender;
    private String dateOfBirth;

    // Constructor
    public PersonProfile(String name, String gender, String dateOfBirth) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    // Display method
    public void display() {
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Date of Birth: " + dateOfBirth);
    }
}

class Lecturer extends PersonProfile {
    private String fileName;
    private List<Course> courses;

    // Constructor
    public Lecturer(String name, String gender, String dateOfBirth, String fileName) {
        super(name, gender, dateOfBirth);
        this.fileName = fileName;
        this.courses = loadCourses();
    }

    // Load courses from file
    private List<Course> loadCourses() {
        List<Course> courseList = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                String courseCode = scanner.nextLine().trim();
                String courseName = scanner.nextLine().trim();
                int year = Integer.parseInt(scanner.nextLine().trim());
                int semester = Integer.parseInt(scanner.nextLine().trim());
                int creditHour = Integer.parseInt(scanner.nextLine().trim());
                int numStudents = Integer.parseInt(scanner.nextLine().trim());

                courseList.add(new Course(courseCode, courseName, year, semester, creditHour, numStudents));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
        return courseList;
    }

    // Compute updated credit hour based on the number of students
    private double computeUpdatedCreditHour(int creditHour, int numStudents) {
        if (numStudents >= 150) {
            return creditHour * 3;
        } else if (numStudents >= 100) {
            return creditHour * 2;
        } else if (numStudents >= 50) {
            return creditHour * 1.5;
        } else {
            return creditHour;
        }
    }

    // Override display method to include course details
    @Override
    public void display() {
        super.display();
        System.out.println("\nCourse Details:");
        for (Course course : courses) {
            double updatedCreditHour = computeUpdatedCreditHour(course.creditHour, course.numStudents);
            System.out.println("Course Code: " + course.courseCode);
            System.out.println("Course Name: " + course.courseName);
            System.out.println("Year: " + course.year);
            System.out.println("Semester: " + course.semester);
            System.out.println("Original Credit Hour: " + course.creditHour);
            System.out.println("Number of Students: " + course.numStudents);
            System.out.println("Updated Credit Hour: " + updatedCreditHour);
            System.out.println("------------------------------");
        }
    }

    // Inner class to represent a course
    private static class Course {
        String courseCode;
        String courseName;
        int year;
        int semester;
        int creditHour;
        int numStudents;

        public Course(String courseCode, String courseName, int year, int semester, int creditHour, int numStudents) {
            this.courseCode = courseCode;
            this.courseName = courseName;
            this.year = year;
            this.semester = semester;
            this.creditHour = creditHour;
            this.numStudents = numStudents;
        }
    }
}
