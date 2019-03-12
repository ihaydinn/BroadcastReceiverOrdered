package com.ismailhakkiaydin.broadcastreceiversample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MySecondReceiver extends BroadcastReceiver {

    private static final String TAG = MySecondReceiver.class.getSimpleName();


    @Override
    public void onReceive(Context context, Intent intent) {
        if (isOrderedBroadcast()) {
            int code = getResultCode();
            String data = getResultData();
            Bundle b = getResultExtras(true);
            String baslik = b.getString("baslik");

            Toast.makeText(context, code+ " "+ data + " "+ b+ " "+ baslik, Toast.LENGTH_LONG).show();

            Toast.makeText(context, "İkinci Receiver ", Toast.LENGTH_LONG).show();

            setResultCode(36);
            setResultData("IOS");
            b.putString("baslik","IHA");
            setResultExtras(b);

            abortBroadcast();

        }
    }
}
