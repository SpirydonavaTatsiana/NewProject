package Tests;

import Utils.DriverManager;
import Pages.FormPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.Duration;

public class FillInFormTest {
    private FormPage formPage;

    @Before
    public void setUp() {
        DriverManager.getDriver();
        formPage = new FormPage(DriverManager.getDriver());
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void fillInFormTest() {
        formPage.navigateToHomePage("https://mts.by");
        formPage.fillInPhoneNumber("297777777");
        formPage.fillInSum("25");
        formPage.fillInEmail("ivanov456987@gmail.com");
        formPage.clickContinueButton();
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}