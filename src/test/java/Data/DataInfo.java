package Data;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

public class DataInfo {
    private DataInfo() {
    }
    //  Получить поля
    public static CardFields getCardFields() {
        String month = getRandomMonth();
        String year = getRandomYear();
        String owner = getRandomOwner();
        String cvcCode = getRandomCVCCode();
        return new CardFields(month, year, owner, cvcCode);
    }

    public static String getRandomMonth() {
        String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        Random random = new Random();
        int i = random.nextInt(months.length);
        return months[i];
    }

    public static String getRandomYear() {
        String[] years = {"20", "21", "22", "23"};
        Random random = new Random();
        int i = random.nextInt(years.length);
        return years[i];
    }

    public static String getRandomOwner() {
        Faker faker = new Faker(new Locale("us"));
        return faker.name().firstName() + " " + faker.name().lastName();
    }

    public static String getRandomCVCCode() {
        Random random = new Random();
        int rnd = random.nextInt(900) + 100;
        return Integer.toString(rnd);
    }

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
}
