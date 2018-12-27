package com.example.administrator.minemvpdemo.utils;

import android.util.Log;

import com.example.administrator.minemvpdemo.base.Constant;

/**
 * 日志工具类
 */
public class LogUtils {

    /**
     * 打印日志
     */
    public static boolean IS_LOG = !Constant.IS_PUBLISH;
    /**
     * 本地日志标签
     */
    private final static String DEBUG_TAG = "debug / ";
    /**
     * 普通错误日志
     */
    public static void e(String msg){
        Log.e(DEBUG_TAG,msg);
    }

    public static void d(String tag,String msg){
        Log.d(tag,msg);
    }
}
