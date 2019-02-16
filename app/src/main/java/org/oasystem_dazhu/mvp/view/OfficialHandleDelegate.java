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

    public void initViews(String typeId) {
        getTitleView().setText(typeId);
    }
}
