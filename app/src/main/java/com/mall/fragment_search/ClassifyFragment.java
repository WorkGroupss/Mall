package com.mall.fragment_search;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.mall.R;

import java.util.ArrayList;

/**
 * Created by Lin on 2016/10/5 0005.
 * 搜索的第一个页面
 */

public class ClassifyFragment extends Fragment{

    private GridView grid;

    public ClassifyFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_classify, container, false);

        grid = (GridView)view.findViewById(R.id.search_grid2);

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

        ClassifyGridAdapter adapter = new ClassifyGridAdapter(datas);
        grid.setAdapter(adapter);

        return view;
    }
}
