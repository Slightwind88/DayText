package demo.liufan.com.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import demo.liufan.com.myapplication.R;

/**
 * Created by liufan on 2017/12/8.
 */

public class MyGridViewAdapter extends BaseAdapter {

    private Context context;
    private TextView textView1;

    public MyGridViewAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return 16;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_gridview, parent, false);
            textView1 = (TextView)convertView.findViewById(R.id.textView1);
        }

        textView1.setText("A");

        return convertView;
    }
}
