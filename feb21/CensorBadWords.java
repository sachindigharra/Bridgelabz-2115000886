
public class CensorBadWords {
    public static String censorBadWords(String text) {
        String[] badWords = {"damn", "stupid"};
        for (String word : badWords) {
            text = text.replaceAll("(?i)\\b" + word + "\\b", "****");
        }
        return text;
    }

    public static void main(String[] args) {
        String input = "This is a damn bad example with some stupid words.";
        System.out.println(censorBadWords(input));
    }
}

