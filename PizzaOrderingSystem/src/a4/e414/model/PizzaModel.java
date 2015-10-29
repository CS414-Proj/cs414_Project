package a4.e414.model;

import java.util.ArrayList;


public class PizzaModel {
	private String size;
	private String crust;
	private float cost; // For 1 pizza
	private int quantity; 
	private ArrayList<PizzaToppings> toppingList = new ArrayList<PizzaToppings>();
	private String subOrderId;


	public String getSubOrderId() {
		return subOrderId;
	}

	public void setSubOrderId(String subOrderId) {
		this.subOrderId = subOrderId;
	}

	public void calculatecost(){
		float cost =0;
		for(ItemDetailsModel item : FullMenuModel.getInstance().getPizzaSizeNameAndPrice())
		{
			if(item.getName().equals(this.size))
				cost= cost+item.getPrice();
		}
		for(ItemDetailsModel item : FullMenuModel.getInstance().getPizzaTypeNameAndPrice())
		{
			if(item.getName().equals(this.crust))
				cost= cost+item.getPrice();
		}
		for(PizzaToppings top : this.toppingList){
			for(ItemDetailsModel item : FullMenuModel.getInstance().getPizzaToppingNameAndPrice())
			{
				if(item.getName().equals(top.getName()))
					cost= cost+item.getPrice();
			}
		}
		this.cost = cost;
	}

	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getCrust() {
		return crust;
	}
	public void setCrust(String crust) {
		this.crust = crust;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public ArrayList<PizzaToppings> getToppingList() {
		return toppingList;
	}
	public void addToppings(PizzaToppings topping) {
		toppingList.add(topping);
	}




}
