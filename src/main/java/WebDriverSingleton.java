import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebDriverSingleton {
    private static WebDriver instance;

    private WebDriverSingleton() {}

    public static WebDriver getInstance() {
        if (instance == null) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\astonuser\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
            instance = new ChromeDriver();
            instance.manage().window().maximize();
            instance.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return instance;
    }
}