package demo.liufan.com.myapplication.listener;

import android.app.Dialog;
import android.support.annotation.Nullable;

import demo.liufan.com.myapplication.bean.BuildBean;

/**
 * Created by liufan on 2017/11/1.
 */

public interface Styleable {

    Dialog show();

    BuildBean setBtnText(CharSequence btn1Text, @Nullable CharSequence btn2Text, @Nullable CharSequence btn3Text);
}
