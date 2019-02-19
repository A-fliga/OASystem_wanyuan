package org.oasystem_wanyuan.mvp.presenter.activity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.oasystem_wanyuan.R;
import org.oasystem_wanyuan.http.MSubscribe;
import org.oasystem_wanyuan.mvp.adapter.MyOfficeTypeAdapter;
import org.oasystem_wanyuan.mvp.adapter.itemClickListener.OnItemClickListener;
import org.oasystem_wanyuan.mvp.model.BaseEntity;
import org.oasystem_wanyuan.mvp.model.PublicModel;
import org.oasystem_wanyuan.mvp.model.bean.AccessoryBean;
import org.oasystem_wanyuan.mvp.model.bean.OfficeTypeBean;
import org.oasystem_wanyuan.mvp.view.MyOfficeDelegate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by www on 2019/1/5.
 */

public class MyOfficeActivity extends ActivityPresenter {
    private MyOfficeTypeAdapter adapter;
    private List<OfficeTypeBean.DataBean> beanList;
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
        EventBus.getDefault().register(this);
        fromHome = getIntent().getExtras().getBoolean("fromHome", true);
        final RecyclerView my_office_recycler = viewDelegate.get(R.id.my_office_recycler);
        PublicModel.getInstance().getOfficeType(new MSubscribe<BaseEntity<OfficeTypeBean>>() {
            @Override
            public void onNext(final BaseEntity<OfficeTypeBean> bean) {
                super.onNext(bean);
                beanList = new ArrayList<OfficeTypeBean.DataBean>();
                beanList.addAll(bean.getData().getData());
                adapter = new MyOfficeTypeAdapter(bean.getData().getData(), MyOfficeActivity.this);
                viewDelegate.setRecycler(my_office_recycler, adapter, true);
                adapter.setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        Bundle bundle = new Bundle();
                        bundle.putString("document_type_id", beanList.get(position).getId() + "");
                        bundle.putBoolean("fromHome", fromHome);
                        startMyActivity(OfficeCenterActivity.class, bundle);
                    }
                });
            }
        }, "1");
    }


    @Subscribe(threadMode = ThreadMode.MAIN) //在ui线程执行
    public void addAccessory(AccessoryBean bean) {
        if (bean != null) {
            finish();
        }
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
