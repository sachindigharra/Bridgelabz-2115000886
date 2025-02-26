import org.json.JSONArray;
import org.json.JSONObject;

import java.sql.*;

public class DatabaseToJsonReport {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:sqlite:mydatabase.db"; // SQLite database file

        try (Connection connection = DriverManager.getConnection(jdbcUrl);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM mytable")) {

            JSONArray jsonArray = new JSONArray();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            while (resultSet.next()) {
                JSONObject jsonObject = new JSONObject();
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    Object columnValue = resultSet.getObject(i);
                    jsonObject.put(columnName, columnValue);
                }
                jsonArray.put(jsonObject);
            }
            System.out.println(jsonArray.toString(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}