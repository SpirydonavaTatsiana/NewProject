import io.appium.java_client.MobileElement;
import io.appium.java_client.AppiumDriver;

import java.net.MalformedURLException;

public class CalculatorTest {
    private AppiumDriver<MobileElement> driver;

    public static void main(String[] args) {
        CalculatorTest test = new CalculatorTest();
        try {
            test.runTests();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            test.tearDown();
        }
    }

    public void runTests() throws MalformedURLException {
        driver = AppiumDriverSingleton.getInstance();

        testCalculator("2", "3", "+", "5");
        testCalculator("10", "4", "-", "6");
        testCalculator("4", "5", "*", "20");
        testCalculator("20", "4", "/", "5");
    }

    private void testCalculator(String num1, String num2, String operator, String expectedResult) {
        // Вводим первое число
        sendInput(num1);

        // Вводим оператор
        sendOperator(operator);

        // Вводим второе число
        sendInput(num2);

        // Нажимаем на кнопку равенства
        driver.findElementById("com.android.calculator2:id/equal").click();

        // Получаем результат
        String result = driver.findElementById("com.android.calculator2:id/result").getText();

        // Проверяем результат
        if (result.equals(expectedResult)) {
            System.out.println("Тест пройден: " + num1 + " " + operator + " " + num2 + " = " + result);
        } else {
            System.out.println("Тест не пройден: " + num1 + " " + operator + " " + num2 + " ожидалось " + expectedResult + ", получено " + result);
        }
    }

    private void sendInput(String number) {
        for (char digit : number.toCharArray()) {
            driver.findElementById("com.android.calculator2:id/digit_" + digit).click();
        }
    }

    private void sendOperator(String operator) {
        switch (operator) {
            case "+":
                driver.findElementById("com.android.calculator2:id/op_add").click();
                break;
            case "-":
                driver.findElementById("com.android.calculator2:id/op_sub").click();
                break;
            case "*":
                driver.findElementById("com.android.calculator2:id/op_mul").click();
                break;
            case "/":
                driver.findElementById("com.android.calculator2:id/op_div").click();
                break;
            default:
                throw new UnsupportedOperationException("Оператор не поддерживается");
        }
    }

    public void tearDown() {
        AppiumDriverSingleton.quitDriver();
    }
}