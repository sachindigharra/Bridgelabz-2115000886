import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReadIplCsv {

    public static JSONArray readIplCsvData(String filePath) throws IOException {
        JSONArray matches = new JSONArray();
        try (Reader reader = new FileReader(filePath)) {
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(reader);
            for (CSVRecord record : records) {
                JSONObject match = new JSONObject();
                for (String header : record.getParser().getHeaderMap().keySet()) {
                    match.put(header, record.get(header));
                }
                matches.put(match);
            }
        }
        return matches;
    }

    public static void main(String[] args) {
        try {
            JSONArray matches = readIplCsvData("ipl_data.csv");
            System.out.println(matches.toString(2));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}