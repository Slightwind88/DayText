package demo.liufan.com.myapplication.bean;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.View;

import demo.liufan.com.myapplication.config.DialogConfig;
import demo.liufan.com.myapplication.listener.DialogUIListener;
import demo.liufan.com.myapplication.listener.Styleable;
import demo.liufan.com.myapplication.utils.ToolUtils;

/**
 * Created by liufan on 2017/11/1.
 */

public class BuildBean extends Buildable implements Styleable{

    /**
     * 上下文
     */
    public Context mContext;

    /**
     * 构建dialog的类型
     */
    public int type;
    public int viewHeight;

    public Dialog dialog;
    public AlertDialog alertDialog;
    public int gravity;
    public View customView;

    /**
     * 是否可以取消
     */
    public boolean cancelable = true;
    /**
     * 面板外是否可以点击
     */
    public boolean outsideTouchable = true;
    public boolean isVertical;
    public CharSequence title;
    public CharSequence msg;
    public CharSequence hint1;

    public DialogUIListener listener;



    public CharSequence text1 = DialogConfig.dialogui_btnTxt1;
    public CharSequence text2 = DialogConfig.dialogui_btnTxt2;
    public CharSequence text3;
    //字体大小
    public int btnTxtSize = 17;
    public int titleTxtSize = 14;
    public int msgTxtSize = 14;
    public int itemTxtSize = 14;
    public int inputTxtSize = 14;

    //三个以下按钮,颜色按此顺序
    @ColorRes
    public int btn1Color = DialogConfig.iosBtnColor;
    @ColorRes
    public int btn2Color = DialogConfig.iosBtnColor;
    @ColorRes
    public int btn3Color = DialogConfig.iosBtnColor;

    @ColorRes
    public int titleTxtColor = DialogConfig.titleTxtColor;
    @ColorRes
    public int msgTxtColor = DialogConfig.msgTxtColor;
    @ColorRes
    public int lvItemTxtColor = DialogConfig.lvItemTxtColor;
    @ColorRes
    public int inputTxtColor = DialogConfig.inputTxtColor;


    @Override
    public BuildBean setBtnText(CharSequence btn1Text, @Nullable CharSequence btn2Text, @Nullable CharSequence btn3Text) {
        this.text1 = btn1Text;
        this.text2 = btn2Text;
        this.text3 = btn3Text;
        return this;
    }

    @Override
    public Dialog show() {
        buildByType(this);
        if (dialog != null && dialog.isShowing()){
            ToolUtils.showDialog(dialog);
            return dialog;
        }else if(alertDialog != null && !alertDialog.isShowing()){
            ToolUtils.showDialog(alertDialog);
            return alertDialog;
        }
        return null;
    }
}
