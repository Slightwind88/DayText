package demo.liufan.com.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import demo.liufan.com.myapplication.R;


/**
 * PopupWindow Item适配器
 *
 * @author sugy
 *         2016/11/24
 */
public class PopupWindowItemAdapter extends BaseAdapter {

    private Context context;
    private int[] imgs;
    private String[] texts;

    public PopupWindowItemAdapter(Context context, int[] imgs, String[] texts) {
        this.context = context;
        this.imgs = imgs;
        this.texts = texts;
    }

    @Override
    public int getCount() {
        return texts.length;
    }

    @Override
    public Object getItem(int position) {
        return texts[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = LayoutInflater.from(context).inflate(R.layout.item_select_dialog, null);
        TextView tv = (TextView) convertView;
        tv.setText(texts == null ? "" : texts[position]);
        tv.setCompoundDrawablesWithIntrinsicBounds(imgs == null ? 0 : imgs[position], 0, 0, 0);
        return convertView;
    }
}