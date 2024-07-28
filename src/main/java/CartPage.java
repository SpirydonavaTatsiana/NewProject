import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getCartItems() {
        return driver.findElements(By.cssSelector(".cart-item")); // Измените селектор, если необходимо
    }

    public double getTotalPrice() {
        String totalPriceText = driver.findElement(By.cssSelector(".total-price")).getText(); // Измените селектор
        return Double.parseDouble(totalPriceText.replaceAll("[^\\d.]", ""));
    }
}