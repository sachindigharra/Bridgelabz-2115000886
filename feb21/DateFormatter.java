import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateFormatter {
    public static String formatDate(String inputDate) {
        try {
            LocalDate date = LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format. Expected yyyy-MM-dd");
        }
    }
}



class DateFormatterTest {

    @Test
    void testValidDate() {
        assertEquals("31-12-2023", DateFormatter.formatDate("2023-12-31"));
    }

    @Test
    void testInvalidDate() {
        assertThrows(IllegalArgumentException.class, () -> DateFormatter.formatDate("31-12-2023"));
    }
}