package a4Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import a4.e414.model.PizzaModel;
import a4.e414.model.DrinksModel;
import a4.e414.model.Sides;
import a4.e414.model.StoreOrderModel;
import a4.e414.model.PizzaToppings;

public class TestNewOrder {

	private ArrayList<PizzaModel> pl;
	private ArrayList<Sides> sl;
	private ArrayList<DrinksModel> dl;
	
	
	private PizzaModel pizza;
	private DrinksModel drink;
	private Sides side;
	
	StoreOrderModel order;

	@Before
	public void setUp() {
		order = new StoreOrderModel();

		pl = new ArrayList<PizzaModel>();
		sl = new ArrayList<Sides>();
		dl = new ArrayList<DrinksModel>();

		pizza = new PizzaModel();
		pizza.setCost(10);
		pizza.setCrust("CheeseBurst Crust");
		pizza.setQuantity(2);
		pizza.setSize("Large");
		pizza.setSubOrderId("o1");
		PizzaToppings top1 = new PizzaToppings();
		top1.setName("top1");
		pizza.addToppings(top1);

		drink = new DrinksModel();
		drink.setSize("Large");
		drink.setCost(4);
		drink.setQuantity(4);
		drink.setType("Coke");
		drink.setSubOrderId("12");

		side = new Sides();
		side.setSize("Regular");
		side.setCost(4);
		side.setQuantity(2);
		side.setType("Potato Wedges");
		side.setSubOrderId("13");

		order.addPizza(pizza);
		pl.add(pizza);
		order.addDrinks(drink);
		dl.add(drink);
		order.addSide(side);
		sl.add(side);
	}

	@Test
	public void testDelete() {
		order.deletePizza("o1");
		order.deleteSide("13");
		order.deleteDrink("12");
		pl.remove(pizza);
		sl.remove(side);
		dl.remove(drink);
		assertEquals(pl, order.getPizzaList());
		assertEquals(sl, order.getSideList());
		assertEquals(dl, order.getDrinksList());
	}

	@Test
	public void testAdd() {
		assertEquals(pl, order.getPizzaList());
		assertEquals(sl, order.getSideList());
		assertEquals(dl, order.getDrinksList());
	}

}
