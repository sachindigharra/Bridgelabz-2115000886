
public class RemoveExtraSpaces {
    public static String removeExtraSpaces(String text) {
        return text.replaceAll("\\s+", " ").trim();
    }

    public static void main(String[] args) {
        String input = "This  is   an example    with multiple  spaces.";
        System.out.println(removeExtraSpaces(input));
    }
}

