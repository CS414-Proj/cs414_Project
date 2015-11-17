package a4.k414.model;

import java.util.ArrayList;

import a4.k414.controller.PlaceOrderController;

public class StoreOrderModel {
	
	private String orderNumber;
	private String orderType;
	private String customerName;
	private String customerNum;
	private ArrayList<PizzaModel> pizzaList = new ArrayList<PizzaModel>();
	private ArrayList<Sides> sideList = new ArrayList<Sides>();
	private ArrayList<DrinksModel> drinksList = new ArrayList<DrinksModel>();
	private boolean specialOrder = false;
	
	public boolean isSpecialOrder() {
		return specialOrder;
	}

	public void setSpecialOrder(boolean specialOrder) {
		this.specialOrder = specialOrder;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerNum() {
		return customerNum;
	}

	public void setCustomerNum(String customerNum) {
		this.customerNum = customerNum;
	}

	public StoreOrderModel(String user,String action){
		new PlaceOrderController(user,RegisterModel.getInstance().getNextOrderNumber(),this,action);
	}

	public StoreOrderModel(){
		
	}
	
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public ArrayList<PizzaModel> getPizzaList() {
		return pizzaList;
	}
	public void addPizza(PizzaModel pizza) {
		pizzaList.add(pizza);
	}
	public ArrayList<Sides> getSideList() {
		return sideList;
	}
	public void addSide(Sides sides) {
		sideList.add(sides);
	}
	public ArrayList<DrinksModel> getDrinksList() {
		return drinksList;
	}
	public void addDrinks(DrinksModel drinks) {
		drinksList.add(drinks);
	}

	public void deletePizza(String subOrderId) {
		for(PizzaModel pizza : pizzaList){
			if(pizza.getSubOrderId().equals(subOrderId)){
				pizzaList.remove(pizza);
				break;
			}
		}
	}

	public void deleteSide(String subOrderId) {
		for(Sides sides : sideList){
			if(sides.getSubOrderId().equals(subOrderId)){
				sideList.remove(sides);
				break;
			}
		}
	}

	public void deleteDrink(String subOrderId) {
		for(DrinksModel drinks : drinksList){
			if(drinks.getSubOrderId().equals(subOrderId)){
				drinksList.remove(drinks);
				break;
			}
		}
	}
	
}
