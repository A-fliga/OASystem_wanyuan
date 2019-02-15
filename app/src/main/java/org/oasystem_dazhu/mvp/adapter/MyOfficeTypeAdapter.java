package org.oasystem_dazhu.mvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.oasystem_dazhu.R;
import org.oasystem_dazhu.mvp.adapter.itemClickListener.OnItemClickListener;
import org.oasystem_dazhu.mvp.model.bean.OfficeTypeBean;

import java.util.List;

/**
 * Created by www on 2019/1/5.
 */

public class MyOfficeTypeAdapter extends RecyclerView.Adapter<MyOfficeTypeAdapter.OfficeTypeViewHolder> {
    private List<OfficeTypeBean.DataBean> typeBeen;
    private Context context;
    private OnItemClickListener itemClickListener;

    public MyOfficeTypeAdapter(List<OfficeTypeBean.DataBean> typeBeen, Context context) {
        this.typeBeen = typeBeen;
        this.context = context;
    }

    @Override
    public OfficeTypeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new OfficeTypeViewHolder(LayoutInflater.from(context).inflate(R.layout.item_office_type, parent, false));
    }

    @Override
    public void onBindViewHolder(OfficeTypeViewHolder holder, final int position) {
        holder.office_type_name.setText(typeBeen.get(position).getName());
        holder.office_type_count.setText(typeBeen.get(position).getDocument_count() + "项");
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
        return typeBeen.size();
    }

    class OfficeTypeViewHolder extends RecyclerView.ViewHolder {
        private TextView office_type_name, office_type_count;

        public OfficeTypeViewHolder(View itemView) {
            super(itemView);
            office_type_name = itemView.findViewById(R.id.office_type_name);
            office_type_count = itemView.findViewById(R.id.office_type_count);
        }
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }
}
