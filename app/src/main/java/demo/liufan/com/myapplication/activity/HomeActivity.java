package demo.liufan.com.myapplication.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import demo.liufan.com.myapplication.R;
import demo.liufan.com.myapplication.adapter.HomeAdapter;
import demo.liufan.com.myapplication.wight.SpaceItemDecoration;

/**
 * Created by liufan on 2017/10/26.
 */

public class HomeActivity extends Activity {

    @BindView(R.id.recycleview)
    private RecyclerView recycleview;

    private boolean onButton;
    private  HomeAdapter homeAdapter;


    private String[] img = {"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516723534071&di=1085691c75883aa915433e25220d5153&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dpixel_huitu%252C0%252C0%252C294%252C40%2Fsign%3Decfe83b9042442a7ba03f5e5b83bc827%2F728da9773912b31bc2fe74138d18367adab4e17e.jpg"
    ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516723534071&di=737cb3dfad36aef57cdaab53a3445b20&imgtype=0&src=http%3A%2F%2Fimage.tianjimedia.com%2FuploadImages%2F2015%2F209%2F42%2F6H182F668EP9.jpg"
    ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516723534071&di=27cc380be4b4d0fefbf4bdd6a48ef9aa&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fe1fe9925bc315c600dce09d386b1cb13495477b6.jpg"
    ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516723534070&di=f8b692e58150ffb6a975b1c8b896bf49&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fdbb44aed2e738bd41f16dd0daa8b87d6277ff9d3.jpg"
    ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516723534070&di=4caf68210f9d6a33deedc445a4379c69&imgtype=0&src=http%3A%2F%2Fimg.tupianzj.com%2Fuploads%2FBizhi%2Fmn53_12802.jpg"
    ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516723534070&di=725796730f34e477c4fb011161930989&imgtype=0&src=http%3A%2F%2Fpic.jj20.com%2Fup%2Fallimg%2F811%2F0525141A139%2F1405251A139-0.jpg"
    ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516723534071&di=1085691c75883aa915433e25220d5153&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dpixel_huitu%252C0%252C0%252C294%252C40%2Fsign%3Decfe83b9042442a7ba03f5e5b83bc827%2F728da9773912b31bc2fe74138d18367adab4e17e.jpg"
            ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516723534071&di=737cb3dfad36aef57cdaab53a3445b20&imgtype=0&src=http%3A%2F%2Fimage.tianjimedia.com%2FuploadImages%2F2015%2F209%2F42%2F6H182F668EP9.jpg"
            ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516723534071&di=27cc380be4b4d0fefbf4bdd6a48ef9aa&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fe1fe9925bc315c600dce09d386b1cb13495477b6.jpg"
            ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516723534070&di=f8b692e58150ffb6a975b1c8b896bf49&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fdbb44aed2e738bd41f16dd0daa8b87d6277ff9d3.jpg"
            ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516723534070&di=4caf68210f9d6a33deedc445a4379c69&imgtype=0&src=http%3A%2F%2Fimg.tupianzj.com%2Fuploads%2FBizhi%2Fmn53_12802.jpg"
            ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516723534070&di=725796730f34e477c4fb011161930989&imgtype=0&src=http%3A%2F%2Fpic.jj20.com%2Fup%2Fallimg%2F811%2F0525141A139%2F1405251A139-0.jpg"
    ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516723534071&di=1085691c75883aa915433e25220d5153&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dpixel_huitu%252C0%252C0%252C294%252C40%2Fsign%3Decfe83b9042442a7ba03f5e5b83bc827%2F728da9773912b31bc2fe74138d18367adab4e17e.jpg"
            ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516723534071&di=737cb3dfad36aef57cdaab53a3445b20&imgtype=0&src=http%3A%2F%2Fimage.tianjimedia.com%2FuploadImages%2F2015%2F209%2F42%2F6H182F668EP9.jpg"
            ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516723534071&di=27cc380be4b4d0fefbf4bdd6a48ef9aa&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fe1fe9925bc315c600dce09d386b1cb13495477b6.jpg"
            ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516723534070&di=f8b692e58150ffb6a975b1c8b896bf49&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fdbb44aed2e738bd41f16dd0daa8b87d6277ff9d3.jpg"
            ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516723534070&di=4caf68210f9d6a33deedc445a4379c69&imgtype=0&src=http%3A%2F%2Fimg.tupianzj.com%2Fuploads%2FBizhi%2Fmn53_12802.jpg"
            ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516723534070&di=725796730f34e477c4fb011161930989&imgtype=0&src=http%3A%2F%2Fpic.jj20.com%2Fup%2Fallimg%2F811%2F0525141A139%2F1405251A139-0.jpg"
    ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516723534071&di=1085691c75883aa915433e25220d5153&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dpixel_huitu%252C0%252C0%252C294%252C40%2Fsign%3Decfe83b9042442a7ba03f5e5b83bc827%2F728da9773912b31bc2fe74138d18367adab4e17e.jpg"
            ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516723534071&di=737cb3dfad36aef57cdaab53a3445b20&imgtype=0&src=http%3A%2F%2Fimage.tianjimedia.com%2FuploadImages%2F2015%2F209%2F42%2F6H182F668EP9.jpg"
            ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516723534071&di=27cc380be4b4d0fefbf4bdd6a48ef9aa&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fe1fe9925bc315c600dce09d386b1cb13495477b6.jpg"
            ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516723534070&di=f8b692e58150ffb6a975b1c8b896bf49&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fdbb44aed2e738bd41f16dd0daa8b87d6277ff9d3.jpg"
            ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516723534070&di=4caf68210f9d6a33deedc445a4379c69&imgtype=0&src=http%3A%2F%2Fimg.tupianzj.com%2Fuploads%2FBizhi%2Fmn53_12802.jpg"
            ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516723534070&di=725796730f34e477c4fb011161930989&imgtype=0&src=http%3A%2F%2Fpic.jj20.com%2Fup%2Fallimg%2F811%2F0525141A139%2F1405251A139-0.jpg",
            "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516723534071&di=1085691c75883aa915433e25220d5153&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dpixel_huitu%252C0%252C0%252C294%252C40%2Fsign%3Decfe83b9042442a7ba03f5e5b83bc827%2F728da9773912b31bc2fe74138d18367adab4e17e.jpg"
            ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516723534071&di=737cb3dfad36aef57cdaab53a3445b20&imgtype=0&src=http%3A%2F%2Fimage.tianjimedia.com%2FuploadImages%2F2015%2F209%2F42%2F6H182F668EP9.jpg"
            ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516723534071&di=27cc380be4b4d0fefbf4bdd6a48ef9aa&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fe1fe9925bc315c600dce09d386b1cb13495477b6.jpg"
            ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516723534070&di=f8b692e58150ffb6a975b1c8b896bf49&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fdbb44aed2e738bd41f16dd0daa8b87d6277ff9d3.jpg"
            ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516723534070&di=4caf68210f9d6a33deedc445a4379c69&imgtype=0&src=http%3A%2F%2Fimg.tupianzj.com%2Fuploads%2FBizhi%2Fmn53_12802.jpg"
            ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516723534070&di=725796730f34e477c4fb011161930989&imgtype=0&src=http%3A%2F%2Fpic.jj20.com%2Fup%2Fallimg%2F811%2F0525141A139%2F1405251A139-0.jpg"
    ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516723534071&di=1085691c75883aa915433e25220d5153&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimage%2Fc0%253Dpixel_huitu%252C0%252C0%252C294%252C40%2Fsign%3Decfe83b9042442a7ba03f5e5b83bc827%2F728da9773912b31bc2fe74138d18367adab4e17e.jpg"
            ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516723534071&di=737cb3dfad36aef57cdaab53a3445b20&imgtype=0&src=http%3A%2F%2Fimage.tianjimedia.com%2FuploadImages%2F2015%2F209%2F42%2F6H182F668EP9.jpg"
            ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516723534071&di=27cc380be4b4d0fefbf4bdd6a48ef9aa&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fe1fe9925bc315c600dce09d386b1cb13495477b6.jpg"
            ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516723534070&di=f8b692e58150ffb6a975b1c8b896bf49&imgtype=0&src=http%3A%2F%2Fimgsrc.baidu.com%2Fimgad%2Fpic%2Fitem%2Fdbb44aed2e738bd41f16dd0daa8b87d6277ff9d3.jpg"
            ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516723534070&di=4caf68210f9d6a33deedc445a4379c69&imgtype=0&src=http%3A%2F%2Fimg.tupianzj.com%2Fuploads%2FBizhi%2Fmn53_12802.jpg"
            ,"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1516723534070&di=725796730f34e477c4fb011161930989&imgtype=0&src=http%3A%2F%2Fpic.jj20.com%2Fup%2Fallimg%2F811%2F0525141A139%2F1405251A139-0.jpg"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        recycleview = (RecyclerView)findViewById(R.id.recycleview);

        homeAdapter = new HomeAdapter(this, img);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recycleview.setLayoutManager(gridLayoutManager);
        recycleview.addItemDecoration(new SpaceItemDecoration(10) );
        recycleview.setAdapter(homeAdapter);

     /*   tv_layout = (TextView) findViewById(R.id.tv_layout);


        tv_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/


    }


    @OnClick(R.id.tv_layout)
    public void onclinck(){

        if (!onButton){
            onButton = true;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(HomeActivity.this);
            recycleview.setLayoutManager(linearLayoutManager);
            homeAdapter.notifyDataSetChanged();
        }else{
            onButton = false;
            GridLayoutManager gridLayoutManager = new GridLayoutManager(HomeActivity.this, 2);
            recycleview.setLayoutManager(gridLayoutManager);
            homeAdapter.notifyDataSetChanged();
        }
    }

}
