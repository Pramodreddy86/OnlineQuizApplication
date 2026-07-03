import javax.swing.*;
import java.awt.*;

public class AddQuestionFrame extends JFrame {

    JTextField question;
    JTextField option1;
    JTextField option2;
    JTextField option3;
    JTextField option4;
    JTextField answer;

    JButton save;

    public AddQuestionFrame() {

        setTitle("Add Question");

        setSize(600,500);

        setLayout(new GridLayout(7,2,10,10));

        question=new JTextField();
        option1=new JTextField();
        option2=new JTextField();
        option3=new JTextField();
        option4=new JTextField();
        answer=new JTextField();

        save=new JButton("Save Question");

        add(new JLabel("Question"));
        add(question);

        add(new JLabel("Option 1"));
        add(option1);

        add(new JLabel("Option 2"));
        add(option2);

        add(new JLabel("Option 3"));
        add(option3);

        add(new JLabel("Option 4"));
        add(option4);

        add(new JLabel("Correct Answer"));
        add(answer);

        add(new JLabel(""));
        add(save);

        setLocationRelativeTo(null);

         save.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent e) {

        Question q = new Question();

        q.setQuestion(question.getText());
        q.setOption1(option1.getText());
        q.setOption2(option2.getText());
        q.setOption3(option3.getText());
        q.setOption4(option4.getText());
        q.setAnswer(answer.getText());

        QuestionDAO dao = new QuestionDAO();

        if(dao.addQuestion(q)) {

            JOptionPane.showMessageDialog(null,
                    "Question Saved Successfully");

            question.setText("");
            option1.setText("");
            option2.setText("");
            option3.setText("");
            option4.setText("");
            answer.setText("");

        } else {

            JOptionPane.showMessageDialog(null,
                    "Failed to Save Question");
        }
    }
});

        setVisible(true);
    }
}