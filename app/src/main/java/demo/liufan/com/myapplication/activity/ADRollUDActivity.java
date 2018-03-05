package demo.liufan.com.myapplication.activity;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import demo.liufan.com.myapplication.R;
import demo.liufan.com.myapplication.bean.HeadlineBean;
import demo.liufan.com.myapplication.utils.AppUtils;
import demo.liufan.com.myapplication.utils.SnackbarUtil;
import demo.liufan.com.myapplication.wight.AdRollUpDown;

/**
 * Created by liufan on 2017/10/31.
 */

public class ADRollUDActivity extends Activity {

    private AdRollUpDown taobaoHeadline;
    private PopupWindow popupWindow;
    private Button pop_button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_taobao_headline);
//        pop_button = (Button)findViewById(R.id.pop_button);

      /*  List<HeadlineBean> data = new ArrayList<>();
        data.add(new HeadlineBean("1", "袜子裤子只要998～只要998～"));
        data.add(new HeadlineBean("2", "秋冬上心，韩流服饰，一折起"));
        data.add(new HeadlineBean("3", "品牌二手车"));
        data.add(new HeadlineBean("4", "MadCatz MMO7 游戏鼠标键盘套装"));
        data.add(new HeadlineBean("5", "MarqueeView_liuliufanfan"));
        data.add(new HeadlineBean("6", "liuliuliulo8liuluilujoji"));
        data.add(new HeadlineBean("7", "csdn：@weiweidefeng88"));
        data.add(new HeadlineBean("8", "你看我：@weiweidefeng88"));

        taobaoHeadline = (AdRollUpDown)findViewById(R.id.fragment_taobao_headline_headline);
        taobaoHeadline.setData(data);
        taobaoHeadline.setHeadlineClickListener(new AdRollUpDown.HeadlineClickListener() {
            @Override
            public void onHeadlineClick(HeadlineBean bean) {
                Random random = new Random();
                int type = random.nextInt(4) + 1;
                SnackbarUtil.ShortSnackbar(taobaoHeadline,bean.getTitle() + ":" + bean.getContent(),type).show();
            }

            @Override
            public void onMoreClick() {
                AppUtils.showToast("更多");
            }
        });*/



    }

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    backgroundAlpha((float)msg.obj);
                    break;
            }
        }
    };

    public void onclick_popupwindow(View view) {

        showbottomWPopw(view);
        new Thread(new Runnable(){
            @Override
            public void run() {
                float alpha = 1f;
                while(alpha>0.5f){
                    try {
                        //4是根据弹出动画时间和减少的透明度计算
                        Thread.sleep(4);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Message msg =mHandler.obtainMessage();
                    msg.what = 1;
                    //每次减少0.01，精度越高，变暗的效果越流畅
                    alpha-=0.01f;
                    msg.obj =alpha ;
                    mHandler.sendMessage(msg);
                }
            }

        }).start();

    }

    private void showbottomWPopw(View view){

        RelativeLayout frameLayout =(RelativeLayout)getLayoutInflater().inflate(R.layout.bottom_info_popupw, null);

        popupWindow = new PopupWindow(frameLayout, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        //点击空白处，隐藏pop窗口
        popupWindow.setFocusable(true);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(true);
        ColorDrawable dw = new ColorDrawable(-00000);
        popupWindow.setBackgroundDrawable(dw);
        //添加弹出，弹入的动画
        popupWindow.setAnimationStyle(R.style.Animation_Bottom_Rising);
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        popupWindow.showAsDropDown(view, Gravity.LEFT | Gravity.BOTTOM, 0, -location[1]);
        //添加按键事件监听
        setButtonListeners(frameLayout);
        popupWindow.setOnDismissListener(new poponDismissListener());
//        backgroundAlpha(1f);
    }

    private void setButtonListeners(RelativeLayout frameLayout){
        TextView tv_cancel = (TextView)frameLayout.findViewById(R.id.tv_cancel);
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (popupWindow != null && popupWindow.isShowing()){
                    popupWindow.dismiss();
                }
            }
        });
    }

    public void backgroundAlpha(float bgAlpha)
    {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        getWindow().setAttributes(lp);  getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }

    class poponDismissListener implements PopupWindow.OnDismissListener{
        @Override
        public void onDismiss() {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //此处while的条件alpha不能<= 否则会出现黑屏
                    float alpha = 0.5f;
                    while(alpha<0.99f){
                        try {
                            Thread.sleep(4);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Log.d("HeadPortrait","alpha:"+alpha);
                        Message msg =mHandler.obtainMessage();
                        msg.what = 1;
                        alpha+=0.01f;
                        msg.obj =alpha ;
                        mHandler.sendMessage(msg);
                    }
                }
            }).start();
        }
    }

}