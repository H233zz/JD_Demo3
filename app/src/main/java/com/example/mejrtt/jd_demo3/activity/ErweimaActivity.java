package com.example.mejrtt.jd_demo3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.example.mejrtt.jd_demo3.R;

/**
 * Created by WANG123456 on 2017/10/11.
 */

public class ErweimaActivity extends AppCompatActivity {
    private WebView wb_ewm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_erweima);
        Intent intent = getIntent();
        String ewm = intent.getStringExtra("ewm");
        wb_ewm= (WebView) findViewById(R.id.wb_ewm);
        wb_ewm.loadUrl(ewm);
    }
}
