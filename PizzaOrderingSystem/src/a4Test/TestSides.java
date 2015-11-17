package a4Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import a4.k414.model.FullMenuModel;
import a4.k414.model.ItemDetailsModel;
import a4.k414.model.Sides;

public class TestSides {

	private Sides side;
	private ItemDetailsModel MI1;
	private ItemDetailsModel MI2;
	private ItemDetailsModel MI3;
	FullMenuModel menu;
	
	@Before
	public void setUp(){
		side = new Sides();
		side.setSize("large");
		side.setQuantity(3);
		side.setType("super");
		side.setSubOrderId("125");
		
		menu = FullMenuModel.getInstance();
		MI1 = new ItemDetailsModel();
		MI1.setName("large");
		MI1.setPrice(2);
		MI2 = new ItemDetailsModel();
		MI2.setName("super");
		MI2.setPrice(5);
		MI3 = new ItemDetailsModel();
		MI3.setName("duper");
		MI3.setPrice(10);
		menu.addElement(MI1,"Side Size");
		menu.addElement(MI2,"Side Type");
		menu.addElement(MI3,"Side Type");
	}
	
	@Test
	public void test() {
		side.calculatecost();
		assertEquals(7,side.getCost(),4);
	}

}
