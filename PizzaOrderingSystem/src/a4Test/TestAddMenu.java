package a4Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import a4.k414.model.FullMenuModel;
import a4.k414.model.ItemDetailsModel;

public class TestAddMenu {

	@Test
	public void testGetDrinkTypeArray() {
		FullMenuModel menu = FullMenuModel.getInstance();

		ItemDetailsModel MI9 = new ItemDetailsModel();
		MI9.setName("small");
		MI9.setPrice(5);
		System.out.println(MI9.getName());
		System.out.println(MI9.getPrice());
		menu.addElement(MI9, "Drink Type");
	}

}
