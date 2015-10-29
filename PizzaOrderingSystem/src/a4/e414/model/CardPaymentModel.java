package a4.e414.model;

public class CardPaymentModel {

	private String name;
	private String cardNumber;
	private String expiryDate;
	private String ccnumber;
	
	public CardPaymentModel(String name, String cardNum, String expiry,String ccNum) {
		this.name = name;
		this.cardNumber = cardNum;
		this.expiryDate = expiry;
		this.ccnumber = ccNum;
	
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	public void setCcnumber(String ccnumber) {
		this.ccnumber = ccnumber;
	}
	public boolean authorize() {
		//send to authorizing agency here
		return true;
	}
	
}
