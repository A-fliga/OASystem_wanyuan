package org.oasystem_wanyuan.mvp.view;

import android.support.v7.widget.RecyclerView;

import org.oasystem_wanyuan.R;
import org.oasystem_wanyuan.constants.Constants;
import org.oasystem_wanyuan.manager.FirmingTypeManager;
import org.oasystem_wanyuan.manager.UserManager;
import org.oasystem_wanyuan.mvp.adapter.HomeTypeAdapter;
import org.oasystem_wanyuan.mvp.adapter.MoreRegularAdapter;
import org.oasystem_wanyuan.mvp.model.bean.HomeBusinessManagerBean;
import org.oasystem_wanyuan.mvp.model.bean.HomeTypeBean;
import org.oasystem_wanyuan.mvp.view.baseDelegate.ViewDelegate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by www on 2019/7/10.
 */

public class MoreTypeDelegate extends ViewDelegate {
    private RecyclerView customizeRecyclerView, regularRecyclerView;

    @Override
    public void onDestroy() {

    }

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_more_type;
    }

    @Override
    public void initWidget() {
        getTitleView().setText("更多应用");
        regularRecyclerView = get(R.id.more_type_regular);
        customizeRecyclerView = get(R.id.more_type_customize);
    }

    public MoreRegularAdapter initRegularAdapter() {
        List<HomeBusinessManagerBean> beanList = new ArrayList<>();
        HomeBusinessManagerBean bean = null;
        int regularTypeSize = 0;
        if (UserManager.getInstance().getUserInfo().getIs_monitoring() == 1) {
            regularTypeSize = 4;
        } else {
            regularTypeSize = 3;
        }
        for (int i = 0; i < regularTypeSize; i++) {
            if (i == 0) {
                bean = new HomeBusinessManagerBean();
                bean.name = "考勤管理";
                bean.resId = R.mipmap.ask_for_leave_icon;
            }
            if (i == 1) {
                bean = new HomeBusinessManagerBean();
                bean.name = "会议管理";
                bean.resId = R.mipmap.meeting_icon;
            }
            if (i == 2) {
                bean = new HomeBusinessManagerBean();
                bean.name = "用车申请";
                bean.resId = R.mipmap.car_apply_icon;
            }
            if (i == 3) {
                bean = new HomeBusinessManagerBean();
                bean.name = "文件监控";
                bean.resId = R.mipmap.wenjianjiankong;
            }
            beanList.add(bean);
        }
        MoreRegularAdapter adapter = new MoreRegularAdapter(beanList, this.getActivity());
        setRecycler(regularRecyclerView, adapter, 6, true);
        return adapter;
    }

    public HomeTypeAdapter initCustomizeList() {
        List<String> imgIdList = new ArrayList<>();
        List<String> typeContentList = new ArrayList<>();
        List<HomeTypeBean.DataBean> beanList = FirmingTypeManager.getInstance().getBeanList();
        for (int i = Constants.TYPE_WIDTH_COUNT; i < beanList.size(); i++) {
            typeContentList.add(beanList.get(i).getName());
            imgIdList.add(beanList.get(i).getImg());
        }
        HomeTypeAdapter adapter = new HomeTypeAdapter(this.getActivity(), imgIdList, typeContentList, beanList, false);
        setRecycler(customizeRecyclerView, adapter, 6, true);
        return adapter;
    }
}
