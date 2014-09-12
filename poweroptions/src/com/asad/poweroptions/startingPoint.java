package com.asad.poweroptions;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;

public class startingPoint extends Activity{
     Button power, hotboot, reboot, recovery;
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context context = this;
       
        
        
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				context);
 
			// set title
            
			alertDialogBuilder.setTitle("Power Options");
 
			// set dialog message
			alertDialogBuilder
				.setMessage("Click yes to exit!")
				.setCancelable(false)
				.setPositiveButton("powerOff",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, close
						// current activity
						powerOff();
					}
				  })
				.setNegativeButton("HotBoot",new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog,int id) {
						// if this button is clicked, just close
						// the dialog box and do nothing
						hotBoot();
					}
				});
 
				// create alert dialog
				AlertDialog alertDialog = alertDialogBuilder.create();
 
				// show it
				alertDialog.show();
			}


    public void hotBoot(){
		try {
		    Process proc = Runtime.getRuntime()
		                    .exec(new String[]{ "su", "-c", "setprop ctl.restart zygote" });
		    proc.waitFor();
		} catch (Exception ex) {
		    ex.printStackTrace();
		}
	}
    
    
    public void powerOff(){
		try {
		    Process proc = Runtime.getRuntime()
		                    .exec(new String[]{ "su", "-c", "reboot -p" });
		    proc.waitFor();
		} catch (Exception ex) {
		    ex.printStackTrace();
		}
	}
		
		
	}
		;
	
    
