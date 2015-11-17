package a4Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import a4.k414.model.DrinksModel;
import a4.k414.model.PizzaModel;
import a4.k414.model.PizzaToppings;
import a4.k414.model.Sides;
import a4.k414.model.StoreOrderModel;
import a4.k414.model.TransactionModel;

public class TestCalculation {

	private PizzaModel p1;
	private DrinksModel d1;
	private Sides s;
	StoreOrderModel o1;
	
	
	@Before
	public void setUp(){
		o1 = new StoreOrderModel();
		
		p1 = new PizzaModel();
		p1.setCost(5);
		p1.setCrust("Thin");
		p1.setQuantity(3);
		p1.setSize("Large");
		p1.setSubOrderId("o1");
		PizzaToppings top1 = new PizzaToppings();
		top1.setName("Topping1");
		p1.addToppings(top1);
		
		d1 = new DrinksModel();
		d1.setSize("Regular");
		d1.setCost(4);
		d1.setQuantity(2);
		d1.setType("Coke");
		d1.setSubOrderId("12");
		
		s = new Sides();
		s.setSize("Regular");
		s.setCost(4);
		s.setQuantity(2);
		s.setType("Hash Brown");
		s.setSubOrderId("13");
		
		o1.addPizza(p1);
		o1.addDrinks(d1);
		o1.addSide(s);
	}
	
	
	@Test
	public void testTaxAmount() {
		TransactionModel sale = new TransactionModel("cashier",o1,"kiosk");
		assertEquals(2.48,sale.tax(sale.subtotal()),4);
	}
	
	
	@Test
	public void testtotalamount() {
		TransactionModel sale = new TransactionModel("cashier",o1,"kiosk");
		assertEquals(31,sale.subtotal(),4);
	}

}
