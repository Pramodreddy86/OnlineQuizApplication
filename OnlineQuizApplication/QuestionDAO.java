import java.sql.Connection;
import java.sql.PreparedStatement;

public class QuestionDAO {

    public boolean addQuestion(Question q) {

        try {

            Connection con = DBConnection.getConnection();

            String sql = "INSERT INTO questions(question, option1, option2, option3, option4, correct_answer) VALUES(?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, q.getQuestion());
            ps.setString(2, q.getOption1());
            ps.setString(3, q.getOption2());
            ps.setString(4, q.getOption3());
            ps.setString(5, q.getOption4());
            ps.setString(6, q.getAnswer());

            int i = ps.executeUpdate();

            if(i > 0)
                return true;

        } catch(Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    public java.util.ArrayList<Question> getAllQuestions() {

    java.util.ArrayList<Question> list = new java.util.ArrayList<>();

    try {

        Connection con = DBConnection.getConnection();

        String sql = "SELECT * FROM questions";

        PreparedStatement ps = con.prepareStatement(sql);

        java.sql.ResultSet rs = ps.executeQuery();

        while(rs.next()) {

            Question q = new Question();

            q.setQuestion(rs.getString("question"));
            q.setOption1(rs.getString("option1"));
            q.setOption2(rs.getString("option2"));
            q.setOption3(rs.getString("option3"));
            q.setOption4(rs.getString("option4"));
            q.setAnswer(rs.getString("correct_answer"));

            list.add(q);
        }

    } catch(Exception e) {
        e.printStackTrace();
    }

    return list;
}



}