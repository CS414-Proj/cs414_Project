package a4.k414.controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import a4.k414.model.FullMenuModel;
import a4.k414.model.ItemDetailsModel;
import a4.k414.view.ManageMenuScreen;


public class ManageMenuController 
{
	private ManageMenuScreen menuEditScreen;
	private FullMenuModel menu;
	private String user;
	private String action = "none";

	public ManageMenuController(String user)
	{
		this.user=user;
		this.menu = FullMenuModel.getInstance();
		this.menuEditScreen = new ManageMenuScreen();
		this.menuEditScreen.addButtonListener(new DefineMenuActionListener());

	}

	public void showAddMenu(String action){
		for(Component comp : menuEditScreen.getPanel().getComponents()){
			if(comp instanceof JCheckBox){
				JCheckBox cb = (JCheckBox) comp;
				cb.setVisible(false);
			}
		}
		menuEditScreen.getEditLabel().setVisible(false);
		menuEditScreen.addItemType(action);
		menuEditScreen.getEditLabel().setVisible(true);
		menuEditScreen.getNameLabel().setVisible(true);
		menuEditScreen.getNameTextField().setVisible(true);
		menuEditScreen.getPriceLabel().setVisible(true);
		menuEditScreen.getPriceTextField().setVisible(true);
		menuEditScreen.getAddMoreButton().setVisible(true);
		menuEditScreen.getDoneEditingButton().setVisible(true);
		menuEditScreen.getDeleteSelectedButton().setVisible(true);
		if(action.equals("Pizza Size"))
			menuEditScreen.addItems(menu.getPizzaSizeNameAndPrice());
		else if(action.equals("Pizza Crust"))
			menuEditScreen.addItems(menu.getPizzaTypeNameAndPrice());
		else if(action.equals("Pizza Topping"))
			menuEditScreen.addItems(menu.getPizzaToppingNameAndPrice());
		else if(action.equals("Side Size"))
			menuEditScreen.addItems(menu.getSideSizeNameAndPrice());
		else if(action.equals("Side Type"))
			menuEditScreen.addItems(menu.getSideTypeNameAndPrice());
		else if(action.equals("Drink Size"))
			menuEditScreen.addItems(menu.getDrinkSizeNameAndPrice());
		else if(action.equals("Drink Type"))
			menuEditScreen.addItems(menu.getDrinkTypeNameAndPrice());
	}

	public void addNameAndPrice()
	{
		String name = menuEditScreen.getNameTextField().getText();
		Boolean flag = true;
		float price=0;
		try
		{
			price = Float.parseFloat(menuEditScreen.getPriceTextField().getText());
		}
		catch(NumberFormatException e)
		{
			flag = false;
		}

		if(name.equals("") || flag.equals(false) )
		{
			JOptionPane.showMessageDialog(null,"Invalid inputs given..!!!");
		}

		ItemDetailsModel menuItemInfo = new ItemDetailsModel();
		menuItemInfo.setName(name);
		menuItemInfo.setPrice(price);
		menu.removeElement(menuItemInfo,action);	//My Edit
		menu.addElement(menuItemInfo,action);
	}

	class DefineMenuActionListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			JButton tempButton = (JButton)e.getSource();

			if(tempButton.equals(menuEditScreen.getPizzaSizeButton()))
			{
				action= "Pizza Size";
				showAddMenu(action);
			}
			else if(tempButton.equals(menuEditScreen.getPizzaTypeButton())) 
			{
				action="Pizza Crust";
				showAddMenu(action);
			}
			else if(tempButton.equals(menuEditScreen.getPizzaToppingButton())) 
			{
				action="Pizza Topping";
				showAddMenu(action);
			}
			else if(tempButton.equals(menuEditScreen.getsideSizeButton())) 
			{
				action="Side Size";
				showAddMenu(action);
			}
			else if(tempButton.equals(menuEditScreen.getsideTypeButton())) 
			{
				action="Side Type";
				showAddMenu(action);
			}
			else if(tempButton.equals(menuEditScreen.getDrinkSizeButton())) 
			{
				action="Drink Size";
				showAddMenu(action);
			}
			else if(tempButton.equals(menuEditScreen.getDrinkTypeButton())) 
			{
				action="Drink Type";
				showAddMenu(action);
			}
			else if(tempButton.equals(menuEditScreen.getDoneEditingButton())) 
			{
				if(!menuEditScreen.getNameTextField().getText().equals("")){
					addNameAndPrice();
				}
				for(Component comp : menuEditScreen.getPanel().getComponents()){
					if(comp instanceof JCheckBox){
						JCheckBox cb = (JCheckBox) comp;
						cb.setVisible(false);
					}
				}
				menuEditScreen.getNameTextField().setText("");
				menuEditScreen.getPriceTextField().setText("");
				menuEditScreen.getEditLabel().setVisible(false);
				menuEditScreen.getNameLabel().setVisible(false);
				menuEditScreen.getNameTextField().setVisible(false);
				menuEditScreen.getPriceLabel().setVisible(false);
				menuEditScreen.getPriceTextField().setVisible(false);
				menuEditScreen.getAddMoreButton().setVisible(false);
				menuEditScreen.getDoneEditingButton().setVisible(false);
				menuEditScreen.getDeleteSelectedButton().setVisible(false);
			}
			else if(tempButton.equals(menuEditScreen.getAddMoreButton())) 
			{
				addNameAndPrice();
				menuEditScreen.getNameTextField().setText("");
				menuEditScreen.getPriceTextField().setText("");
				showAddMenu(action);
			}
			else if(tempButton.equals(menuEditScreen.getDeleteSelectedButton())) 
			{
				JPanel panel = menuEditScreen.getPanel();
				for(Component comp : menuEditScreen.getPanel().getComponents()){
					if(comp instanceof JCheckBox){
						JCheckBox cb = (JCheckBox) comp;
						if(cb.isSelected()){
							StringTokenizer st = new StringTokenizer(cb.getText(), "-");
							ItemDetailsModel menuItemInfo = new ItemDetailsModel();
							menuItemInfo.setName(st.nextToken());
							menuItemInfo.setPrice(Float.parseFloat(st.nextToken()));
							menu.removeElement(menuItemInfo, action);
							panel.remove(cb);
						}
					}
				}
				//Reposition
				showAddMenu(action);

			}
			else if(tempButton.equals(menuEditScreen.getHomeButton())) 
			{
				menuEditScreen.setVisible(false);
				new ManagerActionsController(user);
			}
		}
	}

} 
