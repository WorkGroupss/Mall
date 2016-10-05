package com.mall.fragment_lesson;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mall.R;
import com.mall.activity.SearchActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class LessonFragment extends Fragment {

    List<String> datas = new ArrayList<>();
    List<View> vps = new ArrayList<>();

    public LessonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lesson, null);
        initData();
        initView(view);
        return view;
    }

    private void initData() {
        for (int i = 0; i < 30; i++) {
            datas.add("甜妹儿" + i);
        }

        for (int i = 0; i < 4; i++) {
            ImageView imageView1 = new ImageView(getContext());
            imageView1.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView1.setImageResource(R.drawable.a_1);
            vps.add(imageView1);
        }
    }

    private void initView(View view) {
        RecyclerView recyclerview = (RecyclerView) view.findViewById(R.id.recyclerview);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(llm);
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(datas);
        recyclerview.setAdapter(recyclerAdapter);

        //添加头视图
        View headView = View.inflate(getContext(),R.layout.fragment_lesson_head,null);
        final LinearLayout ll  = (LinearLayout) headView.findViewById(R.id.vp_head_points);
        ViewPager vp_head = (ViewPager) headView.findViewById(R.id.viewPager_head);
        vp_head.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int childCount = ll.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    ImageView iv = (ImageView) ll.getChildAt(i);
                    if (position == i) {
                        iv.setImageResource(android.R.drawable.presence_online);
                    }else {
                        iv.setImageResource(android.R.drawable.presence_invisible);
                    }
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        vp_head.setAdapter(new VpHeadAdapter(vps));
        recyclerAdapter.setHeadView(headView);
    }

    public void search(View view){
        Intent intent = new Intent(getContext(), SearchActivity.class);
        startActivity(intent);
    }


}
