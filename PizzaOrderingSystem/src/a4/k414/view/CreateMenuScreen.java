package a4.k414.view;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


@SuppressWarnings("serial")
public class CreateMenuScreen extends JFrame 
{
	
	public static void main(String args[]){
		new CreateMenuScreen();
				
	}
	private JPanel panel = new JPanel();
	private JLabel welcomeLabel = new JLabel("Define Menu");
	private JLabel pizzaLabel = new JLabel("Pizza");
	private JButton pizzaSizeButton = new JButton("Pizza Size");
	private JButton pizzaTypeButton = new JButton("Pizza Crust");
	private JButton pizzaToppingButton = new JButton("Pizza Toppings");
	private JLabel sideLabel = new JLabel("Side");
	private JButton sideSizeButton = new JButton("Side Size");
	private JButton sideTypeButton = new JButton("Side Type");
	private JLabel drinkLabel = new JLabel("Drink");
	private JButton drinkSizeButton = new JButton("Drink Size");
	private JButton drinkTypeButton = new JButton("Drink Type");
	private JLabel itemType= new JLabel("");;
	private JLabel nameLabel = new JLabel("Name");
	private JLabel priceLabel = new JLabel("Price");
	private JTextField nameTextField = new JTextField();
	private JTextField priceTextField = new JTextField();
	private JButton addMoreButton = new JButton("Add more");
	private JButton doneButton = new JButton("Done");
	
	private JButton backButton = new JButton("Home");
	
	
	public void setFonts() {

		Font myTFont = new Font("Mistral", Font.PLAIN, 1);
		Font myFFont = new Font("Serif", Font.PLAIN, 1);
		Font tNewFont = myTFont.deriveFont(40F);
		Font newFont = myTFont.deriveFont(30F);
		Font newFFont = myFFont.deriveFont(20F);
		welcomeLabel.setFont(tNewFont);
		welcomeLabel.setForeground(Color.RED);
		pizzaLabel.setFont(newFont);
		pizzaLabel.setForeground(Color.BLUE);
		pizzaSizeButton.setFont(newFFont);
		pizzaTypeButton.setFont(newFFont);
		pizzaToppingButton.setFont(newFFont);
		sideLabel.setFont(newFont);
		sideLabel.setForeground(Color.BLUE);
		sideSizeButton.setFont(newFFont);
		sideTypeButton.setFont(newFFont);
		drinkLabel.setFont(newFont);
		drinkLabel.setForeground(Color.BLUE);
		drinkSizeButton.setFont(newFFont);
		drinkTypeButton.setFont(newFFont);
		backButton.setFont(newFont);
		backButton.setForeground(Color.BLUE);
		nameLabel.setFont(newFFont);
		nameLabel.setForeground(Color.BLUE);
		priceLabel.setFont(newFFont);
		priceLabel.setForeground(Color.BLUE);
		nameTextField.setFont(newFFont);
		priceTextField.setFont(newFFont);
		addMoreButton.setFont(newFFont);

		doneButton.setFont(newFFont);

	}
	
	public CreateMenuScreen() 
	{
		this.setUp();
       	
	}
	
