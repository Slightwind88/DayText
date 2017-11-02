package demo.liufan.com.myapplication.listener;

/**
 * Created by liufan on 2017/11/2.
 */

public abstract class DialogUIItemListener {

    /**
     * item点击事件
     */
    public abstract void onItemClick(CharSequence text, int position);

    /**
     * 底部点击事件
     */
    public void onBottomBtnClick() {
    }
}
