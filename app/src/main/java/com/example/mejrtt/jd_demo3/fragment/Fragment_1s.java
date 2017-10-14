package com.example.mejrtt.jd_demo3.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.mejrtt.jd_demo3.R;
import com.example.mejrtt.jd_demo3.adapter.Gvadapter;
import com.example.mejrtt.jd_demo3.bean.Fenlei_bean;
import com.example.mejrtt.jd_demo3.net.Api;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WANG123456 on 2017/10/11.
 */

public class Fragment_1s extends Fragment {
    private List<String> list;
    private List<String> listimg;
    private GridView gv;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getActivity(), R.layout.item1,null);
        gv= (GridView) view.findViewById(R.id.gv);
        RequestParams params=new RequestParams(Api.FENLEI);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Gson gson=new Gson();
                Fenlei_bean bean = gson.fromJson(result, Fenlei_bean.class);
                list=new ArrayList<String>();
                listimg=new ArrayList<String>();
                for(int i=0;i<10;i++){
                    list.add(bean.getData().get(i).getName());
                    listimg.add(bean.getData().get(i).getIcon());
                }
                Gvadapter myadapter=new Gvadapter(listimg,list,getActivity());
                gv.setAdapter(myadapter);
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

        return view;
    }
}
