package com.mall.activity;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.GridView;

import com.mall.R;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    private SearchView searchView;
    private GridView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        initView();
    }

    private void initView() {
        searchView = (SearchView) findViewById(R.id.search_view);
        searchView.setQueryHint("搜索商品，品牌");
        TabLayout tab = (TabLayout) findViewById(R.id.search_table);
        tab.addTab(tab.newTab().setText("分类"));
        tab.addTab(tab.newTab().setText("品牌"));
        tab.addTab(tab.newTab().setText("功效"));

        grid = (GridView) findViewById(R.id.search_grid);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
        ArrayList<String> datas = new ArrayList<>();
        datas.add("洁面");
        datas.add("化妆水");
        datas.add("乳液/面霜");
        datas.add("防晒");
        datas.add("眼妆");
        datas.add("面膜");
        datas.add("面部精华");
        datas.add("T区护理");
        datas.add("润唇膏");
        datas.add("男士护理");
        datas.add("护肤套装");
        datas.add("其他护肤品");

        adapter.addAll(datas);
        grid.setAdapter(adapter);

    }

    public void search(View view) {
        searchView.setQuery("",false);
    }
}
