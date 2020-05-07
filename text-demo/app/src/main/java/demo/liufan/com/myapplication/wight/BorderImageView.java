package demo.liufan.com.myapplication.wight;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import demo.liufan.com.myapplication.R;

/**
 * Created by liufan on 2018/2/7.
 */

public class BorderImageView extends ImageView implements ViewTreeObserver.OnGlobalLayoutListener{

    private static final boolean DEBUG = true;
    private boolean once;
    private Matrix matrix;

    public BorderImageView(Context context) {
        this(context, null);
    }

    public BorderImageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BorderImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        once = true;
        matrix = new Matrix();
        setScaleType(ScaleType.MATRIX);
    }

    @Override
    protected void onAttachedToWindow() {
        getViewTreeObserver().addOnGlobalLayoutListener(this);
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        getViewTreeObserver().removeOnGlobalLayoutListener(this);
        super.onDetachedFromWindow();
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 画边框
        Rect rec = canvas.getClipBounds();
        rec.bottom--;
        rec.right--;
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.img_e0e0e0));
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawRect(rec, paint);
    }

    @Override
    public void onGlobalLayout() {
        if (once) {

            // 1.view wh
            int width = getWidth();
            int height = getHeight();
            // 2. d dw dh
            Drawable drawable = getDrawable();
            if (drawable == null) {
                return;
            }
            if (DEBUG) {
                System.out.println("drawable:" + drawable);
            }
            int dw = drawable.getIntrinsicWidth();
            int dh = drawable.getIntrinsicHeight();
            // first trans
            float dx = width * 1.0f / 2 - dw * 1.0f / 2;
            float dy = height * 1.0f / 2 - dh * 1.0f / 2;
            matrix.postTranslate(dx, dy);
            // second scale
            float scale = 1.0f;
            if (dw > width && dh < height) {
                scale = height * 1.0f / dh;// bigger
            }
            if (dw < width && dh > height) {
                scale = width * 1.0f / dw;// bigger
            }

            if (dw < width && dh < height) {
                float sh = height * 1.0f / dh;
                float sw = width * 1.0f / dw;
                scale = Math.max(sw, sh);
                System.out.println("case3:"+sw+"--"+sh+"==="+scale);
            }
            if (dw > width && dh > height) {
                float sw = width * 1.0f / dw;
                float sh = height * 1.0f / dh;
                scale = Math.max(sw, sh);
                System.out.println("case4:"+sw+"--"+sh+"==="+scale);
            }

            if (DEBUG) {
                System.out.println("scale:" + scale);
            }
            matrix.postScale(scale, scale, width / 2, height / 2);
            setImageMatrix(matrix);
            once = false;
        }
    }
}
