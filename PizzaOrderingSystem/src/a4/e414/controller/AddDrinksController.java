package a4.e414.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import a4.e414.model.FullMenuModel;
import a4.e414.view.AddDrinksScreen;

public class AddDrinksController {

	private AddDrinksScreen orderScreenDrinks;
	private PlaceOrderController takeOrder;
	private CreateSpecialController setSpecial;
	private String user;
	private String action= "none";

	public AddDrinksController(String user, PlaceOrderController takeOrder){
		this.user=user;
		FullMenuModel menu = FullMenuModel.getInstance();
		this.orderScreenDrinks = new AddDrinksScreen(menu.getDrinksSizeArray(),menu.getDrinksTypeArray());
		this.orderScreenDrinks.ButtonListner(new DrinksOrderListner());
		this.takeOrder=takeOrder;
		action="takeOrder";
	}

	public AddDrinksController(String user, CreateSpecialController setSpecial){
		this.user=user;
		FullMenuModel menu = FullMenuModel.getInstance();
		this.orderScreenDrinks = new AddDrinksScreen(menu.getDrinksSizeArray(),menu.getDrinksTypeArray());
		this.orderScreenDrinks.ButtonListner(new DrinksOrderListner());
		this.setSpecial=setSpecial;
		action = "setSpecial";
	}

	class DrinksOrderListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==orderScreenDrinks.getAddButton()){
				String size = orderScreenDrinks.getsizeField();
				String type = orderScreenDrinks.getTypeField();
				String quantity = orderScreenDrinks.getqtyField();
				//My Edit
				if(size == null || type == null || quantity == null){
					JOptionPane.showMessageDialog(null,"Select the drink size, type and quantity \n If menu is not defined see the manager");
				}
				else{
				String subOrder = "Drinks- "+size+" "+type+" Qty:"+quantity;
				if(action.equals("takeOrder")){
					String subOrderId= takeOrder.addSubOrder(subOrder);
					takeOrder.addDrinks(size, type, quantity,subOrderId);
				}
				else if(action.equals("setSpecial")){
					String subOrderId= setSpecial.addSubOrder(subOrder);
					setSpecial.addDrinks(size, type, quantity,subOrderId);
					
				}
				orderScreenDrinks.setVisible(false);
				}
			}
			else if(e.getSource()==orderScreenDrinks.getCancelButton()){
				orderScreenDrinks.setVisible(false);
			}
		}
	}

}
