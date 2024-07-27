package Tests;

import Utils.DriverManager;
import Pages.PaymentPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OnlinePay {
    private PaymentPage paymentPage;

    @Before
    public void setUp() {
        DriverManager.getDriver(); // Инициализация драйвера
        paymentPage = new PaymentPage(DriverManager.getDriver());
        DriverManager.getDriver().manage().window().maximize();
    }

    @Test
    public void checkFillingForm() {
        DriverManager.getDriver().get("https://mts.by");
        paymentPage.agreeToCookies();

        paymentPage.fillPhoneNumber("297777777");
        paymentPage.fillAmount("25");
        paymentPage.fillEmail("ivanov456987@gmail.com");
        paymentPage.clickContinue();

        // Переход в фрейм платежа
        paymentPage.switchToPaymentFrame();

        assertEquals("Номер карты", paymentPage.getCardNumberPlaceholder(), "Плейсхолдер для номера карты не соответствует ожидаемому.");
        assertEquals("Срок действия", paymentPage.getExpiryDatePlaceholder(), "Плейсхолдер для срока действия не соответствует ожидаемому.");
        assertEquals("CVC", paymentPage.getCVCPlaceholder(), "Плейсхолдер для CVC не соответствует ожидаемому.");
        assertEquals("Имя держателя (как на карте)", paymentPage.getHolderNamePlaceholder(), "Плейсхолдер для имени держателя карты не соответствует ожидаемому.");
        assertEquals("25.00 BYN", paymentPage.getPaymentAmount(), "Сумма платежа не соответствует ожидаемому.");

        String phoneNumber = paymentPage.getPhoneNumber();
        assertEquals("Оплата: Услуги связи Номер:375297777777", phoneNumber, "Номер телефона не соответствует ожидаемому.");
    }

    @After
    public void tearDown() {
        DriverManager.quitDriver(); // Закрытие драйвера
    }
}
