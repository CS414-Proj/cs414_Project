package a4Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import a4.e414.model.ItemDetailsModel;
import a4.e414.model.FullMenuModel;

public class TestTheMenu {
	
	private ArrayList<ItemDetailsModel> pizzadetails;
	private ArrayList<ItemDetailsModel> pizzaTypeNameAndPrice;
	private ArrayList<ItemDetailsModel> pizzaToppingNameAndPrice;
	private ArrayList<ItemDetailsModel> sideSizeNameAndPrice;
	private ArrayList<ItemDetailsModel> sideTypeNameAndPrice;
	private ArrayList<ItemDetailsModel> drinkSizeNameAndPrice;
	private ArrayList<ItemDetailsModel> drinkTypeNameAndPrice;
	ItemDetailsModel MI1;
	ItemDetailsModel MI2;
	ItemDetailsModel MI3;
	ItemDetailsModel MI4;
	

	@Before
	public void setUp(){
		pizzadetails = new ArrayList<ItemDetailsModel>();
		pizzaTypeNameAndPrice = new ArrayList<ItemDetailsModel>();
		pizzaToppingNameAndPrice = new ArrayList<ItemDetailsModel>();
		sideSizeNameAndPrice = new ArrayList<ItemDetailsModel>();
		sideTypeNameAndPrice = new ArrayList<ItemDetailsModel>();
		drinkSizeNameAndPrice = new ArrayList<ItemDetailsModel>();
		drinkTypeNameAndPrice = new ArrayList<ItemDetailsModel>();
		
		MI1 = new ItemDetailsModel();
		MI1.setName("small");
		MI1.setPrice(5);
		pizzadetails.add(MI1);
		
		MI2 = new ItemDetailsModel();
		MI2.setName("s");
		MI2.setPrice(5);
		pizzaTypeNameAndPrice.add(MI2);
		
		MI3 = new ItemDetailsModel();
		MI3.setName("m");
		MI3.setPrice(5);
		pizzaToppingNameAndPrice.add(MI3);
		
		MI4 = new ItemDetailsModel();
		MI4.setName("l");
		MI4.setPrice(5);
		
		sideSizeNameAndPrice.add(MI4);
		sideTypeNameAndPrice.add(MI1);
		drinkSizeNameAndPrice.add(MI2);
		drinkTypeNameAndPrice.add(MI3);
	}
	
	
	@Test
	public void testAddElementtoMenu() {
		FullMenuModel menu = FullMenuModel.getInstance();
		menu.addElement(MI1, "Pizza Size");
		assertEquals(pizzadetails, menu.getPizzaSizeNameAndPrice());
		menu.addElement(MI2, "Pizza Crust");
		assertEquals(pizzaTypeNameAndPrice, menu.getPizzaTypeNameAndPrice());
		menu.addElement(MI3, "Pizza Topping");
		assertEquals(pizzaToppingNameAndPrice,menu.getPizzaToppingNameAndPrice());
		menu.addElement(MI4, "Side Size");
		assertEquals(sideSizeNameAndPrice,menu.getSideSizeNameAndPrice());
		menu.addElement(MI1, "Side Type");
		assertEquals(sideTypeNameAndPrice,menu.getSideTypeNameAndPrice());
		menu.addElement(MI2, "Drink Size");
		assertEquals(drinkSizeNameAndPrice,menu.getDrinkSizeNameAndPrice());
		menu.addElement(MI3, "Drink Type");
		assertEquals(drinkTypeNameAndPrice,menu.getDrinkTypeNameAndPrice());
	}
	
