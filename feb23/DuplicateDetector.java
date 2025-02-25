import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateDetector {
    public static void main(String[] args) throws IOException {
        Set<String> ids = new HashSet<>();
        List<String> duplicates = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("students.csv"))) {
            String line;
            br.readLine();//Skip header
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String id = data[0];
                if (ids.contains(id)) {
                    duplicates.add(line);
                } else {
                    ids.add(id);
                }
            }
        }

        System.out.println("Duplicate records:");
        duplicates.forEach(System.out::println);
    }
}

 
