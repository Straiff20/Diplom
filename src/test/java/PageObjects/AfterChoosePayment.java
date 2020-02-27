package PageObjects;

import com.codeborne.selenide.Condition;

public class AfterChoosePayment extends TravelOfDayPageObject {

    public static final int DebitCard = 0;
    public static final int CreditCard = 1;

    int type;
    public AfterChoosePayment(int type) {
        super();
        this.type = type;
        Constant.BY_CARD_TITLE.waitUntil(Condition.visible, 1000);

        if(this.type == DebitCard)
        {
            //проверить заголовок (Оплата по карте)
            Constant.BY_CARD_TITLE.shouldHave(Condition.text("Оплата по карте"));
        }
        else if(this.type == CreditCard)
        {
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
}
