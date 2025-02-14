import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class T1Q9 {
    public static void main(String[] args) {
        String webUrl = "https://www.chess.com/home";
        String keyword = "Play";
        int count = 0;
        
        try {
            // Create URL and open connection
            URL url = new URL(webUrl);
            BufferedReader reader = new BufferedReader(
                new InputStreamReader(url.openStream())
            );
            
            String line;
            // Read each line and count keyword
            while ((line = reader.readLine()) != null) {
                // Convert to lowercase for case-insensitive search
                line = line.toLowerCase();
                
                // Split line into words and count matches
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.contains(keyword)) {
                        count++;
                    }
                }
            }
            reader.close();
            
            // Display results
            System.out.println("Keyword: " + keyword);
            System.out.println("Frequency: " + count);
            
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

// Display the frequency of a keyword from a web page.