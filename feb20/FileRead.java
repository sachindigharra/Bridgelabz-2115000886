 import java.io.*;

public class FileRead {
    public static void main(String[] args) {
        try {
            File file = new File("data.txt");
            FileReader fr = new FileReader(file);
            int i;
            while ((i = fr.read()) != -1) {
                System.out.print((char) i);
            }
            fr.close();
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
} 