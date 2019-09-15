package org.oasystem_wanyuan.mvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.oasystem_wanyuan.R;
import org.oasystem_wanyuan.mvp.adapter.itemClickListener.OnItemClickListener;
import org.oasystem_wanyuan.mvp.model.bean.HomeTypeBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by www on 2019/1/8.
 */

public class ScreenTypeAdapter extends RecyclerView.Adapter<ScreenTypeAdapter.ScreenTypeViewHolder> {
    private OnItemClickListener mItemClickListener;
    private List<HomeTypeBean.DataBean> mBeanList;
    private Context mContext;
    private List<TextView> mTvView = new ArrayList<>();
    private List<Map<Integer, Boolean>> mSelectedList;

    public ScreenTypeAdapter(List<HomeTypeBean.DataBean> beanList, List<Map<Integer, Boolean>> selectedList, Context context) {
        this.mBeanList = beanList;
        this.mContext = context;
        this.mSelectedList = selectedList;
    }

    @Override
    public ScreenTypeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ScreenTypeViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_screen_type, parent, false));
    }

    @Override
    public void onBindViewHolder(ScreenTypeViewHolder holder, final int position) {
        mTvView.add(holder.item_type_tv);
        holder.item_type_tv.setText(mBeanList.get(position).getName());
        if (mSelectedList.get(position).get(mBeanList.get(position).getId())) {
            TextView tv = mTvView.get(position);
            tv.setBackgroundResource(R.drawable.et_selected);
            tv.setTextColor(mContext.getResources().getColor(R.color.color_ffffff));
        }
        setItemClick(holder, position);
    }

    public List<Map<Integer, Boolean>> getList() {
        return mSelectedList;
    }

    private void setItemClick(ScreenTypeViewHolder holder, final int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean b = mSelectedList.get(position).get(mBeanList.get(position).getId());
                Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();
                map.put(mBeanList.get(position).getId(), !b);
                mSelectedList.set(position, map);
                if (!b) {
                    TextView tv = mTvView.get(position);
                    tv.setBackgroundResource(R.drawable.et_selected);
                    tv.setTextColor(mContext.getResources().getColor(R.color.color_ffffff));
                } else {
                    TextView tv = mTvView.get(position);
                    tv.setBackgroundResource(R.drawable.et);
                    tv.setTextColor(mContext.getResources().getColor(R.color.color_010101));
                }
                if (mItemClickListener != null)
                    mItemClickListener.onItemClick(position);
            }
        });
    }

    public void clearSelected() {
        for (int i = 0; i < mTvView.size(); i++) {
            TextView tv = mTvView.get(i);
            tv.setBackgroundResource(R.drawable.et);
            tv.setTextColor(mContext.getResources().getColor(R.color.color_010101));
        }
        if (mSelectedList != null) {
            for (int i = 0; i < mSelectedList.size(); i++) {
                mSelectedList.get(i).put(mBeanList.get(i).getId(), false);
            }
        }
    }

    @Override
    public int getItemCount() {
        return mBeanList.size();
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.mItemClickListener = itemClickListener;
    }

    class ScreenTypeViewHolder extends RecyclerView.ViewHolder {
        public TextView item_type_tv;

        public ScreenTypeViewHolder(View itemView) {
            super(itemView);
            item_type_tv = itemView.findViewById(R.id.item_screen_type);
        }
    }
}
