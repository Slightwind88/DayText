package demo.liufan.com.myapplication.bean;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import demo.liufan.com.myapplication.R;
import demo.liufan.com.myapplication.holder.SuperHolder;
import demo.liufan.com.myapplication.utils.ToolUtils;
import demo.liufan.com.myapplication.wight.DialogUIUtils;

/**
 * Created by liufan on 2017/11/1.
 */

public class AlertDialogHolder  extends SuperHolder{

    protected TextView tvTitle;
    public TextView tvMsg;
    public EditText et1;
    protected View line;
    protected Button btn1;
    protected View lineBtn2;
    protected Button btn2;
    protected View lineBtn3;
    protected Button btn3;
    protected LinearLayout llContainerHorizontal;

    public AlertDialogHolder(Context context){

        super(context);
    }

    @Override
    protected void findViews() {
        tvTitle = (TextView) rootView.findViewById(R.id.dialogui_tv_title);
        tvMsg = (TextView) rootView.findViewById(R.id.dialogui_tv_msg);
        et1 = (EditText) rootView.findViewById(R.id.et_1);
        line = (View) rootView.findViewById(R.id.line);
        btn1 = (Button) rootView.findViewById(R.id.btn_1);
        lineBtn2 = (View) rootView.findViewById(R.id.line_btn2);
        btn2 = (Button) rootView.findViewById(R.id.btn_2);
        lineBtn3 = (View) rootView.findViewById(R.id.line_btn3);
        btn3 = (Button) rootView.findViewById(R.id.btn_3);
        llContainerHorizontal = (LinearLayout) rootView.findViewById(R.id.ll_container_horizontal);
    }

    @Override
    protected int setLayoutRes() {
        return R.layout.dialog_confrim_reminder;
    }

    @Override
    public void assingDatasAndEvents(Context context,final BuildBean bean) {
//style
        tvMsg.setTextColor(ToolUtils.getColor(tvMsg.getContext(), bean.msgTxtColor));
        tvMsg.setTextSize(bean.msgTxtSize);

        tvTitle.setTextColor(ToolUtils.getColor(tvTitle.getContext(), bean.titleTxtColor));
        tvTitle.setTextSize(bean.titleTxtSize);

        btn3.setTextSize(bean.btnTxtSize);
        btn2.setTextSize(bean.btnTxtSize);
        btn1.setTextSize(bean.btnTxtSize);

        btn1.setTextColor(ToolUtils.getColor(btn1.getContext(), bean.btn1Color));
        btn2.setTextColor(ToolUtils.getColor(btn1.getContext(), bean.btn2Color));
        btn3.setTextColor(ToolUtils.getColor(btn1.getContext(), bean.btn3Color));


        llContainerHorizontal.setVisibility(View.VISIBLE);


        if (TextUtils.isEmpty(bean.title)) {
            tvTitle.setVisibility(View.GONE);
        } else {
            tvTitle.setVisibility(View.VISIBLE);
            tvTitle.setText(bean.title);
        }

        if (TextUtils.isEmpty(bean.msg)) {
            tvMsg.setVisibility(View.GONE);
        } else {
            tvMsg.setVisibility(View.VISIBLE);
            tvMsg.setText(bean.msg);

            tvMsg.setTextColor(ToolUtils.getColor(tvMsg.getContext(), bean.msgTxtColor));
            tvMsg.setTextSize(bean.msgTxtSize);
        }

        if (TextUtils.isEmpty(bean.hint1)) {
            et1.setVisibility(View.GONE);
        } else {
            et1.setVisibility(View.VISIBLE);
            et1.setHint(bean.hint1);

            et1.setTextColor(ToolUtils.getColor(et1.getContext(), bean.inputTxtColor));
            et1.setTextSize(bean.inputTxtSize);
        }


        //按钮数量

        if (TextUtils.isEmpty(bean.text3)) {

                btn3.setVisibility(View.GONE);
                lineBtn3.setVisibility(View.GONE);
                btn2.setBackgroundResource(R.drawable.dialogui_selector_right_bottom);

        } else {

                btn3.setVisibility(View.VISIBLE);
                lineBtn3.setVisibility(View.VISIBLE);
                btn3.setText(bean.text3);

        }

        if (TextUtils.isEmpty(bean.text2)) {

            btn2.setVisibility(View.GONE);
            lineBtn2.setVisibility(View.GONE);
            btn2.setBackgroundResource(R.drawable.dialogui_selector_right_bottom);

        } else {

            btn2.setVisibility(View.VISIBLE);
            lineBtn2.setVisibility(View.VISIBLE);
            btn2.setText(bean.text2);

        }


        if (TextUtils.isEmpty(bean.text1)) {
            line.setVisibility(View.GONE);
            llContainerHorizontal.setVisibility(View.GONE);

        } else {

            btn1.setText(bean.text1);

        }


        //事件


            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogUIUtils.dismiss(bean.dialog, bean.alertDialog);
                    bean.listener.onNegative();
                }
            });

            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogUIUtils.dismiss(bean.dialog, bean.alertDialog);
                    bean.listener.onPositive();
                    bean.listener.onGetInput(et1.getText().toString().trim());
                }
            });

            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DialogUIUtils.dismiss(bean.dialog, bean.alertDialog);
                    bean.listener.onNeutral();
                }
            });

    }

}
