package a4.k414.model;

import java.util.ArrayList;


public class FullMenuModel 
{
	private ArrayList<ItemDetailsModel> pizzaSizeNameAndPrice = new ArrayList<ItemDetailsModel>();
	private ArrayList<ItemDetailsModel> pizzaTypeNameAndPrice = new ArrayList<ItemDetailsModel>();
	private ArrayList<ItemDetailsModel> pizzaToppingNameAndPrice = new ArrayList<ItemDetailsModel>();
	private ArrayList<ItemDetailsModel> sideSizeNameAndPrice = new ArrayList<ItemDetailsModel>();
	private ArrayList<ItemDetailsModel> sideTypeNameAndPrice = new ArrayList<ItemDetailsModel>();
	private ArrayList<ItemDetailsModel> drinkSizeNameAndPrice = new ArrayList<ItemDetailsModel>();
	private ArrayList<ItemDetailsModel> drinkTypeNameAndPrice = new ArrayList<ItemDetailsModel>();
	private String specialName = "None";
	private float specialCost = 0;
	private StoreOrderModel specialOrder;
	private static FullMenuModel menu = new FullMenuModel();

	public static FullMenuModel getInstance()
	{
		return menu;
	}


	public void addElement(ItemDetailsModel d, String action)
	{
		if(action.equals("Pizza Size"))
		{
			this.pizzaSizeNameAndPrice.add(d);
		}
		else if(action.equals("Pizza Crust"))
		{
			this.pizzaTypeNameAndPrice.add(d);
		}
		else if(action.equals("Pizza Topping"))
		{
			this.pizzaToppingNameAndPrice.add(d);
		}
		if(action.equals("Side Size"))
		{
			this.sideSizeNameAndPrice.add(d);
		}
		else if(action.equals("Side Type"))
		{
			this.sideTypeNameAndPrice.add(d);
		}
		if(action.equals("Drink Size"))
		{
			this.drinkSizeNameAndPrice.add(d);
		}
		else if(action.equals("Drink Type"))
		{
			this.drinkTypeNameAndPrice.add(d);
		}
	}
	
	public void removeElement(ItemDetailsModel d, String action)
	{
		ItemDetailsModel delItem=d;
		if(action.equals("Pizza Size"))
		{
			for(ItemDetailsModel menuItemInfo: this.getPizzaSizeNameAndPrice()){
				if(menuItemInfo.getName().equals(d.getName()))  //My Edit
					delItem	= menuItemInfo;
			}
			this.pizzaSizeNameAndPrice.remove(delItem);
		}
		else if(action.equals("Pizza Crust"))
		{
			for(ItemDetailsModel menuItemInfo: this.getPizzaTypeNameAndPrice()){
				if(menuItemInfo.getName().equals(d.getName()))  //My Edit
					delItem	= menuItemInfo;
			}
			this.pizzaTypeNameAndPrice.remove(delItem);
		}
		else if(action.equals("Pizza Topping"))
		{
			for(ItemDetailsModel menuItemInfo: this.getPizzaToppingNameAndPrice()){
				if(menuItemInfo.getName().equals(d.getName()))  //My Edit
					delItem	= menuItemInfo;
			}
			this.pizzaToppingNameAndPrice.remove(delItem);
		}
		if(action.equals("Side Size"))
		{
			for(ItemDetailsModel menuItemInfo: this.getSideSizeNameAndPrice()){
				if(menuItemInfo.getName().equals(d.getName()))  //My Edit
					delItem	= menuItemInfo;
			}
			this.sideSizeNameAndPrice.remove(delItem);
		}
		else if(action.equals("Side Type"))
		{
			for(ItemDetailsModel menuItemInfo: this.getSideTypeNameAndPrice()){
				if(menuItemInfo.getName().equals(d.getName()))  //My Edit
					delItem	= menuItemInfo;
			}
			this.sideTypeNameAndPrice.remove(delItem);
		}
		if(action.equals("Drink Size"))
		{
			for(ItemDetailsModel menuItemInfo: this.getDrinkSizeNameAndPrice()){
				if(menuItemInfo.getName().equals(d.getName()))  //My Edit
					delItem	= menuItemInfo;
			}
			this.drinkSizeNameAndPrice.remove(delItem);
		}
		else if(action.equals("Drink Type"))
		{
			for(ItemDetailsModel menuItemInfo: this.getDrinkTypeNameAndPrice()){
				if(menuItemInfo.getName().equals(d.getName()))  //My Edit
					delItem	= menuItemInfo;
			}
			this.drinkTypeNameAndPrice.remove(delItem);
		}
	}


