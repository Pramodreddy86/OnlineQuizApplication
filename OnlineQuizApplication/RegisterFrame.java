import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class RegisterFrame extends JFrame {

    JLabel title, nameLabel, emailLabel, passwordLabel, roleLabel;
    JTextField nameField, emailField;
    JPasswordField passwordField;
    JComboBox<String> roleBox;
    JButton registerButton;

    public RegisterFrame() {

        setTitle("User Registration");
        setSize(450, 400);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        title = new JLabel("USER REGISTRATION");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBounds(110, 20, 250, 30);
        add(title);

        nameLabel = new JLabel("Name");
        nameLabel.setBounds(50, 80, 100, 25);
        add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(170, 80, 180, 25);
        add(nameField);

        emailLabel = new JLabel("Email");
        emailLabel.setBounds(50, 120, 100, 25);
        add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(170, 120, 180, 25);
        add(emailField);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(50, 160, 100, 25);
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(170, 160, 180, 25);
        add(passwordField);

        roleLabel = new JLabel("Role");
        roleLabel.setBounds(50, 200, 100, 25);
        add(roleLabel);

        roleBox = new JComboBox<>();
        roleBox.addItem("Student");
        roleBox.addItem("Admin");
        roleBox.setBounds(170, 200, 180, 25);
        add(roleBox);

        registerButton = new JButton("Register");
        registerButton.setBounds(150, 270, 120, 35);
        add(registerButton);

	registerButton.addActionListener(new ActionListener() {

    		public void actionPerformed(ActionEvent e) {

        		String name = nameField.getText();
       			String email = emailField.getText();
        		String password = new String(passwordField.getPassword());
        		String role = roleBox.getSelectedItem().toString();

        		User user = new User(name, email, password, role);

        		UserDAO dao = new UserDAO();

        		if (dao.registerUser(user)) {

            			JOptionPane.showMessageDialog(null, "Registration Successful");

            			dispose();

        		} else {

            			JOptionPane.showMessageDialog(null, "Registration Failed");

        		}

    		}

	});

        setVisible(true);
    }
}