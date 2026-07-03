import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdminFrame extends JFrame {

    JButton addQuestion,logout;

    public AdminFrame() {

        setTitle("Admin Dashboard");
        setSize(600,400);
        setLayout(new FlowLayout());

        JLabel title = new JLabel("WELCOME ADMIN");
        title.setFont(new Font("Arial",Font.BOLD,22));

       addQuestion = new JButton("Add Question");
	addQuestion.setBounds(250,100,150,40);
	addQuestion.setFont(new Font("Arial",Font.BOLD,14));
	add(addQuestion);
        
        logout = new JButton("Logout");
        logout.setBounds(250,170,150,40);
        logout.setFont(new Font("Arial",Font.BOLD,14));
        add(logout);

        addQuestion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new AddQuestionFrame();
            }
        });
         logout.addActionListener(e -> {

          int option = JOptionPane.showConfirmDialog(
            null,
            "Are you sure you want to logout?",
            "Logout",
            JOptionPane.YES_NO_OPTION);

            if(option == JOptionPane.YES_OPTION){
                dispose();
                new LoginFrame();
            }
       });

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}