import java.io.*;
import java.util.*;

public class L10Q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get appointment details from user
        System.out.print("Enter day: ");
        String day = scanner.next();
        System.out.print("Enter month: ");
        String month = scanner.next();
        System.out.print("Enter year: ");
        String year = scanner.next();
        System.out.print("Enter start time (hour): ");
        int startTime = scanner.nextInt();
        System.out.print("Enter end time (hour): ");
        int endTime = scanner.nextInt();

        // Create Appointment object
        Appointment appointment = new Appointment(day, month, year, startTime, endTime);
        String dateStartTime = String.format("%s-%s-%s %02d:00", day, month, year, startTime);
        String dateEndTime = String.format("%s-%s-%s %02d:00", day, month, year, endTime);

        // Check if slot is available
        if (appointment.search(dateStartTime, dateEndTime)) {
            appointment.saveAppointment();
        } else {
            System.out.println("Appointment slot is already booked!");
        }

        scanner.close();
    }
}

// Interface for searching available appointment slots
interface Searchable {
    boolean search(String dateStartTime, String dateEndTime);
}

// Appointment class implementing Searchable interface
class Appointment implements Searchable {
    private String day, month, year;
    private int startTime, endTime;
    private static final String FILE_NAME = "appointments.txt"; // File for storing appointments

    public Appointment(String day, String month, String year, int startTime, int endTime) {
        this.day = day;
        this.month = month;
        this.year = year;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // Format appointment details
    private String getFormattedAppointment() {
        return String.format("%s-%s-%s %02d:00-%02d:00", day, month, year, startTime, endTime);
    }

    // Save appointment to file
    public void saveAppointment() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(getFormattedAppointment());
            writer.newLine();
            System.out.println("Appointment saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving appointment: " + e.getMessage());
        }
    }

    // Search method to check if appointment slot is available
    @Override
    public boolean search(String dateStartTime, String dateEndTime) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    String existingStartTime = parts[0];
                    String existingEndTime = parts[1];

                    // If appointment overlaps with existing one, return false
                    if (dateStartTime.equals(existingStartTime) || dateEndTime.equals(existingEndTime)) {
                        return false;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return true;
    }
}
