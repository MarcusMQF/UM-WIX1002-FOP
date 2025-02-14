import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.*;

public class Q3_2024S1 {
    public static void main(String[] args) {
        String csvPath = "oaiset.csv";
        OAIRecord[] data = new OAIRecord[50];

        System.out.println("Loading Dataset...");
        loadData(csvPath, data);

        // Clean the data and store the result
        OAIRecord[] cleanedData = cleanedData(data);

        System.out.println("The curated record is as follow: ");
        printRecord(cleanedData);

        printSummary(cleanedData);
    }

    public static OAIRecord[] loadData(String csvPath, OAIRecord[] data){

        try(Scanner scanner = new Scanner(new FileInputStream(csvPath))){
            scanner.nextLine(); // Skip header
            int i = 0;
            
            while(scanner.hasNextLine()){
                // Store each line of the csv file into an OAIRecord object
                String line[] = scanner.nextLine().split(",");
                data[i] = new OAIRecord(line[0], line[1], Arrays.copyOfRange(line, 3, line.length - 2), line[line.length - 2], line[line.length - 1]);
                i++;
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found.");
        }

        return data;
    }

    public static OAIRecord[] cleanedData(OAIRecord[] data){
        OAIRecord[] cleanedData = new OAIRecord[data.length];
        int count = 0;

        for(OAIRecord records : data){
            if(records != null && !records.getStatus().equals("deleted")){
                cleanedData[count++] = records;
            }
        }

        // Resize the cleanedData array to remove null elements
        return Arrays.copyOf(cleanedData, count);
    }

    public static void printRecord(OAIRecord[] records) {
        int recordNumber = 1;
        for (OAIRecord record : records) {
            if(record != null){
                System.out.println("Record #" + recordNumber + " " + record);
                recordNumber++;
            }
        }
    }

    public static void printSummary(OAIRecord[] cleanedData){
        HashMap<String, Integer> authorCount = new HashMap<>();

        for(OAIRecord record: cleanedData){
            for(String author: record.getAuthors()){
                if (!author.isEmpty()) { // Skip empty authors
                    authorCount.put(author, authorCount.getOrDefault(author, 0) + 1);
                }
            }
        }

        // Print the frequency distribution table of authors
        System.out.println("\nThe summary report is as follow: ");
        for(Map.Entry<String, Integer> entry: authorCount.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue() + " publications");
        }
    }
}

class OAIRecord {
    String doi;
    String title;
    String[] authors;
    String keyword;
    String status;

    public OAIRecord(String doi, String title, String[] authors, String keyword, String status){
        this.doi = doi;
        this.title = title;
        this.authors = authors;
        this.keyword = keyword;
        this.status = status;
    } 
    
    public String getStatus(){
        return status;
    }

    public String[] getAuthors(){
        return authors;
    }

    // Helper method to format authors without square brackets
    private String formatAuthors() {
        return "{" + String.join(", ", authors) + "}";
    }

    @Override
    public String toString(){
        return " DOI: " + doi + "  \"" + title + "\"  " + formatAuthors() + "  Keyword: " + keyword + "  Status: " + status;
    }
}
