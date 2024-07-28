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

    public void agreeToCookies() {
        driver.findElement(By.xpath("//div/button[text()='Окей']")).click();
    }

    public void addItemsToCart(int numberOfItems) {
        List<WebElement> items = driver.findElements(By.cssSelector(".product-card__order-wrap")); // карточка товара
        for (int i = 0; i < numberOfItems; i++) {
            items.get(i).findElement(By.cssSelector(".product-card__add-basket.j-add-to-basket.btn-main")).click(); // кнопка добавить в корзину
            // Добавить задержку может???
        }
    }

    public void goToCart() {
        driver.findElement(By.cssSelector(".navbar-pc__link.j-wba-header-item")).click(); // значок корзины
    }
}