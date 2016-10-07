package com.mall.fragment_mall;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mall.R;
import com.mall.javaBean.Goods;
import com.mall.utils.Constants;
import com.mall.utils.HttpUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * A simple {@link Fragment} subclass.
 */
public class OtherFragment extends Fragment  {
    ArrayList<Goods> list = new ArrayList<>();
    int page = 1;
    OtherAdapter mAdapter ;
    Handler hand = new Handler(){
        @Override
        public void handleMessage(Message msg) {


        }
    };

    private RecyclerView mRv;
    private SwipeRefreshLayout mMSwipe;
    int lastVisibleItem;
    LinearLayoutManager mLayoutManager;

    public OtherFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        initData(page);
    }

    private void initData(final int page) {
        ExecutorService fixdThreadPool = Executors.newFixedThreadPool(3);

        fixdThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                String url = Constants.getDanpin(page);
                String json = HttpUtil.loadJSON(url);
                parse(json);
            }
        });
    }

    private void parse(String json) {
        ArrayList<Goods> datas = new ArrayList<>();
        try {
            JSONObject a = JSON.parseObject(json);
            System.out.println("--s" + a);
            String de = a.getString("data");
            System.out.println("--s" + de);

            list.addAll(JSONArray.parseArray(de, Goods.class));
//            hand.post(new Runnable() {
//                @Override
//                public void run() {
//                    list.addAll(good);
//                    System.out.println("--s" + good.get(2).productTitle);
//
//                    mAdapter.notifyDataSetChanged();
//                }
//            });
        } catch (Exception e) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_other,null);
        mMSwipe = (SwipeRefreshLayout) view.findViewById(R.id.swip_refresh);
        mRv = (RecyclerView) view.findViewById(R.id.other_recycler);
        mMSwipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

            }
        });

        mMSwipe.setProgressViewOffset(false,0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                24,getResources().getDisplayMetrics()));

        mRv.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE
                        &&lastVisibleItem+1==mAdapter.getItemCount()){
                    mMSwipe.setRefreshing(true);
                    updateData();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                lastVisibleItem = mLayoutManager.findLastVisibleItemPosition();
            }
        });
        mRv.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRv.setLayoutManager(mLayoutManager);
        mRv.setItemAnimator(new DefaultItemAnimator());
        mAdapter = new OtherAdapter(list);
        mRv.setAdapter(mAdapter);

        return view;
    }

    private void updateData() {
        page=page+1;
        initData(page);
        hand.post(new Runnable() {
            @Override
            public void run() {
            mAdapter.notifyDataSetChanged();
            }
        });
        mMSwipe.setRefreshing(false);
    }


}
