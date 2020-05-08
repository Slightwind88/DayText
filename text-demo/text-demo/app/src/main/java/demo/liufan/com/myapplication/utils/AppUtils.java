package demo.liufan.com.myapplication.utils;

import android.content.Context;


public class AppUtils {

    private static Context appContext;

    /**
     * 如果有使用到showTost...相关的方法使用之前需要初始化该方法
     */
    public static void init(Context appContext) {
        AppUtils.appContext = appContext;
    }

    public static void showToast(String msg) {
    }

}
