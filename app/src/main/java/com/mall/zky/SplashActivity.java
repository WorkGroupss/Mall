package com.mall.zky;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;

import com.mall.MainActivity;
import com.mall.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);
        init();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (hasFocus && Build.VERSION.SDK_INT >= 19) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
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
