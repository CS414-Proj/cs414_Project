package a4Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import a4.k414.model.FullMenuModel;
import a4.k414.model.ItemDetailsModel;
import a4.k414.model.PizzaModel;
import a4.k414.model.PizzaToppings;

public class TestOrderPizza {

	private PizzaModel pizza;
	private ItemDetailsModel MI1;
	private ItemDetailsModel MI2;
	private ItemDetailsModel MI3;
	FullMenuModel menu;
	
	@Before
	public void setUp(){
		pizza = new PizzaModel();
		pizza.setCrust("slice");
		pizza.setQuantity(3);
		pizza.setSize("mid");
		pizza.setSubOrderId("1");
		PizzaToppings t1 = new PizzaToppings();
		t1.setName("olives");
		pizza.addToppings(t1);
		
		menu = FullMenuModel.getInstance();
		MI1 = new ItemDetailsModel();
		MI1.setName("slice");
		MI1.setPrice(5);
		MI2 = new ItemDetailsModel();
		MI2.setName("mid");
		MI2.setPrice(8);
		MI3 = new ItemDetailsModel();
		MI3.setName("peppers");
		MI3.setPrice(2);
		
		
		menu.addElement(MI1,"Pizza Crust");
		menu.addElement(MI2,"Pizza Size");
		menu.addElement(MI3,"Pizza Topping");
	}
	
	@Test
	public void testOrderPizza() {
		pizza.calculatecost();
		assertEquals(13,pizza.getCost(),4);
	}

}
