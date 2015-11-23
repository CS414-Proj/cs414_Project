package cs414.a5.anvesh;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;

public class GetPizzas extends AsyncTask
{
	@Override
	protected Object doInBackground(Object... args) {
		
		String url1 = args[0].toString();		
		String result = null;
		String url = "http://10.0.0.11:9000/pizzas?";
		
		HttpClient httpclient = new DefaultHttpClient();
		HttpPost httpPost = new HttpPost(url);
	    httpPost.setHeader("data", url1);
		HttpResponse response;
		
		try {
			response = httpclient.execute(httpPost);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream instream = entity.getContent();
				
				result = convertToString(instream);
				instream.close();
			}
		} 
		catch (Exception e) 
		{
		}
		return result;
	}

	private String convertToString(InputStream is) {
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuffer buff = new StringBuffer();

		String line = null;
		try {
			line = reader.readLine();
			while (line != null) 
			{
				buff.append(line + "\n");
				line = reader.readLine();
			}
			is.close();
		} 
		catch (Exception e) 
		{
		} 
		return buff.toString();
	}
}
