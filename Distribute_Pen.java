public class Distribute_Pen {
 public static void main(String[] args) {
    int pen = 14;
    int students = 3;
    int eachStudent = pen/students;
    int remaining = pen%students;
    System.out.println("The Pen Per Student is "+eachStudent+" and the remaining pen not distributed is "+remaining);
 }   
}
