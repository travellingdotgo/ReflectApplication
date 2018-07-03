package com.bewantbe.reflectapplication;


import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class myHandlerCallBack implements Handler.Callback {
    //常量值和系统的值保持一致
    public static final int LAUNCH_ACTIVITY = 100;
    public static final int NEW_INTENT = 112;
    Handler handler;
    private String TAG = myHandlerCallBack.class.getName();

    public myHandlerCallBack(Handler handler) {
        this.handler = handler;
    }

    @Override
    public boolean handleMessage(Message msg) {
        if(handler == null){
            return false;
        }
        if (msg.what == LAUNCH_ACTIVITY) {
            Log.i(TAG, "activity is going to launch! " + msg.toString());
        //    return true;
        }else if (msg.what == NEW_INTENT){
            Log.i(TAG, "activity is going to new intent! ");
        }

        handler.handleMessage(msg);
        return true;
    }
}