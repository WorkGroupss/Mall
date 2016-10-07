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
    ArrayList<String> datas2 = new ArrayList<>();
    ArrayList<String> parentDatas = new ArrayList<>();
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
        for (int i = 0; i < 4; i++) {
            parentDatas.add("AAA"+i);
        }

        for (int i = 0; i < name.length; i++) {
            datas.add(name[i]);
        }
        for (int i = 0; i < parentDatas.size(); i++) {
            map.put(parentDatas.get(i),datas);
        }

        ExpandAdapter adapter = new ExpandAdapter(map,parentDatas);


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


        for (int i = 0; i < 12; i++) {
            datas2.add("品牌"+i);
        }
        GridView gridView = (GridView) view.findViewById(R.id.brand_grid);

        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,datas2);
        gridView.setAdapter(adapter2);

        return view;
    }

}
