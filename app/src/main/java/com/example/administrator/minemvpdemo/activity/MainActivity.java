package com.example.administrator.minemvpdemo.activity;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.minemvpdemo.R;
import com.example.administrator.minemvpdemo.utils.PermissionUtils;
import com.example.administrator.minemvpdemo.view.MainView;

public class MainActivity extends BaseActivity implements MainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initData() {

    }

    @Override
    protected void onResume() {
        super.onResume();
//        PermissionUtils.testPermission(MainActivity.this);
    }

    private void initView() {


        Button btn_get = (Button) findViewById(R.id.btn_get);
        btn_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requesPermission(new String[]{
                        Manifest.permission.WRITE_SETTINGS,
                        Manifest.permission.READ_LOGS,
                        Manifest.permission.BATTERY_STATS
                });
            }
        });
    }

    @Override
    public void downLoad(String url) {

    }
}
