package com.mall.guid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mall.MainActivity;
import com.mall.R;

import java.util.ArrayList;

public class GuidActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener{

    ArrayList<View> datas = new ArrayList<View>();
    ImageView[] mvs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_guid);
        initData();
        initPoints();
        initView();
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

    private void initData() {
        ImageView a = new ImageView(this);
        a.setImageResource(R.drawable.a_1);
        a.setScaleType(ImageView.ScaleType.FIT_XY);

        ImageView b = new ImageView(this);
        b.setImageResource(R.drawable.a_2);
        b.setScaleType(ImageView.ScaleType.FIT_XY);

        View c=View.inflate(this, R.layout.last_guid, null);

        datas.add(a);
        datas.add(b);
        datas.add(c);

    }

    private void initPoints() {
        LinearLayout ll = (LinearLayout) findViewById(R.id.points);
        int count = ll.getChildCount();
        mvs = new ImageView[count];
        for (int i = 0; i < count; i++) {
            ImageView x = (ImageView) ll.getChildAt(i);
            mvs[i] = x;
        }

    }

    @SuppressWarnings("deprecation")
    private void initView() {
        ViewPager vp = (ViewPager) findViewById(R.id.viewPager);
        vp.setOnPageChangeListener(this);
        vp.setAdapter(new A());

    }

    public void jump(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
        GuidActivity.this.finish();
    }

    class A extends PagerAdapter {

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(datas.get(position));
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(datas.get(position));
            return datas.get(position);
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0==arg1;
        }

    }

    @Override
    public void onPageScrollStateChanged(int arg0) {

    }

    int current = 0;
    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
        for (ImageView iv : mvs) {
            iv.setVisibility(View.VISIBLE);
        }
        if (arg0 ==current) {
            mvs[arg0].setImageResource(android.R.drawable.presence_online);
        } else {
            mvs[arg0].setImageResource(android.R.drawable.presence_online);

            mvs[current].setImageResource(android.R.drawable.presence_invisible);
            current = arg0;
        }
        //显示最后一页时，引导完成并存储标记
        if (arg0 == datas.size()-1) {
            for (ImageView iv : mvs) {
                iv.setVisibility(View.GONE);
            }

            SharedPreferences sp = getSharedPreferences("args", MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putBoolean("isGuid", true).commit();
        }
    }

    @Override
    public void onPageSelected(int arg0) {

    }
}
