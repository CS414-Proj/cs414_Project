package a4Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import a4.e414.model.ItemDetailsModel;
import a4.e414.model.FullMenuModel;
import a4.e414.model.DrinksModel;

public class TestDrinks {

	private DrinksModel drink;
	private ItemDetailsModel MI1;
	private ItemDetailsModel MI2;
	private ItemDetailsModel MI3;
	FullMenuModel menu;
	
	@Before
	public void setUp(){
		drink = new DrinksModel();
		drink.setSize("Regular");
		drink.setQuantity(1);
		drink.setType("Coke");
		drink.setSubOrderId("12");
		
		menu = FullMenuModel.getInstance();
		MI1 = new ItemDetailsModel();
		MI1.setName("Large");
		MI1.setPrice(3);
		MI2 = new ItemDetailsModel();
		MI2.setName("Coke");
		MI2.setPrice(4);
		MI3 = new ItemDetailsModel();
		MI3.setName("Diet Coke");
		MI3.setPrice(5);
		menu.addElement(MI1,"Drink Size");
		menu.addElement(MI2,"Drink Type");
		menu.addElement(MI3,"Drink Type");
	}
	
	@Test
	public void test() {
		drink.calculatecost();
		assertEquals(4,drink.getCost(),4);
	}

}
