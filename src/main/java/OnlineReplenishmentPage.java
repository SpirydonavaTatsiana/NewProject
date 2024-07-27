package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class OnlineReplenishmentPage {
    private WebDriver driver;

    public OnlineReplenishmentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToPage() {
        driver.get("https://mts.by");
    }

    public WebElement getOnlineReplenishmentBlock() {
        return driver.findElement(By.xpath("//div[2]/section/div")); // Подберите более стабильный селектор CSS
    }

    public boolean isLogoPresent(String logo) {
        List<WebElement> logoElements = getOnlineReplenishmentBlock().findElements(By.xpath("//img[contains(@src, '" + logo + "')]"));
        return logoElements.size() > 0;
    }
}