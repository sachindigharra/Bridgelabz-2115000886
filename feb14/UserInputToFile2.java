import java.io.*;

public class UserInputToFile2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileWriter writer = new FileWriter("output.txt");
        String line;

        System.out.println("Enter text (type 'exit' to finish):");
        while (!(line = br.readLine()).equalsIgnoreCase("exit")) {
            writer.write(line + "\n");
        }
        
        br.close();
        writer.close();
    }
}

