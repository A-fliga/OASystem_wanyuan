package org.oasystem.mvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.oasystem.R;
import org.oasystem.mvp.adapter.itemClickListener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by www on 2019/1/8.
 */

public class ScreenTypeAdapter extends RecyclerView.Adapter<ScreenTypeAdapter.ScreenTypeViewHolder> {
    private OnItemClickListener itemClickListener;
    private List<String> beanList;
    private Context context;
    private List<TextView> tv_view = new ArrayList<>();

    public ScreenTypeAdapter(List<String> beanList, Context context) {
        this.beanList = beanList;
        this.context = context;
    }

    @Override
    public ScreenTypeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ScreenTypeViewHolder(LayoutInflater.from(context).inflate(R.layout.item_screen_type, parent, false));
    }

    @Override
    public void onBindViewHolder(ScreenTypeViewHolder holder, final int position) {
        tv_view.add(holder.item_type_tv);
        holder.item_type_tv.setText(beanList.get(position));
        setItemClick(holder, position);
    }

    private void setItemClick(ScreenTypeViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (itemClickListener != null) {
                    for (int i = 0; i < tv_view.size(); i++) {
                        if (i == position) {
                            TextView tv = tv_view.get(i);
                            tv.setBackgroundResource(R.drawable.et_selected);
                            tv.setTextColor(context.getResources().getColor(R.color.color_ffffff));
                        } else {
                            TextView tv = tv_view.get(i);
                            tv.setBackgroundResource(R.drawable.et);
                            tv.setTextColor(context.getResources().getColor(R.color.color_010101));
                        }
                    }
                    itemClickListener.onItemClick(position);
                }
            }
        });
    }

    public void clearSelected() {
        for (int i = 0; i < tv_view.size(); i++) {
            TextView tv = tv_view.get(i);
            tv.setBackgroundResource(R.drawable.et);
            tv.setTextColor(context.getResources().getColor(R.color.color_010101));
        }
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    class ScreenTypeViewHolder extends RecyclerView.ViewHolder {
        public TextView item_type_tv;

        public ScreenTypeViewHolder(View itemView) {
            super(itemView);
            item_type_tv = itemView.findViewById(R.id.item_screen_type);
        }
    }
}
