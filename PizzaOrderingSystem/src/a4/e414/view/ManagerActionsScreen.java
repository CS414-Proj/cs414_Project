package a4.e414.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ManagerActionsScreen extends JFrame 
{
	
	public static void main(String args[]){
		new ManagerActionsScreen("Anvesh");
				
	}
	private JPanel mainPanel = new JPanel();
	private JLabel welcomeMessageLabel;
	private JButton defineMenuButton = new JButton("Define Menu");
	
	private JButton editMenuButton = new JButton("Edit Menu");
	private JButton setSpecialButton = new JButton("Set Special");
	private JButton viewOrderButton = new JButton("View Orders");
	private JButton logoutButton = new JButton("Logout");
	
	public void setFonts() {

		Font myTFont = new Font("Mistral", Font.PLAIN, 1);
		Font myFFont = new Font("Serif", Font.PLAIN, 1);
		Font tNewFont = myTFont.deriveFont(40F);
		Font newFont = myTFont.deriveFont(30F);
		welcomeMessageLabel.setFont(tNewFont);
		welcomeMessageLabel.setForeground(Color.RED);
		defineMenuButton.setFont(newFont);
		defineMenuButton.setForeground(Color.BLUE);
		editMenuButton.setFont(newFont);
		editMenuButton.setForeground(Color.BLUE);
		setSpecialButton.setFont(newFont);
		setSpecialButton.setForeground(Color.BLUE);
		viewOrderButton.setFont(newFont);
		viewOrderButton.setForeground(Color.BLUE);
		logoutButton.setFont(newFont);
		logoutButton.setForeground(Color.BLUE);
			
	}
	
	
	public ManagerActionsScreen(String user) 
	{

		mainPanel.setLayout(null);
		
		welcomeMessageLabel = new JLabel("Welcome "+user);
		setFonts();
		welcomeMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeMessageLabel.setVerticalAlignment(SwingConstants.CENTER);

        welcomeMessageLabel.setLocation(200,50);
        welcomeMessageLabel.setSize(450, 85);
		welcomeMessageLabel.setAlignmentY(CENTER_ALIGNMENT);


        mainPanel.add(welcomeMessageLabel);
        
        defineMenuButton.setHorizontalAlignment(SwingConstants.CENTER);
        defineMenuButton.setVerticalAlignment(SwingConstants.CENTER);
        defineMenuButton.setLocation(200, 150);
        defineMenuButton.setSize(450, 85);
        mainPanel.add(defineMenuButton);
        
        editMenuButton.setHorizontalAlignment(SwingConstants.CENTER);
        editMenuButton.setVerticalAlignment(SwingConstants.CENTER);
        
        editMenuButton.setLocation(200, 250);
        editMenuButton.setSize(450, 85);
        mainPanel.add(editMenuButton);

        
        setSpecialButton.setHorizontalAlignment(SwingConstants.CENTER);
        setSpecialButton.setVerticalAlignment(SwingConstants.CENTER);
        setSpecialButton.setLocation(200, 350);
        setSpecialButton.setSize(450, 85);
        mainPanel.add(setSpecialButton);

        viewOrderButton.setHorizontalAlignment(SwingConstants.CENTER);
        viewOrderButton.setVerticalAlignment(SwingConstants.CENTER);
        viewOrderButton.setLocation(200, 450);
        viewOrderButton.setSize(450, 85);
        mainPanel.add(viewOrderButton);
               
        logoutButton.setHorizontalAlignment(SwingConstants.CENTER);
        logoutButton.setVerticalAlignment(SwingConstants.CENTER);
        logoutButton.setLocation(200,850);
        logoutButton.setSize(450, 85);
        mainPanel.add(logoutButton);
        
        mainPanel.setOpaque(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Manager Home");
		this.setIconImage(new ImageIcon("C:/Users/ks_an/javaworkspace/PizzaOrderingSystem/icon2.png").getImage());
		this.setSize(900,1000);
        this.setVisible(true);
		this.add(mainPanel);	
	}
	
	//======================getter and setter methods for class variables===================
	/**
	 * @return the defineMenuButton
	 */
	public JButton getDefineMenuButton() {
		return defineMenuButton;
	}

	/**
	 * @param defineMenuButton the defineMenuButton to set
	 */
	public void setDefineMenuButton(JButton defineMenuButton) {
		this.defineMenuButton = defineMenuButton;
	}

	/**
	 * @return the editMenuButton
	 */
	public JButton getEditMenuButton() {
		return editMenuButton;
	}

	/**
	 * @param editMenuButton the editMenuButton to set
	 */
	public void setEditMenuButton(JButton editMenuButton) {
		this.editMenuButton = editMenuButton;
	}

	/**
	 * @return the setSpecialButton
	 */
	public JButton getSetSpecialButton() {
		return setSpecialButton;
	}

	/**
	 * @param setSpecialButton the setSpecialButton to set
	 */
	public void setSetSpecialButton(JButton setSpecialButton) {
		this.setSpecialButton = setSpecialButton;
	}

	/**
	 * @return the viewOrderButton
	 */
	public JButton getViewOrderButton() {
		return viewOrderButton;
	}

	/**
	 * @param viewOrderButton the viewOrderButton to set
	 */
	public void setViewOrderButton(JButton viewOrderButton) {
		this.viewOrderButton = viewOrderButton;
	}

	/**
	 * @return the logoutButton
	 */
	public JButton getLogoutButton() {
		return logoutButton;
	}

	/**
	 * @param logoutButton the logoutButton to set
	 */
	public void setLogoutButton(JButton logoutButton) {
		this.logoutButton = logoutButton;
	}

	//======================Action listener for all buttons=================================
	public void ButtonListener(ActionListener listenerForButton)
	{
    	defineMenuButton.addActionListener(listenerForButton);
    	editMenuButton.addActionListener(listenerForButton);
    	setSpecialButton.addActionListener(listenerForButton);
    	viewOrderButton.addActionListener(listenerForButton);
    	logoutButton.addActionListener(listenerForButton);
	}
	
}