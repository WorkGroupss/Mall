package com.mall.fragment_search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mall.R;

import java.util.ArrayList;

/**
 * Created by Lin on 2016/10/8 0008.
 */

public class EffectAdapter extends BaseAdapter{

    ArrayList<String> datas;

    public EffectAdapter(ArrayList<String> datas) {
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

        if (convertView ==null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.effect_item,null);

            TextView textView = (TextView) convertView.findViewById(R.id.effect_tv);
            textView.setText(datas.get(position));
        }
        return convertView;
    }
}
