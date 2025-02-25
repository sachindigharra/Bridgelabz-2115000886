import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CSVSorter {
    public static void main(String[] args) throws IOException {
        List<String[]> records = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("employees.csv"))) {
            br.readLine(); // Skip header
            String line;
            while ((line = br.readLine()) != null) {
                records.add(line.split(","));
            }
        }

        records.sort(Comparator.comparing(arr -> Double.parseDouble(arr[3]), Comparator.reverseOrder()));

        System.out.println("Top 5 Highest Paid Employees:");
        for (int i = 0; i < Math.min(5, records.size()); i++) {
            String[] data = records.get(i);
            System.out.printf("ID: %s, Name: %s, Salary: %s\n", data[0], data[1], data[3]);
        }
    }
} 
