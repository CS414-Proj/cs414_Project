package cs414.a5.anvesh;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import edu.colostate.cs414k.R;

public class SidesActivity extends Activity {

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sides);
		
		Intent intent = getIntent();
		String[] sidesSize = intent.getStringArrayExtra("sidesSize");
		String[] sidesType = intent.getStringArrayExtra("sidesType");
		
	    Spinner sidesSizeSpinner = (Spinner) findViewById(R.id.spinner1);
	    ArrayAdapter<String> spinnerArrayAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, sidesSize);
	    sidesSizeSpinner.setAdapter(spinnerArrayAdapter1);
	    
	    Spinner sidesTypeSpinner = (Spinner) findViewById(R.id.spinner2);
	    ArrayAdapter<String> spinnerArrayAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, sidesType);
	    sidesTypeSpinner.setAdapter(spinnerArrayAdapter2);
	    
	    String[] quantity = new String[5];
	    for(int i = 0; i<5; i++)
	    {
	    	quantity[i] = Integer.toString(i+1); 
	    }
	    
	    Spinner sidesQuantitySpinner = (Spinner) findViewById(R.id.spinner3);
	    ArrayAdapter<String> spinnerArrayAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, quantity);
	    sidesQuantitySpinner.setAdapter(spinnerArrayAdapter3);
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.sides, menu);
		return true;
	}

	public void onAddClickMethod(View view)
	{
		Spinner sidesSizeSpinner = (Spinner) findViewById(R.id.spinner1);
		Spinner sidesTypeSpinner = (Spinner) findViewById(R.id.spinner2);
		Spinner sidesQuantitySpinner = (Spinner) findViewById(R.id.spinner3);
		
		String sidesSize = String.valueOf(sidesSizeSpinner.getSelectedItem());
		String sidesType = String.valueOf(sidesTypeSpinner.getSelectedItem());
		String sidesQuantity = String.valueOf(sidesQuantitySpinner.getSelectedItem());
	
		String order = "Sides::" + sidesSize + "," + sidesType + ",Qty ::" + sidesQuantity;
		
		//TakeOrderActivity.getInstance().getOrderDetails().add(order);
		ArrayList<String> orderDetails = getIntent().getStringArrayListExtra(TakeOrderActivity.ORDER_DETAILS);
		if(orderDetails == null)
			orderDetails = new ArrayList<String>();
		orderDetails.add(order);
		Intent intent = new Intent(this, TakeOrderActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
		intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		intent.putStringArrayListExtra(TakeOrderActivity.ORDER_DETAILS, orderDetails);
		startActivity(intent);
	}
	
	public void onCancelClickMethod(View view)
	{
		finish();
	}
}
