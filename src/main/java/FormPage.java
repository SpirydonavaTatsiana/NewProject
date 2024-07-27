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
        driver.findElement(By.id("cookie-agree")).click();
    }

    public String getPhoneNumberPlaceholder() {
        WebElement phoneNumberInput = driver.findElement(By.id("connection-phone"));
        return phoneNumberInput.getAttribute("placeholder");
    }

    public String getAmountPlaceholder() {
        WebElement amountInput = driver.findElement(By.id("connection-sum"));
        return amountInput.getAttribute("placeholder");
    }

    public String getEmailPlaceholder() {
        WebElement emailInput = driver.findElement(By.id("connection-email"));
        return emailInput.getAttribute("placeholder");
    }

    public void selectService(String serviceName) {
        driver.findElement(By.xpath("//div[2]/button/span[1][contains(text(), '" + serviceName + "')]")).click();
    }

    public String getAbonentNumberPlaceholder() {
        WebElement abonentNumberInput = driver.findElement(By.id("internet-phone"));
        return abonentNumberInput.getAttribute("placeholder");
    }

    public String getAccountNumberPlaceholder() {
        WebElement accountNumberInput = driver.findElement(By.id("score-instalment"));
        return accountNumberInput.getAttribute("placeholder");
    }

    public String getAccountArrearsNumberPlaceholder() {
        WebElement accountArrearsNumberInput = driver.findElement(By.id("score-arrears"));
        return accountArrearsNumberInput.getAttribute("placeholder");
    }
}