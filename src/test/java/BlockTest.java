package Tests;

import Utils.DriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BlockTest {

    private Pages.PageObject homePage;

    @Before
    public void setUp() {
        DriverManager.getDriver().get("https://www.mts.by/");
        homePage = new Pages.PageObject(DriverManager.getDriver());
        homePage.agreeToCookies();
    }

    @Test
    public void testBlockTitle() {
        String blockTitle = homePage.getBlockTitle();
        assertEquals("Онлайн пополнение\nбез комиссии", blockTitle);
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
