package com.bewantbe.reflectapplication;


import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Created by user on 7/4/18.
 */

public class MyApplication extends Application {
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();

        ReflectUtil.replaceCallBack();

    }

    public static Context getInstance() {
        return mContext;
    }

}
