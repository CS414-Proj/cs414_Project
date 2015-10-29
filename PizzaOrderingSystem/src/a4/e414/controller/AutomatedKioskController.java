package a4.e414.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import a4.e414.model.FullMenuModel;
import a4.e414.model.PizzaModel;
import a4.e414.model.CustomerModel;
import a4.e414.model.DrinksModel;
import a4.e414.model.Sides;
import a4.e414.model.StoreOrderModel;
import a4.e414.model.PizzaToppings;
import a4.e414.view.AutomatedKioskScreen;

public class AutomatedKioskController {

	private AutomatedKioskScreen kioskScreen;
	private FullMenuModel menu;

	public AutomatedKioskController(){
		this.menu = FullMenuModel.getInstance();
		this.kioskScreen = new AutomatedKioskScreen(menu.getSpecialName(),menu.getSpecialCost()+"");
		getOrder();
		this.kioskScreen.ButtonListner(new KioskHomeListner());
	}

	class KioskHomeListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(kioskScreen.getViewOrderButton())){
				new DisplayOrderController("Customer");
				kioskScreen.setVisible(false);
			}
			else if(e.getSource().equals(kioskScreen.getTakeOrderButton())){
				new CustomerModel();
				kioskScreen.setVisible(false);
			}
			else if(e.getSource().equals(kioskScreen.getBackButton())) 
	        {
				new AutomatedKioskController();
				kioskScreen.setVisible(false);
	        	
	        }
		}
	}
	
	public void getOrder(){
		StoreOrderModel searchOrder = menu.getSpecialOrder();
		JPanel panel = kioskScreen.getPanel();
		if(!menu.getSpecialName().equals("None")){
			String tops="";
			int yPosition = 340; 
			for(PizzaModel pizza: searchOrder.getPizzaList()){
				for(PizzaToppings topping : pizza.getToppingList() ){
					tops = tops+" "+topping.getName();
				}
				String subOrder = "Pizza- "+pizza.getSize()+" "+pizza.getCrust()+" "+tops+" Qty:"+pizza.getQuantity();
				JLabel item = new JLabel(subOrder);
				item.setBounds(250, yPosition, 200, 25);
				yPosition = yPosition+30;
				panel.add(item);

			}
			for(Sides bs : searchOrder.getSideList()){
				String subOrder = "Side- "+bs.getSize()+" "+bs.getType()+" Qty:"+bs.getQuantity();
				JLabel item = new JLabel(subOrder);
				item.setBounds(250, yPosition, 200, 25);
				yPosition = yPosition+30;
				panel.add(item);
			}
			for(DrinksModel drinks : searchOrder.getDrinksList()){
				String subOrder = "Drinks- "+drinks.getSize()+" "+drinks.getType()+" Qty:"+drinks.getQuantity();
				JLabel item = new JLabel(subOrder);
				item.setBounds(250, yPosition, 200, 25);
				yPosition = yPosition+30;
				panel.add(item);
			}
		}
		else{
			JLabel item = new JLabel("Special Not Set");
			item.setBounds(250, 340, 200, 25);
			item.setVisible(true);
			panel.add(item);
		}
		panel.revalidate();
		panel.repaint();
	}

}