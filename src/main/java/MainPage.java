import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://wildberries.ru");
    }

    public void addItemsToCart(int numberOfItems) {
        List<WebElement> items = driver.findElements(By.cssSelector(".product-card")); // Измените селектор, если необходимо
        for (int i = 0; i < numberOfItems; i++) {
            items.get(i).findElement(By.cssSelector(".add-to-cart-button")).click(); // Измените селектор кнопки
            // Добавьте задержку, если необходимо
        }
    }

    public void goToCart() {
        driver.findElement(By.cssSelector(".cart-icon")).click(); // Измените селектор значка корзины
    }
}