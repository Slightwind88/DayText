package demo.liufan.com.myapplication.service;

import android.app.Service;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import demo.liufan.com.myapplication.receiver.UserScreenReceiver;

/**
 * Created by admin on 2018/12/11.
 */

public class TextService extends Service {

    private String TAG = "TextService";
    private UserScreenReceiver userScreenReceiver;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate=");
        userScreenReceiver = new UserScreenReceiver();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_SCREEN_OFF);
        intentFilter.addAction(Intent.ACTION_SCREEN_ON);
        registerReceiver(userScreenReceiver, intentFilter);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "onBind=");
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand=");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (userScreenReceiver != null){
            unregisterReceiver(userScreenReceiver);
        }

        Log.e(TAG, "onDestroy=");
    }
}
