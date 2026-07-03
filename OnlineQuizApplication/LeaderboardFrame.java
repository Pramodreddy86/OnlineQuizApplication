import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LeaderboardFrame extends JFrame {

    public LeaderboardFrame() {

        setTitle("Leaderboard");
        setSize(500,400);
        setLocationRelativeTo(null);

        JTextArea area = new JTextArea();
        area.setEditable(false);
        area.setFont(new Font("Arial", Font.PLAIN, 16));

        LeaderboardDAO dao = new LeaderboardDAO();
        ArrayList<String> list = dao.getLeaderboard();

        area.append("========= LEADERBOARD =========\n\n");

        if(list.size()==0){
            area.append("No Results Found");
        } else {
            for(String s : list){
                area.append(s + "\n\n");
            }
        }

        add(new JScrollPane(area));

        setVisible(true);
    }
}