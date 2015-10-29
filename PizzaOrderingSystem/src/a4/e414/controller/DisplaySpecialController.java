package a4.e414.controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import a4.e414.model.FullMenuModel;
import a4.e414.model.PizzaModel;
import a4.e414.model.CSUPizzaStore;
import a4.e414.model.DrinksModel;
import a4.e414.model.Sides;
import a4.e414.model.StoreOrderModel;
import a4.e414.model.PizzaToppings;
import a4.e414.view.DisplaySpecialScreen;

public class DisplaySpecialController {

	private DisplaySpecialScreen specialView;
	private JPanel panel;
	private String user;
	FullMenuModel menu;

	public DisplaySpecialController(String user){
		menu = FullMenuModel.getInstance();
		this.user= user;
		this.specialView = new DisplaySpecialScreen(menu.getSpecialName(),menu.getSpecialCost()+"");
		this.panel = specialView.getPanel();
		getOrder();
		this.specialView.ButtonListner(new ViewSpecialListner());
	}

	class ViewSpecialListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(specialView.getHomeButton())){
				String role = CSUPizzaStore.getBranchInstance().identifyStaffRole(user);
				if(role.equals("manager")){
					new ManagerActionsController(user);
				}
				else if(role.equals("cashier")){
					new CashierActionsController(user);
				}
				else if(role.equals("chef")){
					new ChefActionsController(user);
				}
				specialView.setVisible(false);
			}
		}
	}

	public void getOrder(){
		StoreOrderModel searchOrder = menu.getSpecialOrder();
		Font myFFont = new Font("Serif", Font.PLAIN, 1);
		Font newFFont = myFFont.deriveFont(20F);
		
		if(!menu.getSpecialName().equals("None")){
			String tops="";
			int yPosition = 350; 
			for(PizzaModel pizza: searchOrder.getPizzaList()){
				for(PizzaToppings topping : pizza.getToppingList() ){
					tops = tops+" "+topping.getName();
				}
				String subOrder = "Pizza- "+pizza.getSize()+" "+pizza.getCrust()+" "+tops+" Qty:"+pizza.getQuantity();
				JLabel item = new JLabel(subOrder);
				item.setFont(newFFont);
				item.setBounds(200, yPosition, 350, 35);
				yPosition = yPosition+30;
				panel.add(item);

			}
			for(Sides bs : searchOrder.getSideList()){
				String subOrder = "Side- "+bs.getSize()+" "+bs.getType()+" Qty:"+bs.getQuantity();
				JLabel item = new JLabel(subOrder);
				item.setFont(newFFont);
				item.setBounds(200, yPosition, 350, 35);
				yPosition = yPosition+30;
				panel.add(item);
			}
			for(DrinksModel drinks : searchOrder.getDrinksList()){
				String subOrder = "Drinks- "+drinks.getSize()+" "+drinks.getType()+" Qty:"+drinks.getQuantity();
				JLabel item = new JLabel(subOrder);
				item.setFont(newFFont);
				item.setBounds(200, yPosition, 350, 35);
				yPosition = yPosition+30;
				panel.add(item);
			}
		}
		else{
			JLabel item = new JLabel("Special Not Set");
			item.setFont(newFFont);
			item.setBounds(200, 350, 350, 35);
			item.setVisible(true);
			panel.add(item);
		}
		panel.revalidate();
		panel.repaint();
	}

}
