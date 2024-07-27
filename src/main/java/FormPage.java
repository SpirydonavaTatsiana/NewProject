package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormPage {
    private WebDriver driver;

    public FormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToHomePage(String url) {
        driver.get(url);
        driver.findElement(By.id("cookie-agree")).click(); // Принять куки
    }

    public void fillInPhoneNumber(String phoneNumber) {
        WebElement phoneNumberInput = driver.findElement(By.id("connection-phone"));
        phoneNumberInput.click();
        phoneNumberInput.sendKeys(phoneNumber);
    }

    public void fillInSum(String sum) {
        WebElement sumInput = driver.findElement(By.id("connection-sum"));
        sumInput.click();
        sumInput.sendKeys(sum);
    }

    public void fillInEmail(String email) {
        WebElement emailInput = driver.findElement(By.id("connection-email"));
        emailInput.click();
        emailInput.sendKeys(email);
    }

    public void clickContinueButton() {
        WebElement continueButton = driver.findElement(By.xpath("//button[contains(text(), 'Продолжить')]")); // Более стабильный локатор можно использовать.
        continueButton.click();
    }
}
