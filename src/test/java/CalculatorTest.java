import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.Assert;
import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTest {
    private AppiumDriver<MobileElement> driver;

    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "HUAWEI nova 5T");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10"); // Убедитесь, что версия соответствует вашей
        capabilities.setCapability("appPackage", "com.huawei.calculator");
        capabilities.setCapability("appActivity", "com.huawei.calculator.Calculator"); // Правильное имя активности
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability("noReset", true); // Если не хотите сбрасывать данные приложения

        driver = new AndroidDriver<>(new URL("http://192.168.0.103:4723/wd/hub"), capabilities);
    }

    public void testAddition() {
        performCalculation("5", "3", "+", "8");
    }

    public void testSubtraction() {
        performCalculation("9", "4", "-", "5");
    }

    public void testMultiplication() {
        performCalculation("7", "6", "*", "42");
    }

    public void testDivision() {
        performCalculation("8", "4", "/", "2");
    }

    private void performCalculation(String num1, String num2, String operator, String expectedResult) {
        // Операции калькулятора
        driver.findElementById("com.huawei.calculator:id/digit_" + num1).click();
        driver.findElementById(getOperatorId(operator)).click();
        driver.findElementById("com.huawei.calculator:id/digit_" + num2).click();
        driver.findElementById("com.huawei.calculator:id/eq").click();

        String result = driver.findElementById("com.huawei.calculator:id/formula").getText();

        // Используйте JUnit для ассертаций
        Assert.assertEquals("Expected " + expectedResult + " but got " + result, expectedResult, result);
    }

    private void performCalculation(String num1, String num2, String operator, String expectedResult) {
        driver.findElementById("com.huawei.calculator:id/digit_" + num1).click();
        driver.findElementById(getOperatorId(operator)).click();
        driver.findElementById("com.huawei.calculator:id/digit_" + num2).click();
        driver.findElementById("com.huawei.calculator:id/eq").click();

        String result = driver.findElementById("com.huawei.calculator:id/formula").getText();
        assert result.equals(expectedResult) : "Expected " + expectedResult + " but got " + result;
    }

    private String getOperatorId(String operator) {
        switch (operator) {
            case "+":
                return "com.huawei.calculator:id/op_add";
            case "-":
                return "com.huawei.calculator:id/op_sub";
            case "*":
                return "com.huawei.calculator:id/op_mul";
            case "/":
                return "com.huawei.calculator:id/op_div";
            default:
                throw new IllegalArgumentException("Operator not supported: " + operator);
        }
    }

    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void main(String[] args) {
        CalculatorTest test = new CalculatorTest();
        try {
            test.setUp();
            test.testAddition();
            test.testSubtraction();
            test.testMultiplication();
            test.testDivision();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } finally {
            test.tearDown();
        }
    }
}