package demo.liufan.com.myapplication.wight;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;

import demo.liufan.com.myapplication.activity.SurfaceViewWaveActivity;

/**
 * Created by admin on 2018/12/8.
 */

public class SurfaceViewWaveTime extends SurfaceView implements SurfaceHolder.Callback{
    private  String TAG = "SurfaceViewTest";
    private Timer timer;
    SurfaceHolder holder;
    private MyTimerTask timerTask;
    //-----------------------------
    private final int HEIGHT = 800;
    // 要绘制的曲线的水平宽度
    private int WIDTH = 1000;
    // 离屏幕左边界的起始距离
    private final int X_OFFSET = 5;
    // 初始化X坐标
    private int cx = X_OFFSET;
    // 实际的Y轴的位置
    private int centerY = HEIGHT / 2;
    private int cy = 0;
    private int cz = 0;
    private int cxx = 0;

    private Canvas canvas;

    public SurfaceViewWaveTime(Context context) {
        super(context);
        init();
    }

    public SurfaceViewWaveTime(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        holder = getHolder();
        holder.addCallback(this);
        // 设置画布 背景透明
        holder.setFormat(PixelFormat.TRANSLUCENT);
        // --焦点设置----------------------------
        setFocusable(true);
        // 设置触屏
        setFocusableInTouchMode(true);
        // 设置常亮
        setKeepScreenOn(true);
        timer=new Timer();
        timerTask = new MyTimerTask();
    }
    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        timer.schedule(timerTask, 10, 50);
    }
    @Override
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {
    }
    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        timer.cancel();
        timer.purge();
    }

    class MyTimerTask extends TimerTask {
        Paint paint,xPaint,yPaint,zPaint;
        Canvas c = null;
        int deltax = 0;
        int count = 0;
        private Queue<Point> queue,xQueue,yQueue,zQueue;
        public MyTimerTask() {
            //坐标线
            paint = new Paint();
            paint.setColor(Color.BLACK);
            paint.setStyle(Paint.Style.STROKE);// 空心
            paint.setStrokeWidth(2);
            paint.setTextSize(25);

            //z线
            zPaint = new Paint();
            zPaint.setColor(Color.BLUE);
            zPaint.setStyle(Paint.Style.STROKE);// 空心
            zPaint.setStrokeWidth(4);
            zPaint.setTextSize(25);

            //x线
            xPaint = new Paint();
            xPaint.setColor(Color.RED);
            xPaint.setStyle(Paint.Style.STROKE);// 空心
            xPaint.setStrokeWidth(4);
            xPaint.setTextSize(25);

            //y线
            yPaint = new Paint();
            yPaint.setColor(Color.GREEN);
            yPaint.setStyle(Paint.Style.STROKE);// 空心
            yPaint.setStrokeWidth(4);
            yPaint.setTextSize(25);

            queue= new LinkedList<Point>();

            xQueue = new LinkedList<Point>();
            yQueue = new LinkedList<Point>();
            zQueue = new LinkedList<Point>();

        }
        @Override
        public void run() {

//            cy = (int) (Math.sin((cx - X_OFFSET) / 20f) * 300) + centerY;//正弦
            cy = centerY- SurfaceViewWaveActivity.getYNum()*10;
            cz = centerY-SurfaceViewWaveActivity.getZNum()*10;
            cxx = centerY-SurfaceViewWaveActivity.getXNum()*10;

            queue.add(new Point(cx, cz));
            yQueue.add(new Point(cx,cy));
            xQueue.add(new Point(cx,cxx));

            cx+=10;
            count++;

            if (cx > 1000) {
                deltax+=10;
                queue.poll();
                yQueue.poll();
                xQueue.poll();
            }
            if (count % 1 == 0) {

                // 提交修改
                canvas = holder.lockCanvas(new Rect(0, 0, HEIGHT,
                        WIDTH));
                canvas.drawColor(Color.WHITE);

                canvas.drawLine(0, centerY, WIDTH, centerY, paint);//x坐标线
                canvas.drawLine(100, 40, 100, HEIGHT, paint);//y坐标线

               /* for (int i=0;i<10;i++){
                    canvas.drawText(""+i*10,X_OFFSET+i*50,centerY,paint);//x坐标数字
                }*/

             /*   for (int i=1;i<9;i++){
                    canvas.drawText(""+(8-i)*10,110,i*50,paint);//y正数坐标数字
                    canvas.drawText("-"+i*10,110,HEIGHT/2+i*50,paint);//y负数坐标数字
                }*/
                for (int i=1;i<9;i++){
                    canvas.drawText(""+(8-i)*5,90,i*50,paint);//y正数坐标数字

                    canvas.drawText("-"+i*5,90,HEIGHT/2+i*50,paint);//y负数坐标数字ff
                }


                // 根据Ｘ，Ｙ坐标画点
                List<Point> list = (List<Point>) queue;
                List<Point> yList = (List<Point>)yQueue;
                List<Point> xList = (List<Point>)xQueue;
                Point prevX = xList.get(0);
                Point prevY = yList.get(0);
                Point prev = list.get(0);
                for (int i = 1; i < list.size(); i++) {
                    Point cur = list.get(i);
                    Point ycur = yList.get(i);
                    Point xcur = xList.get(i);
                    canvas.drawLine(prevX.x - deltax, prevX.y, xcur.x - deltax, xcur.y, xPaint);
                    canvas.drawLine(prevY.x - deltax, prevY.y, ycur.x - deltax, ycur.y, yPaint);
                    canvas.drawLine(prev.x - deltax, prev.y, cur.x - deltax, cur.y, zPaint);
                    prev = cur;
                    prevY = ycur;
                    prevX = xcur;

                }
                holder.unlockCanvasAndPost(canvas);
            }
        }

    }
}
