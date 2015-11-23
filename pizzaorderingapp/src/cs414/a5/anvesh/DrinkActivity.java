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

public class DrinkActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_drink);

		Intent intent = getIntent();
		String[] drinkSize = intent.getStringArrayExtra("drinkSize");
		String[] drinkType = intent.getStringArrayExtra("drinkType");

		Spinner drinkSizeSpinner = (Spinner) findViewById(R.id.spinner1);
		ArrayAdapter<String> spinnerArrayAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, drinkSize);
		drinkSizeSpinner.setAdapter(spinnerArrayAdapter1);

		Spinner drinkTypeSpinner = (Spinner) findViewById(R.id.spinner2);
		ArrayAdapter<String> spinnerArrayAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, drinkType);
		drinkTypeSpinner.setAdapter(spinnerArrayAdapter2);

		String[] quantity = new String[5];
		for(int i = 0; i<5; i++)
		{
			quantity[i] = Integer.toString(i+1); 
		}

		Spinner drinkQuantitySpinner = (Spinner) findViewById(R.id.spinner3);
		ArrayAdapter<String> spinnerArrayAdapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, quantity);
		drinkQuantitySpinner.setAdapter(spinnerArrayAdapter3);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.drink, menu);
		return true;
	}

	public void onAddClickMethod(View view)
	{
		Spinner drinkSizeSpinner = (Spinner) findViewById(R.id.spinner1);
		Spinner drinkTypeSpinner = (Spinner) findViewById(R.id.spinner2);
		Spinner drinkQuantitySpinner = (Spinner) findViewById(R.id.spinner3);

		String drinkSize = String.valueOf(drinkSizeSpinner.getSelectedItem());
		String drinkType = String.valueOf(drinkTypeSpinner.getSelectedItem());
		String drinkQuantity = String.valueOf(drinkQuantitySpinner.getSelectedItem());

		String order = "Drink::" + drinkSize + "," + drinkType + ",Qty::" + drinkQuantity;

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
