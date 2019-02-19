package org.oasystem_wanyuan.mvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import org.oasystem_wanyuan.R;

import java.util.List;

/**
 * Created by www on 2019/1/5.
 */

public class MySealAdapter extends RecyclerView.Adapter<MySealAdapter.MySealHolder> {
    private List<byte[]> idList;
    private Context context;

    public MySealAdapter(List<byte[]> idList, Context context) {
        this.idList = idList;
        this.context = context;
    }


    @Override
    public MySealHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MySealHolder(LayoutInflater.from(context).inflate(R.layout.item_myseal, parent, false));
    }

    @Override
    public void onBindViewHolder(final MySealHolder holder, final int position) {
        Glide.with(context).load(idList.get(position)).into(holder.my_seal);
    }

    @Override
    public int getItemCount() {
        return idList.size();
    }

    class MySealHolder extends RecyclerView.ViewHolder {
        private ImageView my_seal;

        public MySealHolder(View itemView) {
            super(itemView);
            my_seal = itemView.findViewById(R.id.item_myseal);
        }
    }
}
