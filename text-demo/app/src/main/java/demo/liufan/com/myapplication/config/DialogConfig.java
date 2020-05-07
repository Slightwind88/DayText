package demo.liufan.com.myapplication.config;

import android.support.annotation.ColorRes;

import demo.liufan.com.myapplication.R;

/**
 * Created by liufan on 2017/11/1.
 */

public class DialogConfig {

    @ColorRes
    public static int iosBtnColor = R.color.ios_btntext_blue;
    @ColorRes
    public static int lvItemTxtColor = R.color.text_item_33;
    @ColorRes
    public static int mdBtnColor = R.color.btn_alert;
    @ColorRes
    public static int titleTxtColor = R.color.text_title_11;
    @ColorRes
    public static int msgTxtColor = R.color.text_title_11;
    @ColorRes
    public static int inputTxtColor = R.color.text_input_44;

    public static CharSequence dialogui_btnTxt1 = "确定";
    public static CharSequence dialogui_btnTxt2 = "取消";
    public static CharSequence dialogui_bottomTxt = "取消";


    public static final int TYPE_MD_LOADING = 2;
    public static final int TYPE_ALERT = 6;
    public static final int TYPE_CUSTOM_ALERT = 15;
}
