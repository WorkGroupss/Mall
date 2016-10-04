package com.mall.fragment_mall;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mall.R;
import com.mall.activity.SearchActivity;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MallFragment extends Fragment implements TabLayout.OnTabSelectedListener {
    View view;
    String[] tss ;
    ArrayList<String> ts = new ArrayList<>();
    ArrayList<Fragment> vs = new ArrayList<>();

    public MallFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mall,null);
        tss=getContext().getResources().getStringArray(R.array.tab);
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
        for (int i=0;i<tss.length;i++){
            tab.addTab(tab.newTab().setText(tss[i]));
        }

        ViewPager vp = (ViewPager) view.findViewById(R.id.mall_vp);
        vp.setAdapter(new VPAdapter(getChildFragmentManager(),ts,vs));
        tab.setupWithViewPager(vp);
    }

    private void initData() {
        vs.add(new FirstFragemnt());
        vs.add(new OtherFragment());
        for (int i = 0;i<tss.length;i++){
            ts.add(tss[i]);
        }

    }
    public void search(View view){
        Intent intent = new Intent(getContext(), SearchActivity.class);
        startActivity(intent);
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
