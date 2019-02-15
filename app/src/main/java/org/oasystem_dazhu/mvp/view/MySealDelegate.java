package org.oasystem_dazhu.mvp.view;

import org.oasystem_dazhu.R;
import org.oasystem_dazhu.mvp.view.baseDelegate.ViewDelegate;

/**
 * Created by www on 2019/1/5.
 */

public class MySealDelegate extends ViewDelegate {
    @Override
    public void onDestroy() {

    }

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_myseal;
    }

    @Override
    public void initWidget() {

    }
    public void initTitle(){
        getTitleView().setText("我的印章");
    }
}
