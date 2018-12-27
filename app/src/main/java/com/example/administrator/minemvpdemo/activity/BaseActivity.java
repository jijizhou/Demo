package com.example.administrator.minemvpdemo.activity;

import android.Manifest;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.minemvpdemo.utils.IntentUtils;
import com.example.administrator.minemvpdemo.utils.LogUtils;
import com.example.administrator.minemvpdemo.utils.PermissionUtils;

public class BaseActivity extends AppCompatActivity {

    /**
     * 当前 Activity 类名
     */
    private String simpleName;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        simpleName = getClass().getSimpleName();
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.e(simpleName + "- onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtils.e(simpleName + "- onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.e(simpleName + "- onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.e(simpleName + "- onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.e(simpleName + "- onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.e(simpleName + "- onDestroy");
    }



    @Override
    public void startActivity(Intent intent)
    {
        super.startActivity(IntentUtils.putFrom(this, intent));
    }

    public void startActivity(Class clazz)
    {
        Intent intent = new Intent(this, clazz);
        this.startActivity(IntentUtils.putFrom(this, intent));
    }

    @Override
    public void startActivities(Intent[] intents)
    {
        if (intents != null && intents.length > 0)
        {
            Intent[] temps = new Intent[intents.length];
            for (int i = 0; i < intents.length; i++)
            {
                temps[i] = IntentUtils.putFrom(this, intents[i]);
            }
            super.startActivities(temps);
        }else
        {
            super.startActivities(intents);
        }
    }


    public void requesPermission(@NonNull final String... perms) {
        new AlertDialog.Builder(this)
                .setMessage("为了给您提供更好的服务,请允许以下权限。")
                .setCancelable(false)
                .setPositiveButton("好的", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        request(perms);
                    }
                })
                .setNegativeButton("残忍拒绝", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
//        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
//            new AlertDialog.Builder(this)
//                    .setMessage("为了给您提供更好的服务,请允许以下权限。")
//                    .setCancelable(false)
//                    .setPositiveButton("好的", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            request(perms);
//                        }
//                    })
//                    .setNegativeButton("残忍拒绝", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int which) {
//                            dialog.dismiss();
//                        }
//                    })
//                    .show();
//
//        } else {
//            request(perms);
//        }
    }

    private void request(String[] perms) {
        PermissionUtils.requesPermission(BaseActivity.this, perms, new PermissionUtils.PermissionCallBack() {
            @Override
            public void requestPermissionsSuccess() {
                LogUtils.e("request Success");
            }

            @Override
            public void requestPermissionsFail() {
                showPermissionDenied(BaseActivity.this);
            }
        });
    }


//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (requestCode == PermissionUtils.REQUEST_CODE_PERMISSION) {
//            if (!PermissionUtils.verifyPermissions(grantResults)) {
//                LogUtils.e("onRequestPermissionsResult");
////            showPermissionDenied(BaseActivity.this);
//            }
//        }
//    }

    public static void showPermissionDenied (@NonNull Activity activity){
        new AlertDialog.Builder(activity)
//                .setTitle(R.string.warm_tips)
                .setMessage(PermissionUtils.REQUEST_DENIED_MESSAGE)
                .setPositiveButton("去设置", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("暂不", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }
}

