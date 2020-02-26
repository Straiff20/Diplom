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

    public BuyByCardPageObject buyButtonClick() {
        Constant.BUY_BUTTON.click();
        return new BuyByCardPageObject();
    }

    public BuyByCreditCardPageObject buyCreditButtonClick() {
        Constant.BUY_CREDIT_BUTTON.click();
        return new BuyByCreditCardPageObject();
    }
}
