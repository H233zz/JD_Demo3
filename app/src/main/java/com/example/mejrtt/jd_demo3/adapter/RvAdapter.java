package com.example.mejrtt.jd_demo3.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.mejrtt.jd_demo3.R;
import com.example.mejrtt.jd_demo3.bean.Shouye_bean;

import java.util.List;

/**
 * Created by WANG123456 on 2017/10/11.
 */

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHolder> {
    public List<Shouye_bean.MiaoshaBean.ListBeanX> datas;
    private Context context;



    public RvAdapter(Context context, List<Shouye_bean.MiaoshaBean.ListBeanX> datas) {
        this.datas = datas;
        this.context = context;
    }
    //创建新View，被LayoutManager所调用
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recler_item,viewGroup,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }
    //将数据与界面进行绑定的操作
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.ms_price.setText(datas.get(position).getPrice()+"");
        Glide.with(context).load("https://m.360buyimg.com/n0/jfs/t9106/106/1785172479/537280/253bc0ab/59bf78a7N057e5ff7.jpg").into(viewHolder.ms_img);

    }
    //获取数据的数量
    @Override
    public int getItemCount() {
        return datas.size();
    }
    //自定义的ViewHolder，持有每个Item的的所有界面元素
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView ms_price;
        public ImageView ms_img;
        public ViewHolder(View view){
            super(view);
            ms_price = (TextView) view.findViewById(R.id.ms_price);
            ms_img = (ImageView) view.findViewById(R.id.ms_img);

        }
    }
}
