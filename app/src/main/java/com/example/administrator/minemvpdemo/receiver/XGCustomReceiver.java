package com.example.administrator.minemvpdemo.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class XGCustomReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String name = intent.getStringExtra("name");
            String code = intent.getStringExtra("code");
        }
    }
}
