import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVSearch {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("employees.csv"))) {
            String line;
            br.readLine(); // Skip header
            String searchName = "Jane Smith"; // Example search name
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[1].equals(searchName)) {
                    System.out.printf("Department: %s, Salary: %s\n", data[2], data[3]);
                    break;
                }
            }
        }
    }
}