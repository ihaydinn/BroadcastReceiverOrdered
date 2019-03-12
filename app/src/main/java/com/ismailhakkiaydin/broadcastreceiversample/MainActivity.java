package com.ismailhakkiaydin.broadcastreceiversample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

    }

    public void sendBroadcastMessage(View view){

        Intent intent = new Intent("my.custom.action.name");
        //sendOrderedBroadcast(intent,null);

        Bundle bundle = new Bundle();
        bundle.putString("baslik", "iha");
        sendOrderedBroadcast(intent,null,new FourthReceiver(),null,AppCompatActivity.RESULT_OK,"Android",bundle);

    }

    public static class MySecondReceiver extends BroadcastReceiver {
        private static final String TAG = MyFirstReceiver.class.getSimpleName();

        @Override
        public void onReceive(Context context, Intent intent) {
            if (isOrderedBroadcast()) {
                int code = getResultCode();
                String data = getResultData();
                Bundle b = getResultExtras(true);
                String baslik = b.getString("baslik");

                Toast.makeText(context, code+ " "+ data + " "+ b+ " "+ baslik, Toast.LENGTH_LONG).show();

                Toast.makeText(context, "İnner Receiver ", Toast.LENGTH_SHORT).show();

                setResultCode(16);
                setResultData("IOS");
                b.putString("baslik","IHA");
                setResultExtras(b);

            }

        }
    }


}
