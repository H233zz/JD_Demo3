package com.example.mejrtt.jd_demo3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mejrtt.jd_demo3.R;
import com.example.mejrtt.jd_demo3.bean.UserBean;
import com.example.mejrtt.jd_demo3.model.LoginModel;
import com.example.mejrtt.jd_demo3.net.Api;
import com.google.gson.Gson;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by WANG123456 on 2017/10/11.
 */

public class LoginActivity extends AppCompatActivity {
    private EditText loginname;
    private EditText loginpwd;
    private TextView zuce;
    private Button login;
    private String url= Api.DENGLU;
    private LoginModel mLoginModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        loginname= (EditText) findViewById(R.id.loginname);
        loginpwd= (EditText) findViewById(R.id.loginpwd);
        zuce= (TextView) findViewById(R.id.zuce);
        login= (Button) findViewById(R.id.login);
        zuce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten=new Intent(LoginActivity.this,ZuceActivity.class);
                startActivity(inten);
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RequestParams params=new RequestParams(url);
                params.addBodyParameter("mobile",loginname.getText().toString());
                params.addBodyParameter("password",loginpwd.getText().toString());
                x.http().post(params, new Callback.CommonCallback<String>() {
                    @Override
                    public void onSuccess(String result) {
                        Gson gson=new Gson();
                        UserBean userBean = gson.fromJson(result, UserBean.class);
                        String msg = userBean.getMsg();
                        Toast.makeText(LoginActivity.this,msg,Toast.LENGTH_SHORT).show();
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
