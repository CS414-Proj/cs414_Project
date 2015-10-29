package a4.e414.model;


public class Sides {
	
	private String size;
	private String type;
	private float cost; 
	private int quantity;
	private String subOrderId;
	
	public void calculatecost() { 
		float cost =0;
		for(ItemDetailsModel item : FullMenuModel.getInstance().getSideSizeNameAndPrice())
		{
			if(item.getName().equals(this.size))
				cost= cost+item.getPrice();
		}
		for(ItemDetailsModel item : FullMenuModel.getInstance().getSideTypeNameAndPrice())
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
	public void setCost(float cost) {
		this.cost = cost;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
