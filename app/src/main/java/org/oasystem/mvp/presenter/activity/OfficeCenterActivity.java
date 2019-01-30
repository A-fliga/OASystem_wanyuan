package org.oasystem.mvp.presenter.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import org.greenrobot.eventbus.EventBus;
import org.oasystem.R;
import org.oasystem.http.MSubscribe;
import org.oasystem.mvp.adapter.OfficeListAdapter;
import org.oasystem.mvp.adapter.itemClickListener.OnItemClickListener;
import org.oasystem.mvp.model.BaseEntity;
import org.oasystem.mvp.model.PublicModel;
import org.oasystem.mvp.model.bean.AccessoryBean;
import org.oasystem.mvp.model.bean.OfficeListBean;
import org.oasystem.mvp.view.MyOfficeDelegate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by www on 2019/1/5.
 */

public class OfficeCenterActivity extends ActivityPresenter {
    private List<OfficeListBean.DataBean> beanList;
    private OfficeListAdapter adapter;
    private Boolean fromHome = true;

    @Override
    public Class getDelegateClass() {
        return MyOfficeDelegate.class;
    }

    @Override
    public boolean isSetDisplayHomeAsUpEnabled() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fromHome = getIntent().getExtras().getBoolean("fromHome", true);
        beanList = new ArrayList<>();
        final RecyclerView recyclerView = viewDelegate.get(R.id.my_office_recycler);
        String document_type_id = getIntent().getExtras().getString("document_type_id");
        PublicModel.getInstance().getOfficeList(new MSubscribe<BaseEntity<OfficeListBean>>() {
            @Override
            public void onNext(BaseEntity<OfficeListBean> bean) {
                super.onNext(bean);
                beanList.addAll(bean.getData().getData());
                adapter = new OfficeListAdapter(beanList, OfficeCenterActivity.this);
                viewDelegate.setRecycler(recyclerView, adapter, true);
                adapter.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        //是从主页来的，点击后需要展示
                        if (fromHome)
                            fromHome(position);
                        else {
                            AccessoryBean accessoryBean = new AccessoryBean();
                            accessoryBean.setName(beanList.get(position).getSource().getName());
                            accessoryBean.setSource_id(beanList.get(position).getSource_id());
                            EventBus.getDefault().post(accessoryBean);
                            finish();
                        }
                    }
                });

            }
        }, document_type_id, "1");

    }

    private void fromHome(int position) {
        Bundle bundle = new Bundle();
        bundle.putString("source_id", beanList.get(position).getSource_id() + "");
        String[] str = beanList.get(position).getSource().getName().split("\\.");
        bundle.putString("type", str[str.length - 1]);
        startMyActivity(OfficeDetailActivity.class, bundle);
    }
}
