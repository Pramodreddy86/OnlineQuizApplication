import java.sql.*;

public class ResultDAO {

    public boolean saveResult(String email, int score, int totalQuestions) {

        try {
            Connection con = DBConnection.getConnection();

            double percentage = ((double) score / totalQuestions) * 100;

            String sql = "INSERT INTO results(user_email, score, total_questions, percentage) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setInt(2, score);
            ps.setInt(3, totalQuestions);
            ps.setDouble(4, percentage);

            int rows = ps.executeUpdate();

            con.close();

            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}