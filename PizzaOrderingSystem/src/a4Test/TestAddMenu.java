package a4Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import a4.e414.model.ItemDetailsModel;
import a4.e414.model.FullMenuModel;

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
