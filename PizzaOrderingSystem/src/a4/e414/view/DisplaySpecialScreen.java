package a4.e414.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class DisplaySpecialScreen extends JFrame {

	private JLabel welcomeLabelSpecialView = new JLabel("View Special");
	private JLabel splNameLabel;
	private JLabel splCostLabel;
	private JLabel specialDetails = new JLabel("Special Details :");
	private JButton homeButton = new JButton("Home");
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
		welcomeLabelSpecialView.setFont(tNewFont);
		welcomeLabelSpecialView.setForeground(Color.RED);
		splNameLabel.setFont(newFFont);
		splNameLabel.setForeground(Color.BLUE);
		splCostLabel.setFont(newFFont);
		splCostLabel.setForeground(Color.BLUE);
		specialDetails.setFont(newFFont);
		specialDetails.setForeground(Color.BLUE);
		homeButton.setFont(newFFont);
		
	}

	public DisplaySpecialScreen(String splNameVal , String splCostval){
		
		splNameLabel = new JLabel("Special Name : "+splNameVal);
		splCostLabel = new JLabel("Special Cost : "+splCostval);
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
		panel.add(welcomeLabelSpecialView);
		panel.add(splNameLabel);
		panel.add(splCostLabel);
		panel.add(specialDetails);
		panel.add(homeButton);
	}
	public void setBounds(){
		welcomeLabelSpecialView.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabelSpecialView.setVerticalAlignment(SwingConstants.CENTER);
		welcomeLabelSpecialView.setBounds(340,30, 400, 100);
		splNameLabel.setBounds(200,120,300,35);
		splCostLabel.setBounds(200,180,300,35);
		homeButton.setBounds(340,830,200,85);
		specialDetails.setBounds(200,330,300,25);
	}

	public void ButtonListner(ActionListener l){
		homeButton.addActionListener(l);
	}

	public JButton getHomeButton() {
		return homeButton;
	}
	
	public JLabel getSpecialDetails() {
		return specialDetails;
	}

}
