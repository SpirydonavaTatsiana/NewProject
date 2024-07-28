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
        return driver.findElements(By.cssSelector(".list-item__wrap")); // Этот вызов обращается к драйверу Selenium (`driver`) и выполняет поиск всех элементов,
        // соответствующих селектору CSS `.cart-item`.
        //- Метод `findElements` возвращает список всех найденных элементов на текущей странице, которые содержат класс `cart-item`, который обычно используется
        // для обозначения товаров в корзине.
        //- Если на странице не будет найдено ни одного элемента соответствующего критериям, метод вернет пустой список.
        //if (Elements.isEmpty()) {
          //  throw new AssertionError("Корзина пуста, ожидаются товары.");
        //}
    }

    public double getTotalPrice() {
        String totalPriceText = driver.findElement(By.cssSelector(".b-top__total line")).getText(); // поле с общ стоимостью товаров в корзине, возвращает строку
        return Double.parseDouble(totalPriceText.replaceAll("[^\\d.]", "")); //парсит в дабл
    }
}