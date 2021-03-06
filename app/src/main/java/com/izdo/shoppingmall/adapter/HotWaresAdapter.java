package com.izdo.shoppingmall.adapter;

import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.izdo.shoppingmall.R;
import com.izdo.shoppingmall.bean.Wares;

import java.util.List;


/**
 * Created by iZdo on 2017/8/14.
 */

public class HotWaresAdapter extends RecyclerView.Adapter<HotWaresAdapter.ViewHolder> {

    private List<Wares> mDatas;

    private LayoutInflater mInflater;

    public HotWaresAdapter(List<Wares> wares) {

        mDatas = wares;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mInflater = LayoutInflater.from(parent.getContext());
        View view = mInflater.inflate(R.layout.template_hot_wares, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Wares wares = getData(position);

        holder.draweeView.setImageURI(Uri.parse(wares.getImgUrl()));
        holder.textTitle.setText(wares.getName());
        holder.textPrice.setText("￥" + wares.getPrice());
    }

    private Wares getData(int position) {

        return mDatas.get(position);
    }

    public List<Wares> getDatas() {

        return mDatas;
    }

    public void clearData() {

        mDatas.clear();
        notifyItemRangeChanged(0, mDatas.size());
    }

    /**
     * 添加新数据(第一次)
     */
    public void addData(List<Wares> datas) {

        addData(0, datas);
    }

    /**
     * 添加新数据
     */
    public void addData(int position, List<Wares> datas) {

        if (datas != null && datas.size() > 0) {

            mDatas.addAll(datas);
            notifyItemRangeChanged(position, mDatas.size());
        }
    }

    @Override
    public int getItemCount() {

        if (mDatas != null && mDatas.size() > 0)
            return mDatas.size();

        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        SimpleDraweeView draweeView;
        TextView textTitle;
        TextView textPrice;

        public ViewHolder(View itemView) {
            super(itemView);

            draweeView = (SimpleDraweeView) itemView.findViewById(R.id.drawee_view);
            textTitle = (TextView) itemView.findViewById(R.id.text_title);
            textPrice = (TextView) itemView.findViewById(R.id.text_price);
        }
    }
}
