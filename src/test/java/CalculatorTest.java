import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.mobile.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MobileCalculatorTest {

    private static AppiumDriver<MobileElement> driver;

    public static void main(String[] args) throws Exception {
        setUp();

        // Тестируем арифметические операции
        testCalculator("2", "3", "+", "5");
        testCalculator("10", "4", "-", "6");
        testCalculator("4", "5", "*", "20");
        testCalculator("20", "4", "/", "5");

        tearDown();
    }

    private static void setUp() throws Exception {
        // Устанавливаем желаемые возможности для Android
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Emulator"); // Название устройства
        capabilities.setCapability("appPackage", "com.android.calculator2"); // Пакет приложения калькулятора
        capabilities.setCapability("appActivity", ".Calculator"); // Главная активность приложения
        capabilities.setCapability("noReset", true); // Не сбрасывать данные приложения

        // Инициализируем драйвер
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    private static void testCalculator(String num1, String num2, String operator, String expectedResult) {
        // Введите первое число
        sendInput(num1);

        // Введите оператор
        sendOperator(operator);

        // Введите второе число
        sendInput(num2);

        // Нажмите на кнопку равенства
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

    private static void sendInput(String number) {
        for (char digit : number.toCharArray()) {
            driver.findElementById("com.android.calculator2:id/digit_" + digit).click();
        }
    }

    private static void sendOperator(String operator) {
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

    private static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}