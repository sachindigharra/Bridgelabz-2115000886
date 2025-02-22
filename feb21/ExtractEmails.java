
import java.util.regex.*;
import java.util.*;

public class ExtractEmails {
    public static List<String> extractEmails(String text) {
        List<String> emails = new ArrayList<>();
        String regex = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b";
        Matcher matcher = Pattern.compile(regex).matcher(text);
        while (matcher.find()) {
            emails.add(matcher.group());
        }
        return emails;
    }

    public static void main(String[] args) {
        String text = "Contact us at support@example.com and info@company.org";
        System.out.println(extractEmails(text));
    }
}

