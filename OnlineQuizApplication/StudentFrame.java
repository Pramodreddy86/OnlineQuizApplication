import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StudentFrame extends JFrame {

        JButton startQuiz,viewResult,leaderBoard,logout;
    

    public StudentFrame() {

        setTitle("Student Dashboard");

        setSize(650,300);

        setLayout(null);

        JLabel title = new JLabel("     WELCOME STUDENT");
        title.setBounds(150,20,350,40);
        title.setFont(new Font("Arial", Font.BOLD, 28));
         add(title);


        startQuiz = new JButton("Start Quiz");
        startQuiz.setBounds(360,100,150,40);
	startQuiz.setFont(new Font("Arial", Font.BOLD, 14));
	add(startQuiz);
         viewResult = new JButton("View Result");
         viewResult.setBounds(140, 100, 150, 40);
         viewResult.setFont(new Font("Arial",Font.BOLD,14));
         add(viewResult);
         leaderBoard = new JButton("Leaderboard");
         leaderBoard.setBounds(250, 180, 150, 40);
         leaderBoard.setFont(new Font("Arial",Font.BOLD,14));
         add(leaderBoard);
         logout = new JButton("Logout");
	logout.setBounds(250, 240, 150, 40);
	logout.setFont(new Font("Arial", Font.BOLD, 14));
	add(logout);


        add(title);
        add(startQuiz);

        startQuiz.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                new QuizFrame();

            }
        });
        viewResult.addActionListener(e -> {
    		new ResultFrame();
	});
        leaderBoard.addActionListener(e -> {
    		new LeaderboardFrame();
	});
         logout.addActionListener(e -> {

    		int option = JOptionPane.showConfirmDialog(
            		null,
            		"Are you sure you want to logout?",
           		 "Logout",
           		 JOptionPane.YES_NO_OPTION);

    		if (option == JOptionPane.YES_OPTION) {
        	dispose();
        	new LoginFrame();
    	}
	});

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}