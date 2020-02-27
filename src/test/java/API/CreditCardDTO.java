package API;

public class CreditCardDTO {
    public String cardNumber;
    public String month;
    public String year;
    public String owner;
    public String CVCCode;

    public CreditCardDTO(String cardNumber, String month, String year, String owner, String CVCCode) {
        this.cardNumber = cardNumber;
        this.month = month;
        this.year = year;
        this.owner = owner;
        this.CVCCode = CVCCode;
    }
}

