package demo.liufan.com.myapplication.wight;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;

import demo.liufan.com.myapplication.R;
import demo.liufan.com.myapplication.adapter.PopupWindowItemAdapter;


/**
 * 自定义PopupWindow
 *
 * @author sugy
 *         2017/6/9
 */

public class MyPopupWindow extends PopupWindow {

    private Context context;

    private int[] imgResIds;

    private String[] texts;
    private ListView selectLv;

    public MyPopupWindow(Context context, int[] imgResIds, String[] texts) {
        this(context, null, imgResIds, texts);
    }

    public MyPopupWindow(Context context, AttributeSet attrs, int[] imgResIds, String[] texts) {
        super(context, attrs);
        this.context = context;
        this.imgResIds = imgResIds;
        this.texts = texts;
        init();
    }

    /**
     * 初始化
     */
    private void init() {

        View contentView = LayoutInflater.from(context).inflate(R.layout.select_dialog, null);
        contentView.setBackgroundResource(R.drawable.circle_add_tck);
        final int width = context.getResources().getDimensionPixelSize(R.dimen.popwindow_width);
        setWidth(width);
        setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        setBackgroundDrawable(new BitmapDrawable());
        setFocusable(true);
        setOutsideTouchable(true);

        selectLv = (ListView) contentView.findViewById(R.id.select_lv);
        selectLv.setAdapter(new PopupWindowItemAdapter(context, imgResIds, texts));
        setContentView(contentView);

        update();
    }

    /**
     * 设置item点击事件
     *
     * @param itemClickListener
     */
    public void setOnItemClickListener(AdapterView.OnItemClickListener itemClickListener) {
        if (selectLv != null)
            selectLv.setOnItemClickListener(itemClickListener);
    }


    /**
     * 显示或隐藏
     *
     * @param parent
     */
    public void showPopupWindow(View parent) {
        if (!isShowing()) {
            showAsDropDown(parent, 0, 0);
        } else {
            dismiss();
        }
    }

    /**
     * 设置宽度减半
     */
    public void setHalfWidth() {
        final int width = context.getResources().getDimensionPixelSize(R.dimen.popwindow_width);
        setWidth(width / 3 * 2);
        update();
    }

}
