package com.example.mejrtt.jd_demo3.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.mejrtt.jd_demo3.R;

/**
 * Created by WANG123456 on 2017/10/11.
 */

public class Fragment_3 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=View.inflate(getActivity(), R.layout.fragment_3,null);
        WebView web_find= (WebView) view.findViewById(R.id.web_find);
        return view;
    }
}
