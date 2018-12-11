package demo.liufan.com.myapplication.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by admin on 2018/12/11.
 */

public class UserScreenReceiver extends BroadcastReceiver {

    private String TAG = "UserScreenReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        String action=intent.getAction();
        Log.e(TAG, "action="+action);
        if (Intent.ACTION_USER_PRESENT.equals(intent.getAction())) {
            Log.e(TAG, "解锁");
        }else if(Intent.ACTION_SCREEN_OFF.equals(intent.getAction())){
            Log.e(TAG, "黑屏");
        }else if(Intent.ACTION_SCREEN_ON.equals(intent.getAction())){
            Log.e(TAG, "亮屏");
        }
    }
}
