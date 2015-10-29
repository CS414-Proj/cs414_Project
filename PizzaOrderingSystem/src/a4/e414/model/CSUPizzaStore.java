package a4.e414.model;

import java.util.ArrayList;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import a4.e414.controller.AutomatedKioskController;
import a4.e414.controller.UserLoginController;


public class CSUPizzaStore {
	
	private static CSUPizzaStore csuPizzaBranch = new CSUPizzaStore();
	
	
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
	
	
	public static CSUPizzaStore getBranchInstance(){
		
		return csuPizzaBranch;
		
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
	
	// Constructor
	
	public CSUPizzaStore(){
		
		this.storeName = "CSU Pizza Hut";
		this.storeAddress = "1508, W Oak street, Fort Collins";
		this.storePhone = "9708895368";
		
	}
	
}
