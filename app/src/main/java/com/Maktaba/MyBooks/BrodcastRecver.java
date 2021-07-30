package com.Maktaba.MyBooks;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class BrodcastRecver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getAction() != null) {

            if (intent.getAction().equalsIgnoreCase("android.net.conn.CONNECTIVITY_CHANGE")) {

                NetworkInfo info = (NetworkInfo) intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);

                if (info.isConnected()) {


                } else {
                    Toast.makeText(context, "يجب عليك تشغيل الانترنت  لتغشيل الكتب", Toast.LENGTH_LONG + 11).show();
                }
            }
        }
    }
}
