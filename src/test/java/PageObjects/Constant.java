package PageObjects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Constant {
    // Карты
    public static final String APPROVED_CARD_NUMBER = "4444 4444 4444 4441";
    public static final String DECLINED_CARD_NUMBER = "4444 4444 4444 4442";
    public static final String UNKNOWN_CARD_NUMBER = "1111 1111 1111 1111";

    //  Начальная страница
    public static final SelenideElement TITLE = $(byText("Путешествие дня"));
    public static final SelenideElement PROMO_PHOTO = $(".Order_cardImage__Q69ii");
    public static final SelenideElement COUNTRY = $("h3.heading");
    public static final SelenideElement PAYMENT_BUTTON = $(byText("Купить"));
    public static final SelenideElement CREDIT_BUTTON = $(byText("Купить в кредит"));

    public static final SelenideElement CREDIT_CARD_TITLE = $(byText("Кредит по данным карты"));
    public static final SelenideElement PAYMENT_CARD_TITLE = $(byText("Оплата по карте"));

    public static final SelenideElement CARD_NUMBER_INPUT = $("div:nth-child(1) > span > span > span.input__top");
    public static final SelenideElement MONTH_INPUT = $("div:nth-child(2) > span > span:nth-child(1) > span > span > span.input__box > input");
    public static final SelenideElement YEAR_INPUT = $("div:nth-child(2) > span > span:nth-child(2) > span > span > span.input__box > input");
    public static final SelenideElement OWNER_INPUT = $("div:nth-child(3) > span > span:nth-child(1) > span > span > span.input__box > input");
    public static final SelenideElement CVC_CODE_INPUT = $("div:nth-child(3) > span > span:nth-child(2) > span > span > span.input__box > input");
    public static final SelenideElement CONTINUE_BUTTON = $("#root > div > form > fieldset > div:nth-child(4) > button");

    public static final SelenideElement NOTIFICATION_STATUS_OK = $(".notification_status_ok");

    public static final SelenideElement NOTIFICATION_STATUS_ERROR = $(".notification_status_error");
}
