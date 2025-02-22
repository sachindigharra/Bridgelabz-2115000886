
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalculatorTest implements Test {
    Calculator calc = new Calculator();

    @Test
    void testAddition() {
        assertEquals(10, calc.add(5, 5));
    }

    @Test
    void testSubtraction() {
        assertEquals(3, calc.subtract(5, 2));
    }

    @Test
    void testMultiplication() {
        assertEquals(15, calc.multiply(3, 5));
    }

    @Test
    void testDivision() {
        assertEquals(2, calc.divide(10, 5));
    }

    @Test
    void testDivisionByZero() {
        assertThrows(ArithmeticException.class, () -> calc.divide(10, 0));
    }
}


public class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }
}

