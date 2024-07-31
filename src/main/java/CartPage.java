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
        return driver.findElements(By.xpath("//div[contains(@class, 'list-item__wrap')]"));
    }

    public double getTotalPrice() {
        String totalPriceText = driver.findElement(By.xpath("//span[contains(@data-link, 'totalPriceWithCouponPersDiscAndDeliveryPrice')]")).getText();
        return Double.parseDouble(totalPriceText.replaceAll("[^\\d.]", ""));
    }
}