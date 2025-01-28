package jan28;

public class MostFrequentCharacter {
    public static void main(String[] args) {
        String str = "success";
        int[] charCount = new int[256]; // Assuming ASCII characters

        for (char ch : str.toCharArray()) {
            charCount[ch]++;
        }

        int maxCount = 0;
        char mostFrequentChar = ' ';

        for (int i = 0; i < 256; i++) {
            if (charCount[i] > maxCount) {
                maxCount = charCount[i];
                mostFrequentChar = (char) i;
            }
        }

        System.out.println("Most Frequent Character: " + mostFrequentChar);
    }
}