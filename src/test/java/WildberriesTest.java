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
        mainPage.addItemsToCart();
        mainPage.goToCart();

        List<WebElement> items = cartPage.getCartItems();//получает список всех веб-элементов товаров в корзине, использует селекторы, чтобы найти элементы, представляющие добавленные товары
        double totalPrice = cartPage.getTotalPrice();//получает общую стоимость всех товаров в корзине
        double calculatedTotalPrice = 0;//Эта переменная будет использоваться для подсчета общей стоимости всех товаров, добавленных в корзину на основе цен каждого из них

//Цикл для подсчета стоимости товаров
        //**Получение названия товара**: `itemName` полученный из элемента, представляющего товар, который может выводить название товара. При этом используется селектор `.item-name`, который нужно будет проверить и при необходимости изменить.
        //- **Получение цены товара**: `itemPriceText` извлекается из соответствующего элемента. Сначала он в формате строки, после чего он очищается от символьных символов, не относящихся к числам.
        //- **Суммирование цен**: `calculatedTotalPrice` обновляется, увеличиваясь на цену текущего товара. Это позволяет в конце проверить, правильно ли были добавлены товары.
        for (WebElement item : items) {
            String itemName = item.findElement(By.cssSelector(".item-name")).getText(); // Измените селектор
            String itemPriceText = item.findElement(By.cssSelector(".item-price")).getText(); // Измените селектор
            double itemPrice = Double.parseDouble(itemPriceText.replaceAll("[^\\d.]", ""));
            calculatedTotalPrice += itemPrice;

            // Добавьте проверки, чтобы убедиться, что название и цена совпадают
        }

        assertEquals(calculatedTotalPrice, totalPrice);
    }

    //@AfterEach
    //public void tearDown() {
   //     driver.quit();
   // }
}