package PageObjects;

import Data.DataInfo;
import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.open;

public class TravelOfDayPageObject {

    public static final int PAYMENT = 0;
    public static final int CREDIT = 1;

    public static final int APPROVED_CARD = 0;
    public static final int DECLINED_CARD = 1;
    public static final int UNKNOWN_CARD = 2;

    int type;
    int typeCard;

    public TravelOfDayPageObject() {
        open("http://localhost:8080/");
        Constant.TITLE.waitUntil(Condition.visible, 10000);
        Constant.PROMO_PHOTO.isDisplayed();
        Constant.COUNTRY.isDisplayed();
        Constant.PAYMENT_BUTTON.isDisplayed();
        Constant.CREDIT_BUTTON.isDisplayed();
    }

    public void choosePayMethod(int type) {
        this.type = type;

//        Constant.PAYMENT_CARD_TITLE.waitUntil(Condition.visible, 10000);
        if (this.type == PAYMENT) {
            //проверить заголовок (Оплата по карте)
            Constant.PAYMENT_CARD_TITLE.shouldHave(Condition.text("Оплата по карте"));
        } else if (this.type == CREDIT) {
            //проверить заголовок (Кредит по данным карты)
            Constant.CREDIT_CARD_TITLE.shouldHave(Condition.text("Кредит по данным карты"));
        }

        Constant.CARD_NUMBER_INPUT.isDisplayed();
        Constant.MONTH_INPUT.isDisplayed();
        Constant.YEAR_INPUT.isDisplayed();
        Constant.OWNER_INPUT.isDisplayed();
        Constant.CVC_CODE_INPUT.isDisplayed();
        Constant.CONTINUE_BUTTON.isDisplayed();
    }

    public TravelOfDayPageObject setFields(int typeCard) {
        this.typeCard = typeCard;

        if (typeCard == APPROVED_CARD) {
            Constant.CARD_NUMBER_INPUT.click();
            Constant.CARD_NUMBER_INPUT.sendKeys(Constant.APPROVED_CARD_NUMBER);
        } else if (typeCard == DECLINED_CARD) {
            Constant.CARD_NUMBER_INPUT.click();
            Constant.CARD_NUMBER_INPUT.sendKeys(Constant.DECLINED_CARD_NUMBER);
        } else if (typeCard == UNKNOWN_CARD) {
            Constant.CARD_NUMBER_INPUT.click();
            Constant.CARD_NUMBER_INPUT.sendKeys((Constant.UNKNOWN_CARD_NUMBER));
        }
        Constant.MONTH_INPUT.click();
        Constant.MONTH_INPUT.sendKeys(DataInfo.getRandomMonth());
        Constant.YEAR_INPUT.click();
        Constant.YEAR_INPUT.sendKeys(DataInfo.getRandomYear());
        Constant.OWNER_INPUT.click();
        Constant.OWNER_INPUT.sendKeys(DataInfo.getRandomOwner());
        Constant.CVC_CODE_INPUT.click();
        Constant.CVC_CODE_INPUT.sendKeys(DataInfo.getRandomCvcCode());
        return this;
    }

    public TravelOfDayPageObject paymentButtonClick() {
        Constant.PAYMENT_BUTTON.click();
        choosePayMethod(PAYMENT);
        return this;
    }

    public TravelOfDayPageObject creditButtonClick() {
        Constant.CREDIT_BUTTON.click();
        choosePayMethod(CREDIT);
        return this;
    }
}
