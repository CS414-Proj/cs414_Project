package cs414.a5.anvesh;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;
import edu.colostate.cs414k.R;

public class PizzaActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pizza);
		
		Intent intent = getIntent();
		String[] pizzaSize = intent.getStringArrayExtra("pizzaSize");
		String[] pizzaCrust = intent.getStringArrayExtra("pizzaCrust");
		String[] pizzaTopping = intent.getStringArrayExtra("pizzaTopping");
		
	    Spinner pizzaSizeSpinner = (Spinner) findViewById(R.id.spinner1);
	    ArrayAdapter<String> spinnerArrayAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, pizzaSize);
	    pizzaSizeSpinner.setAdapter(spinnerArrayAdapter1);
	    
	    Spinner pizzaCrustSpinner = (Spinner) findViewById(R.id.spinner2);
	    ArrayAdapter<String> spinnerArrayAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, pizzaCrust);
	    pizzaCrustSpinner.setAdapter(spinnerArrayAdapter2);
	    
	    LinearLayout ll = (LinearLayout)findViewById(R.id.linearLayout1);
	    int i = 0;
	    for(String s : pizzaTopping)
	    {
	    	CheckBox cb = new CheckBox(this);
	        cb.setText(s);
	        cb.setId(i);
	        ll.addView(cb);
	        i++;
	    }
	    
	    String[] quantity = new String[5];
	    for(i = 0; i<5; i++)
	    {
	    	quantity[i] = Integer.toString(i+1); 
	    }
	    Spinner pizzaQuantitySpinner = (Spinner) findViewById(R.id.spinner3);
	    ArrayAdapter<String> spinnerArrayAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, quantity);
	    pizzaQuantitySpinner.setAdapter(spinnerArrayAdapter3);
	}
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}
	
	public void onAddClickMethod(View view)
	{
		Spinner pizzaSizeSpinner = (Spinner) findViewById(R.id.spinner1);
		Spinner pizzaCrustSpinner = (Spinner) findViewById(R.id.spinner2);
		Spinner pizzaQuantitySpinner = (Spinner) findViewById(R.id.spinner3);
		CheckBox cb = new CheckBox(this);
		
		String pizzaSize = String.valueOf(pizzaSizeSpinner.getSelectedItem());
		String pizzaCrust = String.valueOf(pizzaCrustSpinner.getSelectedItem());
		String pizzaQuantity = String.valueOf(pizzaQuantitySpinner.getSelectedItem());
	
		String toppings = "";
		LinearLayout ll = (LinearLayout)findViewById(R.id.linearLayout1);
		for(int i =0; i<ll.getChildCount(); i++)
		{
			cb =(CheckBox) ll.getChildAt(i);
			if(cb.isChecked())
			{
				toppings += cb.getText() + ",";
			}
		}
		String order = "Pizza::" + pizzaSize + "," + pizzaCrust + "," + toppings + "Qty::" + pizzaQuantity;
		
		//TakeOrderActivity.getInstance().addInOrder(order);
		ArrayList<String> orderDetails = getIntent().getStringArrayListExtra(TakeOrderActivity.ORDER_DETAILS);
		if(orderDetails == null)
			orderDetails = new ArrayList<String>();
		orderDetails.add(order);
		Intent intent = new Intent(this, TakeOrderActivity.class);
		intent.putStringArrayListExtra(TakeOrderActivity.ORDER_DETAILS, orderDetails);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
		intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		startActivity(intent);
	}
	
	public void onCancelClickMethod(View view)
	{
		finish();
		/*Intent intent = new Intent(this, TakeOrderActivity.class);
		startActivity(intent);*/
	}
}
