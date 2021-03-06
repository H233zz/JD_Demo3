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

public class TjAdapter extends RecyclerView.Adapter<TjAdapter.ViewHolder>{
public List<Shouye_bean.TuijianBean.ListBean> datas;
private Context context;

public TjAdapter(Context context, List<Shouye_bean.TuijianBean.ListBean> datas) {
        this.datas = datas;
        this.context = context;
        }
//创建新View，被LayoutManager所调用
@Override
public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.reclertj_item,viewGroup,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
        }
//将数据与界面进行绑定的操作
@Override
public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.tj_price.setText(datas.get(position).getBargainPrice()+"");
        viewHolder.tj_name.setText(datas.get(position).getSubhead());
        Glide.with(context).load("https://m.360buyimg.com/n0/jfs/t6130/97/1370670410/180682/1109582a/593276b1Nd81fe723.jpg").into(viewHolder.tj_img);

        }
//获取数据的数量
@Override
public int getItemCount() {
        return datas.size();
        }
//自定义的ViewHolder，持有每个Item的的所有界面元素
public static class ViewHolder extends RecyclerView.ViewHolder {
    public TextView tj_price;
    public TextView tj_name;

    public ImageView tj_img;
    public ViewHolder(View view){
        super(view);
        tj_price = (TextView) view.findViewById(R.id.tj_price);
        tj_name = (TextView) view.findViewById(R.id.tj_name);

        tj_img = (ImageView) view.findViewById(R.id.tj_img);

    }
}
}