	public String[] getBsSizeArray() {
		String[] items = new String[FullMenuModel.getInstance().getSideSizeNameAndPrice().size()];
		int i=0;
		for(ItemDetailsModel itemInfo : FullMenuModel.getInstance().getSideSizeNameAndPrice()){
			items[i]=itemInfo.getName();
			i++;
		}
		return items;
	}


	public String[] getBsTypeArray() {
		String[] items = new String[FullMenuModel.getInstance().getSideTypeNameAndPrice().size()];
		int i=0;
		for(ItemDetailsModel itemInfo : FullMenuModel.getInstance().getSideTypeNameAndPrice()){
			items[i]=itemInfo.getName();
			i++;
		}
		return items;
	}

	public String[] getDrinksSizeArray() {
		String[] items = new String[FullMenuModel.getInstance().getDrinkSizeNameAndPrice().size()];
		int i=0;
		for(ItemDetailsModel itemInfo : FullMenuModel.getInstance().getDrinkSizeNameAndPrice()){
			items[i]=itemInfo.getName();
			i++;
		}
		return items;
	}


	public String[] getDrinksTypeArray() {
		String[] items = new String[FullMenuModel.getInstance().getDrinkTypeNameAndPrice().size()];
		int i=0;
		for(ItemDetailsModel itemInfo : FullMenuModel.getInstance().getDrinkTypeNameAndPrice()){
			items[i]=itemInfo.getName();
			i++;
		}
		return items;
	}

	public String[] getPizzaSizeArray() {
		String[] items = new String[FullMenuModel.getInstance().getPizzaSizeNameAndPrice().size()];
		int i=0;
		for(ItemDetailsModel itemInfo : FullMenuModel.getInstance().getPizzaSizeNameAndPrice()){
			items[i]=itemInfo.getName();
			i++;
		}
		return items;
	}


	public String[] getPizzaCrustArray() {
		String[] items = new String[FullMenuModel.getInstance().getPizzaTypeNameAndPrice().size()];
		int i=0;
		for(ItemDetailsModel itemInfo : FullMenuModel.getInstance().getPizzaTypeNameAndPrice()){
			items[i]=itemInfo.getName();
			i++;
		}
		return items;
	}

	public String[] getToppingsArray() {
		String[] items = new String[FullMenuModel.getInstance().getPizzaToppingNameAndPrice().size()];
		int i=0;
		for(ItemDetailsModel itemInfo : FullMenuModel.getInstance().getPizzaToppingNameAndPrice()){
			items[i]=itemInfo.getName();
			i++;
		}
		return items;
	}
	
	public ArrayList<ItemDetailsModel> getPizzaSizeNameAndPrice() {
		return pizzaSizeNameAndPrice;
	}

	public ArrayList<ItemDetailsModel> getPizzaTypeNameAndPrice() {
		return pizzaTypeNameAndPrice;
	}

	public ArrayList<ItemDetailsModel> getPizzaToppingNameAndPrice() {
		return pizzaToppingNameAndPrice;
	}

	public ArrayList<ItemDetailsModel> getSideSizeNameAndPrice() {
		return sideSizeNameAndPrice;
	}

	public ArrayList<ItemDetailsModel> getSideTypeNameAndPrice() {
		return sideTypeNameAndPrice;
	}

	public ArrayList<ItemDetailsModel> getDrinkSizeNameAndPrice() {
		return drinkSizeNameAndPrice;
	}

	public ArrayList<ItemDetailsModel> getDrinkTypeNameAndPrice() {
		return drinkTypeNameAndPrice;
	}
	
	public String getSpecialName() {
		return specialName;
	}


	public void setSpecialName(String specialName) {
		this.specialName = specialName;
	}


	public float getSpecialCost() {
		return specialCost;
	}


	public void setSpecialCost(float specialCost) {
		this.specialCost = specialCost;
	}


	public StoreOrderModel getSpecialOrder() {
		return specialOrder;
	}


	public void setSpecialOrder(StoreOrderModel specialOrder) {
		this.specialOrder = specialOrder;
	}
} 
