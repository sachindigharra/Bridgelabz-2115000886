import java.io.FileWriter;
import java.io.IOException;

public class CSVWriterExample {
    public static void main(String[] args) throws IOException {
        try (FileWriter writer = new FileWriter("employees.csv")) {
            writer.write("ID,Name,Department,Salary\n");
            writer.write("1,John Doe,Sales,60000\n");
            writer.write("2,Jane Smith,Marketing,70000\n");
            writer.write("3,David Lee,IT,80000\n");
            writer.write("4,Sarah Jones,HR,65000\n");
            writer.write("5,Michael Brown,Finance,75000\n");
        }
    }
} 
