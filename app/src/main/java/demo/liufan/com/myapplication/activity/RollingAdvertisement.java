package demo.liufan.com.myapplication.activity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.URLSpan;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import demo.liufan.com.myapplication.R;
import demo.liufan.com.myapplication.marqueeview.MarqueeView;

/**
 * Created by liufan on 2017/10/26.
 */

public class RollingAdvertisement extends Activity {

    private MarqueeView marqueeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        marqueeView = (MarqueeView) findViewById(R.id.marqueeView);

        List<CharSequence> list = new ArrayList<>();
        SpannableString ss1 = new SpannableString("1、MarqueeView_liuliufanfan");
        ss1.setSpan(new ForegroundColorSpan(Color.RED), 2, 13, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        list.add(ss1);
        SpannableString ss2 = new SpannableString("2、liuliuliulo8liuluilujoji");
        ss2.setSpan(new ForegroundColorSpan(Color.GREEN), 9, 20, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        list.add(ss2);
        SpannableString ss3 = new SpannableString("3、技术支持URL：http://www.erui.com");
        ss3.setSpan(new URLSpan("www.baidu.com"), 7, 21, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        list.add(ss3);
        list.add("4、csdn：@weiweidefeng88");
        list.add("5、你看我：@weiweidefeng88");
        list.add("6、再看我：@weiweidefeng88");
        list.add("7、麻痹的还看我：@weiweidefeng88");
        list.add("8、好吧，你看吧：@weiweidefeng88");


        marqueeView.startWithList(list);
        marqueeView.setOnItemClickListener(new MarqueeView.OnItemClickListener() {
            @Override
            public void onItemClick(int position, TextView textView) {
                Toast.makeText(RollingAdvertisement.this, textView.getText() + "", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        marqueeView.startFlipping();
    }

    @Override
    public void onStop() {
        super.onStop();
        marqueeView.stopFlipping();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }



}
