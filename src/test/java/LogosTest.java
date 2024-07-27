package Tests;

import Utils.DriverManager;
import Pages.OnlineReplenishmentPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import java.util.List;

public class LogosTest {

    private OnlineReplenishmentPage onlineReplenishmentPage;

    @Before
    public void setUp() {
        DriverManager.getDriver();
        onlineReplenishmentPage = new OnlineReplenishmentPage(DriverManager.getDriver());
        onlineReplenishmentPage.navigateToPage();
    }

    @Test
    public void LogosPresence() {
        List<String> expectedLogos = List.of("visa.svg", "visa-verified.svg", "mastercard.svg", "mastercard-secure.svg", "belkart.svg");
        for (String logo : expectedLogos) {
            assertTrue("Логотип " + logo + " не найден", onlineReplenishmentPage.isLogoPresent(logo));
        }
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}