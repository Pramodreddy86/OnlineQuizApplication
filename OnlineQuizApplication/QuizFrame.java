import javax.swing.*;
import java.awt.*;
import javax.swing.Timer;

public class QuizFrame extends JFrame {
    java.util.ArrayList<Question> questions;
   int current = 0;
   int score = 0;

    JLabel question;
    JRadioButton op1, op2, op3, op4;
    ButtonGroup bg;
    JButton next;
    JLabel timerLabel;
    Timer timer;
    int timeLeft=30;

    public QuizFrame() {

        setTitle("Online Quiz");

        setSize(900,500);

        setLayout(null);

        question = new JLabel("Question will appear here");

        op1 = new JRadioButton();
        op2 = new JRadioButton();
        op3 = new JRadioButton();
        op4 = new JRadioButton();

        bg = new ButtonGroup();

        bg.add(op1);
        bg.add(op2);
        bg.add(op3);
        bg.add(op4);

        next = new JButton("Next");
        timerLabel = new JLabel("Time Left: 30");
	timerLabel.setBounds(30, 20, 150, 30);
	timerLabel.setFont(new Font("Arial", Font.BOLD, 16));
	add(timerLabel);
        add(question);
        add(op1);
        add(op2);
        add(op3);
        add(op4);
        add(next);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	QuestionDAO dao = new QuestionDAO();
	questions = dao.getAllQuestions();

        startTimer();
        
         timer.stop();

	loadQuestion();
	
        next.addActionListener(e -> {

    		Question q = questions.get(current);

    		String ans = "";

    		if (op1.isSelected()) ans = op1.getText();
    			else if (op2.isSelected()) ans = op2.getText();
    			else if (op3.isSelected()) ans = op3.getText();
    			else if (op4.isSelected()) ans = op4.getText();

    			if (ans.equals(q.getCorrectAnswer())) {
        			score++;
    			}

    		current++;
    		loadQuestion();

	});
        setVisible(true);
    }

	public void loadQuestion() {
             if(current >= questions.size()) {

    			int total = questions.size();
   			 double percentage = (score * 100.0) / total;

   			 ResultDAO dao = new ResultDAO();

    		dao.saveResult(
        	LoginFrame.loggedInEmail,
        	score,
        	total
    		);

    		JOptionPane.showMessageDialog(this,
       			 "Quiz Completed\n\nScore : " + score +
        	"\nPercentage : " + percentage + "%");

    		dispose();
    		return;
		}

        Question q = questions.get(current);

    question.setText((current + 1) + ". " + q.getQuestion());
     question.setBounds(40,50,800,30);

	op1.setBounds(60,100,200,30);
	op2.setBounds(320,100,200,30);
	op3.setBounds(60,150,200,30);
	op4.setBounds(320,150,200,30);
        next.setBounds(700,350,120,40);

    op1.setText(q.getOption1());
    op2.setText(q.getOption2());
    op3.setText(q.getOption3());
    op4.setText(q.getOption4());

    bg.clearSelection();
    startTimer();
}
public void startTimer() {
    timeLeft = 30;
    timerLabel.setText("Time Left: " + timeLeft);

    if (timer != null) {
        timer.stop();
    }

    timer = new Timer(1000, e -> {
        timeLeft--;
        timerLabel.setText("Time Left: " + timeLeft);

        if (timeLeft == 0) {
            timer.stop();
            next.doClick();
        }
    });

    timer.start();
}


}