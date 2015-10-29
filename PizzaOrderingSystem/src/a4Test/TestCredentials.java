package a4Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import a4.e414.model.CSUPizzaStore;
import a4.e414.model.StaffDetails;
import a4.e414.model.UserLoginModel;

public class TestCredentials {
	
	@Test
	public void testValidLogin() {
		CSUPizzaStore store = new CSUPizzaStore();
		store.addStaffToDirectory();
		UserLoginModel loginModel = new UserLoginModel();
		StaffDetails employeeDetails=loginModel.checkCredentials("cashier","cash");
		assertEquals("cashier", employeeDetails.getStaffId());
		assertEquals("cash", employeeDetails.getStaffPassword());
		assertEquals("cashier", employeeDetails.getStaffRole());
	}
	
	@Test
	public void testInValidLogin() {
		CSUPizzaStore store = new CSUPizzaStore();
		store.addStaffToDirectory();
		UserLoginModel loginModel = new UserLoginModel();
		StaffDetails employeeDetails=loginModel.checkCredentials("abc","xyz");
		assertNull(employeeDetails);
	}
	
	@Test
	public void testInValidLogin2() {
		CSUPizzaStore store = new CSUPizzaStore();
		store.addStaffToDirectory();
		UserLoginModel loginModel = new UserLoginModel();
		StaffDetails employeeDetails=loginModel.checkCredentials(null,null);
		assertNull(employeeDetails);
	}

}
