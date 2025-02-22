
public class DatabaseConnection {
    public void connect() {
        System.out.println("Database connected");
    }

    public void disconnect() {
        System.out.println("Database disconnected");
    }
}

// Testing Program
import org.junit.jupiter.api.*;

class DatabaseConnectionTest {
    DatabaseConnection db;

    @BeforeEach
    void setUp() {
        db = new DatabaseConnection();
        db.connect();
    }

    @AfterEach
    void tearDown() {
        db.disconnect();
    }

    @Test
    void testConnection() {
        assertNotNull(db);
    }
}

