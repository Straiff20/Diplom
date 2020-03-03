package Data;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class ValidData {
    private ValidData() {
    }

    //  Карта с approved
    public static CardNumber approvedCard() {
        return new CardNumber("4444 4444 4444 4441", "APPROVED");
    }

    //  карта с declined
    public static CardNumber declinedCard() {
        return new CardNumber("4444 4444 4444 4442", "DECLINED");
    }

    //  Получить поля
    public static CardFields getCardFields() {
        String month = getRandomMonth();
        String year = getRandomYear();
        String owner = getRandomOwner();
        String cvcCode = getRandomCVCCode();
        return new CardFields(month, year, owner, cvcCode);
    }

    //  Получить случайный месяц
    public static String getRandomMonth() {
        String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        Random random = new Random();
        int index = random.nextInt(months.length);
        return months[index];
    }

    //  Получить случайный близайший год
    public static String getRandomYear() {
        String[] years = {"20", "21", "22", "23"};
        Random random = new Random();
        int index = random.nextInt(years.length);
        return years[index];
    }

    //  Сгенерировать имя латинницей
    public static String getRandomOwner() {
        Faker faker = new Faker(new Locale("us"));
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    //  Сгенерировать cvc-code
    public static String getRandomCVCCode() {
        Random random = new Random();
        int rnd = random.nextInt(900) + 100;
        return Integer.toString(rnd);
    }

    //  Класс с данными карты
    public static class CardFields {
        private String month;
        private String year;
        private String owner;
        private String cvcCode;

        public CardFields(String month, String year, String owner, String cvcCode) {
            this.month = month;
            this.year = year;
            this.owner = owner;
            this.cvcCode = cvcCode;
        }
    }

    //  Класс с картами
    public static class CardNumber {
        private String cardNumber;
        private String status;

        public CardNumber(String cardNumber, String status) {
            this.cardNumber = cardNumber;
            this.status = status;
        }
    }
}
