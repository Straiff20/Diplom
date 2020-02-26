package Data;

import com.github.javafaker.Faker;

import java.util.Locale;

public class FakerData {
    public static class fields{
        private fields() {}

        public static CardInfo generateCardFields(String locale) {
            Faker faker = new Faker(new Locale(locale));
            return new CardInfo(faker.name().username(),
                    faker.code().)
        }
    }
}
