package a4.e414.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PlaceOrderScreen extends JFrame {

	public static void main(String args[]){
		new PlaceOrderScreen("Anvesh", "Reddy");
				
	}
	
	private JLabel welcomeLabel = new JLabel("Take new Order");
	private JLabel custName = new JLabel("Customer Name");
	private JLabel custPh = new JLabel("Customer Phone");
	private JLabel orderType = new JLabel("Order Type");
	private JLabel orderTypeLabel = new JLabel("Kiosk");;
	private JLabel orderNum = new JLabel("Order Number");
	private JLabel orderDetails = new JLabel("Order Details :");
	private JTextField custNameField = new JTextField(25);
	private JTextField custPhField = new JTextField(25);
	private JComboBox<String> orderTypeField = new JComboBox<String>();
	private JLabel orderNumField;
	private JButton pizzaButton = new JButton("Pizza");
	private JButton sideButton = new JButton("Side");
	private JButton drinksButton = new JButton("Drinks");
	private JButton specialButton = new JButton("Special");
	private JButton deleteButton = new JButton("Delete Selected");
	private JButton cancelButton = new JButton("Cancel");
	private JButton confirmButton = new JButton("confirm");
	private String errorMsg = "Error... Try Again";
	JPanel panel = new JPanel();
	
	public void setFonts() {

		Font myTFont = new Font("Mistral", Font.PLAIN, 1);
		Font myFFont = new Font("Serif", Font.PLAIN, 1);
		Font tNewFont = myTFont.deriveFont(40F);
		Font newFont = myTFont.deriveFont(30F);
		Font newFFont = myFFont.deriveFont(20F);
		welcomeLabel.setFont(tNewFont);
		welcomeLabel.setForeground(Color.RED);
		custName.setFont(newFFont);
		custName.setForeground(Color.BLUE);
		custPh.setFont(newFFont);
		custPh.setForeground(Color.BLUE);
		orderType.setFont(newFFont);
		orderType.setForeground(Color.BLUE);
		orderTypeLabel.setFont(newFFont);
		orderTypeLabel.setForeground(Color.BLUE);
		orderNum.setFont(newFFont);
		orderNum.setForeground(Color.BLUE);
		orderDetails.setFont(newFFont);
		orderDetails.setForeground(Color.BLUE);
		custNameField.setFont(newFFont);
		custPhField.setFont(newFFont);
		orderTypeField.setFont(newFFont);
		orderNumField.setFont(newFFont);
		pizzaButton.setFont(newFFont);
		sideButton.setFont(newFFont);
		drinksButton.setFont(newFFont);
		specialButton.setFont(newFFont);
		
		deleteButton.setFont(newFFont);
		cancelButton.setFont(newFont);
		cancelButton.setForeground(Color.BLUE);
		confirmButton.setFont(newFont);
		confirmButton.setForeground(Color.BLUE);
			
	}
	
	


	public JPanel getPanel() {
		return panel;
	}

	public PlaceOrderScreen(String orderNum,String action){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900,1000);
		this.add(panel);
		panel.setLayout(null);
		
		if(action.equals("cashier")){
			orderTypeField.addItem("Store");
			orderTypeField.addItem("Phone");
			orderTypeLabel.setVisible(false);
		}
		else if (action.equals("kiosk")){
			orderTypeField.setVisible(false);
		}
		orderNumField = new JLabel(orderNum);
		setBounds();
		addtoPanel(panel);
		setFonts();
		this.setTitle("Take Order");
		this.setIconImage(new ImageIcon("C:/Users/ks_an/javaworkspace/PizzaOrderingSystem/icon2.png").getImage());
		this.setVisible(true);
	}

	public void setBounds(){
		welcomeLabel.setBounds(340,30,500,45);

		custName.setBounds(80,110,150,25);
		custNameField.setBounds(260,110,150,25);

		custPh.setBounds(480,110,150,25);
		custPhField.setBounds(660,110,150,25);

		orderType.setBounds(80,170,150,25);
		orderTypeField.setBounds(260,170,150,25);
		orderTypeLabel.setBounds(260,170,150,25);

		orderNum.setBounds(480,170,150,25);
		orderNumField.setBounds(660,170,100,25);


		pizzaButton.setBounds(30,260,200,60);
		sideButton.setBounds(230,260,200,60);
		drinksButton.setBounds(430,260,200,60);
		specialButton.setBounds(630,260,200,60);

		orderDetails.setBounds(120,350,150,25);

		deleteButton.setBounds(340,800,200,45);
		cancelButton.setBounds(180,870,200,65);
		confirmButton.setBounds(500,870,200,65);

	}
	public void addtoPanel(JPanel panel){
		panel.add(welcomeLabel);
		panel.add(custName);
		panel.add(custNameField);
		panel.add(custPh);
		panel.add(custPhField);
		panel.add(orderType);
		panel.add(orderTypeField);
		panel.add(orderNum);
		panel.add(orderNumField);
		panel.add(orderDetails);
		panel.add(orderTypeLabel);

		panel.add(pizzaButton);
		panel.add(sideButton);
		panel.add(drinksButton);
		panel.add(specialButton);

		panel.add(deleteButton);
		panel.add(cancelButton);
		panel.add(confirmButton);
	}


	public void ButtonListner(ActionListener l){
		pizzaButton.addActionListener(l);
		sideButton.addActionListener(l);
		drinksButton.addActionListener(l);
		deleteButton.addActionListener(l);
		cancelButton.addActionListener(l);
		confirmButton.addActionListener(l);
		specialButton.addActionListener(l);
	}

	public JButton getSpecialButton() {
		return specialButton;
	}

	public JLabel getWelcomeLabel() {
		return welcomeLabel;
	}

	public JLabel getCustName() {
		return custName;
	}

	public JLabel getCustPh() {
		return custPh;
	}

	public JLabel getOrderType() {
		return orderType;
	}

	public JLabel getOrderNum() {
		return orderNum;
	}

	public JLabel getOrderDetails() {
		return orderDetails;
	}

	public JTextField getCustNameField() {
		return custNameField;
	}

	public JTextField getCustPhField() {
		return custPhField;
	}

	public JComboBox<String> getOrderTypeField() {
		return orderTypeField;
	}

	public JLabel getOrderNumField() {
		return orderNumField;
	}

	public JButton getPizzaButton() {
		return pizzaButton;
	}

	public JButton getsideButton() {
		return sideButton;
	}

	public JLabel getOrderTypeLabel() {
		return orderTypeLabel;
	}
	public JButton getDrinksButton() {
		return drinksButton;
	}

	public JButton getDeleteButton() {
		return deleteButton;
	}

	public JButton getCancelButton() {
		return cancelButton;
	}

	public JButton getConfirmButton() {
		return confirmButton;
	}

	public String getErrorMsg() {
		return errorMsg;
	}


	public void errorMsg(){
		JOptionPane.showMessageDialog(this,errorMsg);
	}

}