
import java.util.regex.*;
import java.util.*;

public class ExtractCapitalizedWords {
    public static List<String> extractCapitalizedWords(String text) {
        List<String> words = new ArrayList<>();
        String regex = "\\b[A-Z][a-z]*\\b";
        Matcher matcher = Pattern.compile(regex).matcher(text);
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }

    public static void main(String[] args) {
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        System.out.println(extractCapitalizedWords(text));
    }
}

