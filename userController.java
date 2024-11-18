import java.sql.*;

public class UserController {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/language_app";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public boolean login(String username, String password) {
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // True if a matching user is found
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}

