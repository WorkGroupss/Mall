package com.mall.fragment_lesson;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2016/10/5.
 */
public class VpHeadAdapter extends PagerAdapter {

    List<View> vps;

    public VpHeadAdapter(List<View> vps) {
        this.vps = vps;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(vps.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(vps.get(position));
        return vps.get(position);
    }

    @Override
    public int getCount() {
        return vps.size();
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

}



