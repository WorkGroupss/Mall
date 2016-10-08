package com.mall.fragment_search;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.mall.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * 搜索的第三个页面
 */
public class EffectFragment extends Fragment {

    ArrayList<String> datas = new ArrayList<>();

    public EffectFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_effect, container, false);

        initDatas();
        GridView gridView = (GridView) view.findViewById(R.id.effect_gridview);


        gridView.setAdapter(new EffectAdapter(datas));

        return view;
    }

    private void initDatas() {
        datas.clear();
        datas.add("补水保湿");
        datas.add("减肥瘦身");
        datas.add("淡化色彩");
        datas.add("收缩毛孔");
        datas.add("舒缓肌肤");
        datas.add("淡化干纹");
        datas.add("去黑头");
        datas.add("去黑眼圈");
        datas.add("淡化细纹");
        datas.add("去痘印");
        datas.add("上色持久");
        datas.add("定妆");
        datas.add("卸妆");
        datas.add("烫染修复");
        datas.add("促进吸收");

    }

}
