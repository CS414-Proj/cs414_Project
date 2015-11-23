package cs414.a5.anvesh;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import edu.colostate.cs414k.R;

public class PaymentActivity extends Activity {

	private int saleNumber;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_payment);
		
		LocalMenu l = LocalMenu.getInstance();
		
		Intent intent = getIntent();
		String orderDetails = intent.getStringExtra("order");
		
		StringTokenizer st = new StringTokenizer(orderDetails, " ");
		String uName = l.getUid();
		String oNumber= st.nextToken();
		String sTotal= st.nextToken();
		String tx= st.nextToken();
		String bDue= st.nextToken();
		saleNumber= Integer.parseInt(st.nextToken().trim());		
		
		TextView customerName = (TextView) findViewById(R.id.textView2);
		TextView orderNumber = (TextView) findViewById(R.id.textView4);
		TextView subTotal = (TextView) findViewById(R.id.textView6);
		TextView tax = (TextView) findViewById(R.id.textView8);
		TextView discount = (TextView) findViewById(R.id.textView10);
		TextView balanceDue = (TextView) findViewById(R.id.textView12);
		
		customerName.setText("");
		orderNumber.setText(oNumber);
		subTotal.setText(sTotal);
		tax.setText(tx);
		discount.setText(" ");
		balanceDue.setText(bDue);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.payment, menu);
		return true;
	}

	public void onCancelClickMethod(View view)
	{
		Intent intent = new Intent(this, TakeOrderActivity.class);
		intent.putStringArrayListExtra(TakeOrderActivity.ORDER_DETAILS, getIntent().getStringArrayListExtra(TakeOrderActivity.ORDER_DETAILS));
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
		intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		startActivity(intent);
	}
	
	public void onOkClickMethod(View view) throws InterruptedException, ExecutionException
	{
		EditText name = (EditText) findViewById(R.id.editText2);
		EditText cardNumber = (EditText) findViewById(R.id.editText4);
		EditText validThrough = (EditText) findViewById(R.id.editText3);
		EditText ccNumber = (EditText) findViewById(R.id.editText5);
		
//			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/yy");
//			simpleDateFormat.setLenient(false);
//			Date expiryDate = null;
//			try {
//				expiryDate = simpleDateFormat.parse(validThrough.toString());
//			} catch (ParseException e1) {
//				e1.printStackTrace();
//			}
//			boolean expired = expiryDate.before(new Date());
		
		if(name.getText().toString().isEmpty() || cardNumber.getText().toString().isEmpty() || validThrough.getText().toString().isEmpty() || ccNumber.getText().toString().isEmpty())
		{
			Context context = this;
			ErrorHandliing error = new ErrorHandliing();
			error.displayError("InValid Inputs!!!", context);
		}
		else if(cardNumber.length()!=16){
			Context context = this;
			ErrorHandliing error = new ErrorHandliing();
			error.displayError("InValid Inputs!!!", context);
		}
		
		else if(validThrough.length()!=4){
			Context context = this;
			ErrorHandliing error = new ErrorHandliing();
			error.displayError("InValid Inputs!!!", context);
		}
		else if(ccNumber.length()!=3){
			Context context = this;
			ErrorHandliing error = new ErrorHandliing();
			error.displayError("InValid Inputs!!!", context);
		}
		else
		{
			//TakeOrderActivity.getInstance().getOrderDetails().clear();
			
			StringBuffer url = new StringBuffer();
			url.append("query=Payment&SaleNum="+saleNumber);
			url.append("&CardDetails="+name.getText().toString()+"-"+cardNumber.getText().toString()+"-"+validThrough.getText().toString()+"-"+ccNumber.getText().toString());
			AsyncTask result = new GetPizzas().execute(url.toString());
			
			String response = (String)result.get();
			
			if(response.trim().equalsIgnoreCase("success"))
			{
				Intent intent = new Intent(this, WelcomeActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intent);
			}
			else
			{
				
			}
		}
	}
	
	public void onApplyDiscountClickMethod(View view) throws InterruptedException, ExecutionException
	{ 	
		EditText discountID = (EditText) findViewById(R.id.editText1);
		String disc = discountID.getText().toString();
		LocalMenu l = LocalMenu.getInstance();
		String uid = l.getUid();
		
		String url = "query=Discount&code="+disc+"&uid="+uid;
		AsyncTask result = new GetPizzas().execute(url);
		
		TextView discount = (TextView) findViewById(R.id.textView10);
		TextView balanceDue = (TextView) findViewById(R.id.textView12);
		
		String response = (String)result.get();
		
		if(response.contains("-1"))
		{
			discount.setText("free");
			balanceDue.setText("0");
		}
		else
		{
			discount.setText("-"+response);
			float oldDueBal = Float.parseFloat(balanceDue.getText().toString().trim());
			float newDueBal = oldDueBal - Float.parseFloat(response.toString().trim());
			balanceDue.setText(newDueBal+"");
		}
	}
}