package PageObjects;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class BuyByCreditCardPageObject {
    public BuyByCreditCardPageObject() {
        Constant.CREDIT_CARD_TITLE.waitUntil(Condition.visible, 10000);
        Constant.CARD_NUMBER_INPUT.isDisplayed();
        Constant.MONTH_INPUT.isDisplayed();
        Constant.YEAR_INPUT.isDisplayed();
        Constant.OWNER_INPUT.isDisplayed();
        Constant.CVC_CODE_INPUT.isDisplayed();
        Constant.CONTINUE_BUTTON.isDisplayed();
    }

    public BuyByCreditCardPageObject fillFields(String locale) {
        Faker faker = new Faker(new Locale(locale));
        Random random = new Random();

        ownerInput.setValue(random.name)
    }
}
