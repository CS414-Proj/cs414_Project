package a4.k414.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import a4.k414.model.StoreOrderModel;
import a4.k414.view.CashierActionsScreen;

public class CashierActionsController {

	private CashierActionsScreen cashierScreen;
	private String user;

	public CashierActionsController(String user){
		this.user=user;
		this.cashierScreen = new CashierActionsScreen(user);
		this.cashierScreen.ButtonListner(new CashierHomeListner());
	}

	class CashierHomeListner implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {

			if(e.getSource()==cashierScreen.getTakeOrderButton()){
				new StoreOrderModel(user,"cashier");
				cashierScreen.setVisible(false);
			}
			else if(e.getSource()==cashierScreen.getLogOutButton()){
				new UserLoginController();
				cashierScreen.setVisible(false);
			}
			else if(e.getSource()==cashierScreen.getViewOrderbutton()){
				new DisplayOrderController(user);
				cashierScreen.setVisible(false);
			}
			else if(e.getSource()==cashierScreen.getViewSplButton()){
				new DisplaySpecialController(user);
				cashierScreen.setVisible(false);
			}
		}
	}

}
