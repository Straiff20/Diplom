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

        String selectStatus = "SELECT * FROM credit_request_entity STATUS by created DESC LIMIT 1";

        if (properties.getProperty("spring.datasource.url").equals("jdbc:mysql://localhost:3306/app")) {
            try (
                    Connection conn = DriverManager.getConnection("http://localhost:3306", "app", "pass");
                    PreparedStatement cardStatusRequest = conn.prepareStatement(selectStatus)
            ) {
                ResultSet cardStatus = cardStatusRequest.executeQuery();
                return cardStatus.getString("status");
            }
        } else if (properties.getProperty("spring.datasource.url").equals("jdbc:postgresql://localhost:5432/app")) {
            try (
                    Connection conn = DriverManager.getConnection("http://localhost:5432", "app", "pass");
                    PreparedStatement cardStatusRequest = conn.prepareStatement(selectStatus)
            ) {
                ResultSet cardStatus = cardStatusRequest.executeQuery();
                return cardStatus.getString("status");
            }
        } else {
            throw new Exception();
        }
    }

    public static String getPaymentStatus() throws Exception {
        File file = new File("./application.properties");
        Properties properties = new Properties();
        properties.load(new FileReader(file));

        String selectStatus = "SELECT * FROM payment_entity STATUS by created DESC LIMIT 1";

        if (properties.getProperty("spring.datasource.url").equals("jdbc:mysql://localhost:3306/app")) {
            try (
                    Connection conn = DriverManager.getConnection("http://localhost:3306", "app", "pass");
                    PreparedStatement cardStatusRequest = conn.prepareStatement(selectStatus)
            ) {
                ResultSet cardStatus = cardStatusRequest.executeQuery();
                return cardStatus.getString("status");
            }
        } else if (properties.getProperty("spring.datasource.url").equals("jdbc:postgresql://localhost:5432/app")) {
            try (
                    Connection conn = DriverManager.getConnection("http://localhost:5432", "app", "pass");
                    PreparedStatement cardStatusRequest = conn.prepareStatement(selectStatus)
            ) {
                ResultSet cardStatus = cardStatusRequest.executeQuery();
                return cardStatus.getString("status");
            }
        } else {
            throw new Exception();
        }
    }
}