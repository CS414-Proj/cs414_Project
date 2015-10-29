package a4Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import a4.e414.model.ItemDetailsModel;
import a4.e414.model.FullMenuModel;

public class TestTheMenu {
	
	private ArrayList<ItemDetailsModel> pizzaSizeNameAndPrice;
	private ArrayList<ItemDetailsModel> pizzaTypeNameAndPrice;
	private ArrayList<ItemDetailsModel> pizzaToppingNameAndPrice;
	private ArrayList<ItemDetailsModel> sideSizeNameAndPrice;
	private ArrayList<ItemDetailsModel> sideTypeNameAndPrice;
	private ArrayList<ItemDetailsModel> drinkSizeNameAndPrice;
	private ArrayList<ItemDetailsModel> drinkTypeNameAndPrice;
	ItemDetailsModel menuItemInfo1;
	ItemDetailsModel menuItemInfo2;
	ItemDetailsModel menuItemInfo3;
	ItemDetailsModel menuItemInfo4;
	private FullMenuModel menu = FullMenuModel.getInstance();

	@Before
	public void setUp(){
		pizzaSizeNameAndPrice = new ArrayList<ItemDetailsModel>();
		pizzaTypeNameAndPrice = new ArrayList<ItemDetailsModel>();
		pizzaToppingNameAndPrice = new ArrayList<ItemDetailsModel>();
		sideSizeNameAndPrice = new ArrayList<ItemDetailsModel>();
		sideTypeNameAndPrice = new ArrayList<ItemDetailsModel>();
		drinkSizeNameAndPrice = new ArrayList<ItemDetailsModel>();
		drinkTypeNameAndPrice = new ArrayList<ItemDetailsModel>();
		
		menuItemInfo1 = new ItemDetailsModel();
		menuItemInfo1.setName("small");
		menuItemInfo1.setPrice(5);
		pizzaSizeNameAndPrice.add(menuItemInfo1);
		
		menuItemInfo2 = new ItemDetailsModel();
		menuItemInfo2.setName("s");
		menuItemInfo2.setPrice(5);
		pizzaTypeNameAndPrice.add(menuItemInfo2);
		
		menuItemInfo3 = new ItemDetailsModel();
		menuItemInfo3.setName("m");
		menuItemInfo3.setPrice(5);
		pizzaToppingNameAndPrice.add(menuItemInfo3);
		
		menuItemInfo4 = new ItemDetailsModel();
		menuItemInfo4.setName("l");
		menuItemInfo4.setPrice(5);
		
		sideSizeNameAndPrice.add(menuItemInfo4);
		sideTypeNameAndPrice.add(menuItemInfo1);
		drinkSizeNameAndPrice.add(menuItemInfo2);
		drinkTypeNameAndPrice.add(menuItemInfo3);
	}
	
	
	@Test
	public void testAddElementtoMenu() {
		menu.addElement(menuItemInfo1, "Pizza Size");
		assertEquals(pizzaSizeNameAndPrice, menu.getPizzaSizeNameAndPrice());
		menu.addElement(menuItemInfo2, "Pizza Crust");
		assertEquals(pizzaTypeNameAndPrice, menu.getPizzaTypeNameAndPrice());
		menu.addElement(menuItemInfo3, "Pizza Topping");
		assertEquals(pizzaToppingNameAndPrice,menu.getPizzaToppingNameAndPrice());
		menu.addElement(menuItemInfo4, "Side Size");
		assertEquals(sideSizeNameAndPrice,menu.getSideSizeNameAndPrice());
		menu.addElement(menuItemInfo1, "Side Type");
		assertEquals(sideTypeNameAndPrice,menu.getSideTypeNameAndPrice());
		menu.addElement(menuItemInfo2, "Drink Size");
		assertEquals(drinkSizeNameAndPrice,menu.getDrinkSizeNameAndPrice());
		menu.addElement(menuItemInfo3, "Drink Type");
		assertEquals(drinkTypeNameAndPrice,menu.getDrinkTypeNameAndPrice());
	}
	
