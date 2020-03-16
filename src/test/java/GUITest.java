import PageObjects.AfterChoosePageObject;
import PageObjects.Constant;
import PageObjects.TravelOfDayPageObject;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GUITest {
    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true));
    }

    @AfterAll
    static void tearDown() {
        SelenideLogger.removeListener("allure");
    }

    @DisplayName("We check the form through the \"Buy\" button. We serve different card numbers")
    @ParameterizedTest
    @CsvFileSource(resources = "NotificationCheck.csv", numLinesToSkip = 1)
    static void paymentTest(int cardNumber, String baseStatus) throws Exception {
        TravelOfDayPageObject travel = new TravelOfDayPageObject();
        AfterChoosePageObject paymentSuccess = travel.paymentButtonClick();
        paymentSuccess.setFields(cardNumber);
        Constant.CONTINUE_BUTTON.click();
        Constant.NOTIFICATION_STATUS_OK.waitUntil(Condition.visible, 10);
        assertEquals(SQLRequests.getPaymentStatus(), baseStatus);
    }

    @DisplayName("We check the form through the \"buy in credit\" button. We serve different card numbers")
    @ParameterizedTest
    @CsvFileSource(resources = "NotificationCheck.csv", numLinesToSkip = 1)
    static void creditTest(int cardNumber, String baseStatus) throws Exception {
        TravelOfDayPageObject travel = new TravelOfDayPageObject();
        AfterChoosePageObject creditSuccess = travel.creditButtonClick();
        creditSuccess.setFields(cardNumber);
        Constant.CONTINUE_BUTTON.click();
        Constant.NOTIFICATION_STATUS_OK.waitUntil(Condition.visible, 10);
        assertEquals(SQLRequests.getCreditStatus(), baseStatus);
    }
}