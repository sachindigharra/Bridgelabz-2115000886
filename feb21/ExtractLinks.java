import java.util.regex.*;
import java.util.*;

public class ExtractLinks {
    public static List<String> extractLinks(String text) {
        List<String> links = new ArrayList<>();
        String regex = "(https?://[\\w.-]+)";
        Matcher matcher = Pattern.compile(regex).matcher(text);
        while (matcher.find()) {
            links.add(matcher.group());
        }
        return links;
    }

    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";
        System.out.println(extractLinks(text));
    }
}
