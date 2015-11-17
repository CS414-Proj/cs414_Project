package a4.k414.model;

import java.util.ArrayList;

public class RegisterModel {

	private ArrayList<TransactionModel> saleList = new ArrayList<TransactionModel>();
	private int currentsaleNumber = 0;	//My Edit	
	private int currentOrderNumber= 0;	//My Edit
	private static RegisterModel register = new RegisterModel();
	private ArrayList<StoreOrderModel> orderList = new ArrayList<StoreOrderModel>();
	private int tax=8;
	
	
	public int getCurrentsaleNumber() {
		return currentsaleNumber;
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

	public String getNextSaleNumber(){
		currentsaleNumber = currentsaleNumber+1;
		return currentsaleNumber+"";
	}

	public ArrayList<TransactionModel> getSaleList() {
		return saleList;
	}

	public void addSale(TransactionModel sale) {

		saleList.add(sale);
	}

}
