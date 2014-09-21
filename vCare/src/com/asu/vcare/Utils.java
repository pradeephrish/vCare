package com.asu.vcare;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class Utils {
	 public static void showDialog(final String message,Context context) throws Exception
	    {
	        AlertDialog.Builder builder = new AlertDialog.Builder(context);

	        builder.setMessage(message);       

	        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() 
	        {
	            @Override
	            public void onClick(DialogInterface dialog, int which) 
	            {
	                dialog.dismiss();
	            }
	        });

	        builder.show();
	    }
}
