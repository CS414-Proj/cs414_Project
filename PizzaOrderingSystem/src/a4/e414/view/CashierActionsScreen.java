package a4.e414.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class CashierActionsScreen extends JFrame {
	
	private JLabel welcomeLabelCashierView;
	private JButton takeOrderButton = new JButton("Place Order");
	private JButton viewSplButton = new JButton("View Special");
	private JButton viewOrderbutton = new JButton("View Order");
	private JButton logOutButton = new JButton("Log Out");
	private String errorMsg = "An unexpected error occured... Please try again";
	
	public void setFonts() {

		Font myTFont = new Font("Mistral", Font.PLAIN, 1);
		Font myFFont = new Font("Serif", Font.PLAIN, 1);
		Font tNewFont = myTFont.deriveFont(40F);
		Font newFont = myTFont.deriveFont(30F);
		Font newFFont = myFFont.deriveFont(20F);
		welcomeLabelCashierView.setFont(tNewFont);
		welcomeLabelCashierView.setForeground(Color.RED);
		takeOrderButton.setFont(newFFont);
		viewSplButton.setFont(newFFont);
		viewOrderbutton.setFont(newFFont);
		logOutButton.setFont(newFFont);
	}

	
	public CashierActionsScreen(String cashierName){
		welcomeLabelCashierView = new JLabel("Welcome "+cashierName);
		JPanel panel = new JPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900,1000);
		this.add(panel);
		panel.setLayout(null);
		setBounds();
		addtoPanel(panel);
		this.setVisible(true);
		setFonts();
	}

	public void addtoPanel(JPanel panel){
		panel.add(welcomeLabelCashierView);
		panel.add(takeOrderButton);
		panel.add(viewSplButton);
		panel.add(viewOrderbutton);
		panel.add(logOutButton);
	}
	public JButton getViewOrderbutton() {
		return viewOrderbutton;
	}

	public void setBounds(){
		welcomeLabelCashierView.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabelCashierView.setVerticalAlignment(SwingConstants.CENTER);
		welcomeLabelCashierView.setBounds(300,20, 300,85);
		takeOrderButton.setBounds(350,320,200,85);
		viewSplButton.setBounds(350, 430, 200,85);
		viewOrderbutton.setBounds(350, 540, 200,85);
		logOutButton.setBounds(350, 830, 200,85);
	}
	
	public JButton getTakeOrderButton() {
		return takeOrderButton;
	}

	public JButton getLogOutButton() {
		return logOutButton;
	}

	public JButton getViewSplButton() {
		return viewSplButton;
	}

	public void ButtonListner(ActionListener l){
		takeOrderButton.addActionListener(l);
		logOutButton.addActionListener(l);
		viewSplButton.addActionListener(l);
		viewOrderbutton.addActionListener(l);
	}
	
	public void errorMsg(){
		JOptionPane.showMessageDialog(this,errorMsg);
	}
	
	public static void main(String args[]){
		new CashierActionsScreen("cash");
	}

}
