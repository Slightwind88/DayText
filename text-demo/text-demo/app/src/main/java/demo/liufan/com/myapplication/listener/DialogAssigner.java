package demo.liufan.com.myapplication.listener;

import android.content.Context;
import android.view.Gravity;
import android.view.View;

import demo.liufan.com.myapplication.bean.BuildBean;
import demo.liufan.com.myapplication.config.DialogConfig;

/**
 * Created by liufan on 2017/11/2.
 */

public class DialogAssigner implements Assignable{

    private static DialogAssigner instance;

    private DialogAssigner(){

    }

    public static DialogAssigner getInstance(){
        if (instance == null){
            instance = new DialogAssigner();
        }
        return instance;
    }

    @Override
    public BuildBean assignCustomAlert(Context context, View contentView, int gravity, boolean cancleable, boolean outsideTouchable) {
        BuildBean buildBean = new BuildBean();
        buildBean.mContext = context;
        buildBean.customView = contentView;
        buildBean.gravity = gravity;
        buildBean.cancelable = cancleable;
        buildBean.outsideTouchable = outsideTouchable;
        buildBean.type = DialogConfig.TYPE_CUSTOM_ALERT;
        return null;
    }

    @Override
    public BuildBean assignAlert(Context activity, CharSequence title, CharSequence msg, CharSequence hint1,
                                 CharSequence firstTxt,CharSequence secondTxt, boolean isVertical, boolean cancleable, boolean outsideTouchable, DialogUIListener listener) {
        BuildBean bean = new BuildBean();
        bean.mContext = activity;
        bean.msg = msg;
        bean.title = title;
        bean.hint1 = hint1;
        bean.text1 = firstTxt;
        bean.text2 = secondTxt;
        bean.isVertical = isVertical;
        bean.gravity = Gravity.CENTER;
        bean.cancelable = cancleable;
        bean.outsideTouchable = outsideTouchable;
        bean.listener = listener;
        bean.type = DialogConfig.TYPE_ALERT;
        return bean;
    }

}
