package jan28;

public class CountVowelsConsonants {
    public static void main(String[] args) {
        String str = "Hello World";
        int vowels = 0, consonants = 0;

        for (char ch : str.toCharArray()) {
            char lowerCaseChar = Character.toLowerCase(ch);
            if (lowerCaseChar == 'a' || lowerCaseChar == 'e' || lowerCaseChar == 'i' || 
                lowerCaseChar == 'o' || lowerCaseChar == 'u') {
                vowels++;
            } else if (Character.isLetter(ch)) { 
                consonants++;
            }
        }

        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
}