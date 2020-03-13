import Data.DataInfo;
import PageObjects.AfterChoosePageObject;
import PageObjects.TravelOfDayPageObject;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class GUITest {
    @BeforeAll
    static void setUpAll() {
        SelenideLogger.addListener("allure", new AllureSelenide().screenshots(true));
    }

    @AfterAll
    static void tearDown() {
        SelenideLogger.removeListener("allure");
    }

    @Test
    static void paymentHappyTest() {
        TravelOfDayPageObject travel = new TravelOfDayPageObject();
        AfterChoosePageObject paymentSuccess = travel.paymentButtonClick();
        paymentSuccess.setFields();
    }
}
