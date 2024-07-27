import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialCalculatorTest {
    @Test
    public void testFactorialOfZero() {
        assertEquals(1, FactorialCalculator.factorial(0), "Факториал 0 должен быть 1");
    }
    @Test
    public void testFactorialOfPositiveNumber() {
        assertEquals(120, FactorialCalculator.factorial(5), "Факториал 5 должен быть 120");
        assertEquals(720, FactorialCalculator.factorial(6), "Факториал 6 должен быть 720");
    }
    @Test
    public void testFactorialOfOne() {
        assertEquals(1, FactorialCalculator.factorial(1), "Факториал 1 должен быть 1");
    }
    @Test
    public void testFactorialOfNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculator.factorial(-1);
        });
        assertEquals("Факториал не определён для отрицательных чисел.", exception.getMessage());
    }
}