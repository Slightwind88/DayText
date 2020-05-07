package demo.liufan.com.myapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

import demo.liufan.com.myapplication.R;
import demo.liufan.com.myapplication.adapter.MyGridViewAdapter;

/**
 * Created by liufan on 2017/12/8.
 */

public class MyGridView extends Activity{

    private GridView gridView2;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_mygridview);

        gridView2 = (GridView) findViewById(R.id.gridView2);

        gridView2.setAdapter(new MyGridViewAdapter(this));
    }
}
