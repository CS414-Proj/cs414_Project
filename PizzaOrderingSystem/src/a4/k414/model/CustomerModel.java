package a4.k414.model;

public class CustomerModel {
	
	private String firstname;
	private String phoneNum;
	private String userId;
	private String password;
	

	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getPhoneNum() {
		return phoneNum;
	}


	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/*public void placeOrder(String user){
		new StoreOrderModel(user,"kiosk");
	}*/
}
