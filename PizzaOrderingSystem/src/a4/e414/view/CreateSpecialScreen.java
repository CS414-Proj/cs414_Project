package a4.e414.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class CreateSpecialScreen extends JFrame {
	
	private JLabel welcomeLabelSetSpecial = new JLabel("Set Special");
	private JLabel splName = new JLabel("Special Name");
	private JLabel splCost = new JLabel("Special Cost");
	private JLabel specialDetails = new JLabel("Special Details :");
	private JTextField splNameField = new JTextField(25);
	private JTextField splCostField = new JTextField(25);
	private JButton pizzaButton = new JButton("Pizza");

	private JButton sideButton = new JButton("Side");
	private JButton drinksButton = new JButton("Drinks");
	private JButton cancelButton = new JButton("Cancel");
	private JButton confirmButton = new JButton("Set");
	private JButton viewSplButton = new JButton("View Special");
	private String errorMsg = "Error... Try Again";
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
		welcomeLabelSetSpecial.setFont(tNewFont);
		welcomeLabelSetSpecial.setForeground(Color.RED);
		splName.setFont(newFFont);
		splName.setForeground(Color.BLUE);
		splCost.setFont(newFFont);
		splCost.setForeground(Color.BLUE);
		specialDetails.setFont(newFFont);
		specialDetails.setForeground(Color.BLUE);
		pizzaButton.setFont(newFFont);
		sideButton.setFont(newFFont);
		drinksButton.setFont(newFFont);
		cancelButton.setFont(newFFont);
		confirmButton.setFont(newFFont);
		viewSplButton.setFont(newFFont);
	}


	public CreateSpecialScreen(){
		setFonts();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900,1000);
		this.add(panel);
		panel.setLayout(null);
		setBounds();
		addtoPanel(panel);
		this.setVisible(true);
	}
	
	public void setBounds(){
		welcomeLabelSetSpecial.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabelSetSpecial.setVerticalAlignment(SwingConstants.CENTER);
		welcomeLabelSetSpecial.setBounds(340,30, 400, 100);
		
		splName.setBounds(200,120,150,35);
		splNameField.setBounds(400,120,150,35);
		
		splCost.setBounds(200,180,150,35);
		splCostField.setBounds(400,180,150,35);

		pizzaButton.setBounds(100,320,200,85);
		sideButton.setBounds(340,320,200,85);
		drinksButton.setBounds(580,320,200,85);
		
		specialDetails.setBounds(120,470,300,35);
		
		cancelButton.setBounds(100,830,200,85);
		confirmButton.setBounds(340,830,200,85);
		viewSplButton.setBounds(580,830,200,85);
		
	}
	public void addtoPanel(JPanel panel){
		panel.add(welcomeLabelSetSpecial);
		panel.add(splName);
		panel.add(splNameField);
		panel.add(splCost);
		panel.add(splCostField);
		panel.add(specialDetails);
		
		panel.add(pizzaButton);
		panel.add(sideButton);
		panel.add(drinksButton);
		
		panel.add(cancelButton);
		panel.add(confirmButton);
		panel.add(viewSplButton);
	}
	
	
	public void ButtonListner(ActionListener l){
	pizzaButton.addActionListener(l);
	sideButton.addActionListener(l);
	drinksButton.addActionListener(l);
	cancelButton.addActionListener(l);
	confirmButton.addActionListener(l);
	viewSplButton.addActionListener(l);
	}
	
	
	public JButton getViewSplButton() {
		return viewSplButton;
	}

	public JLabel getWelcomeLabel() {
		return welcomeLabelSetSpecial;
	}

	public JLabel getSplName() {
		return splName;
	}

	public JLabel getSplCost() {
		return splCost;
	}

	public JLabel getSpecialDetails() {
		return specialDetails;
	}

	public JTextField getSplNameField() {
		return splNameField;
	}

	public JTextField getSplCostField() {
		return splCostField;
	}

	public JButton getPizzaButton() {
		return pizzaButton;
	}

	public JButton getsideButton() {
		return sideButton;
	}

	public JButton getDrinksButton() {
		return drinksButton;
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
	
}
