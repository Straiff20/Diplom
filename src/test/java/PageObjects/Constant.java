package PageObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Constant {
    //  Начальная страница
    static final SelenideElement TITLE = $(byText("Путешествие дня"));
    static final SelenideElement PROMO_PHOTO = $(".Order_cardImage__Q69ii");
    static final SelenideElement COUNTRY = $("h3.heading");
    static final SelenideElement BUY_BUTTON = $(byText("Купить"));
    static final SelenideElement BUY_CREDIT_BUTTON = $(byText("Купить в кредит"));

    static final SelenideElement CREDIT_CARD_TITLE = $(byText("Кредит по данным карты"));
    static final SelenideElement BY_CARD_TITLE = $(byText("Оплата по карте"));

    static final SelenideElement CARD_NUMBER_INPUT = $("div:nth-child(1) > span > span > span.input__top");
    static final SelenideElement MONTH_INPUT = $("div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__box > input");
    static final SelenideElement YEAR_INPUT = $("div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__box > input");
    static final SelenideElement OWNER_INPUT = $("div:nth-child(3) > span > span:nth-child(1) > span > span > span.input__box > input");
    static final SelenideElement CVC_CODE_INPUT = $("div:nth-child(3) > span > span:nth-child(2) > span > span > span.input__box > input");
    static final SelenideElement CONTINUE_BUTTON = $("#root > div > form > fieldset > div:nth-child(4) > button");
}
