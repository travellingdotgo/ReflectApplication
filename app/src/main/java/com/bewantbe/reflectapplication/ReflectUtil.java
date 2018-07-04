package com.bewantbe.reflectapplication;

import android.os.Handler;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by user on 7/4/18.
 */


public class ReflectUtil {

    private static String TAG = ReflectUtil.class.getName();

    public static void replaceCallBack() {
        try {
            // 通过反射调用 ActivityThread 的静态方法, 获取 currentActivityThread
            Class<?> classAThread = Class.forName("android.app.ActivityThread");
            Method method = classAThread.getDeclaredMethod("currentActivityThread");
            method.setAccessible(true);
            Object currentActivityThread = method.invoke(null);
            // 获取 currentActivityThread 这个示例中的 mH
            Field fieldH = classAThread.getDeclaredField("mH");
            fieldH.setAccessible(true);
            Handler handler = (Handler) fieldH.get(currentActivityThread);

            // 修改 mH 中的 callback 字段
            Field callBackField = Handler.class.getDeclaredField("mCallback");
            callBackField.setAccessible(true);
            //这里没有直接反射出handler的mCallBack属性，而是直接使用了handler，主要是因为mCallBack可能为空
            //Handler.Callback callback = (Handler.Callback) callbackField.get(handler);

            callBackField.set(handler, new MyHandlerCallBack(handler));

        } catch (ClassNotFoundException e) {
            Log.i(TAG, "ClassNotFoundException------- " + e.toString());
        } catch (Exception e) {
            Log.i(TAG, "Exception------- " + e.toString());
        }

    }
}