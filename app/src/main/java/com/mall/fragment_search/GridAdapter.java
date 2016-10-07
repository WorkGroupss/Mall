package com.mall.fragment_search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;

import com.mall.R;

import java.util.ArrayList;

/**
 * Created by Lin on 2016/10/7 0007.
 */

public class GridAdapter extends BaseAdapter{

    ArrayList<String> datas;

    public GridAdapter(ArrayList<String> datas) {
        this.datas = datas;
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView== null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.expand_child_item3,null);
            ImageView imageView = (ImageView) convertView.findViewById(R.id.expanded_imageview);

        }
        return convertView;
    }
}
