import java.util.Date;

public class HarryAge {

    public static void main(String[] args) {
        int birthYear = 2000;
       Date currDate = new Date();
       int currYear = currDate.getYear()+1900;
       int age = currYear - birthYear;
       System.out.println("Harry's age in 2024 is"+age);
    

    }
}