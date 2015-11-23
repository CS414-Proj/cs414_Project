package cs414.a5.anvesh;

import java.io.IOException;
import java.io.StringReader;
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
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import edu.colostate.cs414k.R;

public class WelcomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		System.out.println("I have an error 1");

		super.onCreate(savedInstanceState);
		System.out.println("I have an error 2");

		setContentView(R.layout.activity_welcome);
		System.out.println("I have an error 3");

		
		Intent intent = getIntent();
		System.out.println("I have an error 4");

		String user = intent.getStringExtra("user");
		System.out.println("I have an error 5");

		//String point = intent.getStringExtra("point");
		System.out.println("I have an error 6");

		String specialXml = intent.getStringExtra("special");
		System.out.println("I have an error 7");


		String special = null;
		try {
			special = parsesplXml(specialXml);
		} catch (Exception e) {
			System.out.println("I have an error 8");
//			e.printStackTrace();
		}
		System.out.println("I have an error 9");

		TextView userName = (TextView) findViewById(R.id.textView5);
		System.out.println("I have an error 10");

		userName.setText("Welcome " + user + ",");
		System.out.println("I have an error 11");


		//TextView points = (TextView) findViewById(R.id.textView4);
		System.out.println("I have an error 12");

		//points.setText(point);
		System.out.println("I have an error 13");


		TextView daySpecial = (TextView) findViewById(R.id.textView2);
		System.out.println("I have an error 14");

		daySpecial.setText(special);
		System.out.println("I have an error 15");

	}


	public String parsesplXml(String stringXml) throws ParserConfigurationException, SAXException, IOException
	{
		System.out.println("I have an error 16");

		InputSource source = new InputSource(new StringReader(stringXml));
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse(source);
		System.out.println("I have an error 17");

		StringBuffer sb = new StringBuffer();

		NodeList pizza = doc.getElementsByTagName("pizza");
		System.out.println("I have an error 18");

		String size = null , type = null;
		System.out.println("I have an error 19");

		for(int i=0; i<pizza.getLength() ; i++){
			System.out.println("I have an error 20");

			sb.append("Pizza::");
			Element pizzaElement = (Element) pizza.item(i);
			NodeList pizzaSizeList = pizzaElement.getElementsByTagName("size");
			size=pizzaSizeList.item(i).getTextContent();
			sb.append(size+"-");
			System.out.println("I have an error 21");

			NodeList pizzaCrustList = pizzaElement.getElementsByTagName("crust");
			type=pizzaCrustList.item(i).getTextContent();
			sb.append(type+"-");

			NodeList pizzaToppingList = pizzaElement.getElementsByTagName("topping");
			for(int j=0; j<pizzaToppingList.getLength() ; j++){
				String top=pizzaToppingList.item(j).getTextContent();
				sb.append(top+"-");
			}
			System.out.println("I have an error 22");

			sb.append("\n");
		}
		System.out.println("I have an error 23");

		NodeList drinks = doc.getElementsByTagName("drinks");
		for(int i=0; i<drinks.getLength() ; i++){
			System.out.println("I have an error 24");

			sb.append("Drinks::");
			Element drinksElement = (Element) drinks.item(i);
			System.out.println("I have an error 25");

			NodeList drinksSizeList = drinksElement.getElementsByTagName("size");
			size=drinksSizeList.item(i).getTextContent();
			sb.append(size+"-");
			NodeList drinksTypeList = drinksElement.getElementsByTagName("type");
			type=drinksTypeList.item(i).getTextContent();
			sb.append(type);
			sb.append("\n");
			System.out.println("I have an error 26");

		}
		
		NodeList sideS = doc.getElementsByTagName("sideS");
		System.out.println("I have an error 27");

		for(int i=0; i<sideS.getLength() ; i++){
			sb.append("SideS::");
			Element sideSElement = (Element) sideS.item(i);
			System.out.println("I have an error 28");

			NodeList sideSSizeList = sideSElement.getElementsByTagName("size");
			size=sideSSizeList.item(i).getTextContent();
			sb.append(size+"-");
			NodeList sideSTypeList = sideSElement.getElementsByTagName("type");
			type=sideSTypeList.item(i).getTextContent();
			sb.append(type);
		}
		System.out.println("I have an error 29");

		return sb.toString();
	}
	
	@Override
	public void onBackPressed() {
		//do nothing
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		System.out.println("I have an error 30");

		getMenuInflater().inflate(R.menu.welcome, menu);
		return true;
	}

	public void onPlaceOrderClickMethod(View view) throws InterruptedException, ExecutionException
	{
		System.out.println("I have an error 31");

		String url = "query=Menu";
		AsyncTask result = new GetPizzas().execute(url);

		String response = (String)result.get();
		System.out.println("I have an error 32");

		Intent intent = new Intent(this, TakeOrderActivity.class);
		LocalMenu l = LocalMenu.getInstance();
		l.setMenuXml(response);
		startActivity(intent);
	}

	public void onLogoutClickMethod(View view)
	{
		System.out.println("I have an error 33");

		Intent intent = new Intent(this, SignInActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intent);
	}
}
