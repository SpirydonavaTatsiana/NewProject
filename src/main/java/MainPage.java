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

    public void addItemsToCart(int i) {
        driver.navigate().refresh();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@class='main__container']"))); //product-card__wrapper

        List<WebElement> items = driver.findElements(By.xpath("//a[contains(@class, 'full-product-card')]")); // карточка товара

        int index = 0;
        int numberOfItems = 3;
        for (i = 0; i < numberOfItems; i++) {
            WebElement addToCartButton = items.get(i).findElement(By.xpath("//a[contains(@class, 'product-card__add-basket')]"));
            addToCartButton.click();

            try {
                WebElement popupOverlay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'popup-list-of-sizes')]")));
                if (popupOverlay.isDisplayed()) {
                    WebElement sizeButton = popupOverlay.findElement(By.xpath("//label[contains(@class, 'j-quick-order-size-fake')]"));
                    sizeButton.click();
                }
            } catch (org.openqa.selenium.TimeoutException e) {
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
        public void goToCart() {
        driver.findElement(By.xpath("//span[contains(@class, 'navbar-pc__icon--basket')]")).click();
    }
}