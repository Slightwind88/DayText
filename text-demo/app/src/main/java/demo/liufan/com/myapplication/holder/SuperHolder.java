package demo.liufan.com.myapplication.holder;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.view.View;

import demo.liufan.com.myapplication.bean.BuildBean;

/**
 * Created by liufan on 2017/11/1.
 */

public abstract class SuperHolder {
    public View rootView;

    public SuperHolder(Context context) {
        rootView = View.inflate(context, setLayoutRes(), null);
        findViews();
    }

    protected abstract void findViews();

    protected abstract

    @LayoutRes
    int setLayoutRes();

    /**
     * 一般情况下，实现这个方法就足够了
     *
     * @param context
     * @param bean
     */
    public abstract void assingDatasAndEvents(Context context, BuildBean bean);
}
