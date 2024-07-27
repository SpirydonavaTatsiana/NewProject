import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialCalculatorTestng {
    private final FactorialCalculator calculator = new FactorialCalculator();

    @Test
    public void testCalculateFactorialForZero() {
        Assert.assertEquals(calculator.factorial(0), 1);
    }

    @Test
    public void testCalculateFactorialForPositiveNumber() {
        Assert.assertEquals(calculator.factorial(5), 120);
    }

    @Test
    public void testCalculateFactorialForNegativeNumber() {
        Assert.assertThrows(IllegalArgumentException.class, () -> calculator.factorial(-5));
    }
}