package com.mall.fragment_lesson;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mall.R;

import java.util.ArrayList;
import java.util.List;

import static com.mall.R.id.view;

/**
 * Created by Administrator on 2016/10/5.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {


    List<String> datas = new ArrayList<>();
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_NORMAL = 1;
    private View headView;

    public RecyclerAdapter(List<String> datas) {
        this.datas = datas;
    }

    public void setHeadView(View headView) {
        this.headView = headView;
        notifyItemInserted(0);
    }

    public View getHeadView() {
        return headView;
    }

    @Override
    public int getItemViewType(int position) {
        if (headView == null) return TYPE_NORMAL;
        if (position == 0) return TYPE_HEADER;
        return TYPE_NORMAL;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (headView != null && viewType == TYPE_HEADER) {
            return new MyViewHolder(headView);
        }
        View view = View.inflate(parent.getContext(), R.layout.fragment_lesson_listitem, null);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
         //这里设置各个数据，例如
        if(getItemViewType(position)==TYPE_HEADER) return;

         holder.tv_name.setText(datas.get(position-1));

        holder.iv_comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int zan = Integer.parseInt(holder.tv_comment.getText().toString()) + 1;
                holder.iv_comment.setClickable(false);
                holder.tv_comment.setText(zan+"");
            }
        });
        holder.iv_heart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int heart = Integer.parseInt(holder.tv_heart.getText().toString()) + 1;
                holder.iv_heart.setClickable(false);
                holder.tv_heart.setText(heart+"");
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size()+1;
    }

    class MyViewHolder extends RecyclerView.ViewHolder  {
        TextView tv_name, tv_call, tv_testcolor, tv_comment, tv_heart, tv_title, tv_artical;
        ImageView iv_comment,iv_heart;

        public MyViewHolder(View itemView) {
            super(itemView);
            if (itemView==headView) return;
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            tv_call = (TextView) itemView.findViewById(R.id.tv_call);
            tv_testcolor = (TextView) itemView.findViewById(R.id.tv_testcolor);
            tv_comment = (TextView) itemView.findViewById(R.id.tv_comment);
            tv_heart = (TextView) itemView.findViewById(R.id.tv_heart);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            tv_artical = (TextView) itemView.findViewById(R.id.tv_artical);

            iv_comment = (ImageView) itemView.findViewById(R.id.iv_comment);
            iv_heart = (ImageView) itemView.findViewById(R.id.iv_heart);

        }
    }
}

