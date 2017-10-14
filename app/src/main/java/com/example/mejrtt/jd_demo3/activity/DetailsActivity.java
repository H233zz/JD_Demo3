package com.example.mejrtt.jd_demo3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.mejrtt.jd_demo3.R;
import com.example.mejrtt.jd_demo3.adapter.ListAdapter;
import com.example.mejrtt.jd_demo3.bean.ListBean;
import com.example.mejrtt.jd_demo3.net.Api;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by WANG123456 on 2017/10/13.
 */

public class DetailsActivity extends AppCompatActivity {
    //商品列表页
    private TextView aaa;
    private int i=1;
    private Boolean isCheck=false;
    private String page=i+"";
    private String url= Api.SPLIST;
    private  String pscid;
    private ListAdapter adapter;
    private RadioButton horver;
    private RecyclerView listRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Intent intent = getIntent();
        pscid = intent.getStringExtra("gscid");
        initView();
        horver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isCheck=!isCheck;
                horver.setChecked(!isCheck);
                if(horver.isChecked()) {
                    GridLayoutManager mLayoutManager = new GridLayoutManager(DetailsActivity.this,2);
                    listRecyclerView.setLayoutManager(mLayoutManager);
                    listRecyclerView.setHasFixedSize(true);
                    adapter.notifyDataSetChanged();
                }else{
                    LinearLayoutManager mLayoutManager = new LinearLayoutManager(DetailsActivity.this);
                    listRecyclerView.setLayoutManager(mLayoutManager);
                    listRecyclerView.setHasFixedSize(true);
                    adapter.notifyDataSetChanged();
                }
            }
        });
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(DetailsActivity.this);
        listRecyclerView.setLayoutManager(mLayoutManager);
        listRecyclerView.setHasFixedSize(true);

        getdata();
    }
    public void getdata(){
        RequestParams params=new RequestParams(url);
        params.addBodyParameter("pscid",pscid);
        params.addBodyParameter("page",page);
        x.http().post(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                ListBean listBean = gson.fromJson(result, ListBean.class);
                adapter=new ListAdapter(listBean.getData(),DetailsActivity.this);
                listRecyclerView.setAdapter(adapter);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });


    }
    public void initView(){
        listRecyclerView= (RecyclerView) findViewById(R.id.list_RecyclerView);
        horver= (RadioButton) findViewById(R.id.horver);
    }
}
