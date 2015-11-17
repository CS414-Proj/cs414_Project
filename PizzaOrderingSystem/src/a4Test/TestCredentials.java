package a4Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import a4.k414.model.CSUPizzaStore;
import a4.k414.model.StaffDetails;
import a4.k414.model.UserLoginModel;

public class TestCredentials {

	@Test
	public void testWrongCredentials() {
		CSUPizzaStore str = new CSUPizzaStore();
		str.addStaffToDirectory();
		UserLoginModel lm = new UserLoginModel();
		StaffDetails sd = lm.checkCredentials("abc", "xyz");
		assertNull(sd);
	}
	
	
	@Test
	public void testCorrectCredentials() {
		CSUPizzaStore str = new CSUPizzaStore();
		str.addStaffToDirectory();
		UserLoginModel lm = new UserLoginModel();
		StaffDetails sd = lm.checkCredentials("cashier", "cashier");
		assertEquals("cashier", sd.getStaffId());
		assertEquals("cashier", sd.getStaffPassword());
		assertEquals("cashier", sd.getStaffRole());
	}


	@Test
	public void testWrongCredentials2() {
		CSUPizzaStore str = new CSUPizzaStore();
		str.addStaffToDirectory();
		UserLoginModel lm = new UserLoginModel();
		StaffDetails sd = lm.checkCredentials(null, null);
		assertNull(sd);
	}
}
