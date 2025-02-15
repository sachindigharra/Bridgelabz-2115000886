
public class SearchWord {
    public static String findSentence(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.contains(word)) return sentence;
        }
        return "Not Found";
    }

    public static void main(String[] args) {
        String[] sentences = {"Java is fun", "I love coding", "Data Structures"};
        System.out.println(findSentence(sentences, "coding"));
    }
}

