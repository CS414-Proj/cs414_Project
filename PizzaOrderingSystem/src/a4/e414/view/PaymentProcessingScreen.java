package a4.e414.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class PaymentProcessingScreen extends JFrame {

	private JLabel welcomeLabel = new JLabel("Payment");
	private JLabel subTotal = new JLabel("Sub Total");
	private JLabel tax = new JLabel("Tax");
	private JLabel total = new JLabel("Total");
	private JLabel orderNum = new JLabel("Order Number");
	private JLabel balanceDue = new JLabel("Balance Due");
	private JButton cashButton = new JButton("Pay By Cash");
	private JButton cardButton = new JButton("Pay By Card");
	private JLabel subTotalField;
	private JLabel taxField ;
	private JLabel totalField ;
	private JLabel orderNumField;
	private JLabel balanceDueField;
	private JLabel cashGiven = new JLabel("Cash Given");
	private JTextField cashGivenField = new JTextField(25);
	private JLabel returnCash = new JLabel("Return Cash");
	private JLabel returnCashField= new JLabel("0");// Need to calculate
	private JLabel cardHolderName = new JLabel("Card Holder");
	private JTextField cardHolderNameField = new JTextField(25);
	private JLabel cardNum = new JLabel("Card Number");
	private JTextField cardNumField = new JTextField(25);
	private JLabel validthrough = new JLabel("Valid Through");
	private JTextField validthroughField = new JTextField(25);
	private JLabel ccNum = new JLabel("CC Number");
	private JTextField ccNumField = new JTextField(25);
	private JButton OkButton = new JButton("OK");
	private JButton CancelButton = new JButton("Cancel");
	private JButton changeButton = new JButton("Calculate Change");
	public JButton getChangeButton() {
		return changeButton;
	}
	
	
	public void setFonts() {

		Font myTFont = new Font("Mistral", Font.PLAIN, 1);
		Font myFFont = new Font("Serif", Font.PLAIN, 1);
		Font tNewFont = myTFont.deriveFont(40F);
		Font newFFont = myFFont.deriveFont(20F);
		welcomeLabel.setFont(tNewFont);
		welcomeLabel.setForeground(Color.RED);
		subTotal.setFont(newFFont);
		tax.setFont(newFFont);	
		total.setFont(newFFont);
		orderNum.setFont(newFFont);
		balanceDue.setFont(newFFont);
		subTotal.setFont(newFFont);
		subTotalField.setFont(newFFont);
		taxField.setFont(newFFont);
		totalField.setFont(newFFont);
		orderNumField.setFont(newFFont);
		balanceDueField.setFont(newFFont);
		cashGiven.setFont(newFFont);
		cashGivenField.setFont(newFFont);
		returnCash.setFont(newFFont);
		returnCashField.setFont(newFFont);
		cardHolderName.setFont(newFFont);
		cardHolderNameField.setFont(newFFont);
		cardNum.setFont(newFFont);
		cardNumField.setFont(newFFont);
		validthrough.setFont(newFFont);
		validthroughField.setFont(newFFont);
		ccNum.setFont(newFFont);
		ccNumField.setFont(newFFont);
		cashButton.setFont(newFFont);
		cardButton.setFont(newFFont);
		OkButton.setFont(newFFont);
		CancelButton.setFont(newFFont);
		changeButton.setFont(newFFont);
	}

	private String errorMsg = "Error... Try Again";
	private JPanel panel = new JPanel();


	public PaymentProcessingScreen(String subTotalVal,String taxVal,String totalVal,String orderNumValue,String action){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900,1000);
		this.add(panel);
		panel.setLayout(null);
		subTotalField = new JLabel(subTotalVal);
		taxField = new JLabel(taxVal);
		totalField = new JLabel(totalVal);
		orderNumField = new JLabel(orderNumValue);
		balanceDueField = new JLabel(totalVal); 
		cashGivenField.setText("0");

		if(action.equals("kiosk")){
			cashButton.setVisible(false);
		}
		cashGiven.setVisible(false);
		cashGivenField.setVisible(false);
		changeButton.setVisible(false);

		returnCash.setVisible(false);
		returnCashField.setVisible(false);

		cardHolderName.setVisible(false);
		cardHolderNameField.setVisible(false);
		cardNum.setVisible(false);
		cardNumField.setVisible(false);
		validthrough.setVisible(false);
		validthroughField.setVisible(false);
		ccNum.setVisible(false);
		ccNumField.setVisible(false);

		CancelButton.setVisible(false);
		OkButton.setVisible(false);

		setBounds();
		addtoPanel();
		this.setVisible(true);
		setFonts();
	}


	public JLabel getCcNum() {
		return ccNum;
	}


	public JTextField getCcNumField() {
		return ccNumField;
	}


	public void setBounds(){
		welcomeLabel.setBounds(375 ,50, 200,65);

		orderNum.setBounds(160,100,150,25);
		orderNumField.setBounds(340,100,100,25);

		subTotal.setBounds(160,140,150,25);
		subTotalField.setBounds(340,140,100,25);

		tax.setBounds(160,180,150,25);
		taxField.setBounds(340,180,100,25);

		total.setBounds(160,220,100,25);
		totalField.setBounds(340,220,100,25);

		
		balanceDue.setBounds(160,340,150,25);
		balanceDueField.setBounds(340,340,150,25);

		cashButton.setBounds(220,400,230,55);
		cardButton.setBounds(480,400,230,55);

		cashGiven.setBounds(160,550,100,25);
		cashGivenField.setBounds(340,550,100,25);
		changeButton.setBounds(480,550,175,55);

		returnCash.setBounds(160,590,100,25);
		returnCashField.setBounds(340,590,100,25);

		cardHolderName.setBounds(160,550,170,25);
		cardHolderNameField.setBounds(340,550,100,25);
		
		cardNum.setBounds(160,590,170,40);
		cardNumField.setBounds(340,590,170,25);
		
		validthrough.setBounds(160,640,170,40);
		validthroughField.setBounds(340,640,170,25);
		
		ccNum.setBounds(160,680,100,25);
		ccNumField.setBounds(340,680,100,25);

		CancelButton.setBounds(220,780,150,55);
		OkButton.setBounds(480,780,150,55);


	}
	public void addtoPanel(){
		panel.add(welcomeLabel);
		panel.add(orderNum);
		panel.add(orderNumField);
		panel.add(subTotal);
		panel.add(subTotalField);
		panel.add(tax);
		panel.add(taxField);
		panel.add(total);
		panel.add(totalField);
		panel.add(balanceDue);

		panel.add(balanceDueField);
		panel.add(cashButton);
		panel.add(cardButton);
		panel.add(changeButton);

		panel.add(returnCash);
		panel.add(returnCashField);
		panel.add(cashGiven);
		panel.add(cashGivenField);
		panel.add(OkButton);
		panel.add(CancelButton);

		panel.add(cardHolderName);
		panel.add(cardHolderNameField);
		panel.add(cardNum);
		panel.add(cardNumField);
		panel.add(validthrough);
		panel.add(validthroughField);
		panel.add(OkButton);
		panel.add(CancelButton);

	}



	public void ButtonListner(ActionListener l){
		cashButton.addActionListener(l);
		cardButton.addActionListener(l);
		OkButton.addActionListener(l);
		CancelButton.addActionListener(l);
		changeButton.addActionListener(l);
	}

	public void textFieldListner(ActionListener l){
		cashGivenField.addActionListener(l);
	}


	public String getErrorMsg() {
		return errorMsg;
	}

	public void errorMsg(){
		JOptionPane.showMessageDialog(this,errorMsg);
	}

	public JLabel getWelcomeLabel() {
		return welcomeLabel;
	}

	public JLabel getSubTotal() {
		return subTotal;
	}

	public JLabel getTax() {
		return tax;
	}

	public JLabel getTotal() {
		return total;
	}

	public JLabel getOrderNum() {
		return orderNum;
	}

	public JLabel getBalanceDue() {
		return balanceDue;
	}

	public JButton getCashButton() {
		return cashButton;
	}

	public JButton getCardButton() {
		return cardButton;
	}

	public JLabel getSubTotalField() {
		return subTotalField;
	}

	public JLabel getTaxField() {
		return taxField;
	}

	public JLabel getTotalField() {
		return totalField;
	}

	public JLabel getOrderNumField() {
		return orderNumField;
	}

	public JLabel getBalanceDueField() {
		return balanceDueField;
	}

	public JLabel getCashGiven() {
		return cashGiven;
	}

	public JTextField getCashGivenField() {
		return cashGivenField;
	}

	public JLabel getReturnCash() {
		return returnCash;
	}

	public JLabel getReturnCashField() {
		return returnCashField;
	}

	public JLabel getCardHolderName() {
		return cardHolderName;
	}

	public JTextField getCardHolderNameField() {
		return cardHolderNameField;
	}

	public JLabel getCardNum() {
		return cardNum;
	}

	public JTextField getCardNumField() {
		return cardNumField;
	}

	public JLabel getValidthrough() {
		return validthrough;
	}

	public JTextField getValidthroughField() {
		return validthroughField;
	}

	public JButton getOkButton() {
		return OkButton;
	}

	public JButton getCancelButton() {
		return CancelButton;
	}

	public JPanel getPanel() {
		return panel;
	}


}