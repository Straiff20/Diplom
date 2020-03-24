import Data.DataInfo;
import Data.InvalidDataInfo;
import PageObjects.Constant;
import PageObjects.TravelOfDayPageObject;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Description;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GUITest {
    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true));
    }

    @BeforeEach
    @DisplayName("Clear base table")
    void cleanTable() throws Exception {
        SQLRequests.clearTables();
    }

    @AfterAll
    static void tearDown() {
        SelenideLogger.removeListener("allure");
    }

    @DisplayName("By to payment")
    @Description("We check the form through the \"Buy\" button. We serve different card numbers")
    @ParameterizedTest
    @CsvFileSource(resources = "./NotificationCheck.csv", numLinesToSkip = 1)
    void paymentTest(int cardNumber, String baseStatus) throws Exception {
        TravelOfDayPageObject travel = new TravelOfDayPageObject()
                .paymentButtonClick()
                .setFields(cardNumber);
        Constant.CONTINUE_BUTTON.click();
        Constant.NOTIFICATION_STATUS_OK.waitUntil(Condition.visible, 10000);
        assertEquals(SQLRequests.getPaymentStatus(), baseStatus);
    }

    @DisplayName("By to credit")
    @Description("We check the form through the \"buy in credit\" button. We serve different card numbers")
    @ParameterizedTest
    @CsvFileSource(resources = "./NotificationCheck.csv", numLinesToSkip = 1)
    void creditTest(int cardNumber, String baseStatus) throws Exception {
        TravelOfDayPageObject travel = new TravelOfDayPageObject()
                .creditButtonClick()
                .setFields(cardNumber);
        Constant.CONTINUE_BUTTON.click();
        Constant.NOTIFICATION_STATUS_OK.waitUntil(Condition.visible, 10000);
        assertEquals(SQLRequests.getCreditStatus(), baseStatus);
    }

    @DisplayName("By to payment with unknown card")
    @Description("Check the form through the \"Buy\" button. Use unknown card number")
    @Test
    void paymentWithUnknownCardNumber() {
        TravelOfDayPageObject travel = new TravelOfDayPageObject()
                .paymentButtonClick()
                .setFields(2);
        Constant.CONTINUE_BUTTON.click();
        Constant.NOTIFICATION_STATUS_ERROR.waitUntil(Condition.visible, 10000);
    }

    @DisplayName("By to credit with unknown card")
    @Description("Check the form through the \"buy in credit\" button. Use unknown card number")
    @Test
    void creditWithUnknownCardNumber() {
        TravelOfDayPageObject travel = new TravelOfDayPageObject()
                .creditButtonClick()
                .setFields(2);
        Constant.CONTINUE_BUTTON.click();
        Constant.NOTIFICATION_STATUS_ERROR.waitUntil(Condition.visible, 10000);
    }

    @DisplayName("Empty fields payment form")
    @Description("All fields is empty, choose payment and push button \"next")
    @Test
    void emptyFieldsPaymentCheck() {
        TravelOfDayPageObject travel = new TravelOfDayPageObject()
                .paymentButtonClick();
        Constant.CONTINUE_BUTTON.click();
        Constant.CARD_NUMBER_FIELD_ERROR.isDisplayed();
        Constant.MONTH_FIELD_ERROR.isDisplayed();
        Constant.YEAR_FIELD_ERROR_UNKNOWN_FORMAT.isDisplayed();
        Constant.OWNER_FIELD_ERROR.isDisplayed();
        Constant.CVC_FIELD_ERROR.isDisplayed();
    }

    @DisplayName("Empty fields credit form")
    @Description("All fields is empty, choose credit and push button \"next")
    @Test
    void emptyFieldsCreditCheck() {
        TravelOfDayPageObject travel = new TravelOfDayPageObject()
                .creditButtonClick();
        Constant.CONTINUE_BUTTON.click();
        Constant.CARD_NUMBER_FIELD_ERROR.isDisplayed();
        Constant.MONTH_FIELD_ERROR.isDisplayed();
        Constant.YEAR_FIELD_ERROR_UNKNOWN_FORMAT.isDisplayed();
        Constant.OWNER_FIELD_ERROR.isDisplayed();
        Constant.CVC_FIELD_ERROR.isDisplayed();
    }

    @DisplayName("Wrong format to valid date fields")
    @Description("Set past year and unreal month")
    @Test
    void invalidDateFieldsPaymentCheck() {
        TravelOfDayPageObject travel = new TravelOfDayPageObject()
                .paymentButtonClick();
        Constant.CARD_NUMBER_INPUT.sendKeys(InvalidDataInfo.CardFields.getUnknownFormatCardNumber());
        Constant.MONTH_INPUT.sendKeys(InvalidDataInfo.CardFields.getInvalidMonth());
        Constant.YEAR_INPUT.sendKeys(InvalidDataInfo.CardFields.getPastYear());
        Constant.OWNER_INPUT.sendKeys(DataInfo.getRandomOwner());
        Constant.CVC_CODE_INPUT.sendKeys(InvalidDataInfo.CardFields.getInvalidCvcCode());
        Constant.CONTINUE_BUTTON.click();
        Constant.CARD_NUMBER_FIELD_ERROR.isDisplayed();
        Constant.MONTH_FIELD_ERROR.isDisplayed();
        Constant.YEAR_FIELD_DATE_VALIDATE_ERROR.isDisplayed();
        Constant.CVC_FIELD_ERROR.isDisplayed();
    }
}