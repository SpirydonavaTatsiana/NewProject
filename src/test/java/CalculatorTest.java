import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorTest {
    private AppiumDriver<MobileElement> driver;

    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10"); //версия вашего устройства
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Huawei"); // ваше устройство
        capabilities.setCapability(MobileCapabilityType.APP, "com.android.calculator2"); // пакет калькулятора
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);

        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
    }

    public void testAddition() {
        performCalculation("5", "3", "+", "8");
    }

    public void testSubtraction() {
        performCalculation("10", "4", "-", "6");
    }

    public void testMultiplication() {
        performCalculation("7", "6", "*", "42");
    }

    public void testDivision() {
        performCalculation("12", "4", "/", "3");
    }

    private void performCalculation(String num1, String num2, String operator, String expectedResult) {
        driver.findElementById("com.android.calculator2:id/digit_" + num1).click();
        driver.findElementById(getOperatorId(operator)).click();
        driver.findElementById("com.android.calculator2:id/digit_" + num2).click();
        driver.findElementById("com.android.calculator2:id/op_equals").click();

        String result = driver.findElementById("com.android.calculator2:id/result").getText();
        assert result.equals(expectedResult) : "Expected " + expectedResult + " but got " + result;
    }

    private String getOperatorId(String operator) {
        switch (operator) {
            case "+":
                return "com.android.calculator2:id/op_add";
            case "-":
                return "com.android.calculator2:id/op_subtract";
            case "*":
                return "com.android.calculator2:id/op_multiply";
            case "/":
                return "com.android.calculator2:id/op_divide";
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