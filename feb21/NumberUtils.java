
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
public class NumberUtils {
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}



class NumberUtilsTest {
    
    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8, 10})
    void testIsEven(int number) {
        assertTrue(NumberUtils.isEven(number));
    }
}

