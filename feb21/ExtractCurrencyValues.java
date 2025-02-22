import java.util.regex.*;
import java.util.*;

public class ExtractCurrencyValues {
    public static List<String> extractCurrencies(String text) {
        List<String> currencies = new ArrayList<>();
        String regex = "\\$\\d+(\\.\\d{2})?";
        Matcher matcher = Pattern.compile(regex).matcher(text);
        while (matcher.find()) {
            currencies.add(matcher.group());
        }
        return currencies;
    }

    public static void main(String[] args) {
        String text = "The price is $45.99, and the discount is $5.";
        System.out.println(extractCurrencies(text)); // [$45.99, $5]
    }
}