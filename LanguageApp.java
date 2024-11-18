import java.sql.*;

public class LanguageApp {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/language_app";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            System.out.println("Connected to the database!");

            // Example: Fetching data
            String query = "SELECT * FROM courses";
            try (Statement stmt = connection.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {
                while (rs.next()) {
                    System.out.println("Course: " + rs.getString("course_name"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
