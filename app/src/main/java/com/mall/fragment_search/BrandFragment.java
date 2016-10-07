package com.mall.fragment_search;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.mall.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 * 搜索的第二个页面
 */
public class BrandFragment extends Fragment {

    ArrayList<String> datas = new ArrayList<>();
    ArrayList<String> parentDatas = new ArrayList<>();
    ArrayList<Integer> imgdatas = new ArrayList<>();
    Map<String,ArrayList<String>> map = new HashMap<>();
    String[] name;

    public BrandFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_brand, container, false);
        ExpandableListView listView = (ExpandableListView) view.findViewById(R.id.brand_list);
        name=getContext().getResources().getStringArray(R.array.brand);
        initdatas();



        ExpandAdapter adapter = new ExpandAdapter(parentDatas,map,imgdatas);


        listView.setAdapter(adapter);
        for (int i = 0; i < adapter.getGroupCount(); i++) {
            listView.expandGroup(i);
        }

        listView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return true;
            }
        });
        return view;
    }

    private void initdatas() {
        parentDatas.add("热门品牌");
        parentDatas.add("A");
        parentDatas.add("B");
        parentDatas.add("C");
        for (int i = 0; i < name.length; i++) {
            datas.add(name[i]);
        }
        for (int i = 0; i < parentDatas.size(); i++) {
            map.put(parentDatas.get(i),datas);
        }
        imgdatas.add(R.mipmap.a1);
        imgdatas.add(R.mipmap.a2);
        imgdatas.add(R.mipmap.a3);
        imgdatas.add(R.mipmap.a4);
        imgdatas.add(R.mipmap.a5);
        imgdatas.add(R.mipmap.a6);
        imgdatas.add(R.mipmap.a7);
        imgdatas.add(R.mipmap.a8);
        imgdatas.add(R.mipmap.a9);
        imgdatas.add(R.mipmap.a10);
        imgdatas.add(R.mipmap.a11);
        imgdatas.add(R.mipmap.a12);

    }

}
