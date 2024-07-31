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

    public void addItemsToCart(int numberOfItems) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='product-card__wrapper']")));
        List<WebElement> items = driver.findElements(By.xpath("//a[contains(@class, 'j-open-full-product-card')]")); // карточка товара

        for (int i = 0; i < numberOfItems; i++) {
            WebElement addToCartButton = driver.findElement(By.xpath("//a[contains(@class, 'j-add-to-basket')]"));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@class, 'j-add-to-basket')]"))).click();
            driver.navigate().refresh();
            try {
                WebElement sizePopup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'popup-list-of-sizes')]")));
                WebElement sizeOption = sizePopup.findElement(By.xpath("//li[contains(@class, 'sizes-list__item')]"));
                sizeOption.click();
            } catch (TimeoutException e) {
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