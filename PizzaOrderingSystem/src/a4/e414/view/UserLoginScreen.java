package a4.e414.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class UserLoginScreen extends JFrame {

	private JLabel headerLabel = new JLabel("Ola CSU Pizza user!");
	private JLabel idLabel = new JLabel("Login ID");
	private JLabel passwordLabel = new JLabel("Password");
	private JButton loginButton = new JButton("Login");
	private JTextField idField = new JTextField(20);
	private JPasswordField passwordField = new JPasswordField(20);

	public void setFonts() {

		Font myTFont = new Font("Mistral", Font.PLAIN, 1);
		Font myFFont = new Font("Serif", Font.PLAIN, 1);
		Font tNewFont = myTFont.deriveFont(40F);
		Font newFont = myTFont.deriveFont(30F);
		Font newFFont = myFFont.deriveFont(20F);
		headerLabel.setFont(tNewFont);
		headerLabel.setForeground(Color.RED);
		idLabel.setFont(newFont);
		idLabel.setForeground(Color.BLUE);
		passwordLabel.setFont(newFont);
		passwordLabel.setForeground(Color.BLUE);
		loginButton.setFont(newFFont);
		loginButton.setForeground(Color.RED);
		idField.setFont(newFFont);
		passwordField.setFont(newFFont);

	}

	public void setDimensions() {
		headerLabel.setBounds(115, 150, 700, 85);
		idLabel.setBounds(100, 300, 200, 35);
		idField.setBounds(300, 300, 200, 35);
		passwordLabel.setBounds(100, 360, 200, 35);
		passwordField.setBounds(300, 360, 200, 35);
		loginButton.setBounds(250, 450, 100, 55);
	}

	public void pinOnPanel(JPanel newUserPanel) {
		newUserPanel.add(headerLabel);
		newUserPanel.add(idLabel);
		newUserPanel.add(idField);
		newUserPanel.add(passwordLabel);
		newUserPanel.add(passwordField);
		newUserPanel.add(loginButton);
	}

	public String getPasswordField() {
		String passString = new String(passwordField.getPassword());
		return passString;

	}

	public String getIdField() {
		return idField.getText();
	}

	public void userLoginListner(ActionListener listen) {
		loginButton.addActionListener(listen);
	}
	
	private String errorMsg = "Incorrect ID or Password...";


	public void errorMsg() {
		JOptionPane.showMessageDialog(this, errorMsg);
	}
	
	public UserLoginScreen() {
		JPanel newUserPanel = new JPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(650, 750);
		this.setTitle("User Login");
		this.setIconImage(new ImageIcon("C:/Users/ks_an/javaworkspace/PizzaOrderingSystem/icon2.png").getImage());
		this.add(newUserPanel);
		newUserPanel.setLayout(null);
		setDimensions();
		setFonts();
		pinOnPanel(newUserPanel);
		this.setVisible(true);
	}

}
