package com.mall;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.mall.activity.SearchActivity;
import com.mall.fragment_lesson.LessonFragment;
import com.mall.fragment_mall.MallFragment;
import com.mall.fragment_mine.MineFragemnt;
import com.mall.fragment_shoppingcart.CartFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    ArrayList<Fragment> fragments = new ArrayList<>();
    static Fragment currentfg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT>Build.VERSION_CODES.LOLLIPOP){
            Window window =getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(0xff000000);
        }
        initShow();
        initView();
    }

    private void initShow() {
        fragments.add(new LessonFragment());
        fragments.add(new MallFragment());
        fragments.add(new CartFragment());
        fragments.add(new MineFragemnt());

        currentfg = fragments.get(0);
        getSupportFragmentManager().beginTransaction().add(R.id.content, currentfg).commit();
    }

    private void initView() {
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup_foot);
        radioGroup.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        Fragment fragment = null;
                        if (i==R.id.radioButtonX){
                            return;
                        }
                        switch (i) {
                            case R.id.radioButton1:
                                fragment = fragments.get(0);
                                break;
                            case R.id.radioButton2:
                                fragment = fragments.get(1);
                                break;
                            case R.id.radioButton3:
                                fragment = fragments.get(2);
                                break;
                            case R.id.radioButton4:
                                fragment = fragments.get(3);
                                break;
                        }
                        load(fragment);
                    }
                }
        );
    }

    private void load(Fragment f) {
        if (currentfg != f) {
            FragmentTransaction tansaction = getSupportFragmentManager().beginTransaction();
            if (!f.isAdded()) {
                tansaction.hide(currentfg).add(R.id.content, f).commit();
            } else {
                tansaction.hide(currentfg).show(f).commit();
            }
            currentfg = f;
        }
    }

    long curTime;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - curTime < 2000) {
                finish();
                System.exit(0);
            } else {
                Toast.makeText(this, "再按一次退出", Toast.LENGTH_SHORT).show();
                curTime = System.currentTimeMillis();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void search(View view) {
        Intent intent = new Intent(this, SearchActivity.class);
        startActivity(intent);
    }



}
