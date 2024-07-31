import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.lang.model.util.Elements;
import javax.swing.text.html.parser.Element;
import java.util.List;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> getCartItems() {
        return driver.findElements(By.xpath("//div[contains(@class, 'list-item__wrap')]"));
        //if (Elements.isEmpty()) {
        //  throw new AssertionError("Корзина пуста, ожидаются товары.");
        //}
    }

    public double getTotalPrice() {
        String totalPriceText = driver.findElement(By.xpath("//span[contains(@data-link, 'totalPriceWithCouponPersDiscAndDeliveryPrice')]")).getText(); // поле с общ стоимостью товаров в корзине, возвращает строку
        return Double.parseDouble(totalPriceText.replaceAll("[^\\d.]", "")); //парсит в дабл
    }
}