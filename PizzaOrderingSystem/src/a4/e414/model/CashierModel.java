package a4.e414.model;

import a4.e414.controller.CashierActionsController;



public class CashierModel {

	public CashierModel(String user){
		new CashierActionsController(user);
	}

}
