/*

a. Store ten random integers within 0 to 1000 ro a text file name integer.txt

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class T7Q1 {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("integer.txt");
            Random random = new Random();

            for (int i = 0; i < 10; i++) {
                int randomInt = random.nextInt(1001); // Generate random integer between 0 and 1000
                writer.write(Integer.toString(randomInt) + "\n");
            }

            writer.close();
            System.out.println("Integers written to 'integer.txt' file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}

b. Read from the text file generated in a. Display all the integer and the largest integer

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class IntegerReader {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("integer.txt"));
            String line;
            int largestInt = Integer.MIN_VALUE;

            System.out.println("All the integers:");
            while ((line = reader.readLine()) != null) {
                int num = Integer.parseInt(line);
                System.out.println(num);
                largestInt = Math.max(largestInt, num);
            }

            System.out.println("The largest integer is: " + largestInt);
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}

c. Store ten random integers within 0 to 1000 to a binary file name integer.dat

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class BinaryIntegerGenerator {
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("integer.dat");
            DataOutputStream dos = new DataOutputStream(fos);
            Random random = new Random();

            for (int i = 0; i < 10; i++) {
                int randomInt = random.nextInt(1001); // Generate random integer between 0 and 1000
                dos.writeInt(randomInt);
            }

            dos.flush();
            dos.close();
            fos.close();
            System.out.println("Integers written to 'integer.dat' file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}

d. Read from the binary file generated in c. Display all the integer and the average

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BinaryIntegerReader {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("integer.dat");
            DataInputStream dis = new DataInputStream(fis);

            System.out.println("All the integers:");
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                int num = dis.readInt();
                System.out.println(num);
                sum += num;
            }

            double average = (double) sum / 10;
            System.out.println("The average of the integers is: " + average);

            dis.close();
            fis.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }
}
*/
