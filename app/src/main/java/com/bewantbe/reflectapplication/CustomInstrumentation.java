package com.bewantbe.reflectapplication;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.util.Log;

/**
 * Created by user on 7/4/18.
 */

public class CustomInstrumentation  extends Instrumentation{
    public final static String TAG = "CustomInstrumentation";

    private Instrumentation base;

    public CustomInstrumentation(Instrumentation base) {
        this.base = base;
    }

    //重写创建Activity的方法
    @Override
    public Activity newActivity(ClassLoader cl, String className, Intent intent) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        Log.d(TAG, "you are hook!,做自己想要的事情   " + "className="+className+" intent="+intent );

        return super.newActivity(cl, className, intent);
    }
}

