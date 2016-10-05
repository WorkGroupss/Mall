package com.mall.javaBean;

import java.io.Serializable;

/**
 * Created by hasee on 2016/10/5.
 */

public class Goods  implements Serializable {
    public String productTitle;
    public String recommend;
    public String proPrice;
    public String liziPrice;

    public String picSmall;
    public String salesCount;

    public Goods(String productTitle, String recommend, String proPrice, String liziPrice, String picSmall, String salesCount) {
        this.productTitle = productTitle;
        this.recommend = recommend;
        this.proPrice = proPrice;
        this.liziPrice = liziPrice;
        this.picSmall = picSmall;
        this.salesCount = salesCount;
    }

    public Goods() {
    }
}
