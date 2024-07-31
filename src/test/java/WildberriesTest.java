import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WildberriesTest {
    private WebDriver driver;
    private MainPage mainPage;
    private CartPage cartPage;

    @BeforeEach
    public void setUp() {
        driver = WebDriverSingleton.getInstance();
        mainPage = new MainPage(driver);
        cartPage = new CartPage(driver);
    }

    @Test
    public void testAddItemsToCart() {
        mainPage.open();
        mainPage.agreeToCookies();
        mainPage.addItemsToCart(6);
        mainPage.goToCart();

        List<WebElement> items = cartPage.getCartItems();
        double totalPrice = cartPage.getTotalPrice();
        double calculatedTotalPrice = 0;

        for (WebElement item : items) {
            String itemName = item.findElement(By.xpath("//span[contains(@class, 'good-info__good-name')]")).getText();
            String itemPriceText = item.findElement(By.xpath("//div[contains(@class, 'list-item__price-new')]")).getAttribute("data-jsv");
            double itemPrice = Double.parseDouble(itemPriceText.replaceAll("[^\\d.]", ""));
            calculatedTotalPrice += itemPrice;

            assertEquals(itemName, itemName);
            assertEquals(itemPrice, itemPrice);
        }

        assertEquals(totalPrice, calculatedTotalPrice);
    }

    //@AfterEach
    //public void tearDown() {
    //     driver.quit();
    // }
}