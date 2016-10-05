package com.mall.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.GridView;

import com.mall.R;
import com.mall.fragment_mall.VPAdapter;
import com.mall.fragment_search.BrandFragment;
import com.mall.fragment_search.ClassifyFragment;
import com.mall.fragment_search.EffectFragment;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {

    private SearchView searchView;
    ArrayList<String> ts = new ArrayList<>();
    ArrayList<Fragment> vs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initDatas();
        initView();
    }

    private void initDatas() {
        ts.add("分类");
        ts.add("品牌");
        ts.add("功效");
        vs.add(new ClassifyFragment());
        vs.add(new BrandFragment());
        vs.add(new EffectFragment());
    }

    private void initView() {
        searchView = (SearchView) findViewById(R.id.search_view);
        searchView.setQueryHint("搜索商品，品牌");
        TabLayout tab = (TabLayout) findViewById(R.id.search_table);
        tab.setOnTabSelectedListener(this);
        for (int i = 0; i < ts.size(); i++) {
            tab.addTab(tab.newTab().setText(ts.get(i)));
        }


        ViewPager vp = (ViewPager) findViewById(R.id.search_vp);
        vp.setAdapter(new VPAdapter(getSupportFragmentManager(),ts,vs));

        tab.setupWithViewPager(vp);


    }

    public void search(View view) {
        searchView.setQuery("",false);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        int position = tab.getPosition();
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
