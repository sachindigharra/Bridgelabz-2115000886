
import java.util.regex.*;
import java.util.*;

public class ExtractHTMLTags {
    public static List<String> extractTags(String text) {
        List<String> tags = new ArrayList<>();
        String regex = "<(\\w+)[^>]*>";
        Matcher matcher = Pattern.compile(regex).matcher(text);
        while (matcher.find()) {
            tags.add(matcher.group(1));
        }
        return tags;
    }

    public static void main(String[] args) {
        String html = "<html><body><h1>Welcome</h1><p>Hello World</p></body></html>";
        System.out.println(extractTags(html)); // [html, body, h1, p, body, html]
    }
}

