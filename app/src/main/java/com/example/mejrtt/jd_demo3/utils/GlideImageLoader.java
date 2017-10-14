package com.example.mejrtt.jd_demo3.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by WANG123456 on 2017/10/11.
 */

public class GlideImageLoader extends ImageLoader{


    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context).load(path).into(imageView);

    }
}
