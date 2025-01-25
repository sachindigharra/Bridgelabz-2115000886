public class AveragePercentage {
    public static void main(String[] args) {
        int math = 94;
        int physics = 95;
        int chemistry = 96;
    
        double totalMarks = math + physics + chemistry;
        double average = totalMarks / 3;
        double percentage = (average / 100) * 100;
        System.out.println("Sam’s average mark in PCM is"+percentage);
    }
}
