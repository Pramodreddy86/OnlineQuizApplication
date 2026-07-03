import java.sql.*;
import java.util.ArrayList;

public class LeaderboardDAO {

    public ArrayList<String> getLeaderboard() {

        ArrayList<String> list = new ArrayList<>();

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT user_email, score, total_questions, percentage FROM results ORDER BY score DESC, percentage DESC LIMIT 10";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            int rank = 1;

            while (rs.next()) {

                String row =
                        rank + ". "
                        + rs.getString("user_email")
                        + "   Score : "
                        + rs.getInt("score")
                        + "/"
                        + rs.getInt("total_questions")
                        + "   ("
                        + rs.getDouble("percentage")
                        + "%)";

                list.add(row);
                rank++;
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}