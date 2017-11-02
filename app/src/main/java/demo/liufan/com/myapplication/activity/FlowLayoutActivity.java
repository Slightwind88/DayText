package demo.liufan.com.myapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TextView;

import demo.liufan.com.myapplication.R;
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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flowlayoutactivity);

        mFlowLayout = (FlowLayout) findViewById(R.id.id_flowlayout);

        initData();
    }

    public void initData()
    {
        // for (int i = 0; i < mVals.length; i++)
        // {
        // Button btn = new Button(this);
        //
        // MarginLayoutParams lp = new MarginLayoutParams(
        // MarginLayoutParams.WRAP_CONTENT,
        // MarginLayoutParams.WRAP_CONTENT);
        //
        // btn.setText(mVals[i]);
        // mFlowLayout.addView(btn, lp);
        // }
        LayoutInflater mInflater = LayoutInflater.from(this);
        for (int i = 0; i < mVals.length; i++)
        {
            TextView tv = (TextView) mInflater.inflate(R.layout.tv,
                    mFlowLayout, false);
            tv.setText(mVals[i]);
            mFlowLayout.addView(tv);
        }

    }

}
