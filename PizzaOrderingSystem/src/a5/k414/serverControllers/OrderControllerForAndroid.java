package a5.k414.serverControllers;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import a4.k414.model.CSUPizzaStore;
import a4.k414.model.CustomerModel;
import a4.k414.model.DrinksModel;
import a4.k414.model.PaymentModel;
import a4.k414.model.PizzaModel;
import a4.k414.model.PizzaToppings;
import a4.k414.model.RegisterModel;
import a4.k414.model.Sides;
import a4.k414.model.StoreOrderModel;
import a4.k414.model.TransactionModel;



public class OrderControllerForAndroid{

	public String addNewOrder(String userId, String stringXml) throws ParserConfigurationException, SAXException, IOException{
		StoreOrderModel order = placeOrder(stringXml, userId );
		TransactionModel trans = new TransactionModel(userId,order,"App");
		PaymentModel payment = trans.createPayment();
		String paymentDetails =order.getOrderNumber()+" "+payment.getPaymentDetails()+" "+trans.getTransNumber();
		trans.addtoReg(); // Add order to register after payment
		return paymentDetails;
	}
	
	private StoreOrderModel placeOrder(String stringXml, String userId) {
		
		StoreOrderModel neworder = new StoreOrderModel();
		try{
		InputSource source = new InputSource(new StringReader(stringXml));

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(source);

		NodeList userid = doc.getElementsByTagName("userid");
		CustomerModel customer = CSUPizzaStore.getBranchInstance().getCustomerfromList(userId);

		neworder.setOrderNumber(RegisterModel.getInstance().getNextOrderNumber());
		neworder.setOrderType("app");
		neworder.setCustomerName("sagar");
		neworder.setCustomerNum("4044887710");
		addPizza(neworder,doc);
		addDrinks(neworder,doc);
		addSideS(neworder,doc);
		addSpl(neworder,doc);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return neworder;
	}

	private void addSpl(StoreOrderModel neworder, Document doc) {
		NodeList special = doc.getElementsByTagName("special");
		if(special.getLength()>0){
		String setspl = special.item(0).getTextContent();
		if(setspl.equals("true")){
			neworder.setSpecialOrder(true);
		}
		}
	}

	private void addPizza(StoreOrderModel neworder, Document doc){
		NodeList pizzaNode = doc.getElementsByTagName("pizza");

		for(int i=0; i<pizzaNode.getLength() ; i++){
			PizzaModel pizza = new PizzaModel();
			Element pizzaElement = (Element) pizzaNode.item(i);

			NodeList pizzaSize = pizzaElement.getElementsByTagName("size");
			String size=pizzaSize.item(0).getTextContent();
			pizza.setSize(size);

			NodeList pizzaCrust = pizzaElement.getElementsByTagName("crust");
			String crust=pizzaCrust.item(0).getTextContent();
			pizza.setCrust(crust);

			NodeList pizzaToppingList = pizzaElement.getElementsByTagName("topping");
			for(int j=0; j<pizzaToppingList.getLength() ; j++){
				String topping=pizzaToppingList.item(i).getTextContent();
				PizzaToppings top = new PizzaToppings();
				top.setName(topping);
				pizza.addToppings(top);
			}

			NodeList pizzaQty = pizzaElement.getElementsByTagName("qty");
			String qty=pizzaQty.item(0).getTextContent();
			pizza.setQuantity(Integer.parseInt(qty.trim()));
			
			pizza.calculatecost();
			neworder.addPizza(pizza);
		}
	}

	private void addDrinks(StoreOrderModel neworder, Document doc){
		NodeList drinksNode = doc.getElementsByTagName("drinks");

		for(int i=0; i<drinksNode.getLength() ; i++){
			DrinksModel drinks = new DrinksModel();
			Element drinksElement = (Element) drinksNode.item(i);
			NodeList drinksSize = drinksElement.getElementsByTagName("size");
			String size=drinksSize.item(0).getTextContent();
			drinks.setSize(size);

			NodeList drinksType = drinksElement.getElementsByTagName("type");
			String type=drinksType.item(0).getTextContent();
			drinks.setType(type);

			NodeList drinksQty = drinksElement.getElementsByTagName("qty");
			String qty=drinksQty.item(0).getTextContent();
			drinks.setQuantity(Integer.parseInt(qty.trim()));
			drinks.calculatecost();
			neworder.addDrinks(drinks);
		}
	}

	private void addSideS(StoreOrderModel neworder, Document doc){
		NodeList sideSNode = doc.getElementsByTagName("sideS");

		for(int i=0; i<sideSNode.getLength() ; i++){
			Sides sideS = new Sides();
			Element sideSElement = (Element) sideSNode.item(i);
			NodeList sideSSize = sideSElement.getElementsByTagName("size");
			String size=sideSSize.item(0).getTextContent();
			sideS.setSize(size);

			NodeList sideSType = sideSElement.getElementsByTagName("type");
			String type=sideSType.item(0).getTextContent();
			sideS.setType(type);

			NodeList sideSQty = sideSElement.getElementsByTagName("qty");
			String qty=sideSQty.item(0).getTextContent();
			sideS.setQuantity(Integer.parseInt(qty.trim()));
			sideS.calculatecost();
			neworder.addSide(sideS);
		}
		
	}
}
