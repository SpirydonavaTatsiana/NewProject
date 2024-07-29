import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://wildberries.ru");
    }

    public void agreeToCookies() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/button[text()='Окей']"))).click();
    }

    public void addItemsToCart(int numberOfItems) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='product-card__wrapper']")));

        List<WebElement> items = driver.findElements(By.xpath("//div[@class='product-card__wrapper']//a[contains(@class, 'j-open-full-product-card')]")); // карточка товара
        if (items.size() < numberOfItems) {
            throw new IllegalArgumentException("Недостаточно товаров для добавления в корзину.");
        }
        for (int i = 0; i < numberOfItems; i++) {
            // Используем ожидание здесь
            wait.until(ExpectedConditions.elementToBeClickable(items.get(i).findElement(By.xpath("//span[text()='Послезавтра']")))).click(); // кнопка добавить в корзину
        }
    }


    public void goToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//2[contains(@class, 'j-wba-header-item')]"))).click(); // значок корзины
    }
}