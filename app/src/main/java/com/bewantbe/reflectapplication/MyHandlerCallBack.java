package com.bewantbe.reflectapplication;


import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class MyHandlerCallBack implements Handler.Callback {

    //常量值和系统的值保持一致
    public static final int LAUNCH_ACTIVITY         = 100;
    public static final int PAUSE_ACTIVITY          = 101;
    public static final int PAUSE_ACTIVITY_FINISHING= 102;
    public static final int STOP_ACTIVITY_SHOW      = 103;
    public static final int STOP_ACTIVITY_HIDE      = 104;
    public static final int SHOW_WINDOW             = 105;
    public static final int HIDE_WINDOW             = 106;
    public static final int RESUME_ACTIVITY         = 107;
    public static final int SEND_RESULT             = 108;
    public static final int DESTROY_ACTIVITY        = 109;
    public static final int BIND_APPLICATION        = 110;
    public static final int EXIT_APPLICATION        = 111;
    public static final int NEW_INTENT              = 112;
    public static final int RECEIVER                = 113;
    public static final int CREATE_SERVICE          = 114;
    public static final int SERVICE_ARGS            = 115;
    public static final int STOP_SERVICE            = 116;

    Handler handler;
    private String TAG = MyHandlerCallBack.class.getName();

    public MyHandlerCallBack(Handler handler) {
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