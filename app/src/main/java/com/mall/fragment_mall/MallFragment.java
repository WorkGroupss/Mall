package com.mall.fragment_mall;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mall.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MallFragment extends Fragment implements TabLayout.OnTabSelectedListener {
    View view;
    ArrayList<String> ts = new ArrayList<>();

    public MallFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mall,null);
        initData();
        initView();
        return view;
    }

    private void initView() {
        TabLayout tab = (TabLayout) view.findViewById(R.id.mall_tab);
        tab.setTabMode(TabLayout.MODE_SCROLLABLE);
        int width = getResources().getDisplayMetrics().widthPixels;
        tab.setMinimumWidth(width);
        tab.setOnTabSelectedListener(this);
        tab.addTab(tab.newTab().setText("首页"));
        tab.addTab(tab.newTab().setText("TOP单品"));
        tab.addTab(tab.newTab().setText("潮流新品"));
        tab.addTab(tab.newTab().setText("补水保湿"));
        tab.addTab(tab.newTab().setText("防晒美白"));
        tab.addTab(tab.newTab().setText("底妆隔离"));
        tab.addTab(tab.newTab().setText("洗发护发"));
        tab.addTab(tab.newTab().setText("化妆工具"));
    }

    private void initData() {
        ts.add("首页");
        ts.add("TOP单品");
        ts.add("潮流新品");
        ts.add("补水保湿");
        ts.add("防晒美白");
        ts.add("底妆隔离");
        ts.add("洗发护发");
        ts.add("化妆工具");
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
