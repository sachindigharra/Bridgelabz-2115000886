import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVRowCount {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("students.csv"))) {
            long count = br.lines().skip(1).count(); // Skip header
            System.out.println("Number of records: " + count);
        }
    }
} 