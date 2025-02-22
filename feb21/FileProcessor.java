import java.io.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

class FileProcessorTest {

    @Test
    void testFileOperations() throws IOException {
        String filename = "test.txt";
        String content = "Hello, JUnit!";
        
        FileProcessor.writeToFile(filename, content);
        assertTrue(Files.exists(Paths.get(filename)));
        
        String result = FileProcessor.readFromFile(filename);
        assertEquals(content, result);
    }
}



public class FileProcessor {
    public static void writeToFile(String filename, String content) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(content);
        }
    }

    public static String readFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        return reader.readLine();
    }
}
