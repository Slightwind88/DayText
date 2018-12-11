package demo.liufan.com.myapplication;

import android.Manifest;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.logging.Logger;

import demo.liufan.com.myapplication.activity.ADRollUDActivity;
import demo.liufan.com.myapplication.activity.FlowLayoutActivity;
import demo.liufan.com.myapplication.activity.HomeActivity;
import demo.liufan.com.myapplication.activity.IndicatorActivity;
import demo.liufan.com.myapplication.activity.InquiryQuotationActivity;
import demo.liufan.com.myapplication.activity.MyGridView;
import demo.liufan.com.myapplication.activity.TabViewExcelActivity;
import demo.liufan.com.myapplication.listener.DialogUIListener;
import demo.liufan.com.myapplication.service.TextService;
import demo.liufan.com.myapplication.utils.SnackbarUtil;
import demo.liufan.com.myapplication.wight.BorderImageView;
import demo.liufan.com.myapplication.wight.BottomMenuDialog;
import demo.liufan.com.myapplication.wight.DialogUIUtils;

public class MainActivity extends Activity{

    private static final String TAG = "MainActivity";

    private BottomMenuDialog d5;
    private LinearLayout linear;
    private BorderImageView iv_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_main);

        linear = (LinearLayout)findViewById(R.id.linear);
        iv_img = (BorderImageView)findViewById(R.id.iv_img);

        iv_img.setBackgroundResource(R.mipmap.shoes);


        startService(new Intent(this, TextService.class));

    }

    public void onClick_Event_listMenu(View view){
        startActivity(new Intent(this, ListViewMenuActivity.class));
    }

    public void onClick_Event_DiaLog(View view){
        startActivity(new Intent(this, HomeActivity.class));
    }

    public void onClick_Event_3(View view){
        startActivity(new Intent(this, InquiryQuotationActivity.class));
    }

    public void onClick_Event_4(View view){
        startActivity(new Intent(this, TabViewExcelActivity.class));
    }

    public void onClick_Event_5(View view){
        startActivity(new Intent(this, FlowLayoutActivity.class));
    }

    public void onClick_Event_6(View view){
        startActivity(new Intent(this, ADRollUDActivity.class));
    }
    public void onClick_Event_7(final View view){



        d5 = new BottomMenuDialog.Builder(MainActivity.this)
                .setTitle("请选择")
                .addMenu("下载商务报价单", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        d5.dismiss();
                        SnackbarUtil.ShortSnackbar(view,"下载商务报价单",SnackbarUtil.Info);
                    }
                }).addMenu("下载对外报价单", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        DialogUIUtils.showAlert(MainActivity.this,"确认催办", "", "请输入催办理由", "取消", "确认", true, true, true, new DialogUIListener() {
                            @Override
                            public void onPositive() {
                            }

                            @Override
                            public void onNegative() {

                            }

                            @Override
                            public void onGetInput(CharSequence input2) {
                                super.onGetInput(input2);
                                Toast.makeText(MainActivity.this,input2 + "".toString(),Toast.LENGTH_SHORT).show();
                            }
                        }).show();

                    }
                }).addMenu("邮件发送对外报价单", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        d5.dismiss();
                        Intent data=new Intent(Intent.ACTION_SENDTO);
                        data.setData(Uri.parse("mailto:"));
                        data.putExtra(Intent.EXTRA_SUBJECT, "");
                        data.putExtra(Intent.EXTRA_TEXT, "");
                        startActivity(data);
                    }
                }).create();

        d5.show();

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale_anim);

        animation.setFillAfter(true);
        linear.startAnimation(animation);
    }

    public void onClick_Event_8(final View view){
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);
        }

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 2);
            getReadContacts();
        }
        Intent intent = new Intent("demo.liufan.com.myapplication");
        sendBroadcast(intent);
    }

    public void onClick_Event_9(View view){
        startActivity(new Intent(this, IndicatorActivity.class));
    }

    private void getReadContacts() {
        Cursor cursor = null;
        try{
            cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
            if (cursor != null){
                while (cursor.moveToNext()){
                    String displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                    String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    Log.i(TAG, "displayName: "+displayName+"............"+"number"+number);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode){
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){

                }else{

                }
            case 2:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){

                }else{

                }
        }
    }
}
