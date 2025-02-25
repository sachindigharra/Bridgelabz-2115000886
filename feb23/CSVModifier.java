import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVModifier {
    public static void main(String[] args) throws IOException {
        List<String> updatedLines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("employees.csv"))) {
            String line;
            updatedLines.add(br.readLine()); // Add header
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data[2].equals("IT")) {
                    double salary = Double.parseDouble(data[3]);
                    salary *= 1.10;
                    data[3] = String.valueOf(salary);
                    line = String.join(",", data); //Reconstruct the line with the updated salary
                }
                updatedLines.add(line);
            }
        }
        try (FileWriter writer = new FileWriter("updated_employees.csv")) {
            for (String line : updatedLines) {
                writer.write(line + "\n");
            }
        }
    }
} 
