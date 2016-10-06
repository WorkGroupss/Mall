package com.mall.fragment_search;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.mall.MainActivity;
import com.mall.R;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Lin on 2016/10/6 0006.
 * ExpandableListView的Adapter
 */

public class ExpandAdapter extends BaseExpandableListAdapter{

    ArrayList<String> parentdatas;
    Map<String,ArrayList<String>> map;

    public ExpandAdapter(Map<String, ArrayList<String>> map, ArrayList<String> parentdatas) {
        this.map = map;
        this.parentdatas = parentdatas;
    }

    @Override
    public int getGroupCount() {
        return parentdatas.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        String key = parentdatas.get(groupPosition);
        int size = map.get(key).size();
        return size;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return parentdatas.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        String key = parentdatas.get(groupPosition);

        return map.get(key).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.expand_parent_item,null);

        }

        TextView tv = (TextView) convertView.findViewById(R.id.parent);

        tv.setText(parentdatas.get(groupPosition));
        return tv;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String key = parentdatas.get(groupPosition);
        String info = map.get(key).get(childPosition);
        if (convertView == null){
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.expand_child_item2,null);

        }

        TextView tv2 = (TextView) convertView.findViewById(R.id.child2);
        tv2.setText(info);
        return tv2;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
