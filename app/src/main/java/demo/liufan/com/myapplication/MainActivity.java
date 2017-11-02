package demo.liufan.com.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import demo.liufan.com.myapplication.activity.ADRollUDActivity;
import demo.liufan.com.myapplication.activity.DiaLog;
import demo.liufan.com.myapplication.activity.FlowLayoutActivity;
import demo.liufan.com.myapplication.activity.RollingAdvertisement;
import demo.liufan.com.myapplication.activity.TabViewExcelActivity;
import demo.liufan.com.myapplication.listener.DialogUIListener;
import demo.liufan.com.myapplication.utils.SnackbarUtil;
import demo.liufan.com.myapplication.wight.BottomMenuDialog;
import demo.liufan.com.myapplication.wight.DialogUIUtils;

public class MainActivity extends AppCompatActivity {

    private BottomMenuDialog d5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_main);

    }

    public void onClick_Event_listMenu(View view){
        startActivity(new Intent(this, ListViewMenuActivity.class));
    }

    public void onClick_Event_DiaLog(View view){
        startActivity(new Intent(this, DiaLog.class));
    }

    public void onClick_Event_3(View view){
        startActivity(new Intent(this, RollingAdvertisement.class));
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
                        data.setData(Uri.parse("mailto:670236133@qq.com"));
                        data.putExtra(Intent.EXTRA_SUBJECT, "这是标题");
                        data.putExtra(Intent.EXTRA_TEXT, "这是内容");
                        startActivity(data);
                    }
                }).create();

        d5.show();
    }
}
