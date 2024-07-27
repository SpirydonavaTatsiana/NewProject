package Tests;

import Utils.DriverManager;
import Pages.ServicePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.time.Duration;

public class LinkTest {
    private ServicePage servicePage;

    @Before
    public void setUp() {
        DriverManager.getDriver();
        servicePage = new ServicePage(DriverManager.getDriver());
        DriverManager.getDriver().manage().window().maximize();
        DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testServiceLink() {
        servicePage.navigateToHomePage();
        servicePage.clickServiceLink();
        String headerText = servicePage.getPageHeader();
        assertEquals("Порядок оплаты и безопасность интернет платежей", headerText);
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
