import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class ResultFrame extends JFrame {

    JTextArea area;

    public ResultFrame() {

        setTitle("Quiz Results");
        setSize(500,400);
        setLayout(new BorderLayout());

        area = new JTextArea();
        area.setEditable(false);

        add(new JScrollPane(area), BorderLayout.CENTER);

        loadResults();

        setLocationRelativeTo(null);
        setVisible(true);
    }

    void loadResults() {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "SELECT score,total_questions,percentage,quiz_date FROM results WHERE user_email=? ORDER BY id DESC";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, LoginFrame.loggedInEmail);

            ResultSet rs = ps.executeQuery();

            area.setText("");

            while(rs.next()) {

                area.append("Score : " + rs.getInt("score") + "\n");
                area.append("Total Questions : " + rs.getInt("total_questions") + "\n");
                area.append("Percentage : " + rs.getDouble("percentage") + "%\n");
                area.append("Date : " + rs.getTimestamp("quiz_date") + "\n");
                area.append("-------------------------------------\n");
            }

            rs.close();
            ps.close();
            con.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}