	@Test
	public void testRemoveElementFromMenu() {
		// Remove
		FullMenuModel menu = FullMenuModel.getInstance();
		pizzadetails.remove(MI1);
		pizzaTypeNameAndPrice.remove(MI2);
		pizzaToppingNameAndPrice.remove(MI3);
		sideSizeNameAndPrice.remove(MI4);
		sideTypeNameAndPrice.remove(MI1);
		drinkSizeNameAndPrice.remove(MI2);
		drinkTypeNameAndPrice.remove(MI3);
		//
		menu.removeElement(MI1, "Pizza Size");
		assertEquals(pizzadetails, menu.getPizzaSizeNameAndPrice());
		menu.removeElement(MI2, "Pizza Crust");
		assertEquals(pizzaTypeNameAndPrice, menu.getPizzaTypeNameAndPrice());
		menu.removeElement(MI3, "Pizza Topping");
		assertEquals(pizzaToppingNameAndPrice,menu.getPizzaToppingNameAndPrice());
		menu.removeElement(MI4, "Side Size");
		assertEquals(sideSizeNameAndPrice,menu.getSideSizeNameAndPrice());
		menu.removeElement(MI1, "Side Type");
		assertEquals(sideTypeNameAndPrice,menu.getSideTypeNameAndPrice());
		menu.removeElement(MI2, "Drink Size");
		assertEquals(drinkSizeNameAndPrice,menu.getDrinkSizeNameAndPrice());
		menu.removeElement(MI3, "Drink Type");
		assertEquals(drinkTypeNameAndPrice,menu.getDrinkTypeNameAndPrice());
	}

	
	@Test
	public void testGetDrinkTypeArray(){
		
		ItemDetailsModel MI9 = new ItemDetailsModel();
		MI9.setName("small");
		MI9.setPrice(5);
		System.out.println(MI9.getName());
		System.out.println(MI9.getPrice());		
		FullMenuModel menu1 = FullMenuModel.getInstance();
		menu1.addElement(MI9, "Drink Type");
	}
}
		
		
/*		menu.addElement(MI3, "Drink Type");
		menu.addElement(MI4, "Drink Type");
		System.out.println(menu.getDrinksTypeArray()[1]);*/
		
/*		String [] expectedString = {"s","m","l"};
		System.out.println(expectedString[1]);
		assertEquals(expectedString[0], menu.getDrinksTypeArray()[0]);
		assertEquals(expectedString[1], menu.getDrinksTypeArray()[1]);
		assertEquals(expectedString[2], menu.getDrinksTypeArray()[2]);*/
/*		String a = "1";
		String b = "1";
		 assertEquals(a,b);
*/
		
/*//		for (int i = 0; i < 2; i++) {
			String a = expectedString[1];
			 String b = menu.getDrinksTypeArray()[1];
			 assertEquals(a,b);
//		}
*/	
	
/*	@SuppressWarnings("deprecation")
	@Test
	public void testGetDrinksSizeArray(){
		menu.addElement(MI2, "Drink Size");
		menu.addElement(MI3, "Drink Size");
		menu.addElement(MI4, "Drink Size");
		String [] expectedString = {"s","m","l"};
		assertEquals(expectedString, menu.getDrinksSizeArray());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetgetBsSizeArray(){
		menu.addElement(MI2, "Side Size");
		menu.addElement(MI3, "Side Size");
		menu.addElement(MI4, "Side Size");
		String [] expectedString = {"s","m","l"};
		assertEquals(expectedString, menu.getBsSizeArray());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetgetBsTypeArray(){
		menu.addElement(MI2, "Side Type");
		menu.addElement(MI3, "Side Type");
		menu.addElement(MI4, "Side Type");
		String [] expectedString = {"s","m","l"};
		assertEquals(expectedString, menu.getBsTypeArray());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetPizzaSizeArray(){
		menu.addElement(MI2, "Pizza Size");
		menu.addElement(MI3, "Pizza Size");
		menu.addElement(MI4, "Pizza Size");
		String [] expectedString = {"s","m","l"};
		assertEquals(expectedString, menu.getPizzaSizeArray());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetPizzaCrustArray(){
		menu.addElement(MI2, "Pizza Crust");
		menu.addElement(MI3, "Pizza Crust");
		menu.addElement(MI4, "Pizza Crust");
		String [] expectedString = {"s","m","l"};
		assertEquals(expectedString, menu.getPizzaCrustArray());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetToppingsArray(){
		menu.addElement(MI2, "Pizza Topping");
		menu.addElement(MI3, "Pizza Topping");
		menu.addElement(MI4, "Pizza Topping");
		String [] expectedString = {"s","m","l"};
		assertEquals(expectedString, menu.getToppingsArray());
	}
*/

