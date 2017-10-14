package com.example.mejrtt.jd_demo3.model;

import com.example.mejrtt.jd_demo3.bean.UserBean;
import com.example.mejrtt.jd_demo3.net.Api;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by WANG123456 on 2017/10/11.
 */

public class LoginModel {
    public void login(String mobile, String pwd){
        OkHttpClient okHttpClient = new OkHttpClient();
        FormBody.Builder builder = new FormBody.Builder();
        builder.add("mobile",mobile);
        builder.add("password",pwd);
        FormBody body = builder.build();

        Request request = new Request.Builder().post(body).url(Api.DENGLU).build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(okhttp3.Call call, IOException e) {
                iLogin.failure(call,e);
            }

            @Override
            public void onResponse(okhttp3.Call call, Response response) throws IOException {
                if (response!=null&&response.isSuccessful()) {
                    String result = response.body().string();
                    Gson gson=new Gson();
                    UserBean userBean = gson.fromJson(result, UserBean.class);
                    //走解析逻辑，解析完成走如下逻辑
                    if (userBean.getCode().equals("0")) {
                        iLogin.loginSuccess(userBean.getCode(), userBean.getMsg());
                    } else {
                        iLogin.loginFail(userBean.getCode(),userBean.getMsg());
                    }
                }
            }
        });
    }



    private ILogin iLogin;

    /**
     * 对外暴露的回调接口
     * @param iLogin
     */
    public void setiLogin(ILogin iLogin) {
        this.iLogin = iLogin;
    }

    public interface ILogin{
        void loginSuccess(String code,String msg);
        void loginFail(String code,String msg);
        void failure(okhttp3.Call call, IOException e);
    }
}
