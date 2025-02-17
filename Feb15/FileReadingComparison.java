package Feb15;

import java.io.*;

public class FileReadingComparison {
    public static void main(String[] args) {
        // Specify file path (assumed to be a large file)
        String filePath = "largefile.txt"; // Change this to your file path

        // Measure time for FileReader (Character Stream)
        long start = System.nanoTime();
        try (FileReader fileReader = new FileReader(filePath)) {
            char[] buffer = new char[1024]; // Buffer to hold read data
            while (fileReader.read(buffer) != -1) {
                // Just reading the file
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();
        double fileReaderTime = (end - start) / 1e6; // Convert to milliseconds

        // Measure time for InputStreamReader (Byte Stream)
        start = System.nanoTime();
        try (InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(filePath))) {
            char[] buffer = new char[1024]; // Buffer to hold read data
            while (inputStreamReader.read(buffer) != -1) {
                // Just reading the file
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        end = System.nanoTime();
        double inputStreamReaderTime = (end - start) / 1e6; // Convert to milliseconds

        // Output the time taken for each method
        System.out.printf("%-20s %-20s %-20s%n", "File Size", "FileReader Time", "InputStreamReader Time");
        System.out.println("-----------------------------------------------------------");
        System.out.printf("%-20s %-20.2f %-20.2f%n", "500MB", fileReaderTime, inputStreamReaderTime);
    }
}

