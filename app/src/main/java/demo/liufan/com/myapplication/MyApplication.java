package demo.liufan.com.myapplication;

import android.app.Application;
import android.content.Context;

import demo.liufan.com.myapplication.utils.AppUtils;
import demo.liufan.com.myapplication.wight.DialogUIUtils;

/**
 * Created by liufan on 2017/10/31.
 */

public class MyApplication extends Application {

    /**
     * 全局上下文
     */
    public static Context appContext;

    private static MyApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        DialogUIUtils.init(this);
    }

    public static MyApplication getInstance() {
        return instance;
    }
}
