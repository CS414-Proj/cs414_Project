package a4.k414.model;

import java.util.ArrayList;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import a4.k414.controller.AutomatedKioskController;
import a4.k414.controller.UserLoginController;


public class CSUPizzaStore {
	
	private static CSUPizzaStore csuPizzaBranch = new CSUPizzaStore();
	
	public void startPos(){
		createInitialMenu();
		addCustomer();
		
		new UserLoginController(); // Add login controllers
		new AutomatedKioskController();
		CSUPizzaStore.getBranchInstance().addStaffToDirectory();
	}
	
	
	public static void main(String args[]){
		
		//Set the default look and feel of the app
		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, fall back to cross-platform
		    try {
		        UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		    } catch (Exception ex) {
		        
		    }}
		
		
		
		new UserLoginController();
		new UserLoginController();
		new UserLoginController();
		new AutomatedKioskController();
		CSUPizzaStore.getBranchInstance().addStaffToDirectory();
	
	}
	
	
	private ArrayList<StaffDetails> staffDirectory = new ArrayList<StaffDetails>();
	private ArrayList<CustomerModel> usersList = new ArrayList<CustomerModel>();
	
	public ArrayList<StaffDetails> getStaffDirectory() {
		return staffDirectory;
	}

	public void addToStaffDirectory(StaffDetails employeeDetails) {
		staffDirectory.add(employeeDetails);
	}
	

	
	public void addStaffToDirectory(){
		
		addManager();
		addCashier();
		addChef();
	}
	
	public void addManager(){
		
		StaffDetails manager = new StaffDetails();
		
		manager.setStaffRole("manager");
		manager.setStaffName("Arora");
		manager.setStaffId("manager");
		manager.setStaffPassword("manager");
		manager.setStaffDOB("05/09/1989");
		manager.setStaffSalary(25000);
		manager.setStaffPhone("9708895368");
		
		getBranchInstance().staffDirectory.add(manager);
				
	}
	
	
	public void addCashier(){
		
		StaffDetails cashier = new StaffDetails();
		
		cashier.setStaffRole("cashier");
		cashier.setStaffName("Katamreddy");
		cashier.setStaffPhone("9708895369");
		cashier.setStaffId("cashier");
		cashier.setStaffPassword("cashier");
		cashier.setStaffSalary(20000);
		cashier.setStaffDOB("05/07/1989");
		
		getBranchInstance().staffDirectory.add(cashier);		
		
	}
	
	public void addChef(){
		

		StaffDetails chef = new StaffDetails();
		
		chef.setStaffRole("chef");
		chef.setStaffName("Bijjam");
		chef.setStaffPhone("9708895370");
		chef.setStaffSalary(15000);
		chef.setStaffId("chef");
		chef.setStaffPassword("chef");
		chef.setStaffDOB("05/05/1989");
		
		getBranchInstance().staffDirectory.add(chef);		
		
	}
	
	private void addCustomer(){ //Remove
		CustomerModel c = new CustomerModel();
		c.setFirstname("sagar");
		c.setPhoneNum("4044887710");
		c.setUserId("user");
		c.setPassword("user");
		CSUPizzaStore ps = CSUPizzaStore.getBranchInstance();
		ps.addCustomertoList(c);
	}
	
	 private void createInitialMenu(){
         FullMenuModel menu = FullMenuModel.getInstance();

         //Create some sizes to start with
         ItemDetailsModel Size1 = new ItemDetailsModel();
         ItemDetailsModel Size2 = new ItemDetailsModel();
         ItemDetailsModel Size3 = new ItemDetailsModel();
         Size1.setName("Small");
         Size1.setPrice(1);
         Size2.setName("Medium");
         Size2.setPrice(2);
         Size3.setName("Large");
         Size3.setPrice(3);
         menu.addElement(Size1,"Pizza Size");
         menu.addElement(Size2,"Pizza Size");
         menu.addElement(Size3,"Pizza Size");


         //Define initial crusts
         ItemDetailsModel crust1 = new ItemDetailsModel();
         ItemDetailsModel crust2 = new ItemDetailsModel();
         ItemDetailsModel crust3 = new ItemDetailsModel();
         crust1.setName("Thin");
         crust1.setPrice(2);
         crust2.setName("Thick");
         crust2.setPrice(4);
         crust3.setName("Cheesy");
         crust3.setPrice(6);
         menu.addElement(crust1,"Pizza Crust");
         menu.addElement(crust2,"Pizza Crust");
         menu.addElement(crust3,"Pizza Crust");


         //Topping
         ItemDetailsModel top1 = new ItemDetailsModel();
         ItemDetailsModel top2 = new ItemDetailsModel();
         ItemDetailsModel top3 = new ItemDetailsModel();
         ItemDetailsModel top4 = new ItemDetailsModel();
         top1.setName("Mushroom");
         top1.setPrice(1);
         top2.setName("Chicken");
         top2.setPrice(1);
         top3.setName("Peppers");
         top3.setPrice(1);
         top4.setName("onion");
         top4.setPrice(1);
         menu.addElement(top1,"Pizza Topping");
         menu.addElement(top2,"Pizza Topping");
         menu.addElement(top3,"Pizza Topping");
         menu.addElement(top4,"Pizza Topping");

         //size
         ItemDetailsModel sideSize1 = new ItemDetailsModel();
         ItemDetailsModel sideSize2 = new ItemDetailsModel();
         sideSize1.setName("Small");
         sideSize1.setPrice(1);
         sideSize2.setName("Large");
         sideSize2.setPrice(2);
         menu.addElement(sideSize1,"Side Size");
         menu.addElement(sideSize2,"Side Size");

         //type
         ItemDetailsModel sideType1 = new ItemDetailsModel();
         ItemDetailsModel sideType2 = new ItemDetailsModel();
         ItemDetailsModel sideType3 = new ItemDetailsModel();
         ItemDetailsModel sideType4 = new ItemDetailsModel();
         sideType1.setName("Fries");
         sideType1.setPrice(2);
         sideType2.setName("Cake");
         sideType2.setPrice(2);
         sideType3.setName("Pasta");
         sideType3.setPrice(2);
         sideType4.setName("Biscut");
         sideType4.setPrice(2);
         menu.addElement(sideType1,"Side Type");
         menu.addElement(sideType2,"Side Type");
         menu.addElement(sideType3,"Side Type");
         menu.addElement(sideType4,"Side Type");


         //Drink Type
         ItemDetailsModel Drink1 = new ItemDetailsModel();
         ItemDetailsModel Drink2 = new ItemDetailsModel();
         ItemDetailsModel Drink3 = new ItemDetailsModel();
         ItemDetailsModel Drink4 = new ItemDetailsModel();
         Drink1.setName("Soft Drink");
         Drink1.setPrice(2);
         Drink2.setName("Coffee");
         Drink2.setPrice(2);
         Drink3.setName("Cold Coffee");
         Drink3.setPrice(2);
         Drink4.setName("Tea");
         Drink4.setPrice(2);
         menu.addElement(Drink1,"Drink Type");
         menu.addElement(Drink2,"Drink Type");
         menu.addElement(Drink3,"Drink Type");
         menu.addElement(Drink4,"Drink Type");


         //Drink Size
         ItemDetailsModel DrinkSize1 = new ItemDetailsModel();
         ItemDetailsModel DrinkSize2 = new ItemDetailsModel();
         ItemDetailsModel DrinkSize3 = new ItemDetailsModel();
         DrinkSize1.setName("Small");
         DrinkSize1.setPrice(1);
         DrinkSize2.setName("Medium");
         DrinkSize2.setPrice(2);
         DrinkSize3.setName("Large");
         DrinkSize3.setPrice(3);
         menu.addElement(DrinkSize1,"Drink Size");
         menu.addElement(DrinkSize2,"Drink Size");
         menu.addElement(DrinkSize3,"Drink Size");


         //Create special
         menu.setSpecialName("Chicken Combo");
         menu.setSpecialCost(12);
         StoreOrderModel spl = new StoreOrderModel();
         PizzaModel specialPizza = new PizzaModel();
         specialPizza.setCrust("Cheesy");
         specialPizza.setQuantity(1);
         specialPizza.setSize("Medium");
         PizzaToppings topping = new PizzaToppings();
         topping.setName("Chicken");
         specialPizza.addToppings(topping);
         spl.addPizza(specialPizza);
         DrinksModel drink = new DrinksModel();
         drink.setQuantity(1);
         drink.setSize("Small");
         drink.setType("Coffee");
         spl.addDrinks(drink);
         Sides side = new Sides();
         side.setQuantity(1);
         side.setSize("Large");
         side.setType("Cake");
         spl.addSide(side);
         menu.setSpecialOrder(spl);
        
        
}
	
	public static CSUPizzaStore getBranchInstance(){
		
		return csuPizzaBranch;
		
	}
	
	public void addCustomertoList(CustomerModel user) {
		usersList.add(user);
	}
	
	public CustomerModel getCustomerfromList(String userid) {
		for(CustomerModel customer : usersList){
			if(customer.getUserId().equals(userid))
				return customer;
		}
		return null;
	}
	
	
	//Find ot the role of the current user
	
	
	public String identifyStaffRole(String staff){
		for (StaffDetails staffList : staffDirectory){
			if(staffList.getStaffName().equals(staff)){
				return staffList.getStaffRole();
			}
		}
		return "none";
	}


	
	// For later use if/when there are other branches
	
	private String storeName;
	private String storeAddress;
	private String storePhone;
	

	public String getStoreName() {
		return this.storeName;
	}
	

	public String getStorePhone() {
		return this.storePhone;
	}

	public String getStoreAddress() {
		return this.storeAddress;
	}
	
	public void  setStoreName(String storeName) {
		this.storeName = storeName;
	}
	

	public void  setStorePhone(String storePhone) {
		this.storePhone = storePhone;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}	
	
	public ArrayList<CustomerModel> getCustomerList() {
		return usersList;
	}
	// Constructor
	
	public CSUPizzaStore(){
		
		this.storeName = "CSU Pizza Hut";
		this.storeAddress = "1508, W Oak street, Fort Collins";
		this.storePhone = "9708895368";
		
	}
	
}
