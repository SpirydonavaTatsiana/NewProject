package Tests;

import Utils.DriverManager;
import Pages.FormPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmptyFieldTest {
    private FormPage formPage;

    @Before
    public void setUp() {
        DriverManager.getDriver();
        formPage = new FormPage(DriverManager.getDriver());
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkPlaceholdersOfEmptyFields() {
        formPage.navigateToHomePage("https://mts.by");

        assertEquals("Номер телефона", formPage.getPhoneNumberPlaceholder(), "Плейсхолдер для номера телефона не соответствует ожидаемому.");
        assertEquals("Сумма", formPage.getAmountPlaceholder(), "Плейсхолдер для суммы не соответствует ожидаемому.");
        assertEquals("E-mail для отправки чека", formPage.getEmailPlaceholder(), "Плейсхолдер для E-mail не соответствует ожидаемому.");

        formPage.selectService("Услуги связи");
        formPage.selectService("Домашний интернет");
        assertEquals("Номер абонента", formPage.getAbonentNumberPlaceholder(), "Плейсхолдер для номера абонента не соответствует ожидаемому.");

        formPage.selectService("Рассрочка");
        assertEquals("Номер счета на 44", formPage.getAccountNumberPlaceholder(), "Плейсхолдер для номера счета не соответствует ожидаемому.");

        formPage.selectService("Задолженность");
        assertEquals("Номер счета на 2073", formPage.getAccountArrearsNumberPlaceholder(), "Плейсхолдер для номера счета не соответствует ожидаемому.");
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
