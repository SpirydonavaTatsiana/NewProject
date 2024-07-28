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
        driver.findElement(By.xpath("//div/button[text()='Окей']")).click();
    }

    public void addItemsToCart(int numberOfItems) {
        List<WebElement> items = driver.findElements(By.cssSelector(".product-card__link.j-card-link.j-open-full-product-card")); // карточка товара
        for (int i = 0; i < numberOfItems; i++) {
            items.get(i).findElement(By.cssSelector(".btn-text.selectorgadget_suggested")).click(); // кнопка добавить в корзину

        }
    }

    //public void addItemsToCart(int numberOfItems) {
        //List<WebElement> items = driver.findElements(By.cssSelector(".product-card__link.j-card-link.j-open-full-product-card")); // карточка товара
       // WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".btn-text.selectorgadget_suggested")));
        //for (int i = 0; i < numberOfItems; i++) {
           // items.get(i).findElement(By.cssSelector(".btn-text.selectorgadget_suggested")).click(); // кнопка добавить в корзину

       // }
   // }
    public void goToCart() {
        driver.findElement(By.cssSelector(".navbar-pc__link.j-wba-header-item")).click(); // значок корзины
    }
}