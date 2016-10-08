package com.mall.fragment_mall;

import android.content.Context;
import android.graphics.Paint;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.mall.R;
import com.mall.javaBean.Goods;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by hasee on 2016/10/5.
 */

public class FirstRVAdapter extends RecyclerView.Adapter<FirstRVAdapter.Holder>{
    ArrayList<Goods> datas;
    Context mContext;
    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);
        void onItemLongClick(View view , int position);
    }
    private OnItemClickLitener mOnItemClickLitener;
    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }



    public FirstRVAdapter(ArrayList<Goods> datas, Context context) {
        this.datas = datas;
        mContext = context;
    }

    public FirstRVAdapter(ArrayList<Goods> datas) {
        this.datas = datas;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = View.inflate(parent.getContext(), R.layout.first_recycler_item,null);
        Holder holder = new Holder(layout);
        return holder;
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public void onBindViewHolder(final Holder holder, int position) {
        String url = datas.get(position).picSmall;
        String imageUrl = url.split("!")[0];

        Picasso.with(mContext).load(imageUrl).into(holder.picMall);
        holder.productTitle.setText(datas.get(position).productTitle);
        holder.recommend.setText(datas.get(position).recommend);
        holder.proPrice.setText("￥"+datas.get(position).proPrice);
        holder.liziPrice.setText(datas.get(position).liziPrice);
        holder.salesCount.setText("已经售出了"+datas.get(position).salesCount+"件");
        holder.addCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,"加入购物车",Toast.LENGTH_SHORT).show();
            }
        });
        if (mOnItemClickLitener !=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickLitener.onItemClick(holder.itemView,pos);
                }
            });
        }
    }

    class Holder extends RecyclerView.ViewHolder{
        ImageView picMall;
        TextView productTitle;
        TextView recommend;
        TextView proPrice;
        TextView liziPrice;
        TextView salesCount;
        Button addCar;
        public Holder(View itemView) {
            super(itemView);
            picMall = (ImageView) itemView.findViewById(R.id.picSmall);
            productTitle = (TextView) itemView.findViewById(R.id.productTitle);
            recommend = (TextView) itemView.findViewById(R.id.recommend);
            proPrice = (TextView) itemView.findViewById(R.id.proPrice);
            liziPrice = (TextView) itemView.findViewById(R.id.liziPrice);
            liziPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
            salesCount = (TextView) itemView.findViewById(R.id.salesCount);
            addCar = (Button) itemView.findViewById(R.id.add_cart);

        }

    }
}
