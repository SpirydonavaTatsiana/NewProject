
package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObject {
    private WebDriver driver;

    public PageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void agreeToCookies() {
        driver.findElement(By.id("cookie-agree")).click();
    }
    public String getBlockTitle() {
        return driver.findElement(By.xpath("//h2[contains(text(), 'Онлайн пополнение')]")).getText();
    }
}
