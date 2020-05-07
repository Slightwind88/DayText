package demo.liufan.com.myapplication.listener;

import android.content.Context;
import android.view.View;

import demo.liufan.com.myapplication.bean.BuildBean;

/**
 * Created by liufan on 2017/11/2.
 */

public interface Assignable {

    /**
     * 自定义弹出框
     */
    BuildBean assignCustomAlert(Context context, View contentView, int gravity, boolean cancleable, boolean outsideTouchable);


    /**
     * 提示弹出框
     */
    BuildBean assignAlert(Context activity, CharSequence title, CharSequence msg, CharSequence hint1,
                          CharSequence firstTxt, CharSequence secondTxt, boolean isVertical, boolean cancleable, boolean outsideTouchable, final DialogUIListener listener);


}
