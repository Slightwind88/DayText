package demo.liufan.com.myapplication.bean;

import android.support.v7.app.AlertDialog;

import demo.liufan.com.myapplication.config.DialogConfig;
import demo.liufan.com.myapplication.utils.ToolUtils;

/**
 * Created by liufan on 2017/11/1.
 */

public class Buildable {

    protected BuildBean buildByType(BuildBean buildBean){
        ToolUtils.fixContext(buildBean);
        switch (buildBean.type){
            case DialogConfig.TYPE_ALERT:
                buildAlert(buildBean);
                break;
        }
        ToolUtils.setDialogStyle(buildBean);
        ToolUtils.setCancelable(buildBean);
     return buildBean;
    }

    protected BuildBean buildAlert(BuildBean buildBean){
        AlertDialog.Builder builder = new AlertDialog.Builder(buildBean.mContext);
        AlertDialogHolder holder = new AlertDialogHolder(buildBean.mContext);
        builder.setView(holder.rootView);
        AlertDialog dialog = builder.create();
        buildBean.alertDialog = dialog;
        holder.assingDatasAndEvents(buildBean.mContext, buildBean);
        return buildBean;
    }
}
