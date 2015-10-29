package a4.e414.view;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import a4.e414.model.ItemDetailsModel;

@SuppressWarnings("serial")
public class ManageMenuScreen extends JFrame 
{
 


	private JPanel panel = new JPanel();
	private JLabel welcomeLabel = new JLabel("<html><div style=\"text-align: center;\">" + "Edit menu" + "</html>", SwingConstants.CENTER);
	private JLabel pizzaLabel = new JLabel("Pizaa");
	private JButton pizzaSizeButton = new JButton("Pizza Size");
	private JButton pizzaTypeButton = new JButton("Pizza Crust");
	private JButton pizzaToppingButton = new JButton("Pizza Toppings");
	private JLabel sideLabel = new JLabel("side");
	private JButton sideSizeButton = new JButton("side Size");
	private JButton sideTypeButton = new JButton("side Type");
	private JLabel drinkLabel = new JLabel("Drinks");
	private JButton drinkSizeButton = new JButton("Drink Size");
	private JButton drinkTypeButton = new JButton("Drink Type");
	private JButton homeButton = new JButton("Home");
	private JLabel editLabel = new JLabel("");
	private JLabel nameLabel = new JLabel("Name");
	private JLabel priceLabel = new JLabel("Price");
	private JTextField nameTextField = new JTextField();
	private JTextField priceTextField = new JTextField();
	private JButton addMoreButton = new JButton("Add More");
	private JButton deleteSelectedButton = new JButton("Delete Selected");
	private JButton doneEditingButton = new JButton("Done Editing");
	
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
		homeButton.setFont(newFont);
		homeButton.setForeground(Color.BLUE);
		nameLabel.setFont(newFFont);
		nameLabel.setForeground(Color.BLUE);
		priceLabel.setFont(newFFont);
		priceLabel.setForeground(Color.BLUE);
		nameTextField.setFont(newFFont);
		priceTextField.setFont(newFFont);
		addMoreButton.setFont(newFFont);
		deleteSelectedButton.setFont(newFFont);
		doneEditingButton.setFont(newFFont);

	}

	
	
	public static void main(String args[]){
		new ManageMenuScreen();
		
		

		
	}
	public ManageMenuScreen() 
	{
		setFonts();
		this.setUp();
		
			
	}
	
	public void setUp(){
		panel.setLayout(null);
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setVerticalAlignment(SwingConstants.CENTER);
		welcomeLabel.setBounds(340,30,500,35);
		panel.add(welcomeLabel);

        pizzaLabel.setBounds(400,100,150,35);
        panel.add(pizzaLabel);
        
        pizzaSizeButton.setBounds(100,150,200,85);
        panel.add(pizzaSizeButton);

        pizzaTypeButton.setBounds(350,150,200,85);
        panel.add(pizzaTypeButton);
        
        pizzaToppingButton.setBounds(600,150,200,85);
        panel.add(pizzaToppingButton);

       

        sideLabel.setBounds(380,250,100,35);
        panel.add(sideLabel);
        
        sideSizeButton.setBounds(200,300,200,85);
        panel.add(sideSizeButton);
        
        sideTypeButton.setBounds(500,300,200,85);
        panel.add(sideTypeButton);
        
       
        drinkLabel.setBounds(400,410,100,25);
        panel.add(drinkLabel);
        
        drinkSizeButton.setBounds(200,450,200,85);
        panel.add(drinkSizeButton);

        drinkTypeButton.setBounds(500,450,200,85);
        panel.add(drinkTypeButton);
        
        editLabel.setBounds(30,250,150,25);
        panel.add(editLabel);
        
				
		nameLabel.setBounds(200,750,150,25);
        panel.add(nameLabel);
        
        nameTextField.setBounds(370,750,350,35);
        panel.add(nameTextField);
		
        priceLabel.setBounds(200,800,150,35);
        panel.add(priceLabel);
        
        priceTextField.setBounds(370,800,350,35);
        panel.add(priceTextField);
        
        addMoreButton.setBounds(100,840,150,35);
  		panel.add(addMoreButton);
  		
  		deleteSelectedButton.setBounds(370,840,170,35);
  		panel.add(deleteSelectedButton);
  		
  		doneEditingButton.setBounds(620,840,150,35);
        panel.add(doneEditingButton);
        
        homeButton.setBounds(370,890,170,45);
  		panel.add(homeButton);
  		
  		nameLabel.setVisible(true);
    	nameTextField.setVisible(true);
    	priceLabel.setVisible(true);
    	priceTextField.setVisible(true);
    	addMoreButton.setVisible(true);
    	deleteSelectedButton.setVisible(true);
    	doneEditingButton.setVisible(true);
    	editLabel.setVisible(true);
        
        this.add(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Edit Menu");
		this.setIconImage(new ImageIcon("C:/Users/ks_an/javaworkspace/PizzaOrderingSystem/icon2.png").getImage());
		this.setSize(900,1000);
        this.setVisible(true);
	}
	
	public void addItemType(String action){
		editLabel = new JLabel(action);
		panel.add(editLabel);
		panel.revalidate();
		panel.repaint();
	}
	
	public void addItems(ArrayList<ItemDetailsModel> itemList){
		int x=30,y=550,count=1;
		for(ItemDetailsModel item: itemList){
			JCheckBox itemCheckbox = new JCheckBox(item.getName()+"-"+item.getPrice());
			Font myFFont = new Font("Serif", Font.PLAIN, 1);
			Font newFFont = myFFont.deriveFont(20F);
			itemCheckbox.setFont(newFFont);
			itemCheckbox.setBounds(x,y,160,35);
			panel.add(itemCheckbox);
			x=x+180;
			if(count%4==0){
				y=y+35;
				x=30;
			}
			count++;
		}
		panel.revalidate();
		panel.repaint();
	}
	
	public JPanel getPanel() {
		return panel;
	}
	public JLabel getNameLabel() {
		return nameLabel;
	}
	public JLabel getPriceLabel() {
		return priceLabel;
	}
	public JButton getDoneEditingButton() {
		return doneEditingButton;
	}
	public JLabel getEditLabel() {
		return editLabel;
	}
	public void addButtonListener(ActionListener listenerForButton)
	{
    	pizzaSizeButton.addActionListener(listenerForButton);
    	pizzaTypeButton.addActionListener(listenerForButton);
    	pizzaToppingButton.addActionListener(listenerForButton);
    	sideSizeButton.addActionListener(listenerForButton);
    	sideTypeButton.addActionListener(listenerForButton);
    	drinkSizeButton.addActionListener(listenerForButton);
    	drinkTypeButton.addActionListener(listenerForButton);
    	addMoreButton.addActionListener(listenerForButton);
    	deleteSelectedButton.addActionListener(listenerForButton);
    	homeButton.addActionListener(listenerForButton);
    	doneEditingButton.addActionListener(listenerForButton);
	}
	
	/**
	 * @return the pizzaSizeButton
	 */
	public JButton getPizzaSizeButton() {
		return pizzaSizeButton;
	}

	/**
	 * @param pizzaSizeButton the pizzaSizeButton to set
	 */
	public void setPizzaSizeButton(JButton pizzaSizeButton) {
		this.pizzaSizeButton = pizzaSizeButton;
	}

	/**
	 * @return the pizzaTypeButton
	 */
	public JButton getPizzaTypeButton() {
		return pizzaTypeButton;
	}

	/**
	 * @param pizzaTypeButton the pizzaTypeButton to set
	 */
	public void setPizzaTypeButton(JButton pizzaTypeButton) {
		this.pizzaTypeButton = pizzaTypeButton;
	}

	/**
	 * @return the pizzaToppingButton
	 */
	public JButton getPizzaToppingButton() {
		return pizzaToppingButton;
	}

	/**
	 * @param pizzaToppingButton the pizzaToppingButton to set
	 */
	public void setPizzaToppingButton(JButton pizzaToppingButton) {
		this.pizzaToppingButton = pizzaToppingButton;
	}

	/**
	 * @return the sideSizeButton
	 */
	public JButton getsideSizeButton() {
		return sideSizeButton;
	}

	/**
	 * @param sideSizeButton the sideSizeButton to set
	 */
	public void setsideSizeButton(JButton sideSizeButton) {
		this.sideSizeButton = sideSizeButton;
	}

	/**
	 * @return the sideTypeButton
	 */
	public JButton getsideTypeButton() {
		return sideTypeButton;
	}

	/**
	 * @param sideTypeButton the sideTypeButton to set
	 */
	public void setsideTypeButton(JButton sideTypeButton) {
		this.sideTypeButton = sideTypeButton;
	}

	/**
	 * @return the drinkSizeButton
	 */
	public JButton getDrinkSizeButton() {
		return drinkSizeButton;
	}

	/**
	 * @param drinkSizeButton the drinkSizeButton to set
	 */
	public void setDrinkSizeButton(JButton drinkSizeButton) {
		this.drinkSizeButton = drinkSizeButton;
	}

	/**
	 * @return the drinkTypeButton
	 */
	public JButton getDrinkTypeButton() {
		return drinkTypeButton;
	}

	/**
	 * @param drinkTypeButton the drinkTypeButton to set
	 */
	public void setDrinkTypeButton(JButton drinkTypeButton) {
		this.drinkTypeButton = drinkTypeButton;
	}
	/**
	 * @return the nameTextField
	 */
	public JTextField getNameTextField() {
		return nameTextField;
	}

	/**
	 * @param nameTextField the nameTextField to set
	 */
	public void setNameTextField(JTextField nameTextField) {
		this.nameTextField = nameTextField;
	}

	/**
	 * @return the priceTextField
	 */
	public JTextField getPriceTextField() {
		return priceTextField;
	}

	/**
	 * @param priceTextField the priceTextField to set
	 */
	public void setPriceTextField(JTextField priceTextField) {
		this.priceTextField = priceTextField;
	}

	/**
	 * @return the addMoreButton
	 */
	public JButton getAddMoreButton() {
		return addMoreButton;
	}

	/**
	 * @param addMoreButton the addMoreButton to set
	 */
	public void setAddMoreButton(JButton addMoreButton) {
		this.addMoreButton = addMoreButton;
	}

	/**
	 * @return the deleteSelectedButton
	 */
	public JButton getDeleteSelectedButton() {
		return deleteSelectedButton;
	}

	/**
	 * @param deleteSelectedButton the deleteSelectedButton to set
	 */
	public void setDeleteSelectedButton(JButton deleteSelectedButton) {
		this.deleteSelectedButton = deleteSelectedButton;
	}

	/**
	 * @return the doneButton
	 */
	public JButton getHomeButton() {
		return homeButton;
	}

	/**
	 * @param doneButton the doneButton to set
	 */
	public void setHomeButton(JButton doneButton) {
		this.homeButton = doneButton;
	}
	
	/**
	 * @param doneAddingButton the doneAddingButton to set
	 */
	public void setDoneEditingButton(JButton doneEditingButton) {
		this.doneEditingButton = doneEditingButton;
	}
}