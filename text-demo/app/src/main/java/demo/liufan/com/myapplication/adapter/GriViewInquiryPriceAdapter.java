package demo.liufan.com.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import demo.liufan.com.myapplication.R;

/**
 * Created by liufan on 2017/11/25.
 */

public class GriViewInquiryPriceAdapter extends BaseAdapter{

    private Context context;
    private List<String> mListData = new ArrayList();
    private TextView tv_inquiryname;

    public GriViewInquiryPriceAdapter(Context context) {
        this.context = context;
    }

    public GriViewInquiryPriceAdapter(Context context, List<String> mListData) {
        this.context = context;
        this.mListData = mListData;
    }

    @Override
    public int getCount() {
        return mListData.size();
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
            convertView = LayoutInflater.from(context).inflate(R.layout.item_inquiry_qutedprice, parent, false);

        tv_inquiryname =(TextView) convertView.findViewById(R.id.tv_inquiryname);

        tv_inquiryname.setText(position+mListData.get(position));


        return convertView;
    }

}
