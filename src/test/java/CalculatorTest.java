import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CalculatorTest {
    public static void main(String[] args) {
        WebDriver driver = WebDriverSingleton.getInstance();
        // Тестируем арифметические операции
        testCalculator(driver, "addition", "2", "3", "5");
        testCalculator(driver, "subtraction", "10", "4", "6");
        testCalculator(driver, "multiplication", "4", "5", "20");
        testCalculator(driver, "division", "20", "4", "5");

        driver.quit(); // Закрываем драйвер
    }

    static void testCalculator(WebDriver driver, String operation, String num1, String num2, String expectedResult) {
        driver.get("https://www.google.com/search?q=calculator");

        // Нажимаем кнопки чисел и операции
        clickButton(driver, num1);
        switch (operation) {
            case "addition":
                clickButton(driver, "+");
                break;
            case "subtraction":
                clickButton(driver, "-");
                break;
            case "multiplication":
                clickButton(driver, "×");
                break;
            case "division":
                clickButton(driver, "÷");
                break;
            default:
                System.out.println("Неизвестная операция");
                return;
        }
        clickButton(driver, num2);
        clickButton(driver, "=");

        // Получаем результат
        String result = driver.findElement(By.cssSelector(".result-container")).getText();

        // Проверяем результат
        if (result.equals(expectedResult)) {
            System.out.println("Тест пройден: " + num1 + " " + operation + " " + num2 + " = " + result);
        } else {
            System.out.println("Тест не пройден: " + num1 + " " + operation + " " + num2 + " ожидалось " + expectedResult + ", получено " + result);
        }
    }

    static void clickButton(WebDriver driver, String value) {
        WebElement button = driver.findElement(By.xpath("//div[contains(text(), '" + value + "')]"));
        button.click();
    }
}