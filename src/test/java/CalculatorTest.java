import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    private AppiumDriver<MobileElement> driver;

    @BeforeEach
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "HUAWEI nova 5T");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
        capabilities.setCapability("appPackage", "com.huawei.calculator");
        capabilities.setCapability("appActivity", "com.huawei.calculator.Calculator");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        capabilities.setCapability(MobileCapabilityType.NO_RESET, false);

        driver = new AndroidDriver<>(new URL("http://192.168.0.103:4723/wd/hub"), capabilities);
    }

    @Test
    @Description("This test performs all arithmetic operations and checks the results.")
    public void testAllCalculations() {
        performCalculation("6", "3", "+", "9");
        performCalculation("9", "4", "-", "5");
        performCalculation("7", "5", "*", "35");
        performCalculation("8", "2", "/", "4");
    }

    @Step("Performing calculation: {num1} {operator} {num2}")
    private void performCalculation(String num1, String num2, String operator, String expectedResult) {
        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.huawei.calculator:id/digit_" + num1))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(getOperatorId(operator)))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.huawei.calculator:id/digit_" + num2))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.huawei.calculator:id/eq"))).click();

        String result = driver.findElementById("com.huawei.calculator:id/formula").getText();

        System.out.println("Calculating: " + num1 + " " + operator + " " + num2);
        System.out.println("Result: " + result);

        assertEquals(expectedResult, result, "Expected " + expectedResult + " but got " + result);
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

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
