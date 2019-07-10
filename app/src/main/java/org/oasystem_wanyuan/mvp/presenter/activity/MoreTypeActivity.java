package org.oasystem_wanyuan.mvp.presenter.activity;

import android.os.Bundle;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.oasystem_wanyuan.http.MSubscribe;
import org.oasystem_wanyuan.manager.FirmingTypeManager;
import org.oasystem_wanyuan.mvp.adapter.HomeTypeAdapter;
import org.oasystem_wanyuan.mvp.adapter.MoreRegularAdapter;
import org.oasystem_wanyuan.mvp.adapter.itemClickListener.OnItemClickListener;
import org.oasystem_wanyuan.mvp.model.BaseEntity;
import org.oasystem_wanyuan.mvp.model.PublicModel;
import org.oasystem_wanyuan.mvp.model.bean.HomeTypeBean;
import org.oasystem_wanyuan.mvp.view.MoreTypeDelegate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by www on 2019/7/10.
 */

public class MoreTypeActivity extends ActivityPresenter<MoreTypeDelegate> {
    private MoreRegularAdapter mRegularAdapter;
    private HomeTypeAdapter mCustomizeAdapter;

    @Override
    public Class<MoreTypeDelegate> getDelegateClass() {
        return MoreTypeDelegate.class;
    }

    @Override
    public boolean isSetDisplayHomeAsUpEnabled() {
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initRegular();
        initCustomize();
        EventBus.getDefault().register(this);
    }

    private void initCustomize() {
        mCustomizeAdapter = viewDelegate.initCustomizeList();
        setCustomizeClick();
    }

    private void initRegular() {
        mRegularAdapter = viewDelegate.initRegularAdapter();
        setRegularClick();
    }

    public void setRegularClick() {
        mRegularAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                switch (position) {
                    case 0:
                        startMyActivity(AttendanceActivity.class, null);
                        break;
                    case 1:
                        startMyActivity(MeetingsActivity.class, null);
                        break;
                    case 2:
                        startMyActivity(CarManagementActivity.class, null);
                        break;
                    case 3:
                        startMyActivity(FileMonitorActivity.class, null);
                        break;
                }
            }
        });
    }

    @Subscribe(threadMode = ThreadMode.MAIN) //在ui线程执行
    public void refreshList(String content) {
        if (content.equals("upLoadSuccess")) {
            getFirmingType();
        }
    }

    private void getFirmingType() {
        PublicModel.getInstance().getType(new MSubscribe<BaseEntity<HomeTypeBean>>() {
            @Override
            public void onNext(BaseEntity<HomeTypeBean> bean) {
                super.onNext(bean);
                List<HomeTypeBean.DataBean> beanList = new ArrayList<HomeTypeBean.DataBean>();
                beanList.addAll(bean.getData().getData());
                FirmingTypeManager.getInstance().addBeanList(beanList);
                initCustomize();
            }
        });
    }


    private void setCustomizeClick() {
        mCustomizeAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                start2Activity(FirmingTypeManager.getInstance().getBeanList().get(position).getId());
            }
        });
    }

    private void start2Activity(int typeId) {
        Bundle bundle = new Bundle();
        bundle.putInt("typeId", typeId);
        startMyActivity(OfficialHandleActivity.class, bundle);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
