package PageObjects;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.open;

public class TravelOfDayPageObject {
    public TravelOfDayPageObject() {
        open("http://localhost:8080/");
        Constant.TITLE.waitUntil(Condition.visible, 10000);
        Constant.PROMO_PHOTO.isDisplayed();
        Constant.COUNTRY.isDisplayed();
        Constant.PAYMENT_BUTTON.isDisplayed();
        Constant.CREDIT_BUTTON.isDisplayed();
    }

    public AfterChoosePageObject paymentButtonClick() {
        Constant.PAYMENT_BUTTON.click();
        return new AfterChoosePageObject(AfterChoosePageObject.payment);
    }

    public AfterChoosePageObject creditButtonClick() {
        Constant.CREDIT_BUTTON.click();
        return new AfterChoosePageObject(AfterChoosePageObject.credit);
    }
}
