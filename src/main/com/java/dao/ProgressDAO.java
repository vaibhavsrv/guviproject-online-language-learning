package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProgressDAO {
    private Connection connection = DBConnection.getConnection();

    public boolean updateProgress(int userId, String language, int progressLevel) {
        try {
            String sql = "INSERT INTO progress (user_id, language, progress_level) VALUES (?, ?, ?) " +
                    "ON DUPLICATE KEY UPDATE progress_level = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, userId);
            stmt.setString(2, language);
            stmt.setInt(3, progressLevel);
            stmt.setInt(4, progressLevel);
            stmt.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<String> getProgress(int userId) {
        List<String> progressList = new ArrayList<>();
        try {
            String sql = "SELECT language, progress_level FROM progress WHERE user_id = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                progressList.add(rs.getString("language") + ": " + rs.getInt("progress_level") + "%");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return progressList;
    }
}