	@Test
	public void testRemoveElementFromMenu() {
		// Remove
		pizzaSizeNameAndPrice.remove(menuItemInfo1);
		pizzaTypeNameAndPrice.remove(menuItemInfo2);
		pizzaToppingNameAndPrice.remove(menuItemInfo3);
		sideSizeNameAndPrice.remove(menuItemInfo4);
		sideTypeNameAndPrice.remove(menuItemInfo1);
		drinkSizeNameAndPrice.remove(menuItemInfo2);
		drinkTypeNameAndPrice.remove(menuItemInfo3);
		//
		menu.removeElement(menuItemInfo1, "Pizza Size");
		assertEquals(pizzaSizeNameAndPrice, menu.getPizzaSizeNameAndPrice());
		menu.removeElement(menuItemInfo2, "Pizza Crust");
		assertEquals(pizzaTypeNameAndPrice, menu.getPizzaTypeNameAndPrice());
		menu.removeElement(menuItemInfo3, "Pizza Topping");
		assertEquals(pizzaToppingNameAndPrice,menu.getPizzaToppingNameAndPrice());
		menu.removeElement(menuItemInfo4, "Side Size");
		assertEquals(sideSizeNameAndPrice,menu.getSideSizeNameAndPrice());
		menu.removeElement(menuItemInfo1, "Side Type");
		assertEquals(sideTypeNameAndPrice,menu.getSideTypeNameAndPrice());
		menu.removeElement(menuItemInfo2, "Drink Size");
		assertEquals(drinkSizeNameAndPrice,menu.getDrinkSizeNameAndPrice());
		menu.removeElement(menuItemInfo3, "Drink Type");
		assertEquals(drinkTypeNameAndPrice,menu.getDrinkTypeNameAndPrice());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetDrinkTypeArray(){
		menu.addElement(menuItemInfo2, "Drink Type");
		menu.addElement(menuItemInfo3, "Drink Type");
		menu.addElement(menuItemInfo4, "Drink Type");
		String [] expectedString = {"s","m","l"};
		assertEquals(expectedString, menu.getDrinksTypeArray());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetDrinksSizeArray(){
		menu.addElement(menuItemInfo2, "Drink Size");
		menu.addElement(menuItemInfo3, "Drink Size");
		menu.addElement(menuItemInfo4, "Drink Size");
		String [] expectedString = {"s","m","l"};
		assertEquals(expectedString, menu.getDrinksSizeArray());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetgetBsSizeArray(){
		menu.addElement(menuItemInfo2, "Side Size");
		menu.addElement(menuItemInfo3, "Side Size");
		menu.addElement(menuItemInfo4, "Side Size");
		String [] expectedString = {"s","m","l"};
		assertEquals(expectedString, menu.getBsSizeArray());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetgetBsTypeArray(){
		menu.addElement(menuItemInfo2, "Side Type");
		menu.addElement(menuItemInfo3, "Side Type");
		menu.addElement(menuItemInfo4, "Side Type");
		String [] expectedString = {"s","m","l"};
		assertEquals(expectedString, menu.getBsTypeArray());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetPizzaSizeArray(){
		menu.addElement(menuItemInfo2, "Pizza Size");
		menu.addElement(menuItemInfo3, "Pizza Size");
		menu.addElement(menuItemInfo4, "Pizza Size");
		String [] expectedString = {"s","m","l"};
		assertEquals(expectedString, menu.getPizzaSizeArray());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetPizzaCrustArray(){
		menu.addElement(menuItemInfo2, "Pizza Crust");
		menu.addElement(menuItemInfo3, "Pizza Crust");
		menu.addElement(menuItemInfo4, "Pizza Crust");
		String [] expectedString = {"s","m","l"};
		assertEquals(expectedString, menu.getPizzaCrustArray());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetToppingsArray(){
		menu.addElement(menuItemInfo2, "Pizza Topping");
		menu.addElement(menuItemInfo3, "Pizza Topping");
		menu.addElement(menuItemInfo4, "Pizza Topping");
		String [] expectedString = {"s","m","l"};
		assertEquals(expectedString, menu.getToppingsArray());
	}

}
