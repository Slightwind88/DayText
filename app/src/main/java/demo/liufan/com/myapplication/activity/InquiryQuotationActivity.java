package demo.liufan.com.myapplication.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Layout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import demo.liufan.com.myapplication.R;
import demo.liufan.com.myapplication.adapter.PopupWindowItemAdapter;
import demo.liufan.com.myapplication.wight.MyPopupWindow;

/**
 * Created by liufan on 2017/11/3.
 */

public class InquiryQuotationActivity extends FragmentActivity {

    @Override
    public void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_inquiry_question);

        findViewById(R.id.text1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getDialogSeletor(v);
                bottomDialog();
            }
        });
    }

    private void getDialogSeletor(View v) {

        String [] stall = {"我", "你", "他", "who"};

        MyPopupWindow myPopupWindow = new MyPopupWindow(this, null, stall);
        myPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        myPopupWindow.setHalfWidth();
        myPopupWindow.showPopupWindow(v);
    }

    private void bottomDialog(){
        final String [] stall = {"我", "你", "他", "who"};
        final Dialog dialog = new Dialog(this, R.style.BottomDialog);
        View contentView = LayoutInflater.from(this).inflate(R.layout.bottom_info_popupw, null);
      /*  ListView listview_dialog = (ListView)contentView.findViewById(R.id.listview_dialog);
        listview_dialog.setAdapter(new PopupWindowItemAdapter(this, null, stall));
        listview_dialog.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(InquiryQuotationActivity.this, stall[position], Toast.LENGTH_SHORT).show();
            }
        });*/
        contentView.findViewById(R.id.tv_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });


        int height = getWindowManager().getDefaultDisplay().getHeight();
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 380);

        contentView.setLayoutParams(params);
        dialog.setContentView(contentView);

        ViewGroup.LayoutParams layoutParams = contentView.getLayoutParams();
        layoutParams.width = getResources().getDisplayMetrics().widthPixels;
        contentView.setLayoutParams(layoutParams);

        dialog.getWindow().setGravity(Gravity.BOTTOM);
        dialog.getWindow().setWindowAnimations(R.style.Animation_Bottom_Rising);
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }

}
