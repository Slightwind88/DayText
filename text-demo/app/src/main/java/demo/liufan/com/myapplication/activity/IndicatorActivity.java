package demo.liufan.com.myapplication.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

import com.flyco.tablayout.SlidingTabLayout;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import demo.liufan.com.myapplication.R;
import demo.liufan.com.myapplication.adapter.Find_tab_Adapter;
import demo.liufan.com.myapplication.fragment.FragmentOne;

/**
 * Created by liufan on 2018/3/5.
 */

public class IndicatorActivity extends FragmentActivity{

    private ViewPager viewPager;
    private SlidingTabLayout tab_FindFragment_title;
    private List<Fragment> list_fragment = new ArrayList<>();
    private List<String> list_title;
    private Find_tab_Adapter find_tab_adapter;
    private TabLayout tab_tablayout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indicator);

        viewPager = (ViewPager)findViewById(R.id.viewpager);
        tab_FindFragment_title = (SlidingTabLayout)findViewById(R.id.tab_FindFragment_title);
        tab_tablayout = (TabLayout)findViewById(R.id.tab_tablayout) ;


        initView();

    }


    private void initView(){
        list_title = new ArrayList<>();
        list_title.add("All");
        list_title.add("Personal information");
        list_title.add("Employee information");


        for(int i=0; i < 3; i++){
            list_fragment.add(new FragmentOne());
        }

        find_tab_adapter = new Find_tab_Adapter(getSupportFragmentManager(), list_fragment, list_title);


        viewPager.setAdapter(find_tab_adapter);
        tab_FindFragment_title.setViewPager(viewPager);

        tab_tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tab_tablayout.setupWithViewPager(viewPager);
        setIndicator(this, tab_tablayout, 10, 10);

    }

    public static void setIndicator(Context context, TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        tabStrip.setAccessible(true);
        LinearLayout ll_tab = null;
        try {
            ll_tab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int left = (int) (getDisplayMetrics(context).density * leftDip);
        int right = (int) (getDisplayMetrics(context).density * rightDip);

        for (int i = 0; i < ll_tab.getChildCount(); i++) {
            View child = ll_tab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics metric = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(metric);
        return metric;
    }

    public static float getPXfromDP(float value, Context context) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value,
                context.getResources().getDisplayMetrics());
    }
}
