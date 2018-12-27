package com.example.administrator.minemvpdemo.utils;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * Intent 统一处理类
 */
public class IntentUtils {

//    public static Intent getSchemaIntent(Activity current, String url)
//    {
//        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//        ActivityManager manager = (ActivityManager) current.getSystemService(Context.ACTIVITY_SERVICE);
//        ActivityManager.RunningTaskInfo info = manager.getRunningTasks(1).get(0);
//        String shortClassName = info.topActivity.getShortClassName();    //类名
//        String className = info.topActivity.getClassName();              //完整类名
//        String packageName = info.topActivity.getPackageName();          //包名
//        intent.putExtra("from",shortClassName);
//        return intent;
//    }

    /**
     * 跳转添加 来源Activity
     */
    public static Intent putFrom(Activity current, Intent intent)
    {
        intent.putExtra("from",current.getClass().getSimpleName());
        LogUtils.e("-----from; " + current.getClass().getSimpleName());
        return intent;
    }

    /**
     * 跳转添加 来源Fragment
     */
    public static Intent putFrom(Fragment fragment, Intent intent)
    {
        intent.putExtra("from",fragment.getClass().getSimpleName());
        LogUtils.e("-----from; " + fragment.getClass().getSimpleName());
        return intent;
    }
}
