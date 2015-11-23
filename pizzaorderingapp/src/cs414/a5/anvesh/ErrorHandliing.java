package cs414.a5.anvesh;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class ErrorHandliing
{
	public void displayError(String message, Context context)
	{
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

		alertDialogBuilder.setTitle("Error!!!");

		alertDialogBuilder
		.setMessage(message)
		.setCancelable(false)
		.setNegativeButton("OK",new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog,int id) {
			}
		});

		AlertDialog alertDialog = alertDialogBuilder.create();
		alertDialog.show();
	}
}
