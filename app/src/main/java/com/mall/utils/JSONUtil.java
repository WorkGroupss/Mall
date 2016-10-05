package com.mall.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.mall.javaBean.Goods;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutorService;

/**
 * Created by hasee on 2016/9/13.
 */
public class JSONUtil {


    private static ArrayList<Goods> list;


    public static ArrayList<Goods> parse(String json) {
        try {

            JSONObject a = JSON.parseObject(json);
            System.out.println("--s" + a);
            String de = a.getString("data");

            System.out.println("--s" + de);
            JSONArray jsons =JSON.parseArray(de);
            for(Object o:jsons){
                JSONArray jo = (JSONArray) o;
                Goods good = JSON.parseObject(jo.toString(),Goods.class);
                list.add(good);
            }

            return list;

        } catch (Exception e) {

        }
        return  null;
    }
}
