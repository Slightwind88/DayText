package demo.liufan.com.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import demo.liufan.com.myapplication.R;
import demo.liufan.com.myapplication.bean.Home;
import demo.liufan.com.myapplication.utils.ToolUtils;

/**
 * Created by liufan on 2018/1/23.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>{

    private String[] mFruitList;
    private Context context;

     class ViewHolder extends RecyclerView.ViewHolder{
         ImageView fruitImage;

        public ViewHolder(View view){
            super(view);
            fruitImage = (ImageView) view.findViewById(R.id.textView1);

        }
    }

    public HomeAdapter(Context context, String[] fruitList){
         this.mFruitList = fruitList;
         this.context = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gridview,parent, false);
        ViewHolder holder = new ViewHolder(view);


        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        ToolUtils.setImage(context, mFruitList[position], holder.fruitImage);
    }

    @Override
    public int getItemCount() {
        return mFruitList.length;
    }
}
