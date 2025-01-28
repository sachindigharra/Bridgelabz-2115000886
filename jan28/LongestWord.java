package jan28;

public class LongestWord {
    public static void main(String[] args) {
        String sentence = "This is a sentence with some words";
        String[] words = sentence.split(" ");
        String longestWord = "";

        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }

        System.out.println("Longest Word: " + longestWord);
    }
}