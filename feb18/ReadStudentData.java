import java.io.*;

class StudentData {
    public static void main(String[] args) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("student.dat"))) {
            dos.writeInt(101);
            dos.writeUTF("John Doe");
            dos.writeDouble(3.8);
            System.out.println("Data stored successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class ReadStudentData {
    public static void main(String[] args) {
        try (DataInputStream dis = new DataInputStream(new FileInputStream("student.dat"))) {
            System.out.println("Roll No: " + dis.readInt());
            System.out.println("Name: " + dis.readUTF());
            System.out.println("GPA: " + dis.readDouble());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
