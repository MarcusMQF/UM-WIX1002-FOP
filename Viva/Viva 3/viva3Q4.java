import java.io.*;
import java.util.ArrayList;

class Exhibit {
    String title, artist, year, type, description;

    Exhibit(String title, String artist, String year, String type, String description) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.type = type;
        this.description = description;
    }

    void getDetails() {
        System.out.println("Title: " + title);
        System.out.println("Artist: " + artist);
        System.out.println("Year: " + year);
        System.out.println("Type: " + type);
        System.out.println("Description: " + description);
        System.out.println(); // Empty line for spacing
    }
}

class Museum {
    private ArrayList<Exhibit> exhibits;

    Museum() {
        exhibits = new ArrayList<>();
    }

    void loadExhibits(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 5) {
                    exhibits.add(new Exhibit(parts[0], parts[1], parts[2], parts[3], parts[4]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    void searchExhibitsByArtist(String artist) {
        for (Exhibit exhibit : exhibits) {
            if (exhibit.artist.equals(artist)) {
                exhibit.getDetails();
            }
        }
    }

    void searchExhibitsByType(String type) {
        for (Exhibit exhibit : exhibits) {
            if (exhibit.type.equals(type)) {
                exhibit.getDetails();
            }
        }
    }

    void searchExhibitsByYear(int year) {
        for (Exhibit exhibit : exhibits) {
            if (exhibit.year.equals(String.valueOf(year))) {
                exhibit.getDetails();
            }
        }
    }

    void viewAllExhibits() {
        for (Exhibit exhibit : exhibits) {
            exhibit.getDetails();
        }
    }
}

public class viva3Q4 {
    public static void main(String[] args) {
        Museum museum = new Museum();
        museum.loadExhibits("Viva 3/Exhibits.txt");

        System.out.println("All exhibits:");
        museum.viewAllExhibits();

        System.out.println("\nSearch exhibits by artist 'Vincent van Gogh':");
        museum.searchExhibitsByArtist("Vincent van Gogh");

        System.out.println("\nSearch exhibits by type 'Painting':");
        museum.searchExhibitsByType("Painting");

        System.out.println("\nSearch exhibits by year '1504':");
        museum.searchExhibitsByYear(1504);
    }
}
