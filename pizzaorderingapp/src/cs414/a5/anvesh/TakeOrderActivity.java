package cs414.a5.anvesh;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutionException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import edu.colostate.cs414k.R;

public class TakeOrderActivity extends Activity {
	
	public static final String ORDER_DETAILS = "order-details";
	public static final String CLOSE_ACTIVITY = "close-activity";
	
	//private ArrayList<String> orderDetails = new ArrayList<String>();
/*	private static TakeOrderActivity takeOrderActivity = new TakeOrderActivity();
	
	public static TakeOrderActivity getInstance()
	{
		return takeOrderActivity;
	}
*/
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_take_order);
	}
	
	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		setIntent(intent);
	}
	
	private void refreshList(){
		ArrayList<String> orderDetails = getIntent().getStringArrayListExtra(ORDER_DETAILS);
		//if(!TakeOrderActivity.getInstance().getOrderDetails().isEmpty())
		if(null != orderDetails && orderDetails.size() > 0)
		{
			LinearLayout ll = (LinearLayout)findViewById(R.id.linearScrollLayout);
		    int i = 0;
		    ll.removeAllViews();
		    //for(String s : TakeOrderActivity.getInstance().getOrderDetails())
		    for(String s : orderDetails)
		    {
		    	CheckBox cb = new CheckBox(this);
		        cb.setText(s);
		        cb.setId(i);
		        ll.addView(cb);
		        i++;
		    }
		}
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		refreshList();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onPizzaClickMethod(View view) throws ParserConfigurationException, SAXException, IOException
	{
		Document doc = getDoc();
		NodeList pizza = doc.getElementsByTagName("pizza");
		Element pizzaElement = (Element) pizza.item(0);

		NodeList pizzaSizeList = pizzaElement.getElementsByTagName("size");
		String[] pizzaSizeItems = new String[pizzaSizeList.getLength()];
		for(int i=0; i<pizzaSizeList.getLength() ; i++){
			pizzaSizeItems[i]=pizzaSizeList.item(i).getTextContent();
		}
		
		NodeList pizzaCrustList = pizzaElement.getElementsByTagName("crust");
		String[] pizzaCrustItems = new String[pizzaCrustList.getLength()];
		for(int i=0; i<pizzaCrustList.getLength() ; i++){
			pizzaCrustItems[i]=pizzaCrustList.item(i).getTextContent();
		}
		
		NodeList pizzaToppingList = pizzaElement.getElementsByTagName("topping");
		String[] pizzaToppingItems = new String[pizzaToppingList.getLength()];
		for(int i=0; i<pizzaToppingList.getLength() ; i++){
			pizzaToppingItems[i]=pizzaToppingList.item(i).getTextContent();
		}
		
		Intent intent = new Intent(this, PizzaActivity.class);
		
		intent.putExtra("pizzaSize", pizzaSizeItems);
		intent.putExtra("pizzaCrust", pizzaCrustItems);
		intent.putExtra("pizzaTopping", pizzaToppingItems);
		intent.putStringArrayListExtra(ORDER_DETAILS, getIntent().getStringArrayListExtra(ORDER_DETAILS));
		startActivity(intent);
	}

	public void onSidesClickMethod(View view) throws ParserConfigurationException, SAXException, IOException
	{
		Document doc = getDoc();
		NodeList sideS = doc.getElementsByTagName("sideS");
		Element sideSElement = (Element) sideS.item(0);

		NodeList sideSSizeList = sideSElement.getElementsByTagName("size");
		String[] sideSSizeItems = new String[sideSSizeList.getLength()];
		for(int i=0; i<sideSSizeList.getLength() ; i++){
			sideSSizeItems[i]=sideSSizeList.item(i).getTextContent();
		}
		
		NodeList sideSTypeList = sideSElement.getElementsByTagName("type");
		String[] sideSTypeItems = new String[sideSTypeList.getLength()];
		for(int i=0; i<sideSTypeList.getLength() ; i++){
			sideSTypeItems[i]=sideSTypeList.item(i).getTextContent();
		}
		
		Intent intent = new Intent(this, SidesActivity.class);
		
		intent.putExtra("sidesSize", sideSSizeItems);
		intent.putExtra("sidesType", sideSTypeItems);
		intent.putStringArrayListExtra(ORDER_DETAILS, getIntent().getStringArrayListExtra(ORDER_DETAILS));
		startActivity(intent);
	}
	
	public void onDrinkClickMethod(View view) throws ParserConfigurationException, SAXException, IOException
	{
		Document doc = getDoc();
		NodeList drinks = doc.getElementsByTagName("drinks");
		Element drinksElement = (Element) drinks.item(0);

		NodeList drinksSizeList = drinksElement.getElementsByTagName("size");
		String[] drinksSizeItems = new String[drinksSizeList.getLength()];
		for(int i=0; i<drinksSizeList.getLength() ; i++){
			drinksSizeItems[i]=drinksSizeList.item(i).getTextContent();
		}
		
		NodeList drinksTypeList = drinksElement.getElementsByTagName("type");
		String[] drinksTypeItems = new String[drinksTypeList.getLength()];
		for(int i=0; i<drinksTypeList.getLength() ; i++){
			drinksTypeItems[i]=drinksTypeList.item(i).getTextContent();
		}

		Intent intent = new Intent(this, DrinkActivity.class);
		intent.putExtra("drinkSize", drinksSizeItems);
		intent.putExtra("drinkType", drinksTypeItems);
		intent.putStringArrayListExtra(ORDER_DETAILS, getIntent().getStringArrayListExtra(ORDER_DETAILS));
		startActivity(intent);
	}
	
	public void onDaySpecialClickMethod(View view)
	{
		String order = "Special";
		
		//TakeOrderActivity.getInstance().getOrderDetails().add(order);
		ArrayList<String> orderDetails = getIntent().getStringArrayListExtra(ORDER_DETAILS);
		if(orderDetails == null)
			orderDetails = new ArrayList<String>();
		/*Intent intent = new Intent(this, TakeOrderActivity.class);
		startActivity(intent);*/
		orderDetails.add(order);
		getIntent().putStringArrayListExtra(ORDER_DETAILS, orderDetails);
		refreshList();
	}
	
	public void onDeleteSelectedClickMethod(View view)
	{
		LinearLayout ll = (LinearLayout)findViewById(R.id.linearScrollLayout);
		CheckBox cb = new CheckBox(this);
		ArrayList<String> orderDetails = getIntent().getStringArrayListExtra(ORDER_DETAILS);
		for(int i =0; i<ll.getChildCount(); i++)
		{
			cb =(CheckBox) ll.getChildAt(i);
			if(cb.isChecked())
			{
				String item = cb.getText().toString();
				//TakeOrderActivity.getInstance().getOrderDetails().remove(item);
				if(null != orderDetails)
					orderDetails.remove(item);
			}
		}
		getIntent().putStringArrayListExtra(ORDER_DETAILS, orderDetails);
		refreshList();
		/*Intent intent = new Intent(this, TakeOrderActivity.class);
		startActivity(intent);*/
	}
	
	public void onCancelClickMethod(View view) throws InterruptedException, ExecutionException
	{
		
		finish();
		
		
		/*Intent intent = new Intent(this, WelcomeActivity.class);
		
		String url = "query=Cancel&userid=" + LocalMenu.getInstance().getUid();
		AsyncTask result = new GetPizzas().execute(url);
		
		String response = (String)result.get();
		StringTokenizer st = new StringTokenizer(response, " ");
		
		String uid = "", uname = "", point = "", special = "";
		
		if(st.hasMoreTokens())
			uid = st.nextToken().toString();
		if(st.hasMoreTokens())
			uname = st.nextToken().toString();
		if(st.hasMoreTokens())
			point = st.nextToken().toString(); 
		for(;st.hasMoreTokens();)
		{
			special += st.nextToken().toString() + " ";
		}
	
		intent.putExtra("user", uname);
		//intent.putExtra("point", point);
		intent.putExtra("special", special);
		startActivity(intent);*/
	}
	
	public void onConfirmClickMethod(View view) throws InterruptedException, ExecutionException
	{
		ArrayList<String> orderDetails = getIntent().getStringArrayListExtra(ORDER_DETAILS);
		//if(TakeOrderActivity.getInstance().getOrderDetails().isEmpty())
		if(orderDetails == null || orderDetails.size() == 0)
		{
			Context context = this;
			ErrorHandliing error = new ErrorHandliing();
			error.displayError("Order at least 1 item!!!", context);
		}
		else
		{
			LocalMenu l = LocalMenu.getInstance();
			String uid = l.getUid();
			StringBuffer sb = new StringBuffer();
			sb.append("<order>");
			for(String s : orderDetails)
			{
				StringTokenizer st = new StringTokenizer(s, "::");
				String item = st.nextToken();
				if(item.trim().equalsIgnoreCase("Pizza"))
				{
					sb.append("<pizza>");
					String pizza = parsePizza(st.nextToken(), st.nextToken());
					sb.append(pizza);
					sb.append("</pizza>");
				}
				else if(item.trim().equalsIgnoreCase("Sides"))
				{
					sb.append("<sideS>");
					String bs = parseSides(st.nextToken(), st.nextToken());
					sb.append(bs);
					sb.append("</sideS>");
				}
				else if(item.trim().equalsIgnoreCase("Drink"))
				{
					sb.append("<drinks>");
					String drinks = parseDrink(st.nextToken(), st.nextToken());
					sb.append(drinks);
					sb.append("</drinks>");
				}
				else if(item.trim().equalsIgnoreCase("Special"))
				{
					sb.append("<special>true</special>");
				}
			}
			sb.append("</order>");
			
			String url = "query=NewOrder&xml="+sb.toString()+"&uid="+uid;
			AsyncTask result = new GetPizzas().execute(url);
			
			String response = (String)result.get();
			
			Intent intent = new Intent(this, PaymentActivity.class);
			intent.putExtra("order", response);
			intent.putStringArrayListExtra(ORDER_DETAILS, getIntent().getStringArrayListExtra(ORDER_DETAILS));
			startActivity(intent);
		}
	}
	
	public String parsePizza(String pizza, String qty)
	{
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(pizza, ",");
		int length = st.countTokens();
		sb.append("<size>" + st.nextToken() + "</size>");
		sb.append("<crust>" + st.nextToken() + "</crust>");
		for(int i =0; i < length -3 ; i++)
		{
			sb.append("<topping>" + st.nextToken() + "</topping>");
		}
		sb.append("<qty>" + qty + "</qty>");
		return sb.toString();
	}
	
	public String parseSides( String sides, String qty)
	{
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(sides, ",");
		sb.append("<size>" + st.nextToken() + "</size>");
		sb.append("<type>" + st.nextToken() + "</type>");
		sb.append("<qty>" + qty + "</qty>");
		return sb.toString();
	}
	
	public String parseDrink(String drink, String qty)
	{
		StringBuffer sb = new StringBuffer();
		StringTokenizer st = new StringTokenizer(drink, ",");
		sb.append("<size>" + st.nextToken() + "</size>");
		sb.append("<type>" + st.nextToken() + "</type>");
		sb.append("<qty>" + qty + "</qty>");
		return sb.toString();
	}
	
	/*public ArrayList<String> getOrderDetails() {
		return orderDetails;
	}
	
	public void addInOrder(String item)
	{
		orderDetails.add(item);
	}

	public void setOrderDetails(ArrayList<String> orderDetails) {
		this.orderDetails = orderDetails;
	}*/
	
	private Document getDoc() throws ParserConfigurationException, SAXException, IOException
	{
		LocalMenu l = LocalMenu.getInstance();
		String stringXml = l.getMenuXml();
		InputSource source = new InputSource(new StringReader(stringXml));

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(source);
		return doc;
	}
}