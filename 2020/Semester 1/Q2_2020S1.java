import java.util.Scanner;

public class Q2_2020S1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt for Location 1
        System.out.println("Enter Location 1");

        // Latitude for Location 1
        char latDirection1 = getValidDirection(sc, "Enter Direction: [N, S, E, W]: ");
        System.out.print("Enter Degree, Minute, and Second: ");
        double latDegree1 = sc.nextDouble();
        double latMinutes1 = sc.nextDouble();
        double latSeconds1 = sc.nextDouble();

        // Longitude for Location 1
        char lonDirection1 = getValidDirection(sc, "Enter Direction: [N, S, E, W]: ");
        System.out.print("Enter Degree, Minute, and Second: ");
        double lonDegree1 = sc.nextDouble();
        double lonMinutes1 = sc.nextDouble();
        double lonSeconds1 = sc.nextDouble();

        // Prompt for Location 2
        System.out.println("Enter Location 2");

        // Latitude for Location 2
        char latDirection2 = getValidDirection(sc, "Enter Direction: [N, S, E, W]: ");
        System.out.print("Enter Degree, Minute, and Second: ");
        double latDegree2 = sc.nextDouble();
        double latMinutes2 = sc.nextDouble();
        double latSeconds2 = sc.nextDouble();

        // Longitude for Location 2
        char lonDirection2 = getValidDirection(sc, "Enter Direction: [N, S, E, W]: ");
        System.out.print("Enter Degree, Minute, and Second: ");
        double lonDegree2 = sc.nextDouble();
        double lonMinutes2 = sc.nextDouble();
        double lonSeconds2 = sc.nextDouble();

        // Convert to decimal degrees
        double lat1 = decimalDegreeConversion(latDirection1, latDegree1, latMinutes1, latSeconds1);
        double lon1 = decimalDegreeConversion(lonDirection1, lonDegree1, lonMinutes1, lonSeconds1);
        double lat2 = decimalDegreeConversion(latDirection2, latDegree2, latMinutes2, latSeconds2);
        double lon2 = decimalDegreeConversion(lonDirection2, lonDegree2, lonMinutes2, lonSeconds2);

        // Calculate the distance
        double distance = haversine(lat1, lon1, lat2, lon2);

        // Display the results
        System.out.printf("Location 1: %.6f Latitude%n", lat1);
        System.out.printf("%.6f Longitude%n", lon1);
        System.out.printf("Location 2: %.6f Latitude%n", lat2);
        System.out.printf("%.6f Longitude%n", lon2);
        System.out.printf("Distance: %.2f KM%n", distance);

        sc.close();
    }

    // Method to validate and prompt for direction input
    public static char getValidDirection(Scanner sc, String prompt) {
        char direction;
        while (true) {
            System.out.print(prompt);
            direction = sc.next().toUpperCase().charAt(0);
            if (direction == 'N' || direction == 'S' || direction == 'E' || direction == 'W') {
                break;
            } else {
                System.out.println("Invalid direction. Please enter N, S, E, or W.");
            }
        }
        return direction;
    }

    // Method to convert to decimal degrees
    public static double decimalDegreeConversion(char direction, double degree, double minutes, double seconds) {
        double decimalDegree = degree + (minutes / 60) + (seconds / 3600);
        if (direction == 'S' || direction == 'W') {
            decimalDegree = -decimalDegree;
        }
        return decimalDegree;
    }

    // Method to calculate distance using the Haversine formula
    public static double haversine(double lat1, double lon1, double lat2, double lon2) {
        double dlat = Math.toRadians(lat2 - lat1);
        double dlon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double a = Math.pow(Math.sin(dlat / 2), 2) +
                   Math.pow(Math.sin(dlon / 2), 2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double r = 6371; // Radius of Earth in kilometers (given)
        return c * r;
    }
}
