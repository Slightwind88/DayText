package demo.liufan.com.myapplication.wight;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import demo.liufan.com.myapplication.R;


/**
 * 对话框
 *
 * @author sugy
 */
public class MyDialog extends Dialog {

    private TextView tvTitle, tvMessage;

    private Button leftBtn, rightBtn;

    private FrameLayout frameLayout;

    private Context context;

    public MyDialog(Context context, int theme) {
        super(context, theme);
        this.context = context;
        initView();
    }

    public MyDialog(Context context) {
        this(context, R.style.DialogStyle);
    }

    private void initView() {
        setContentView(R.layout.my_dialog);
        tvTitle = (TextView) findViewById(R.id.d_title);
        tvMessage = (TextView) findViewById(R.id.d_message);
        leftBtn = (Button) findViewById(R.id.d_left_btn);
        rightBtn = (Button) findViewById(R.id.d_right_btn);
        frameLayout = (FrameLayout) findViewById(R.id.custom_view);

        setTitle(R.string.tip);
        setLeftButton(android.R.string.cancel, new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        setRightButton(android.R.string.ok, new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        setCanceledOnTouchOutside(true);

    }

    /**
     * 设置自定义view
     *
     * @param viewLayoutId
     * @return
     */
    public void setCustomView(int viewLayoutId) {
        frameLayout.setVisibility(View.VISIBLE);
        tvMessage.setVisibility(View.GONE);
        View.inflate(context, viewLayoutId, frameLayout);
    }

    /**
     * 隐藏左边按钮
     */
    public void setOneBtn() {
        leftBtn.setVisibility(View.GONE);
        rightBtn.setBackgroundResource(R.drawable.selector_my_dialog_one_btn);
        findViewById(R.id.line_view).setVisibility(View.GONE);
    }

    /**
     * 设置标题 {@inheritDoc}
     */
    @Override
    public void setTitle(int titleId) {
        tvTitle.setText(titleId);
    }

    /**
     * 设置标题 {@inheritDoc}
     */
    @Override
    public void setTitle(CharSequence title) {
        tvTitle.setText(title);
    }

    /**
     * 获取标题
     *
     * @return
     */
    public CharSequence getTitle() {
        return tvTitle.getText();
    }

    /**
     * 设置显示内容
     *
     * @param messageId
     */
    public void setMessage(int messageId) {
        tvMessage.setText(messageId);
    }

    /**
     * 设置显示内容
     *
     * @param message
     */
    public void setMessage(CharSequence message) {
        tvMessage.setText(message);
    }

    /**
     * 设置左侧按钮事件
     *
     * @param clickListener
     */
    public void setLeftButton(View.OnClickListener clickListener) {
        leftBtn.setOnClickListener(clickListener);
    }

    /**
     * 设置左侧按钮文字和事件
     *
     * @param textResId
     * @param clickListener
     */
    public void setLeftButton(int textResId,
                              View.OnClickListener clickListener) {
        leftBtn.setText(textResId);
        leftBtn.setOnClickListener(clickListener);
    }

    /**
     * 设置左侧按钮文字和事件
     *
     * @param text
     * @param clickListener
     */
    public void setLeftButton(CharSequence text,
                              View.OnClickListener clickListener) {
        leftBtn.setText(text);
        leftBtn.setOnClickListener(clickListener);
    }

    /**
     * 设置右侧按钮事件
     *
     * @param clickListener
     */
    public void setRightButton(View.OnClickListener clickListener) {
        rightBtn.setOnClickListener(clickListener);
    }

    /**
     * 设置右侧按钮文字和事件
     *
     * @param textResId
     * @param clickListener
     */
    public void setRightButton(int textResId,
                               View.OnClickListener clickListener) {
        rightBtn.setText(textResId);
        rightBtn.setOnClickListener(clickListener);
    }

    /**
     * 设置右侧按钮文字，字体颜色和事件
     *
     * @param text
     * @param clickListener
     */
    public void setRightButton(CharSequence text, String colors,
                               View.OnClickListener clickListener) {
        rightBtn.setText(text);
        rightBtn.setTextColor(Color.parseColor(colors));
        rightBtn.setOnClickListener(clickListener);
    }


}
