import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSingleton {
    private static WebDriver instance;

    private WebDriverSingleton() {}

    public static WebDriver getInstance() {
        if (instance == null) {
            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
            instance = new ChromeDriver();
            instance.manage().window().maximize(); // Максимизация окна
        }
        return instance;
    }
}