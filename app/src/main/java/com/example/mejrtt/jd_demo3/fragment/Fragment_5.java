package com.example.mejrtt.jd_demo3.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mejrtt.jd_demo3.R;

/**
 * Created by WANG123456 on 2017/10/11.
 */

public class Fragment_5 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getActivity(), R.layout.fragment_5,null);
        Button bt_dl= (Button) view.findViewById(R.id.bt_dl);
        bt_dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), com.example.mejrtt.jd_demo3.activity.LoginActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
