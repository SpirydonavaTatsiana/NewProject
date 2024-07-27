package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaymentPage {
    private WebDriver driver;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void agreeToCookies() {
        driver.findElement(By.id("cookie-agree")).click();
    }

    public void fillPhoneNumber(String phoneNumber) {
        WebElement phoneNumberInput = driver.findElement(By.id("connection-phone"));
        phoneNumberInput.click();
        phoneNumberInput.sendKeys(phoneNumber);
    }

    public void fillAmount(String amount) {
        WebElement sumInput = driver.findElement(By.id("connection-sum"));
        sumInput.click();
        sumInput.sendKeys(amount);
    }

    public void fillEmail(String email) {
        WebElement emailInput = driver.findElement(By.id("connection-email"));
        emailInput.click();
        emailInput.sendKeys(email);
    }

    public void clickContinue() {
        WebElement continueButton = driver.findElement(By.xpath("//button[contains(text(), 'Продолжить')]"));
        continueButton.click();
    }

    public void switchToPaymentFrame() {
        driver.switchTo().frame(0); // Переключение на фрейм платежа
    }

    public String getPaymentAmount() {
        return driver.findElement(By.xpath("//div[contains(text(), '25.00 BYN')]")).getText();
    }

    public String getPhoneNumber() {
        return driver.findElement(By.xpath("//span[contains(text(), 'Оплата: Услуги связи Номер:')]")).getText();
    }

    public String getCardNumberAttribute() {
        return driver.findElement(By.cssSelector(".ng-tns-c46-1.ng-star-inserted")).getAttribute("innerText");
    }

    public String getExpiryDateAttribute() {
       return driver.findElement(By.className("date-input")).getAttribute("innerText");
    }

    public String getCVCAttribute() {
        WebElement codeCVCInput = driver.findElement(By.name("verification_value"));
        return codeCVCInput.getAttribute("placeholder");
    }

    public String getHolderNameAttribute() {
        WebElement holderNameInput = driver.findElement(By.xpath("//label[contains(text(), 'Имя держателя (как на карте)')]"));
        return holderNameInput.getAttribute("placeholder");
    }
}
