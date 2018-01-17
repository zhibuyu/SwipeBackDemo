package com.xyu.swipebackdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * Created by xiongyu on 2017/11/17.
 */
public class SecondActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        findViewById(R.id.back_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public boolean isSwpeBack() {
        return true;
    }

    @Override
    protected void DragFinsh() {
        super.DragFinsh();
        Toast.makeText(SecondActivity.this,"滑动返回",Toast.LENGTH_SHORT).show();
    }
}
