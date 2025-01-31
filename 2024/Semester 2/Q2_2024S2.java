import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Q2_2024S2 {

    public static void main(String[] args) {

        String directoryPath = "jobs_directory"; 

        // Folder name where job files are stored
        ArrayList<Job> jobs = readJobsFromDirectory(directoryPath);
        listAllJobs(jobs);
        generateStatistics(jobs);
    }

    public static ArrayList<Job> readJobsFromDirectory(String directoryPath) {
        ArrayList<Job> jobs = new ArrayList<>();
        File directory = new File(directoryPath);

        if (directory.isDirectory()) {  // Check if the provided path is a directory, return a boolean
            File[] files = directory.listFiles(); // List all files in the directory
            if (files != null) { // Check if the directory is empty
                for (File file : files) { // Loop through all files in the directory
                    if (file.isFile()) { // Check if the file is a file, return a boolean
                        try (Scanner scanner = new Scanner(file)) {
                            String jobName = "";
                            String partition = "";
                            String memory = "";
                            String qos = "";

                            while (scanner.hasNextLine()) {
                                String line = scanner.nextLine();
                                if (line.startsWith("JobName:")) {
                                    jobName = line.substring("JobName:".length()).trim();
                                } else if (line.startsWith("Partition:")) {
                                    partition = line.substring("Partition:".length()).trim();
                                } else if (line.startsWith("Memory:")) {
                                    memory = line.substring("Memory:".length()).trim();
                                } else if (line.startsWith("QoS:")) {
                                    qos = line.substring("QoS:".length()).trim();
                                }
                            }

                            // Add all jobs information into the list
                            if (!jobName.isEmpty() && !partition.isEmpty() && !memory.isEmpty() && !qos.isEmpty()) {
                                jobs.add(new Job(jobName, partition, memory, qos));
                            }
                        } catch (FileNotFoundException e) {
                            System.out.println("File not found: " + file.getName());
                        }
                    }
                }
            }
        } else {
            System.out.println("The provided path is not a directory.");
        }

        return jobs;
    }

    public static void listAllJobs(ArrayList<Job> jobs) {
        System.out.println("List of all jobs:");
        for (Job job : jobs) {
            System.out.println(job);
        }
    }

    public static void generateStatistics(ArrayList<Job> jobs) {

        // HashMap<key, value>, to store the count of each partition and qos
        HashMap<String, Integer> partitionStats = new HashMap<>(); 
        HashMap<String, Integer> qosStats = new HashMap<>();

        // Check whether it exists in the HashMap, if not, add it to the HashMap
        for (Job job : jobs) {
            // If doesn't exist, return 0, else return the hashmap value
            partitionStats.put(job.partition, partitionStats.getOrDefault(job.partition, 0) + 1); 
            qosStats.put(job.qos, qosStats.getOrDefault(job.qos, 0) + 1);
        }

        System.out.println("\nPartition Statistics:");
        for (String partition : partitionStats.keySet()) {
            System.out.println(partition + ": " + partitionStats.get(partition) + " jobs");
        }

        System.out.println("\nQoS Statistics:");
        for (String qos : qosStats.keySet()) {
            System.out.println(qos + ": " + qosStats.get(qos) + " jobs");
        }
    }
}

class Job {
    String jobName;
    String partition;
    String memory;
    String qos;

    // Constructor define each Job's attribute
    Job(String jobName, String partition, String memory, String qos) {
        this.jobName = jobName;
        this.partition = partition;
        this.memory = memory;
        this.qos = qos;
    }

    // Return each Job's information
    @Override
    public String toString() {
        return "Job Name: " + jobName + ", Partition: " + partition + ", Memory: " + memory + ", QoS: " + qos;
    }
}
