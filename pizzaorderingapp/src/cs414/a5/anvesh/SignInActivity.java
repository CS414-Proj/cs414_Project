package cs414.a5.anvesh;

import java.util.StringTokenizer;
import java.util.concurrent.ExecutionException;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import edu.colostate.cs414k.R;

public class SignInActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_in);
		
		EditText userName = (EditText) findViewById(R.id.editText1);
		EditText password = (EditText) findViewById(R.id.editText2);
		
		userName.setText("");
		password.setText("");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}
	
	@Override
	public void onBackPressed() {
		finish();
	}
	
	public void onSignInClickMethod(View view) throws InterruptedException, ExecutionException
	{
		EditText userName = (EditText) findViewById(R.id.editText1);
		EditText password = (EditText) findViewById(R.id.editText2);
		
		if(userName.getText().toString().isEmpty() || password.getText().toString().isEmpty())
		{
			Context context = this;
			ErrorHandliing error = new ErrorHandliing();
			error.displayError("Enter Valid Inputs!!!", context);
		}
		else
		{
			String url = "query=Login&user=" + userName.getText().toString() + "&password=" + password.getText().toString();
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
			for(;st.hasMoreTokens();)
			{
				special += st.nextToken().toString() + " ";
			}
			
			if(uid.equalsIgnoreCase(userName.getText().toString()))
			{
				Intent intent = new Intent(this, WelcomeActivity.class);
				intent.putExtra("user", uname);
				intent.putExtra("uid",uid);
				//intent.putExtra("point", point);
				intent.putExtra("special", special);
				LocalMenu.getInstance().setUid(uid);
				startActivity(intent);
			}
			else if(response.trim().equalsIgnoreCase("Invalid"))
			{
				TextView message = (TextView) findViewById(R.id.textView4);
				message.setText("Not Valid");
				message.setTextColor(Color.RED);
			}
		}
	}

	public void onSignUpClickMethod(View view)
	{
		Intent intent = new Intent(this, SignUpActivity.class);
		startActivity(intent);
	}
}
