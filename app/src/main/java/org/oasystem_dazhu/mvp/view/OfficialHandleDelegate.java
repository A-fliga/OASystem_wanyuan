package org.oasystem_dazhu.mvp.view;

import org.oasystem_dazhu.R;
import org.oasystem_dazhu.mvp.view.baseDelegate.ViewDelegate;
import org.oasystem_dazhu.mvp.view.customView.NoScrollViewPager;

/**
 * Created by www on 2019/1/19.
 */

public class OfficialHandleDelegate extends ViewDelegate {
    private NoScrollViewPager viewPager;

    @Override
    public void onDestroy() {

    }

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_official_handle;
    }

    public NoScrollViewPager getViewPager(){
        return viewPager;
    }
    @Override
    public void initWidget() {
        viewPager = get(R.id.bottom_viewpager);
    }

    public void initViews(int typeId) {
        switch (typeId) {
            case 1:
                getTitleView().setText("上级来文");
                break;
            case 2:
                getTitleView().setText("平级来文");
                break;
            case 3:
                getTitleView().setText("下级来文");
                break;
            case 4:
                getTitleView().setText("发文审批");
                break;
            case 5:
                getTitleView().setText("传阅文件");
                break;
            case 6:
                getTitleView().setText("内部文件");
                break;
        }
    }
}
