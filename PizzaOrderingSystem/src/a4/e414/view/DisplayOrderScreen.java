package a4.e414.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class DisplayOrderScreen extends JFrame {
	
	public static void main(String args[]){
		new DisplayOrderScreen();
				
	}
	
	private JLabel welcomeLabel = new JLabel("View Order");
	private JLabel orderIdLabel = new JLabel("Order Id");
	private JTextField orderIdField = new JTextField(35);
	private JButton getOrderButton = new JButton("Get Order");
	private JLabel orderDetailsLabel = new JLabel("Order Details:");
	private JButton managerCancelButton = new JButton("Manager");
	private JButton homeButton = new JButton("Home");
	private JLabel managerId = new JLabel("Manager Id");
	private JTextField managerIdField = new JTextField(25);
	private JLabel pwd = new JLabel("Password");
	private JPasswordField pwdField = new JPasswordField(25);
	private JButton cancelButton = new JButton("Cancel Order");
	
	
	private String errorMsg = "Invalid Login Details...";
	private JPanel panel = new JPanel();
	
	public JPanel getPanel() {
		return panel;
	}

	
	public void setFonts() {

		Font myTFont = new Font("Mistral", Font.PLAIN, 1);
		Font myFFont = new Font("Serif", Font.PLAIN, 1);
		Font tNewFont = myTFont.deriveFont(40F);
		Font newFont = myTFont.deriveFont(30F);
		Font newFFont = myFFont.deriveFont(20F);
		welcomeLabel.setFont(tNewFont);
		getOrderButton.setFont(newFFont);
		welcomeLabel.setForeground(Color.RED);
		
		orderIdField.setFont(newFFont);
		getOrderButton.setFont(newFFont);
		pwd.setFont(newFFont);
		orderDetailsLabel.setFont(newFFont);
		getOrderButton.setFont(newFFont);
		managerId.setFont(newFFont);
		managerIdField.setFont(newFFont);
		pwdField.setFont(newFFont);
		orderIdLabel.setFont(newFFont);
				
		managerCancelButton.setFont(newFFont);
		cancelButton.setFont(newFFont);
		homeButton.setFont(newFont);
		homeButton.setForeground(Color.BLUE);
	}
	
	
	public DisplayOrderScreen(){
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900,1000);
		this.add(panel);
		panel.setLayout(null);
		setBounds();
		setFonts();
		addtoPanel(panel);		
		managerCancelButton.setVisible(false);
		managerId.setVisible(false);
		managerIdField.setVisible(false);
		pwd.setVisible(false);
		pwdField.setVisible(false);
		cancelButton.setVisible(false);
		this.setVisible(true);
	}

	public JLabel getManagerId() {
		return managerId;
	}

	public JTextField getManagerIdField() {
		return managerIdField;
	}

	public JLabel getPwd() {
		return pwd;
	}

	public JPasswordField getPwdField() {
		return pwdField;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public void addtoPanel(JPanel panel){
		panel.add(welcomeLabel);
		panel.add(orderIdLabel);
		panel.add(orderIdField);
		panel.add(getOrderButton);
		
		panel.add(orderDetailsLabel);
		panel.add(managerCancelButton);
		panel.add(homeButton);
		panel.add(managerId);
		panel.add(managerIdField);
		panel.add(pwd);
		panel.add(pwdField);
		panel.add(cancelButton);
	}
	public void setBounds(){
		welcomeLabel.setBounds(300 ,20, 350,65);
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setVerticalAlignment(SwingConstants.CENTER);
		orderIdLabel.setBounds(250, 100, 150,25);
		orderIdField.setBounds(375, 100, 150,25);
		getOrderButton.setBounds(375,150,150,65);
		getOrderButton.setHorizontalAlignment(SwingConstants.CENTER);
		getOrderButton.setVerticalAlignment(SwingConstants.CENTER);
		orderDetailsLabel.setBounds(250, 220, 150,25);

		managerId.setBounds(250, 600, 150, 25);
		managerIdField.setBounds(375, 600, 150, 25);
		pwd.setBounds(250,650, 200, 25);
		pwdField.setBounds(375,650, 150, 25);
		cancelButton.setBounds(375,700, 200, 35);
		
		managerCancelButton.setBounds(375, 760, 150,65);
		homeButton.setBounds(375,850, 150,65);
	}
	
	
	public void ButtonListner(ActionListener l){
		managerCancelButton.addActionListener(l);
		homeButton.addActionListener(l);
		getOrderButton.addActionListener(l);
		cancelButton.addActionListener(l);
	}

	public JLabel getWelcomeLabel() {
		return welcomeLabel;
	}

	public JLabel getOrderIdLabel() {
		return orderIdLabel;
	}

	public JTextField getOrderIdField() {
		return orderIdField;
	}

	public JButton getGetOrderButton() {
		return getOrderButton;
	}

	public JLabel getOrderDetailsLabel() {
		return orderDetailsLabel;
	}

	public JButton getManagerCancelButton() {
		return managerCancelButton;
	}

	public JButton getHomeButton() {
		return homeButton;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

}