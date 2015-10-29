package a4.e414.controller;

import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import a4.e414.model.FullMenuModel;
import a4.e414.view.AddPizzaScreen;

public class AddPizzaController {

	private AddPizzaScreen orderScreenPizza;
	private PlaceOrderController takeOrder;
	private CreateSpecialController setSpecial;
	private String user;
	private String action = "none";

	public AddPizzaController(String user, PlaceOrderController takeOrder){
		this.user=user;
		FullMenuModel menu= FullMenuModel.getInstance();
		this.orderScreenPizza = new AddPizzaScreen(menu.getPizzaSizeArray(),menu.getPizzaCrustArray(),menu.getToppingsArray());
		this.orderScreenPizza.ButtonListner(new PizzaOrderListner());
		this.takeOrder=takeOrder;
		this.action="takeOrder";
	}

	public AddPizzaController(String user, CreateSpecialController setSpecial){
		this.user=user;
		FullMenuModel menu= FullMenuModel.getInstance();
		this.orderScreenPizza = new AddPizzaScreen(menu.getPizzaSizeArray(),menu.getPizzaCrustArray(),menu.getToppingsArray());
		this.orderScreenPizza.ButtonListner(new PizzaOrderListner());
		this.setSpecial=setSpecial;
		this.action="setSpecial";
	}

	class PizzaOrderListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==orderScreenPizza.getAddButton()){
				String size = orderScreenPizza.getsizeField();
				String crust = orderScreenPizza.getcrustField();
				String quantity = orderScreenPizza.getqtyField();
				//My Edit
				if(size == null || crust == null || quantity == null){
					JOptionPane.showMessageDialog(null,"Select the pizza size, crust and quantity \n If menu is not defined see the manager");
				} 
				//
				else {
				JPanel panel = orderScreenPizza.getPanel();
				JCheckBox cb;
				ArrayList<String> toppings = new ArrayList<String>();
				for(int i=10 ; i<panel.getComponentCount();i++){
					cb=(JCheckBox) panel.getComponent(i);
					if(cb.isSelected()){
						toppings.add(cb.getText());
					}
				}
				String tops="";
				for(String top: toppings){
					tops = tops+" "+top;
				}
				//
				String subOrder = "Pizza- "+size+" "+crust+" "+tops+" Qty:"+quantity;
				if(action.equals("takeOrder")){
					String subOrderId= takeOrder.addSubOrder(subOrder);
					takeOrder.addPizza(size, crust, quantity, toppings,subOrderId);
				}
				else if(action.equals("setSpecial")){
					String subOrderId= setSpecial.addSubOrder(subOrder);
					setSpecial.addPizza(size, crust, quantity, toppings,subOrderId);
				}
				orderScreenPizza.setVisible(false);
				}
			}
			else if(e.getSource()==orderScreenPizza.getCancelButton()){
				orderScreenPizza.setVisible(false);
			}
		}
	}

}
