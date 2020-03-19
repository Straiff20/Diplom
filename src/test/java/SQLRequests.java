import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class SQLRequests {
    public static String getCreditStatus() throws Exception {
        File file = new File("./application.properties");
        Properties properties = new Properties();
        properties.load(new FileReader(file));

        String[] parts = properties.getProperty("spring.datasource.url").split(":");
        parts[2] = "//localhost";
        String url = String.join(":", parts);

        String selectStatus = "SELECT * FROM credit_request_entity ORDER BY created DESC LIMIT 1";

        try (
                Connection conn = DriverManager.getConnection(url,
                        properties.getProperty("spring.datasource.username"),
                        properties.getProperty("spring.datasource.password"));
                PreparedStatement cardStatusRequest = conn.prepareStatement(selectStatus);
        ) {
            ResultSet cardStatus = cardStatusRequest.executeQuery();
            cardStatus.next();
            return cardStatus.getString("status");
        }
    }

    public static String getPaymentStatus() throws Exception {
        File file = new File("./application.properties");
        Properties properties = new Properties();
        properties.load(new FileReader(file));

        String[] parts = properties.getProperty("spring.datasource.url").split(":");
        parts[2] = "//localhost";
        String url = String.join(":", parts);

        String selectStatus = "SELECT * FROM payment_entity ORDER BY created DESC LIMIT 1";

        try (
                Connection conn = DriverManager.getConnection(url,
                        properties.getProperty("spring.datasource.username"),
                        properties.getProperty("spring.datasource.password"));
                PreparedStatement cardStatusRequest = conn.prepareStatement(selectStatus);
        ) {
            ResultSet cardStatus = cardStatusRequest.executeQuery();
            cardStatus.next();
            return cardStatus.getString("status");
        }
    }
}