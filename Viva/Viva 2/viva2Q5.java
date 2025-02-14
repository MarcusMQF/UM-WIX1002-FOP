public class viva2Q5 {
    public static void main(String[] args) {
        // Sample data
        String[] studentID = {"S0001", "S0002", "S0003", "S0004", "S0005", "S0006"};
        String[] studentName = {"John", "Cindy", "Alex", "Ali", "Rosli", "Roger"};
        int[] marks = {59, 62, 21, 36, 85, 74};

        // Get student information
        String[][] studentInfo = getStudentInfo(studentID, studentName, marks);

        // Print student information
        printStudentInfo(studentInfo);

        // Find and print the student with the highest marks
        String studentWithHighestMarks = findStudentWithHighestMarks(studentInfo);
        System.out.println("\nStudent with the highest marks:\n" + studentWithHighestMarks);

        // Calculate and print the average mark
        double average = findAverage(marks);
        System.out.println("\nAverage mark: " + average);

        // List students with marks below the average
        listStudentsBelowAverage(studentInfo, average);
    }

    // Method to get student information
    public static String[][] getStudentInfo(String[] studentID, String[] studentName, int[] marks) {
        String[][] studentInfo = new String[studentID.length][3];
        for (int i = 0; i < studentID.length; i++) {
            studentInfo[i][0] = studentID[i];
            studentInfo[i][1] = studentName[i];
            studentInfo[i][2] = String.valueOf(marks[i]);
        }
        return studentInfo;
    }

    // Method to print student information
    public static void printStudentInfo(String[][] studentInfo) {
        System.out.println("Student ID\tStudent Name\tMarks");
        for (String[] student : studentInfo) {
            System.out.println(student[0] + "\t\t" + student[1] + "\t\t" + student[2]);
        }
    }

    // Method to find the student with the highest marks
    public static String findStudentWithHighestMarks(String[][] studentInfo) {
        int maxMarks = Integer.MIN_VALUE;
        String studentWithHighestMarks = "";

        for (String[] student : studentInfo) {
            int marks = Integer.parseInt(student[2]);
            if (marks > maxMarks) {
                maxMarks = marks;
                studentWithHighestMarks = student[1] + " : " + marks;
            }
        }

        return studentWithHighestMarks;
    }

    // Method to calculate the average mark of all students
    public static double findAverage(int[] marks) {
        int sum = 0;
        for (int mark : marks) {
            sum += mark;
        }
        return (double) sum / marks.length;
    }

    // Method to list students with marks below the average
    public static void listStudentsBelowAverage(String[][] studentInfo, double average) {
        System.out.println("\nStudents with marks below the average:");
        for (String[] student : studentInfo) {
            int marks = Integer.parseInt(student[2]);
            if (marks < average) {
                System.out.println(student[1] + " : " + marks);
            }
        }
    }
}
