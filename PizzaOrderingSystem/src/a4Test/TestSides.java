package a4Test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import a4.e414.model.ItemDetailsModel;
import a4.e414.model.FullMenuModel;
import a4.e414.model.Sides;

public class TestSides {

	private Sides side;
	private ItemDetailsModel menuItemInfo1;
	private ItemDetailsModel menuItemInfo2;
	private ItemDetailsModel menuItemInfo3;
	FullMenuModel menu;
	
	@Before
	public void setUp(){
		side = new Sides();
		side.setSize("large");
		side.setQuantity(3);
		side.setType("super");
		side.setSubOrderId("125");
		
		menu = FullMenuModel.getInstance();
		menuItemInfo1 = new ItemDetailsModel();
		menuItemInfo1.setName("large");
		menuItemInfo1.setPrice(2);
		menuItemInfo2 = new ItemDetailsModel();
		menuItemInfo2.setName("super");
		menuItemInfo2.setPrice(5);
		menuItemInfo3 = new ItemDetailsModel();
		menuItemInfo3.setName("duper");
		menuItemInfo3.setPrice(10);
		menu.addElement(menuItemInfo1,"side Size");
		menu.addElement(menuItemInfo2,"side Type");
		menu.addElement(menuItemInfo3,"side Type");
	}
	
	@Test
	public void test() {
		side.calculatecost();
		assertEquals(7,side.getCost(),4);
	}

}
