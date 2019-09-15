package org.oasystem_wanyuan.mvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.oasystem_wanyuan.R;
import org.oasystem_wanyuan.constants.Constants;
import org.oasystem_wanyuan.manager.FirmingTypeManager;
import org.oasystem_wanyuan.mvp.adapter.itemClickListener.OnItemClickListener;
import org.oasystem_wanyuan.mvp.model.bean.HomeTypeBean;

import java.util.List;

/**
 * Created by www on 2019/2/16.
 */

public class HomeTypeAdapter extends RecyclerView.Adapter<HomeTypeAdapter.HomeTypeViewHolder> {
    private List<String> mImgIdList;
    private List<String> mTypeContentList;
    private List<HomeTypeBean.DataBean> mBeanList;
    private OnItemClickListener mListener;
    private Context mContext;
    private int mWindowWidth;
    private boolean mIsHome;
    private int mVisibleSize = 0;


    public HomeTypeAdapter(Context context, List<String> imgIdList, List<String> typeContentList, List<HomeTypeBean.DataBean> beanList, boolean isHome) {
        this.mImgIdList = imgIdList;
        this.mTypeContentList = typeContentList;
        this.mContext = context;
        this.mBeanList = beanList;
        this.mIsHome = isHome;
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        mWindowWidth = wm.getDefaultDisplay().getWidth();
    }

    public List<HomeTypeBean.DataBean> getmBeanList() {
        return mBeanList;
    }


    @Override
    public HomeTypeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HomeTypeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_type, parent, false));
    }

    @Override
    public void onBindViewHolder(HomeTypeViewHolder holder, final int position) {
        ViewGroup.LayoutParams param = holder.itemView.getLayoutParams();
        param.width = mWindowWidth / (Constants.TYPE_WIDTH_COUNT + 1);
        if ("more".equals(mImgIdList.get(position % mImgIdList.size()))) {
            Glide.with(mContext).load(R.mipmap.more_type).fitCenter().into(holder.type_img);
        } else {
            Glide.with(mContext).load(mImgIdList.get(position % mImgIdList.size())).fitCenter().placeholder(R.mipmap.sign_add_advise).into(holder.type_img);
        }
        holder.type_tv.setText(mTypeContentList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null) {
                    mListener.onItemClick(position);
                }
            }
        });
        holder.home_type_count.setVisibility(View.VISIBLE);
        if (mIsHome) {
            if (position < mVisibleSize - 1) {
                holder.home_type_count.setText(mBeanList.get(position).getDispatch_flow_list_count() > 99 ? "99"
                        : String.valueOf(mBeanList.get(position).getDispatch_flow_list_count()));
            } else {
                long totalCount = 0;
                //分类数小于5时，不显示统计的数量
                if (FirmingTypeManager.getInstance().getBeanList().size() <= Constants.TYPE_WIDTH_COUNT) {
                    holder.home_type_count.setVisibility(View.GONE);
                } else {
                    for (int i = Constants.TYPE_WIDTH_COUNT; i < FirmingTypeManager.getInstance().getBeanList().size(); i++) {
                        totalCount = totalCount + FirmingTypeManager.getInstance().getBeanList().get(i).getDispatch_flow_list_count();
                    }
                    holder.home_type_count.setText(totalCount > 99 ? "99"
                            : String.valueOf(totalCount));
                }
            }
        } else {
            holder.home_type_count.setText(mBeanList.get(position).getDispatch_flow_list_count() > 99 ? "99"
                    : String.valueOf(mBeanList.get(position).getDispatch_flow_list_count()));
        }
    }

    @Override
    public int getItemCount() {
        if (mIsHome) {
            if (mBeanList.size() > Constants.TYPE_WIDTH_COUNT) {
                mVisibleSize = Constants.TYPE_WIDTH_COUNT + 1;
            } else {
                mVisibleSize = mBeanList.size() + 1;
            }
        } else {
            mVisibleSize = mBeanList.size();
        }
        return mVisibleSize;
    }

    class HomeTypeViewHolder extends RecyclerView.ViewHolder {
        private ImageView type_img;
        private TextView type_tv, home_type_count;

        public HomeTypeViewHolder(View itemView) {
            super(itemView);
            type_img = itemView.findViewById(R.id.type_img);
            type_tv = itemView.findViewById(R.id.type_tv);
            home_type_count = itemView.findViewById(R.id.home_type_count);
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }
}
