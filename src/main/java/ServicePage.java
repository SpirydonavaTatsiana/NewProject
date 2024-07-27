package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ServicePage {
    private WebDriver driver;

    public ServicePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToHomePage() {
        driver.get("https://mts.by");
        driver.findElement(By.id("cookie-agree")).click();
    }

    public void clickServiceLink() {
        WebElement serviceLink = driver.findElement(By.xpath("//a[contains(text(), 'Подробнее о сервисе')]"));
        serviceLink.click();
    }

    public String getPageHeader() {
        WebElement pageHeader = driver.findElement(By.cssSelector("ul li:nth-child(3) span > span"));
        return pageHeader.getText();
    }
}
