package a5.serverControllers;

import a4.k414.model.DrinksModel;
import a4.k414.model.FullMenuModel;
import a4.k414.model.PizzaModel;
import a4.k414.model.PizzaToppings;
import a4.k414.model.Sides;
import a4.k414.model.StoreOrderModel;

public class XmlCreator{

	public String splOrderXml(){
		FullMenuModel menu = FullMenuModel.getInstance();
		StringBuffer buffer = new StringBuffer();
		buffer.append("<SpecialOrder>");

		StoreOrderModel splorder = menu.getSpecialOrder();
		for(PizzaModel p : splorder.getPizzaList()){
			buffer.append("<pizza>");
			buffer.append("<size>" + p.getSize() + "</size>");
			buffer.append("<crust>" + p.getCrust() + "</crust>");
			for (PizzaToppings topping : p.getToppingList())	{
				buffer.append("<topping>" + topping.getName() + "</topping>");
			}
			buffer.append("</pizza>");
		}
		for(DrinksModel d : splorder.getDrinksList()){
			buffer.append("<drinks>");
			buffer.append("<size>" + d.getSize() + "</size>");
			buffer.append("<type>" + d.getType() + "</type>");
			buffer.append("</drinks>");
		}
		for(Sides b: splorder.getSideList()){
			buffer.append("<side>");
			buffer.append("<size>" + b.getSize() + "</size>");
			buffer.append("<type>" + b.getType() + "</type>");
			buffer.append("</side>");
		}
		buffer.append("</SpecialOrder>");
		return buffer.toString();
	}

}

