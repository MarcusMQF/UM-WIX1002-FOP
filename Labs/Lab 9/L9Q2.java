import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class L9Q2 {
    public static void main(String[] args) {
        // Create a Student object
        Student student = new Student("John Doe", "Male", "1995-05-15", "course.txt");
        // Display student profile and course details
        student.display();
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

class Student extends PersonProfile {
    private String fileName;
    private List<Course> courses;

    // Constructor
    public Student(String name, String gender, String dateOfBirth, String fileName) {
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
                int mark = Integer.parseInt(scanner.nextLine().trim());

                courseList.add(new Course(courseCode, courseName, year, semester, mark));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }
        return courseList;
    }

    // Calculate grade based on mark
    private String getGrade(int mark) {
        if (mark >= 85) return "A";
        else if (mark >= 75) return "A-";
        else if (mark >= 70) return "B+";
        else if (mark >= 65) return "B";
        else if (mark >= 60) return "B-";
        else if (mark >= 55) return "C+";
        else if (mark >= 50) return "C";
        else if (mark >= 45) return "D";
        else if (mark >= 35) return "E";
        else return "F";
    }

    // Override display method to include course details
    @Override
    public void display() {
        super.display();
        System.out.println("\nCourse Details:");
        for (Course course : courses) {
            System.out.println("Course Code: " + course.courseCode);
            System.out.println("Course Name: " + course.courseName);
            System.out.println("Year: " + course.year);
            System.out.println("Semester: " + course.semester);
            System.out.println("Mark: " + course.mark);
            System.out.println("Grade: " + getGrade(course.mark));
            System.out.println("------------------------------");
        }
    }

    // Inner class to represent a course
    private static class Course {
        String courseCode;
        String courseName;
        int year;
        int semester;
        int mark;

        public Course(String courseCode, String courseName, int year, int semester, int mark) {
            this.courseCode = courseCode;
            this.courseName = courseName;
            this.year = year;
            this.semester = semester;
            this.mark = mark;
        }
    }
}
