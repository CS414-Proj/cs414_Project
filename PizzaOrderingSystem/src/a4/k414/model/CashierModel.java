package a4.k414.model;

import a4.k414.controller.CashierActionsController;



public class CashierModel {

	public CashierModel(String user){
		new CashierActionsController(user);
	}

}
