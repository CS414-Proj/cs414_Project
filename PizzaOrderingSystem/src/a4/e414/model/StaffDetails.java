package a4.e414.model;


public class StaffDetails {

	
	// Role of the staff
	
	private String StaffRole;
	
	public String getStaffRole() {
		return StaffRole;
	}
	public void setStaffRole(String StaffRole) {
		this.StaffRole = StaffRole;
	}
	
	// legal name of the staff
	
	private String staffName;

	
	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	
	// Contact no foir staff
	

	private String staffPhone;

	
	public String getStaffPhone() {
		return staffPhone;
	}

	public void setStaffPhone(String staffPhone) {
		this.staffPhone = staffPhone;
	}
	
	// Unique ID to log in to the app

	
	
	private String StaffId;


	public String getStaffId() {
		return StaffId;
	}

	public void setStaffId(String StaffId) {
		this.StaffId = StaffId;
	}
	
	// password to log in to the app


	private String StaffPassword;

	public String getStaffPassword() {
		return StaffPassword;
	}

	public void setStaffPassword(String StaffPassword) {
		this.StaffPassword = StaffPassword;
	}
		
	// DOB info

	
	private String StaffDOB;

	public String getStaffDOB() {
		return StaffDOB;
	}

	public void setStaffDOB(String StaffDOB) {
		this.StaffDOB = StaffDOB;
	}
	
	// Salary info
	
	private int staffSalary;


	public int getStaffSalary() {
		return staffSalary;
	}

	public void setStaffSalary(int salary) {
		this.staffSalary = staffSalary;
	}
	
	// Empty constructor 
	
	public StaffDetails(){
	}


}
