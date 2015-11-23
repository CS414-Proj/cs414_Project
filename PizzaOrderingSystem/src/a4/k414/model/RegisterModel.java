package a4.k414.model;

import java.util.ArrayList;

public class RegisterModel {

	private ArrayList<TransactionModel> transactionList = new ArrayList<TransactionModel>();
	private int currenttransNumber = 0;	//My Edit	
	private int currentOrderNumber= 0;	//My Edit
	private static RegisterModel register = new RegisterModel();
	private ArrayList<StoreOrderModel> orderList = new ArrayList<StoreOrderModel>();
	private int tax=8;
	
	
	public int getCurrenttransNumber() {
		return currenttransNumber;
	}

	public int getCurrentOrderNumber() {
		return currentOrderNumber;
	}

	public static RegisterModel getRegister() {
		return register;
	}

	public int getTax() {
		return tax;
	}

	public ArrayList<StoreOrderModel> getOrderList() {
		return orderList;
	}

	public void addOrder(StoreOrderModel order) {
		orderList.add(order);
	}
	
	public void removeOrder(StoreOrderModel order) {
		orderList.remove(order);
	}

	public static RegisterModel getInstance(){
		return register;
	}
	
	public String getNextOrderNumber(){
		currentOrderNumber = currentOrderNumber+1;
		return currentOrderNumber+"";
	}

	public String getNextTransactionNumber(){
		currenttransNumber = currenttransNumber+1;
		return currenttransNumber+"";
	}
	
	public TransactionModel getTrans(String transNumber){
		for(TransactionModel transaction : transactionList){
			if(transaction.getTransNumber().equals(transNumber)){
				return transaction;
			}
		}
		return null;
	}

	public ArrayList<TransactionModel> getTransList() {
		return transactionList;
	}

	public void addTrans(TransactionModel trans) {

		transactionList.add(trans);
	}

}
