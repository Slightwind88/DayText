package demo.liufan.com.myapplication.utils;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import demo.liufan.com.myapplication.R;
import demo.liufan.com.myapplication.bean.BuildBean;
import demo.liufan.com.myapplication.config.DialogConfig;
import demo.liufan.com.myapplication.wight.DialogUIUtils;

import static android.support.v4.content.ContextCompat.getColor;

/**
 * Created by liufan on 2017/11/2.
 */

public class ToolUtils {

    /**
     * 统一显示
     * 解决badtoken问题,一劳永逸
     *
     * @param dialog
     */
    public static void showDialog(Dialog dialog) {
        try {
            if (dialog != null) {
                dialog.show();
            }
        } catch (Exception e) {
        }
    }

    public static BuildBean setCancelable(BuildBean bean) {
        if (bean.alertDialog != null) {
            bean.alertDialog.setCancelable(bean.cancelable);
            bean.alertDialog.setCanceledOnTouchOutside(bean.outsideTouchable);
        } else if (bean.dialog != null) {
            bean.dialog.setCancelable(bean.cancelable);
            bean.dialog.setCanceledOnTouchOutside(bean.outsideTouchable);
        }
        return bean;
    }

    public static void setDialogStyle(BuildBean bean) {
        if (bean.alertDialog != null) {
            setMdBtnStytle(bean);
        } else {
            setDialogStyle(bean.mContext, bean.dialog, bean.viewHeight, bean);
        }

    }

    /**
     * 设置MD风格样式
     */
    public static void setMdBtnStytle(BuildBean bean) {
        Button btnPositive =
                bean.alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
        Button btnNegative =
                bean.alertDialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        Button btnNatural =
                bean.alertDialog.getButton(AlertDialog.BUTTON_NEUTRAL);
        if (btnPositive != null && btnNegative != null) {
            btnPositive.setTextSize(bean.btnTxtSize);
            btnNegative.setTextSize(bean.btnTxtSize);
            btnNatural.setTextSize(bean.btnTxtSize);
            if (bean.btn1Color != 0)
                btnPositive.setTextColor(getColor(null, bean.btn1Color));
            if (bean.btn2Color != 0)
                btnNegative.setTextColor(getColor(null, bean.btn2Color));
            if (bean.btn3Color != 0)
                btnNatural.setTextColor(getColor(null, bean.btn3Color));
        }
        Window window = bean.alertDialog.getWindow();
        window.setGravity(bean.gravity);
    }

    /**
     * 混合上下文
     */
    public static BuildBean fixContext(BuildBean bean) {
        if (bean.mContext == null) {
            bean.mContext = DialogUIUtils.appContext;
        } else if (bean.mContext instanceof Activity) {
            Activity activity = (Activity) bean.mContext;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                if (activity.isDestroyed()) {
                    bean.mContext = DialogUIUtils.appContext;
                }
            }
        }
        return bean;
    }

    /**
     * 获取文字
     */
    public static String getString(Context context, int resId) {
        return context.getResources().getString(resId);
    }

    public static void setDialogStyle(Context context, Dialog dialog, int measuredHeight, BuildBean bean) {
        if (dialog == null) {
            return;
        }
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        window.setGravity(bean.gravity);
        WindowManager.LayoutParams wl = window.getAttributes();
        // 以下这两句是为了保证按钮可以水平满屏
        int width = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getWidth();
        int height = (int) (((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getHeight() * 0.9);
        if (bean.type != DialogConfig.TYPE_MD_LOADING) {
            wl.width = (int) (width * 0.94);  // todo keycode to keep gap
        } else {
            wl.width = ViewGroup.LayoutParams.WRAP_CONTENT;
        }
        wl.height = ViewGroup.LayoutParams.WRAP_CONTENT;  //TODO  一般情况下为wrapcontent,最大值为height*0.9
        if (measuredHeight > height) {
            wl.height = height;
        }
        if (context instanceof Activity) {
            Activity activity1 = (Activity) context;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                if (activity1.isDestroyed()) {
                    context = DialogUIUtils.appContext;
                }
            }
        } else {
            wl.type = WindowManager.LayoutParams.TYPE_TOAST;
            //todo keycode to improve window level,同时要让它的后面半透明背景也拦截事件,不要传递到下面去
            //todo 单例化,不然连续弹出两次,只能关掉第二次的
        }
        dialog.onWindowAttributesChanged(wl);

    }


    /**
     * 获取资源颜色
     */
    public static int getColor(Context context, int colorRes) {
        if (context == null) {
            context = DialogUIUtils.appContext;
        }
        return context.getResources().getColor(colorRes);

    }

    public static void setImage(Context context, String imag, ImageView imageView){
        Glide.with(context).load(imag).into(imageView);
//        imageView.setBackgroundResource(R.color.app_style_blue);
    }

}
