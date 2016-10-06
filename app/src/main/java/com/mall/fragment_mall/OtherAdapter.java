package com.mall.fragment_mall;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mall.R;
import com.mall.javaBean.Goods;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hasee on 2016/10/6.
 */

public class OtherAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<Goods> mList;
    private static  final int TYPE_ITEM=0;
    private static  final int TYPE_FOOTER=1;

    public OtherAdapter(List<Goods> list) {
        mList = list;
    }

    public OtherAdapter() {
        mList = new ArrayList<>();
    }

    @Override
    public int getItemCount() {
        return mList.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position+1==getItemCount()){
            return TYPE_FOOTER;
        }else {
            return TYPE_ITEM;
        }
    }
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyHolder){
            ((MyHolder) holder).textView.setText(mList.get(position).productTitle);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_ITEM){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.other_item,null);
            view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,
                    RecyclerView.LayoutParams.WRAP_CONTENT));
            return new MyHolder(view);
        }else if (viewType==TYPE_FOOTER){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.footer_view,null);
            view.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT,
                    RecyclerView.LayoutParams.WRAP_CONTENT));
            return new FooterViewHolder(view);
        }
        return null;
    }




    class FooterViewHolder extends RecyclerView.ViewHolder{

        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }
    class MyHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public MyHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.other_item_text);
        }
    }
}
