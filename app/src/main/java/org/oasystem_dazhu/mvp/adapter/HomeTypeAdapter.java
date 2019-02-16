package org.oasystem_dazhu.mvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;


import org.oasystem_dazhu.R;
import org.oasystem_dazhu.mvp.adapter.itemClickListener.OnItemClickListener;

import java.util.List;

/**
 * Created by www on 2019/2/16.
 */

public class HomeTypeAdapter extends RecyclerView.Adapter<HomeTypeAdapter.HomeTypeViewHolder> {
    private List<String> imgIdList;
    private List<String> typeContentList;
    private OnItemClickListener listener;
    private Context context;
    private int width;

    public HomeTypeAdapter(List<String> imgIdList, List<String> typeContentList, Context context) {
        this.imgIdList = imgIdList;
        this.typeContentList = typeContentList;
        this.context = context;
        WindowManager wm = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);

        width = wm.getDefaultDisplay().getWidth();
    }


    @Override
    public HomeTypeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HomeTypeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_type, parent, false));
    }

    @Override
    public void onBindViewHolder(HomeTypeViewHolder holder, final int position) {
        ViewGroup.LayoutParams param = holder.itemView.getLayoutParams();
        param.width = width / 6;
        Glide.with(context).load(imgIdList.get(position % imgIdList.size())).placeholder(R.mipmap.ic_launcher_round).into(holder.type_img);
        holder.type_tv.setText(typeContentList.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onItemClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return typeContentList.size();
    }

    class HomeTypeViewHolder extends RecyclerView.ViewHolder {
        private ImageView type_img;
        private TextView type_tv;

        public HomeTypeViewHolder(View itemView) {
            super(itemView);

            type_img = itemView.findViewById(R.id.type_img);
            type_tv = itemView.findViewById(R.id.type_tv);
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
