package com.example.administrator.minemvpdemo.utils;

import android.content.Context;
import android.telephony.TelephonyManager;

public class PhoneUtils {

    private static String[] phoneType = {"未知","2G","3G","4G"};
    private static String[] simState = {"状态未知","无SIM卡","被PIN加锁","被PUK加锁",
            "被NetWork PIN加锁","已准备好"};

    //归属地查询
//    https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=13338776932
    public static void getBaseInfo(Context context){

        //①获得系统提供的TelphonyManager对象的实例
        TelephonyManager tManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        if (tManager != null) {
//            LogUtils.e("设备编号" + tManager.getDeviceId());
//            LogUtils.e("软件版本" + (tManager.getDeviceSoftwareVersion()!= null? tManager.getDeviceSoftwareVersion():"未知"));
//            LogUtils.e("设备当前位置" + (tManager.getCellLocation() != null ? tManager.getCellLocation().toString() : "未知位置"));
//            LogUtils.e("SIM卡序列号" + tManager.getSimSerialNumber());

            LogUtils.e("运营商代号" + tManager.getNetworkOperator());
            LogUtils.e("运营商名称" + tManager.getNetworkOperatorName());
            LogUtils.e("网络类型" + phoneType[tManager.getPhoneType()]);
            LogUtils.e("SIM卡的国别" + tManager.getSimCountryIso());
            LogUtils.e("运营商名称" + tManager.getNetworkOperatorName());
            LogUtils.e("SIM卡状态" + simState[tManager.getSimState()]);
        }
    }
}
