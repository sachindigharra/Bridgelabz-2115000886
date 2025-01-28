package jan28;

public class StringReplace {

    public static String replaceWord(String sentence, String wordToReplace, String replacementWord) {
        String[] words = sentence.split(" ");
        StringBuilder newSentence = new StringBuilder();

        for (String word : words) {
            if (word.equals(wordToReplace)) {
                newSentence.append(replacementWord).append(" ");
            } else {
                newSentence.append(word).append(" ");
            }
        }

        return newSentence.toString().trim(); 
    }

    public static void main(String[] args) {
        String sentence = "The quick brown fox jumps over the lazy dog.";
        String wordToReplace = "fox";
        String replacementWord = "cat";

        String newSentence = replaceWord(sentence, wordToReplace, replacementWord);
        System.out.println("Original Sentence: " + sentence);
        System.out.println("New Sentence: " + newSentence);
    }
}