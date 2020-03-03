package Data;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.Locale;

public class InvalidData {

    //  Класс с неверными данными для полей в карте
    public static class InvalidCard {
        private String invalidYear;
        private String rusOwner;
        private String ownerWithSymbols;
        private String invalidCard;
        private String cvcWrongCode;

        public InvalidCard(String invalidYear, String rusOwner, String ownerWithSymbols, String invalidCard, String cvcWrongCode) {
            this.invalidYear = invalidYear;
            this.rusOwner = rusOwner;
            this.ownerWithSymbols = ownerWithSymbols;
            this.invalidCard = invalidCard;
            this.cvcWrongCode = cvcWrongCode;
        }

        public static InvalidCardFields getInvalidCardField() {
            LocalDate today = LocalDate.now();
            Faker faker = new Faker(new Locale("rus"));
            String invalidYear = String.format("%tm", today.minusYears(1));
            String invalidCard = "1111 1111 1111 1111";
            String cvcWrongCode = "22";
            String ownerWithSymbols = "L!s@ Simpson";
            String rusOwner = faker.name().firstName() + " " + faker.name().lastName();
            return InvalidCardFields(invalidYear, invalidCard, cvcWrongCode, ownerWithSymbols, rusOwner);
        }
    }

}
