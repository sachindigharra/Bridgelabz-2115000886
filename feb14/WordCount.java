
import java.io.*;

public class WordCount {
    public static void main(String[] args) throws IOException {
        String targetWord = "hello";
        int count = 0;
        BufferedReader reader = new BufferedReader(new FileReader("test.txt"));
        String line;
        
        while ((line = reader.readLine()) != null) {
            String[] words = line.split("\\s+");
            for (String word : words) {
                if (word.equals(targetWord)) count++;
            }
        }
        reader.close();
        System.out.println("Word '" + targetWord + "' found " + count + " times.");
    }
}