	public void setUp(){
		panel.setLayout(null);
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setVerticalAlignment(SwingConstants.CENTER);
		welcomeLabel.setBounds(340,30,500,45);
		panel.add(welcomeLabel);
	
        pizzaLabel.setBounds(400,100,150,35);
        panel.add(pizzaLabel);
        
        pizzaSizeButton.setBounds(100,140,200,60);
        panel.add(pizzaSizeButton);

        pizzaTypeButton.setBounds(350,140,200,60);
        panel.add(pizzaTypeButton);
        
        pizzaToppingButton.setBounds(600,140,200,60);
        panel.add(pizzaToppingButton);

       
        sideLabel.setBounds(380,220,100,35);
        panel.add(sideLabel);
        
        sideSizeButton.setBounds(200,270,200,60);
        panel.add(sideSizeButton);
        
        sideTypeButton.setBounds(500,270,200,60);
        panel.add(sideTypeButton);
        
        drinkLabel.setBounds(400,340,100,35);
        panel.add(drinkLabel);
        
        drinkSizeButton.setBounds(200,380,200,60);
        panel.add(drinkSizeButton);

        drinkTypeButton.setBounds(500,380,200,60);
        panel.add(drinkTypeButton);
        

		nameLabel.setBounds(200,600,150,35);
        panel.add(nameLabel);
        
        nameTextField.setBounds(370,600,350,35);
        panel.add(nameTextField);
		
        priceLabel.setBounds(200,650,150,35);
        panel.add(priceLabel);
        
        priceTextField.setBounds(370,650,350,35);
        panel.add(priceTextField);
        
        addMoreButton.setBounds(200,750,200,35);
  		panel.add(addMoreButton);
  		
        doneButton.setBounds(500,750,200,35);
        panel.add(doneButton);
		backButton.setBounds(370,890,170,45);
		panel.add(backButton);

		nameLabel.setVisible(true);
    	nameTextField.setVisible(true);
    	priceLabel.setVisible(true);
    	priceTextField.setVisible(true);
    	addMoreButton.setVisible(true);
    	doneButton.setVisible(true);
    	
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(900,1000);
		setFonts();
		this.setTitle("Define Menu");
		this.setIconImage(new ImageIcon("C:/Users/ks_an/javaworkspace/PizzaOrderingSystem/icon2.png").getImage());
        this.setVisible(true);
		this.add(panel);
	}


	public void buttonListener(ActionListener listenerForButton)
	{
    	pizzaSizeButton.addActionListener(listenerForButton);
    	pizzaTypeButton.addActionListener(listenerForButton);
    	pizzaToppingButton.addActionListener(listenerForButton);
    	sideSizeButton.addActionListener(listenerForButton);
    	sideTypeButton.addActionListener(listenerForButton);
    	drinkSizeButton.addActionListener(listenerForButton);
    	drinkTypeButton.addActionListener(listenerForButton);
    	addMoreButton.addActionListener(listenerForButton);
    	doneButton.addActionListener(listenerForButton);
    	backButton.addActionListener(listenerForButton);
	}
	
			
	public void addItemType(String action){
		itemType = new JLabel(action + ":");
		itemType.setBounds(100,500,500,35);
		Font myFFont = new Font("Serif", Font.PLAIN, 1);
		Font newFFont = myFFont.deriveFont(30F);
		itemType.setFont(newFFont);
		itemType.setForeground(Color.BLUE);
		panel.add(itemType);
		panel.revalidate();
		panel.repaint();
	}
	
	public JLabel getItemType() {
		return itemType;
	}

	public JPanel getPanel() {
		return panel;
	}

	public JButton getBackButton() {
		return backButton;
	}
	public JButton getPizzaSizeButton() {
		return pizzaSizeButton;
	}

	public JButton getPizzaTypeButton() {
		return pizzaTypeButton;
	}

	public JButton getPizzaToppingButton() {
		return pizzaToppingButton;
	}

	public JButton getsideSizeButton() {
		return sideSizeButton;
	}

	public JButton getsideTypeButton() {
		return sideTypeButton;
	}

	public JButton getDrinkSizeButton() {
		return drinkSizeButton;
	}

	public JButton getDrinkTypeButton() {
		return drinkTypeButton;
	}

	public JTextField getNameTextField() {
		return nameTextField;
	}

	public JTextField getPriceTextField() {
		return priceTextField;
	}
	
	public JLabel getWelcomeLabel() {
		return welcomeLabel;
	}

	public JLabel getPizzaLabel() {
		return pizzaLabel;
	}

	public JLabel getsideLabel() {
		return sideLabel;
	}

	public JLabel getDrinkLabel() {
		return drinkLabel;
	}

	public JLabel getNameLabel() {
		return nameLabel;
	}

	public JLabel getPriceLabel() {
		return priceLabel;
	}

	public JButton getAddMoreButton() {
		return addMoreButton;
	}

	public JButton getDoneButton() {
		return doneButton;
	}

}