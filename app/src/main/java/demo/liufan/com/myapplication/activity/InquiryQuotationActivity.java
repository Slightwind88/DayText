package demo.liufan.com.myapplication.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;

import demo.liufan.com.myapplication.R;
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
                getDialogSeletor(v);
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

}
