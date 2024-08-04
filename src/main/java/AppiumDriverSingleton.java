import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumDriverSingleton {
    private static AppiumDriver<MobileElement> instance;

    private AppiumDriverSingleton() {}

    public static AppiumDriver<MobileElement> getInstance() throws MalformedURLException {
        if (instance == null) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", "Android");
            capabilities.setCapability("deviceName", "Emulator"); // Укажите имя вашего устройства
            capabilities.setCapability("appPackage", "com.android.calculator2"); // Пакет калькулятора Google
            capabilities.setCapability("appActivity", ".Calculator"); // Главная активность приложения
            capabilities.setCapability("noReset", true); // Не сбрасывать данные приложения

            instance = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return instance;
    }

    public static void quitDriver() {
        if (instance != null) {
            instance.quit();
            instance = null;
        }
    }
}
