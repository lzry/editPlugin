package com.example.editplugin;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class DataEditing extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String ScanResult = intent.getStringExtra("data");//Read the scan result from the Intent

        //---------------------------------------------
        //Modify the scan result as needed.
        //---------------------------------------------

        //Return the Modified scan result string
        Log.d("DataEdit", ScanResult);
        Bundle bundle = new Bundle();
        //convert data to hex string
        String trimed;
        if (ScanResult.startsWith("183")) {
            trimed = ScanResult.substring(ScanResult.length()-8, ScanResult.length());
        }else {
            trimed = ScanResult.toString();
        }

        bundle.putString("data", trimed);

        setResultExtras(bundle);
    }
}
