package PageObjects;

import com.codeborne.selenide.Condition;

public class BuyByCardPageObject {
    public BuyByCardPageObject() {
        Constant.BY_CARD_TITLE.waitUntil(Condition.visible, 1000);
        Constant.CARD_NUMBER_INPUT.isDisplayed();
        Constant.MONTH_INPUT.isDisplayed();
        Constant.YEAR_INPUT.isDisplayed();
        Constant.OWNER_INPUT.isDisplayed();
        Constant.CVC_CODE_INPUT.isDisplayed();
        Constant.CONTINUE_BUTTON.isDisplayed();
    }
}
