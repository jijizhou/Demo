package com.example.administrator.minemvpdemo.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.administrator.minemvpdemo.R;
import com.example.administrator.minemvpdemo.utils.PermissionUtils;

public class SeconedActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        PermissionUtils.testPermission(SeconedActivity.this);
    }

    private void initView() {
        Button btn_second = (Button) findViewById(R.id.btn_second);
        btn_second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
