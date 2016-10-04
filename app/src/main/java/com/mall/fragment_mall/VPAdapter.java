package com.mall.fragment_mall;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * Created by hasee on 2016/10/4.
 */

public class VPAdapter extends FragmentPagerAdapter{

    ArrayList<String> ts;
    ArrayList<Fragment> vs;

    public VPAdapter(FragmentManager fm, ArrayList<String> ts, ArrayList<Fragment> vs) {
        super(fm);
        this.ts = ts;
        this.vs = vs;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return ts.get(position);
    }

    @Override
    public Fragment getItem(int position) {
        return vs.get(position);
    }

    @Override
    public int getCount() {
        return vs.size();
    }


}
