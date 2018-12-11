package demo.liufan.com.myapplication.activity;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;
import android.widget.TextView;

import demo.liufan.com.myapplication.R;
import demo.liufan.com.myapplication.wight.SurfaceViewWaveTime;

/**
 * Created by admin on 2018/12/8.
 */

public class SurfaceViewWaveActivity extends Activity implements SensorEventListener {

    private SensorManager mSensorManager;
    public static int numValue,numXValue,numYValue,numZValue;
    private TextView tv_sensor,tv_min_max;
    private SurfaceViewWaveTime surfaceview_wave;
    private FrameLayout framelayout;

    private int xMin = 0;
    private int xMax = 0;
    private int yMin = 0;
    private int yMax = 0;
    private int zMin = 0;
    private int zMax = 0;
    private int valueMin = 0;
    private int valueMax = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_sensor_wave);
        init();

    }

    private void init() {
        tv_sensor = (TextView)findViewById(R.id.tv_sensor1);
        framelayout = (FrameLayout)findViewById(R.id.framelayout);

        surfaceview_wave = new SurfaceViewWaveTime(this);
        framelayout.addView(surfaceview_wave);

        //获取传感器SensorManager对象
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        //加速度传感器
        mSensorManager.registerListener(this,
                mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),//传感器TYPE类型
                SensorManager.SENSOR_DELAY_UI);//采集频率
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (Sensor.TYPE_ACCELEROMETER == event.sensor.getType()){
            setXNum((int)event.values[0]);
            setYNum((int)event.values[1]);
            setZNum((int)event.values[2]);
            int valueNum = (int)Math.sqrt(event.values[0]*event.values[0]+event.values[1]*event.values[1]+event.values[2]*event.values[2]);

            //x的最大最小值
            if (xMin>event.values[0]){
                xMin = (int)event.values[0];
            }
            if (xMax<event.values[0]){
                xMax = (int)event.values[0];
            }

            //y最大最小值
            if (yMin>event.values[0]){
                yMin = (int)event.values[0];
            }
            if (yMax<event.values[0]){
                yMax = (int)event.values[0];
            }

            //z最大最小值
            if (zMin>event.values[0]){
                zMin = (int)event.values[0];
            }
            if (zMax<event.values[0]){
                zMax = (int)event.values[0];
            }

            //阈值最大最小值
            if (valueMin>event.values[0]){
                valueMin = (int)event.values[0];
            }
            if (valueMax<event.values[0]){
                valueMax = (int)event.values[0];
            }

            tv_sensor.setText("加速度"+"\n"+"x : "+event.values[0]+"\n"+"y : "+event.values[1]+"\n"+"z ："+event.values[2]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public static int getXNum(){
        return numXValue;
    }

    public static  void setXNum(int num){
        numXValue = num;
    }

    public static int getYNum(){
        return numYValue;
    }

    public static  void setYNum(int num){
        numYValue = num;
    }

    public static int getZNum(){
        return numZValue;
    }

    public static  void setZNum(int num){
        numZValue = num;
    }
}
