package a4.k414.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import a4.k414.model.FullMenuModel;
import a4.k414.model.ItemDetailsModel;
import a4.k414.view.CreateMenuScreen;

 
public class CreateMenuController 
{
	private CreateMenuScreen menuDefineScreen;
	private FullMenuModel theModel;
	private String user;
	private String action = "none";
		
	public CreateMenuController(String user)
	{
		this.user=user;
		this.theModel = FullMenuModel.getInstance();
		this.menuDefineScreen = new CreateMenuScreen();
		this.menuDefineScreen.buttonListener(new DefineMenuActionListener());
		
	}

	public void showAddMenu(String action){
		menuDefineScreen.getItemType().setVisible(false);
		menuDefineScreen.addItemType(action);
		menuDefineScreen.getItemType().setVisible(true);
		menuDefineScreen.getNameLabel().setVisible(true);
    	menuDefineScreen.getNameTextField().setVisible(true);
    	menuDefineScreen.getPriceLabel().setVisible(true);
    	menuDefineScreen.getPriceTextField().setVisible(true);
    	menuDefineScreen.getAddMoreButton().setVisible(true);
    	menuDefineScreen.getDoneButton().setVisible(true);
	}
	
	public void addNameAndPrice()
	{
		String name = menuDefineScreen.getNameTextField().getText();
    	boolean flag = true;
    	float price=0;
		try
		{
			price = Float.parseFloat(menuDefineScreen.getPriceTextField().getText());
		}
		catch(NumberFormatException e)
		{
			flag = false;
		}
    	
    	if(name.equals("") || flag==false )
    	{
    		JOptionPane.showMessageDialog(null,"Invalid inputs given..!!!");
    	}
    	
    	ItemDetailsModel menuItemInfo = new ItemDetailsModel();
    	menuItemInfo.setName(name);
    	menuItemInfo.setPrice(price);
    	
    	theModel.addElement(menuItemInfo,action);
	}
	
	class DefineMenuActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			JButton tempButton = (JButton)e.getSource();
		    			
			if(tempButton.equals(menuDefineScreen.getPizzaSizeButton()))
	        {
				action= "Pizza Size";
				showAddMenu(action);
	        }
	        else if(tempButton.equals(menuDefineScreen.getPizzaTypeButton())) 
	        {
	        	action="Pizza Crust";
	        	showAddMenu(action);
	        }
	        else if(tempButton.equals(menuDefineScreen.getPizzaToppingButton())) 
	        {
	        	action="Pizza Topping";
	        	showAddMenu(action);
	        }
	        else if(tempButton.equals(menuDefineScreen.getsideSizeButton())) 
	        {
	        	action="Side Size";
	        	showAddMenu(action);
	        }
	        else if(tempButton.equals(menuDefineScreen.getsideTypeButton())) 
	        {
	        	action="Side Type";
	        	showAddMenu(action);
	        }
	        else if(tempButton.equals(menuDefineScreen.getDrinkSizeButton())) 
	        {
	        	action="Drink Size";
	        	showAddMenu(action);
	        }
	        else if(tempButton.equals(menuDefineScreen.getDrinkTypeButton())) 
	        {
	        	action="Drink Type";
	        	showAddMenu(action);
	        }
	        else if(tempButton.equals(menuDefineScreen.getDoneButton())) 
	        {
	        	if(!menuDefineScreen.getNameTextField().getText().equals("")){
	        		addNameAndPrice();
	        	}
	        	menuDefineScreen.getNameTextField().setText("");
	        	menuDefineScreen.getPriceTextField().setText("");
	        	menuDefineScreen.getItemType().setVisible(false);
	        	menuDefineScreen.getNameLabel().setVisible(false);
	        	menuDefineScreen.getNameTextField().setVisible(false);
	        	menuDefineScreen.getPriceLabel().setVisible(false);
	        	menuDefineScreen.getPriceTextField().setVisible(false);
	        	menuDefineScreen.getAddMoreButton().setVisible(false);
	        	menuDefineScreen.getDoneButton().setVisible(false);
	        }
	        else if(tempButton.equals(menuDefineScreen.getAddMoreButton())) 
	        {
	        	addNameAndPrice();
	        	menuDefineScreen.getNameTextField().setText("");
	        	menuDefineScreen.getPriceTextField().setText("");
	        }
	        else if(tempButton.equals(menuDefineScreen.getBackButton())) 
	        {
	        	menuDefineScreen.setVisible(false);
	        	new ManagerActionsController(user);
	        }
		}
	}
} 
