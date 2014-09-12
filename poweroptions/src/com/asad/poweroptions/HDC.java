package com.asad.poweroptions;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class HDC extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
// Prevent other apps from launching
     abortBroadcast();
// Your Program
     
     
     Intent startActivity = new Intent();
        startActivity.setClass(context, startingPoint.class);
        startActivity.setAction(startingPoint.class.getName());
        startActivity.setFlags(
        Intent.FLAG_ACTIVITY_NEW_TASK
        | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);
        context.startActivity(startActivity);
        }
    
    }

