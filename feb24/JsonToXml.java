import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class JsonToXml {
    public static void main(String[] args) {
        try {
            ObjectMapper jsonMapper = new ObjectMapper();
            XmlMapper xmlMapper = new XmlMapper();

            JsonNode jsonNode = jsonMapper.readTree(new File("data.json")); // JSON file

            String xml = xmlMapper.writeValueAsString(jsonNode);
            System.out.println(xml);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}