import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONToCSVConverter {
    public static void main(String[] args) throws IOException {
        try (FileReader reader = new FileReader("students.json")) {
            Gson gson = new GsonBuilder().create();
            Student[] students = gson.fromJson(reader, Student[].class);

            try (FileWriter writer = new FileWriter("students_from_json.csv")) {
                writer.write("id,name,age,marks\n"); // Header
                for (Student student : students) {
                    writer.write(student.id + "," + student.name + "," + student.age + "," + student.marks + "\n");
                }
            }
        }
    }

    public static void csvToJson(String csvFile, String jsonFile) throws IOException {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            br.readLine(); // Skip header
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Student student = new Student(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]));
                students.add(student);
            }
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(jsonFile)) {
            gson.toJson(students, writer);
        }
    }
}

