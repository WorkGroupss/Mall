package com.mall.fragment_shoppingcart;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mall.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class cart_fragment extends Fragment {


    public cart_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lesson_fragment, container, false);
    }

}
