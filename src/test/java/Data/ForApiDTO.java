package Data;

public class ForApiDTO {
    public String number;
    public int month;
    public int year;
    public String holder;
    public int cvc;

    public ForApiDTO(String number, int month, int year, String holder, int cvc) {
        this.number = number;
        this.month = month;
        this.year = year;
        this.holder = holder;
        this.cvc = cvc;
    }
}