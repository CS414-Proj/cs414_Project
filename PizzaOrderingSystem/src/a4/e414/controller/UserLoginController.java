package a4.e414.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import a4.e414.model.StoreManagerModel;
import a4.e414.model.CashierModel;
import a4.e414.model.StaffDetails;
import a4.e414.model.UserLoginModel;
import a4.e414.view.UserLoginScreen;

public class UserLoginController {

	private UserLoginModel usrLmodel;
	private UserLoginScreen usrLview;
	
	// When user tries to login, based on employee type show differently screens. 

	class UserLoginListner implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent click) {
			String password = usrLview.getPasswordField();
			String id = usrLview.getIdField();
			StaffDetails staff = usrLmodel.checkCredentials(id, password); // Check
																		// the
																		// credentials
			
			System.out.println(staff.getStaffRole());
			
			if (staff.getStaffRole() == null){
				usrLview.errorMsg();
			}else {
			
			switch (staff.getStaffRole()) {

			case "manager":
				new StoreManagerModel(staff.getStaffName());
				usrLview.setVisible(false);
				break;

			case "cashier":
				new CashierModel(staff.getStaffName());
				usrLview.setVisible(false);
				break;

			case "chef":
				new ChefActionsController(staff.getStaffName());
				usrLview.setVisible(false);
				break;
			
			default:
				usrLview.errorMsg();
				break;

			}
			}

		}
	}

	// Constructor to initialize the user login screens and controls

	public UserLoginController() {
		this.usrLview = new UserLoginScreen();
		this.usrLview.userLoginListner(new UserLoginListner());
		this.usrLmodel = new UserLoginModel();
	}

}
