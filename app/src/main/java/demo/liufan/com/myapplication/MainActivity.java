package demo.liufan.com.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import demo.liufan.com.myapplication.activity.ADRollUDActivity;
import demo.liufan.com.myapplication.activity.FlowLayoutActivity;
import demo.liufan.com.myapplication.activity.InquiryQuotationActivity;
import demo.liufan.com.myapplication.activity.MyGridView;
import demo.liufan.com.myapplication.activity.TabViewExcelActivity;
import demo.liufan.com.myapplication.listener.DialogUIListener;
import demo.liufan.com.myapplication.utils.SnackbarUtil;
import demo.liufan.com.myapplication.wight.BottomMenuDialog;
import demo.liufan.com.myapplication.wight.DialogUIUtils;

public class MainActivity extends Activity {

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
        startActivity(new Intent(this, MyGridView.class));
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
    }
}
