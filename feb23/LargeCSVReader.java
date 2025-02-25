import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LargeCSVReader {
    public static void main(String[] args) throws IOException {
        long linesProcessed = 0;
        int chunkSize = 100;

        try (BufferedReader br = new BufferedReader(new FileReader("large_file.csv"))) {
            String line;
            br.readLine();//Skip header
            while ((line = br.readLine()) != null) {
                linesProcessed++;
                if (linesProcessed % chunkSize == 0) {
                    System.out.println("Processed " + linesProcessed + " lines.");
                }
            }
        }
        System.out.println("Total lines processed: " + linesProcessed);
    }
} 