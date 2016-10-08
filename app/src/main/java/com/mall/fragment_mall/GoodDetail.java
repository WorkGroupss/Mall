package com.mall.fragment_mall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mall.R;
import com.mall.javaBean.Goods;

public class GoodDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_detail);
        Goods goods = (Goods) getIntent().getSerializableExtra("good");
    }
}
