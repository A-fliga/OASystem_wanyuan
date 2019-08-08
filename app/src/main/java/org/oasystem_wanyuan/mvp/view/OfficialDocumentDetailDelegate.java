package org.oasystem_wanyuan.mvp.view;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import org.oasystem_wanyuan.R;
import org.oasystem_wanyuan.manager.UserManager;
import org.oasystem_wanyuan.mvp.adapter.SignatureBottomAdapter;
import org.oasystem_wanyuan.mvp.model.bean.DocumentBean;
import org.oasystem_wanyuan.mvp.model.bean.SignFlowsBean;
import org.oasystem_wanyuan.mvp.view.baseDelegate.ViewDelegate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by www on 2019/1/6.
 */

public class OfficialDocumentDetailDelegate extends ViewDelegate {
    private LinearLayout sign_left_ll;
    private RecyclerView sign_bottom;
    @Override
    public void onDestroy() {

    }

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_official_document_detail;
    }

    @Override
    public void initWidget() {
        sign_left_ll = get(R.id.sign_left_ll);
        sign_bottom = get(R.id.sign_bottom);
        setToolBarRightTv2("保存");
        getToolBarRightTv2().setVisibility(View.GONE);
    }

    public void hideLeftBtn(String auth) {
        for (int i = 0; i < sign_left_ll.getChildCount()-1; i++) {
            if (!auth.contains(i + 1 + "")) {
                sign_left_ll.getChildAt(i).setVisibility(View.GONE);
            }
        }
        if (Integer.parseInt(UserManager.getInstance().getUserInfo().getIs_daiqian()) == 0) {
            sign_left_ll.getChildAt(sign_left_ll.getChildCount() - 1).setVisibility(View.GONE);
        }
    }
    public void initBottomRecyclerView(DocumentBean.DataBean bean,Boolean done){
        List<SignFlowsBean> beanList = new ArrayList<>();
        SignFlowsBean flowsBean = new SignFlowsBean();
        flowsBean.setName(bean.getDispatch().getUser().getName());
        flowsBean.setOpName("起草");
        flowsBean.setStatus(1);
        flowsBean.setUserId(bean.getDispatch().getUser().getId());
        flowsBean.setOpTime(bean.getDispatch().getUpdated_at());
        beanList.add(flowsBean);
        for (int i = 0; i < bean.getFlows().size(); i++) {
            DocumentBean.DataBean.DataFlowsBean dataFlowsBean = bean.getFlows().get(i);
            SignFlowsBean fBean = new SignFlowsBean();
            fBean.setName(dataFlowsBean.getUser().getName());
            fBean.setOpName(dataFlowsBean.getName());
            fBean.setUserId(dataFlowsBean.getUser_id());
            fBean.setOpTime(dataFlowsBean.getUpdated_at());
            fBean.setStatus(dataFlowsBean.getStatus());
            beanList.add(fBean);
        }
        SignatureBottomAdapter adapter = new SignatureBottomAdapter(this.getActivity(),beanList,done);
        setRecyclerView(sign_bottom,adapter);
    }

    private void setRecyclerView(RecyclerView recyclerView,SignatureBottomAdapter adapter){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}
