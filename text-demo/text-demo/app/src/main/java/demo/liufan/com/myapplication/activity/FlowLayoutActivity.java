package demo.liufan.com.myapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import demo.liufan.com.myapplication.R;
import demo.liufan.com.myapplication.adapter.GriViewInquiryPriceAdapter;
import demo.liufan.com.myapplication.wight.FlowLayout;

/**
 * Created by liufan on 2017/10/28.
 */

public class FlowLayoutActivity extends Activity {
    private String[] mVals = new String[]
            { "Hello", "Android", "Weclome Hi ", "Button", "TextView", "Hello",
                    "Android", "Weclome", "Button ImageView", "TextView", "Helloworld",
                    "Android", "Weclome Hello", "Button Text", "TextView" };

    private FlowLayout mFlowLayout;
    private GridView gridlist_goods;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flowlayoutactivity);

        gridlist_goods = (GridView) findViewById(R.id.gridlist_goods);

        initData();
    }

    public void initData()
    {

        List<String> mdata = Arrays.asList(mVals);
        gridlist_goods.setAdapter(new GriViewInquiryPriceAdapter(this, mdata));

    }

}
