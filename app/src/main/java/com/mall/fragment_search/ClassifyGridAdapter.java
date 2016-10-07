package com.mall.fragment_search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mall.R;

import java.util.ArrayList;

/**
 * Created by Lin on 2016/10/7 0007.
 */

public class ClassifyGridAdapter extends BaseAdapter{

    ArrayList<String> datas;

    public ClassifyGridAdapter(ArrayList<String> datas) {
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
        if(convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.classify_item,null);
            TextView tv = (TextView) convertView.findViewById(R.id.border_textview);
            tv.setText(datas.get(position));
        }
        return convertView;
    }
}
