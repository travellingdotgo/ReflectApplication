package com.bewantbe.reflectapplication;


import android.app.Application;
import android.content.Context;
import android.util.Log;

/**
 * Created by user on 7/4/18.
 */

public class MyApplication extends Application {
    private static Context mContext;
    public final static String TAG = "MyApplication";

    private String getTraceInfo(){
        int SEQ = 3;    // each time when one more depth of function invoke ,add this value one by one
        String s = "[FILE] "
                + Thread.currentThread().getStackTrace()[SEQ].getFileName()
                + "  #  "
                + Thread.currentThread().getStackTrace()[SEQ].getClassName()
                + "  ->  "
                + Thread.currentThread().getStackTrace()[SEQ].getMethodName();

        return s;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        Log.i(TAG, getTraceInfo());

        ReflectUtil.replaceCallBack();
        try{
            ReflectUtil.hookInstrumentation();
        } catch ( Exception e ){
            e.printStackTrace();
        } finally{

        }
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.i(TAG, getTraceInfo());

        mContext = getApplicationContext();
    }

    public static Context getInstance() {
        return mContext;
    }

}
