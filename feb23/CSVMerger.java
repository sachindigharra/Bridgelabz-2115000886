import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CSVMerger {
    public static void main(String[] args) throws IOException {
        Map<String, String[]> students1Data = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("students1.csv"))) {
            br.readLine();//Skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                students1Data.put(data[0], data);
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader("students2.csv"))) {
            br.readLine();//Skip header
            try (FileWriter writer = new FileWriter("merged_students.csv")) {
                writer.write("ID,Name,Age,Marks,Grade\n");
                String line;
                while ((line = br.readLine()) != null) {
                    String[] data2 = line.split(",");
                    String id = data2[0];
                    String[] data1 = students1Data.get(id);

                    if (data1 != null) {
                        writer.write(String.join(",", data1) + "," + data2[1] + "," + data2[2] + "\n");
                    }
                }
            }
        }
    }
} 
