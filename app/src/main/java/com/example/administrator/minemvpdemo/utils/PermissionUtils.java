package com.example.administrator.minemvpdemo.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;


public class PermissionUtils {
    public interface PermissionCallBack{
        /**
         * 请求权限成功回调
         */
        void requestPermissionsSuccess();

        /**
         * 请求权限失败回调
         */
        void requestPermissionsFail();
    }


    private   static PermissionCallBack permissionCallBack;

    public static PermissionCallBack getPermissionCallBack() {
        return permissionCallBack;
    }

    public static void setResultListener(PermissionCallBack callBack) {
        permissionCallBack = callBack;
    }

    public static final int REQUEST_CODE_PERMISSION = 10011;
    public static final String REQUEST_DENIED_MESSAGE = "您拒绝权限申请，此功能将不能正常使用，您可以去设置页面重新授权";

    /**
     * 是否已申请过
     */
    private static boolean hasPermissions(Context context, @NonNull String... perms) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return true;
        }
        if (context == null) {
            throw new IllegalArgumentException("Can't check permissions for null context");
        }
        for (String perm : perms) {
            if (ContextCompat.checkSelfPermission(context, perm)
                    != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    public static boolean verifyPermissions(int[] grantResults) {
        if (grantResults.length < 1) {
            return false;
        }
        for (int result : grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    public static void requesPermission(Activity activity, @NonNull String[] perms ,PermissionCallBack callBack) {
        setResultListener(callBack);
        if (!hasPermissions(activity, perms)) {
            ActivityCompat.requestPermissions(activity, perms, REQUEST_CODE_PERMISSION);
            if (hasPermissions(activity, perms)) {
                callBack.requestPermissionsSuccess();
            } else {
                callBack.requestPermissionsFail();
            }
        } else {
            callBack.requestPermissionsSuccess();
        }
    }

//    public  static void testPermission(@NonNull Activity activity,PermissionCallBack callBack){
//        requesPermission(activity,new String[]{
//                Manifest.permission.WRITE_SETTINGS,
//                Manifest.permission.READ_LOGS,
//                Manifest.permission.BATTERY_STATS},callBack);
//    }
}
