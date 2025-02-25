import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSVValidator {
    public static void main(String[] args) throws IOException {
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);

        try (BufferedReader br = new BufferedReader(new FileReader("students.csv"))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String email = data[4]; // Assuming email is the 5th column
                String phone = data[5]; // Assuming phone number is the 6th column

                Matcher matcher = pattern.matcher(email);
                if (!matcher.matches()) {
                    System.out.println("Invalid email: " + email + " in row: " + line);
                }

                if (phone.length() != 10 || !phone.matches("\\d+")) { //Check if the phone number contains only digits
                    System.out.println("Invalid phone number: " + phone + " in row: " + line);
                }
            }
        }
    }
} 
