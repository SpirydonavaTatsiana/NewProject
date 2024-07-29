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

    public void addItemsToCart() {
        // Устанавливаем значение numberOfItems равным 3
        int numberOfItems = 3;

        // Создаем ожидание
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Ожидаем загрузки всех карточек товара
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='product-card__wrapper']")));

        // Получаем список товаров
        List<WebElement> items = driver.findElements(By.xpath("//div[@class='product-card__wrapper']//a[contains(@class, 'full-product-card')]")); // карточка товара

        // Проверяем, достаточно ли товаров для добавления в корзину
        if (items.size() < numberOfItems) {
            throw new IllegalArgumentException("Недостаточно товаров для добавления в корзину.");
        }

        // Цикл добавления товаров
        for (int i = 0; i < numberOfItems; i++) {
            // Ожидаем кликабельность кнопки и добавляем товар в корзину
            wait.until(ExpectedConditions.elementToBeClickable(items.get(i).findElement(By.xpath("//span[text()='Послезавтра']")))).click(); // кнопка добавить в корзину
        }

    }
        public void goToCart() {
            driver.findElement(By.xpath("//span[contains(@class, 'navbar-pc__icon--basket')]")).click(); // значок корзины
        }
    //public void addItemsToCart(int numberOfItems) {
      //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='product-card__wrapper']")));

      //  List<WebElement> items = driver.findElements(By.xpath("//div[@class='product-card__wrapper']//a[contains(@class, 'j-open-full-product-card')]")); // карточка товара
       // if (items.size() < numberOfItems) {
      //      throw new IllegalArgumentException("Недостаточно товаров для добавления в корзину.");
     //   }
      //  for (int i = 0; i < numberOfItems; i++) {
            // Используем ожидание здесь
       //     wait.until(ExpectedConditions.elementToBeClickable(items.get(i).findElement(By.xpath("//span[text()='Послезавтра']")))).click(); // кнопка добавить в корзину
      //  }
   // }

}