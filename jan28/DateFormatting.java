package jan28;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormatting {

    public static void main(String[] args) {
        LocalDate today = LocalDate.now();

        // Define date formats
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter format3 = DateTimeFormatter.ofPattern("EEE, MMM dd, yyyy");

        // Format and display dates
        String formattedDate1 = today.format(format1);
        String formattedDate2 = today.format(format2);
        String formattedDate3 = today.format(format3);

        System.out.println("Format 1: " + formattedDate1);
        System.out.println("Format 2: " + formattedDate2);
        System.out.println("Format 3: " + formattedDate3);
    }
}