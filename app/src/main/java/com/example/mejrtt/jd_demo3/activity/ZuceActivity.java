package com.example.mejrtt.jd_demo3.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mejrtt.jd_demo3.R;
import com.example.mejrtt.jd_demo3.bean.UserBean;
import com.example.mejrtt.jd_demo3.net.Api;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by WANG123456 on 2017/10/11.
 */

public class ZuceActivity extends AppCompatActivity{
    private EditText name;
    private EditText pwd;
    private Button zuce;
    private String url= Api.ZUCE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zuce);
        name= (EditText) findViewById(R.id.zuce_name);
        pwd= (EditText) findViewById(R.id.zuce_pwd);
        zuce= (Button) findViewById(R.id.zuce_zuce);
        zuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestParams params=new RequestParams(url);
                params.addBodyParameter("mobile",name.getText().toString());
                params.addBodyParameter("password",pwd.getText().toString());
                x.http().post(params, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Gson gson=new Gson();
                        UserBean userBean = gson.fromJson(result, UserBean.class);
                        String msg = userBean.getMsg();
                        Toast.makeText(ZuceActivity.this,msg,Toast.LENGTH_SHORT).show();
                        if(userBean.getCode().equals("0")){
                            finish();
                        }
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
        });




    }
}
