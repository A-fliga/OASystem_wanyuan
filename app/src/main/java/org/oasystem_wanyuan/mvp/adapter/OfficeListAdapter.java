package org.oasystem_wanyuan.mvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.oasystem_wanyuan.R;
import org.oasystem_wanyuan.mvp.adapter.itemClickListener.OnItemClickListener;
import org.oasystem_wanyuan.mvp.model.bean.OfficeListBean;

import java.util.List;

/**
 * Created by www on 2019/1/5.
 */

public class OfficeListAdapter extends RecyclerView.Adapter<OfficeListAdapter.OfficeListViewHolder> {
    private List<OfficeListBean.DataBean> beanList;
    private Context context;
    private OnItemClickListener itemClickListener;

    public OfficeListAdapter(List<OfficeListBean.DataBean> beanList, Context context) {
        this.beanList = beanList;
        this.context = context;
    }

    @Override
    public OfficeListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new OfficeListViewHolder(LayoutInflater.from(context).inflate(R.layout.item_office_list, parent, false));
    }

    @Override
    public void onBindViewHolder(OfficeListViewHolder holder, final int position) {
        holder.office_list_title.setText(beanList.get(position).getName());
        holder.office_list_time.setText(beanList.get(position).getUpdated_at());
        String[] str = beanList.get(position).getSource().getName().split("\\.");

        if (str[str.length - 1].equals("pdf")) {
            Glide.with(context).load(R.mipmap.office_pdf).into(holder.office_detail_img);
        }
        if (str[str.length - 1].equals("doc") || str[str.length - 1].equals("docx")) {
            Glide.with(context).load(R.mipmap.office_word).into(holder.office_detail_img);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClickListener != null) {
                    itemClickListener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    class OfficeListViewHolder extends RecyclerView.ViewHolder {
        public TextView office_list_title, office_list_time;
        public ImageView office_detail_img;

        public OfficeListViewHolder(View itemView) {
            super(itemView);
            office_list_title = itemView.findViewById(R.id.office_list_title);
            office_list_time = itemView.findViewById(R.id.office_list_time);
            office_detail_img = itemView.findViewById(R.id.office_detail_img);
        }
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
