package com.mall.fragment_mall;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mall.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragemnt extends Fragment {


    public FirstFragemnt() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first,null);


        return view;
    }

}
