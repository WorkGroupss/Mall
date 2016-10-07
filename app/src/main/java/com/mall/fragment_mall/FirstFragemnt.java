package com.mall.fragment_mall;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mall.R;
import com.mall.javaBean.Goods;
import com.mall.utils.Constants;
import com.mall.utils.HttpUtil;
import com.mall.utils.JSONUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragemnt extends Fragment {
    ArrayList<Goods> list = new ArrayList<>();
    int page = 1;
   FirstRVAdapter fadapter;
    Handler hand = new Handler(){
        @Override
        public void handleMessage(Message msg) {


        }
    };
    public FirstFragemnt() {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        fadapter  = new FirstRVAdapter(list,context);
        initData(page);

    }

    private void initData(final int page) {
        ExecutorService  fixdThreadPool = Executors.newFixedThreadPool(3);

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
                String de = a.getString("data");
                final List<Goods> good = JSONArray.parseArray(de, Goods.class);
                hand.post(new Runnable() {
                    @Override
                    public void run() {
                        list.addAll(good);
                        System.out.println("--s" + good.get(2).productTitle);

                        fadapter.notifyDataSetChanged();
                    }
                });
            } catch (Exception e) {

            }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first,null);
        RecyclerView rv = (RecyclerView) view.findViewById(R.id.first_recycler);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(llm);
        rv.setAdapter(fadapter);
        rv.setNestedScrollingEnabled(false);
        return view;
    }

}
