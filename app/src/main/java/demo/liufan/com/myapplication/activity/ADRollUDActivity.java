package demo.liufan.com.myapplication.activity;

import android.app.Activity;
import android.os.Bundle;

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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_taobao_headline);

        List<HeadlineBean> data = new ArrayList<>();
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
        });
    }
}
