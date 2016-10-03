package com.mall.zky;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

import com.mall.MainActivity;
import com.mall.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash);
        init();
    }

    Intent intent = null;
    private void init() {
        SharedPreferences sp = getSharedPreferences("args",MODE_PRIVATE);
        boolean isGuid = sp.getBoolean("isGuid", false);
        if (isGuid){
            intent = new Intent(this, MainActivity.class);
        }else {
            intent = new Intent(this,GuidActivity.class);
        }

        //三秒引导时间....
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    startActivity(intent);
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();



    }
}
