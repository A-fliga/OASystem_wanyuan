package org.oasystem_dazhu.mvp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.oasystem_dazhu.R;
import org.oasystem_dazhu.manager.UserManager;
import org.oasystem_dazhu.mvp.model.bean.SignFlowsBean;

import java.util.List;

/**
 * Created by www on 2019/1/22.
 */

public class SignatureBottomAdapter extends RecyclerView.Adapter<SignatureBottomAdapter.SignatureBottomViewHolder> {
    private Context context;
    private List<SignFlowsBean> beanList;
    private Boolean done;
    private int userId;
    private int index = 0;
    private Boolean isFirstAceept = true;

    public SignatureBottomAdapter(Context context, List<SignFlowsBean> beanList, Boolean done) {
        this.context = context;
        this.beanList = beanList;
        this.done = done;
        userId = UserManager.getInstance().getUserInfo().getId();
        if (beanList.size() > 1) {
            for (int i = 1; i < beanList.size(); i++) {
                if (beanList.get(i).getUserId() == userId) {
                    index = i;
                }
            }
        }
    }

    @Override
    public SignatureBottomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SignatureBottomViewHolder(LayoutInflater.from(context).inflate(R.layout.item_sign_flows, parent, false));
    }

    @Override
    public void onBindViewHolder(SignatureBottomViewHolder holder, int position) {
        SignFlowsBean bean = beanList.get(position);
        if (position == 0) {
            holder.sign_name.setText("起草人:" + bean.getName());
            holder.sign_status_img.setImageResource(R.mipmap.already_sign);
            holder.sign_line_img.setImageResource(R.mipmap.sign_line);
            holder.sign_flows.setText(bean.getOpName());
        } else {
            holder.sign_flows.setText(bean.getOpName());
            holder.sign_name.setText(bean.getName());
            if (!done) {
                if (userId == bean.getUserId()) {
                    holder.sign_status_img.setImageResource(R.mipmap.is_signing);
                    holder.sign_flows.setText("等待审批");
                } else {
                    if (position < index) {
                        holder.sign_status_img.setImageResource(R.mipmap.already_sign);
                        holder.sign_line_img.setImageResource(R.mipmap.sign_line);
                    }
                }
            } else {
                if (position <= index) {
                    holder.sign_status_img.setImageResource(R.mipmap.already_sign);
                    holder.sign_line_img.setImageResource(R.mipmap.sign_line);
                } else {
                    if (bean.getStatus() == 0) {
                        if (isFirstAceept) {
                            holder.sign_status_img.setImageResource(R.mipmap.is_signing);
                            holder.sign_flows.setText("等待审批");
                            isFirstAceept = false;
                        }
                    }
                }
            }

        }

        if (position == beanList.size() - 1) {
            holder.sign_line_img.setVisibility(View.GONE);
        } else {
            holder.sign_line_img.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    class SignatureBottomViewHolder extends RecyclerView.ViewHolder {
        private TextView sign_name, sign_flows;
        private ImageView sign_status_img, sign_line_img;

        public SignatureBottomViewHolder(View itemView) {
            super(itemView);
            sign_name = itemView.findViewById(R.id.sign_name);
            sign_flows = itemView.findViewById(R.id.sign_flows);
            sign_status_img = itemView.findViewById(R.id.sign_status_img);
            sign_line_img = itemView.findViewById(R.id.sign_line_img);
        }
    }
}