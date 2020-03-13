package PageObjects;

import Data.DataInfo;
import com.codeborne.selenide.Condition;

public class AfterChoosePageObject extends TravelOfDayPageObject {

    public static final int payment = 0;
    public static final int credit = 1;

    int type;

    public AfterChoosePageObject(int type) {
        super();
        this.type = type;
        Constant.PAYMENT_CARD_TITLE.waitUntil(Condition.visible, 1000);

        if (this.type == payment) {
            //проверить заголовок (Оплата по карте)
            Constant.PAYMENT_CARD_TITLE.shouldHave(Condition.text("Оплата по карте"));
        } else if (this.type == credit) {
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

    public void setFields() {
        Constant.CARD_NUMBER_INPUT.setValue(Constant.approvedCardNumber);
        Constant.MONTH_INPUT.setValue(DataInfo.getRandomMonth());
        Constant.YEAR_INPUT.setValue(DataInfo.getRandomYear());
        Constant.OWNER_INPUT.setValue(DataInfo.getRandomOwner());
        Constant.CVC_CODE_INPUT.setValue(DataInfo.getRandomCVCCode());
    }
}
