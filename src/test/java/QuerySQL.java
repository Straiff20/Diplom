import java.sql.*;

public class QuerySQL {
    public static String getStatusFromMySQL(String id) throws SQLException {
        String selectStatus = "SELECT * FROM credit_request_entity STATUS by created DESC LIMIT 1";

        try (
            Connection conn = DriverManager.getConnection("http://localhost:3306", "app", "pass");
            PreparedStatement cardStatusRequest = conn.prepareStatement(selectStatus)
        ) {
            ResultSet cardStatus = cardStatusRequest.executeQuery();
            return cardStatus.getString("status");
        }
    }

    public static String getStatusFromPostgres() throws SQLException {
        String selectStatus = "SELECT * FROM credit_request_entity STATUS by created DESC LIMIT 1";

        try (
                Connection conn = DriverManager.getConnection("http://localhost:5432", "app", "pass");
                PreparedStatement cardStatusRequest = conn.prepareStatement(selectStatus)
        ) {
            ResultSet cardStatus = cardStatusRequest.executeQuery();
            return cardStatus.getString("status");
        }
    }

}
