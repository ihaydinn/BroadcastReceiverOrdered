package com.ismailhakkiaydin.broadcastreceiversample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MyFirstReceiver extends BroadcastReceiver {

    private static final String TAG = MyFirstReceiver.class.getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {

        if (isOrderedBroadcast()) {
            int code = getResultCode();
            String data = getResultData();
            Bundle b = getResultExtras(true);
            String baslik = b.getString("baslik");

            Toast.makeText(context, code+ " "+ data + " "+ b+ " "+ baslik, Toast.LENGTH_LONG).show();

            Toast.makeText(context, "Birinci Receiver ", Toast.LENGTH_LONG).show();

            setResultCode(26);
            setResultData("IOS");
            b.putString("baslik","IHA");
            setResultExtras(b);

        }

    }
}
