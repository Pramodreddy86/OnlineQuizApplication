import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;


public class LoginFrame extends JFrame {

    JLabel title, emailLabel, passwordLabel;
    JTextField emailField;
    JPasswordField passwordField;
    JButton loginButton, registerButton;
    
    public static String loggedInEmail = "";

    public LoginFrame() {

        setTitle("Online Quiz Application");
        setSize(400, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        title = new JLabel("ONLINE QUIZ SYSTEM");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBounds(90, 20, 250, 30);
        add(title);

        emailLabel = new JLabel("Email");
        emailLabel.setBounds(50, 70, 100, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(150, 70, 180, 25);
        add(emailField);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(50, 110, 100, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(150, 110, 180, 25);
        add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(70, 180, 100, 30);
        add(loginButton);

        registerButton = new JButton("Register");
        registerButton.setBounds(210, 180, 100, 30);
        add(registerButton);
	registerButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
       			 new RegisterFrame();
    		}
	});


	loginButton.addActionListener(new ActionListener() {

    		public void actionPerformed(ActionEvent e) {

        	String email = emailField.getText();
        	String password = new String(passwordField.getPassword());

       		 LoginDAO dao = new LoginDAO();

        	User user = dao.login(email, password);

        	if (user != null) {

            		JOptionPane.showMessageDialog(null,
                    "Welcome " + user.getName());
                loggedInEmail=email;
           	if (user.getRole().equalsIgnoreCase("Admin")) {

                	new AdminFrame();

            	} else {

                	new StudentFrame();

            	}

            	dispose();

        	} else {

            		JOptionPane.showMessageDialog(null,
                    "Invalid Email or Password");

        	}

    	   }

	});

        setVisible(true);
    }
}