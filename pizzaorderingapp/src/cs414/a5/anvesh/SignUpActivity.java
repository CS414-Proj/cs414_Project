package cs414.a5.anvesh;

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
import edu.colostate.cs414k.R;

public class SignUpActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_up);
		
		EditText name = (EditText) findViewById(R.id.editText1);
		EditText number = (EditText) findViewById(R.id.editText2);
		EditText userName = (EditText) findViewById(R.id.editText3);
		EditText password = (EditText) findViewById(R.id.editText4);
		
		name.setText("");
		number.setText("");
		userName.setText("");
		password.setText("");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.sign_up, menu);
		return true;
	}
	
	@Override
	public void onBackPressed() {
		finish();
	}

	public void onSignUpClickMethod(View view) throws InterruptedException, ExecutionException 
	{
		EditText name = (EditText) findViewById(R.id.editText1);
		EditText number = (EditText) findViewById(R.id.editText2);
		EditText userName = (EditText) findViewById(R.id.editText3);
		EditText password = (EditText) findViewById(R.id.editText4);
		
		if(name.getText().toString().isEmpty() || number.getText().toString().isEmpty() || userName.getText().toString().isEmpty() || password.getText().toString().isEmpty())
		{
			Context context = this;
			ErrorHandliing error = new ErrorHandliing();
			error.displayError("In Valid Inputs!!!", context);
		}
		else if(number.length()!=10){
			Context context = this;
			ErrorHandliing error = new ErrorHandliing();
			error.displayError("In Valid Inputs!!!", context);
		}
		else
		{
			StringBuffer buffer = new StringBuffer();
			
			buffer.append("<register>");
			buffer.append("<name>" + name.getText().toString() + "</name>");
			buffer.append("<phoneNum>" + number.getText().toString() + "</phoneNum>");
			buffer.append("<userId>" + userName.getText().toString() + "</userId>");
			buffer.append("<pwd>" + password.getText().toString() + "</pwd>");
			buffer.append("</register>");
			
			String xml = buffer.toString();
			
			String url = "query=Register&xml="+ xml;
			
			AsyncTask result = new GetPizzas().execute(url);		
			
			String response = (String)result.get();
			
			StringTokenizer st = new StringTokenizer(response, " ");
			
			String uid = "", uname = "", point = "", special = "";
			
			if(st.hasMoreTokens())
				uid = st.nextToken().toString();
			if(st.hasMoreTokens())
				uname = st.nextToken().toString();
			/*if(st.hasMoreTokens())
				point = st.nextToken().toString(); */
			if(st.hasMoreTokens())
				special = st.nextToken().toString();
			
			LocalMenu.getInstance().setUid(uid);
			
			Intent intent = new Intent(this, WelcomeActivity.class);
			intent.putExtra("user", uname);
			intent.putExtra("point", point);
			intent.putExtra("special", special);
			startActivity(intent);
		}
	}
}
