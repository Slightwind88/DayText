package demo.liufan.com.myapplication.wight;

import android.app.Dialog;
import android.content.Context;

import demo.liufan.com.myapplication.R;

/**
 * Created by liufan on 2018/2/28.
 */

public class MyBottomDialog extends Dialog{

    private Context context;

    public MyBottomDialog(Context context, int theme){
        super(context, theme);
        this.context = context;
        initView();
    }

    public MyBottomDialog(Context context){
        this(context, R.style.BottomDialog);
    }

    private void initView(){

    }
}
