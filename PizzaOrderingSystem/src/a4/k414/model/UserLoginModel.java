package a4.k414.model;


public class UserLoginModel {
	
	public StaffDetails checkCredentials(String id, String password){
		
		// Start with null so that we error when the details are in valid
		
		StaffDetails loggedinStaff =null;
		
		
		// Now let us loop through all the full staff list to check if credentials are valid 
		
		for(StaffDetails currentUser : CSUPizzaStore.getBranchInstance().getStaffDirectory()){
			
			if(currentUser.getStaffId().equals(id) && currentUser.getStaffPassword().equals(password)){
					loggedinStaff = currentUser;
					break;
				}
			}				
		
		
		return loggedinStaff;
	}
	public CustomerModel authenticate(String id, String pwd){
		for(CustomerModel customer : CSUPizzaStore.getBranchInstance().getCustomerList()){
			if(customer.getUserId().equals(id) && customer.getPassword().equals(pwd)){
				return customer;
			}
		}
		return null;
	}
}
