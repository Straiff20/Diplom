package PageObjects;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.open;

public class TravelOfDayPageObject {
    public TravelOfDayPageObject() {
        open("http://localhost:8080/");
        Constant.TITLE.waitUntil(Condition.visible, 10000);
        Constant.PROMO_PHOTO.isDisplayed();
        Constant.COUNTRY.isDisplayed();
        Constant.BUY_BUTTON.isDisplayed();
        Constant.BUY_CREDIT_BUTTON.isDisplayed();
    }

    public AfterChoosePayment buyButtonClick() {
        Constant.BUY_BUTTON.click();
        return new AfterChoosePayment(AfterChoosePayment.DebitCard);
    }

    public AfterChoosePayment buyCreditButtonClick() {
        Constant.BUY_CREDIT_BUTTON.click();
        return new AfterChoosePayment(AfterChoosePayment.CreditCard);
    }
}
