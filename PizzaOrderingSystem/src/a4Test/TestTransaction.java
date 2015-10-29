package a4Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import a4.e414.model.PizzaModel;
import a4.e414.model.DrinksModel;
import a4.e414.model.RegisterModel;
import a4.e414.model.TransactionModel;
import a4.e414.model.Sides;
import a4.e414.model.StoreOrderModel;
import a4.e414.model.PizzaToppings;

public class TestTransaction {

	private PizzaModel pizza;
	private DrinksModel drink;
	private Sides side;
	StoreOrderModel order;
	
	@Before
	public void setUp(){
		order = new StoreOrderModel();
		
		pizza = new PizzaModel();
		pizza.setCost(20);
		pizza.setCrust("thin");
		pizza.setQuantity(3);
		pizza.setSize("medium");
		pizza.setSubOrderId("id1");
		PizzaToppings top1 = new PizzaToppings();
		top1.setName("top1");
		pizza.addToppings(top1);
		
		drink = new DrinksModel();
		drink.setSize("small");
		drink.setCost(14);
		drink.setQuantity(2);
		drink.setType("sprite");
		drink.setSubOrderId("124");
		
		side = new Sides();
		side.setSize("large");
		side.setCost(24);
		side.setQuantity(3);
		side.setType("super");
		side.setSubOrderId("125");
		
		order.addPizza(pizza);
		order.addDrinks(drink);
		order.addSide(side);
	}
	
	@Test
	public void testAddtoRegister() {
		TransactionModel sale = new TransactionModel("cashier",order,"kiosk");
		sale.addtoReg();
		RegisterModel register = RegisterModel.getInstance();
		assertEquals(sale,register.getSaleList().get(0));
		assertEquals(order,register.getOrderList().get(0));
	}

}
