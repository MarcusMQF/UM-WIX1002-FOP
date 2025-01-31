public class Q5_2020S1 {
    public static void main(String[] args) {
        // Define cloud packages
        CloudPackage c1 = new CloudPackage("P2-15", 4, 15, 1.24);
        CloudPackage c2 = new CloudPackage("P2-30", 6, 30, 2.11);
        CloudPackage c3 = new CloudPackage("R5-30", 4, 20, 1.38);
        CloudPackage c4 = new CloudPackage("R6-20", 6, 20, 1.88);
        
        // Create an array of cloud packages
        CloudPackage[] cloudPackages = {c1, c2, c3, c4};

        // Define jobs with their respective details
        Job j1 = new Job("J1", 252, 20);
        Job j2 = new Job("J2", 108, 10);
        Job j3 = new Job("J3", 72, 25);
        
        // Create an array of jobs
        Job[] jobs = {j1, j2, j3};

        // Array to store the best cloud package for each job
        CloudPackage[] bestPackage = new CloudPackage[jobs.length];

        // Find the first valid cloud package for each job that can handle the memory requirement
        for (int i = 0; i < jobs.length; i++) {
            for (CloudPackage cloudPackage : cloudPackages) {
                if (cloudPackage.check(jobs[i])) {
                    bestPackage[i] = cloudPackage;  // Store the first valid cloud package
                    break;  // No need to check further once a valid package is found
                }
            }
        }

        // Iterate over the cloud packages again to find the most cost-effective package
        for (int i = 0; i < jobs.length; i++) {
            for (CloudPackage cloudPackage : cloudPackages) {
                if (cloudPackage.check(jobs[i])) {
                    // If the current package is more cost-effective, update the best package
                    if (bestPackage[i].totalCost(jobs[i]) >= cloudPackage.totalCost(jobs[i])) {
                        bestPackage[i] = cloudPackage;
                        cloudPackage.setTotalCost(bestPackage[i].totalCost(jobs[i])); // Set the cost of the chosen package
                    }
                }
            }
        }

        // Output the best cloud package for each job
        for (int i = 0; i < jobs.length; i++) {
            System.out.println(jobs[i].toString());  // Print job details
            System.out.println(bestPackage[i].toString());  // Print best cloud package details
        }
    }
}

class Cloud {
    protected String cloudPackage;  // The name of the cloud package
    private double totalCost;       // The total cost for using the cloud package

    // Getter for totalCost
    public double getTotalCost() {
        return totalCost;
    }

    // Setter for totalCost
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    // Constructor for Cloud class which initializes the cloudPackage
    public Cloud(String cloudPackage) {
        this.cloudPackage = cloudPackage;
    }

    // Override toString method to display cloud package details
    @Override
    public String toString() {
        return "Cloud Package: " + cloudPackage + "\nTotal Cost: " + totalCost;
    }
}

class Job {
    private String jobName;   // The name of the job
    private int numberOfTasks;  // The number of tasks in the job
    private int memory;        // The memory required for the job

    // Constructor to initialize job details
    public Job(String jobName, int numberOfTasks, int memory) {
        this.jobName = jobName;
        this.numberOfTasks = numberOfTasks;
        this.memory = memory;
    }

    // Getters for job properties
    public String getJobName() {
        return jobName;
    }

    public int getNumberOfTasks() {
        return numberOfTasks;
    }

    public int getMemory() {
        return memory;
    }

    // Override toString method to display job details
    @Override
    public String toString() {
        return "Job Name: " + jobName + "\nNumber of Tasks: " + numberOfTasks + "\nMemory: " + memory;
    }
}

class CloudPackage extends Cloud {
    private int numberOfCores;    // Number of cores in the cloud package
    private int memory;           // Memory size of the cloud package
    private double pricePerHour;  // Price per hour for using the cloud package

    // Constructor to initialize cloud package details
    public CloudPackage(String cloudPackage, int numberOfCores, int memory, double pricePerHour) {
        super(cloudPackage);   // Call the constructor of the parent Cloud class
        this.numberOfCores = numberOfCores;
        this.memory = memory;
        this.pricePerHour = pricePerHour;
    }

    // Method to check if the cloud package can handle the job based on memory
    public boolean check(Job job) {
        return memory >= job.getMemory();   // Cloud package must have enough memory to handle the job
    }

    // Method to calculate the total cost of running a job on this cloud package
    public double totalCost(Job job) {
        return (double) job.getNumberOfTasks() / numberOfCores * pricePerHour;  // Cost is based on the number of tasks and cores
    }
}
