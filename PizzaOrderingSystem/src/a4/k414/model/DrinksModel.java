package a4.k414.model;


public class DrinksModel {
	private String size;
	private String type;
	private float cost; // For 1 drink
	private int quantity; 
	private String subOrderId;
	
	public void calculatecost() { // calculates cost for 1 drink
		float cost =0;
		for(ItemDetailsModel item : FullMenuModel.getInstance().getDrinkSizeNameAndPrice())
		{
			if(item.getName().equals(this.size))
				cost= cost+item.getPrice();
		}
		for(ItemDetailsModel item : FullMenuModel.getInstance().getDrinkTypeNameAndPrice())
		{
			if(item.getName().equals(this.type))
				cost= cost+item.getPrice();
		}
		this.cost = cost;
		
	}
	
	public String getSubOrderId() {
		return subOrderId;
	}
	public void setSubOrderId(String subOrderId) {
		this.subOrderId = subOrderId;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	
}
