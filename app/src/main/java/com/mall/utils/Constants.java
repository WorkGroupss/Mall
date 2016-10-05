package com.mall.utils;

/**
 * Created by hasee on 2016/10/5.
 */

public  class Constants {
    public static String getDanpin(int page){
        String a ="https://api.lizi.com/0.7/common/recItems?mark=android&version=3.2.5&page="+page+"&sign=eceb5dc032b0e3dde7c0ee5f9957e3ae&androidchannel=wandoujia";
        return a;
    }
}
