import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
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
        driver.navigate().refresh();
    }

    public void addItemsToCart(int i) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='product-card__wrapper']")));
        List<WebElement> items = driver.findElements(By.xpath("//a[contains(@class, 'j-open-full-product-card')]")); // карточка товара

        //if (items.size() < numberOfItems) {
        //    throw new IllegalArgumentException("Недостаточно товаров для добавления в корзину.");
        //}

        int numberOfItems = 3;
        for (i = 0; i < numberOfItems; i++) {
            WebElement addToCartButton;
            addToCartButton = items.get(i).findElement(By.xpath("//a[contains(@class, 'j-add-to-basket')]"));
            //wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
            addToCartButton.click();
            //driver.navigate().refresh();
            try {
                WebElement sizePopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'popup-list-of-sizes')]")));

                // Если попап появился, выбираем размер (например, первый размер)
                WebElement sizeOption = sizePopup.findElement(By.xpath("//li[contains(@class, 'sizes-list__item')]"));
                sizeOption.click();

                // Подтверждаем выбор размера (если необходимо)
                //WebElement confirmButton = sizePopup.findElement(By.xpath("//button[contains(@class, 'confirm-size')]")); // Измените XPath на правильный для вашего сайта
                // confirmButton.click();

            } catch (TimeoutException e) {
                // Если попап не появился, просто продолжаем цикл
                //System.out.println("Попап не появился для товара " + (i + 1));
            }
        }



        try {
            Thread.sleep(1000);
        }
            catch (InterruptedException e){
                e.printStackTrace();
            }
    }
    public void goToCart() {
        driver.findElement(By.xpath("//span[contains(@class, 'navbar-pc__icon--basket')]")).click();
    }
}