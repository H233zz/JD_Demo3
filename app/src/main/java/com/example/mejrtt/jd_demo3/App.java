package com.example.mejrtt.jd_demo3;

import android.app.Application;

import org.xutils.x;

/**
 * Created by WANG123456 on 2017/10/11.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG);



    }
}
