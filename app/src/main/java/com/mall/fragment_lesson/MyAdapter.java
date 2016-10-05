package com.mall.fragment_lesson;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mall.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/10/5.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    List<String> datas ;

    public MyAdapter(List<String> datas) {
        this.datas = datas;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.fragment_lesson_listitem, null);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_name.setText(datas.get(position));
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name, tv_call, tv_testcolor, tv_zan, tv_heart, tv_title, tv_artical;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_call = (TextView) itemView.findViewById(R.id.tv_call);
            tv_testcolor = (TextView) itemView.findViewById(R.id.tv_testcolor);
            tv_zan = (TextView) itemView.findViewById(R.id.tv_zan);
            tv_heart = (TextView) itemView.findViewById(R.id.tv_heart);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_artical = (TextView) itemView.findViewById(R.id.tv_artical);
        }
    }
}

