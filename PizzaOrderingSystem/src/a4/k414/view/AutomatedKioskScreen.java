package a4.k414.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class AutomatedKioskScreen extends JFrame {
	
	private JLabel welcomeLabel = new JLabel("Kiosk Order");
	private JLabel splLabel = new JLabel("Today's special:");
	private JLabel splNameLabel;
	private JLabel splCostLabel;
	private JButton takeOrderButton = new JButton("New Order");
	private JButton viewOrderButton = new JButton("View Order");
	private JPanel panel = new JPanel();
	private JButton backButton = new JButton("Refresh");
	
	public JPanel getPanel() {
		return panel;
	}

	public void setFonts() {

		Font myTFont = new Font("Mistral", Font.PLAIN, 1);
		Font myFFont = new Font("Serif", Font.PLAIN, 1);
		Font tNewFont = myTFont.deriveFont(40F);
		Font newFFFont = myFFont.deriveFont(30F);
		Font newFFont = myFFont.deriveFont(20F);
		welcomeLabel.setFont(tNewFont);
		welcomeLabel.setForeground(Color.RED);
		splLabel.setFont(newFFFont);
		splLabel.setForeground(Color.BLUE);
		splNameLabel.setFont(newFFont);
		splCostLabel.setFont(newFFont);
		takeOrderButton.setFont(newFFont);
		viewOrderButton.setFont(newFFont);
		backButton.setFont(newFFont);		
	}
	
	
	
	public AutomatedKioskScreen(String splNameVal , String splCostval){
		splNameLabel = new JLabel("Special Name : "+splNameVal);
		splCostLabel = new JLabel("Special Cost : "+splCostval);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900,1000);
		this.add(panel);
		panel.setLayout(null);
		setBounds();
		setFonts();
		addtoPanel(panel);
		this.setVisible(true);
	}

	public JButton getTakeOrderButton() {
		return takeOrderButton;
	}

	public JButton getViewOrderButton() {
		return viewOrderButton;
	}

	public void addtoPanel(JPanel panel){
		panel.add(welcomeLabel);
		panel.add(splLabel);
		panel.add(splNameLabel);
		panel.add(splCostLabel);
		panel.add(takeOrderButton);
		panel.add(viewOrderButton);
		panel.add(backButton);
		
	}
	public void setBounds(){
		welcomeLabel.setBounds(170,100, 600,65);
		splLabel.setBounds(200, 170,600,65);
		splNameLabel.setBounds(200, 260, 500,25);
		splCostLabel.setBounds(200, 300, 500,25);
		takeOrderButton.setBounds(390, 790, 150,65);
		viewOrderButton.setBounds(200,790,150,65);
		backButton.setBounds(575, 790, 150,65);
	}
	
	public void ButtonListner(ActionListener l){
		takeOrderButton.addActionListener(l);
		viewOrderButton.addActionListener(l);
		backButton.addActionListener(l);
	}
	public JButton getBackButton() {
		return backButton;
	}

}